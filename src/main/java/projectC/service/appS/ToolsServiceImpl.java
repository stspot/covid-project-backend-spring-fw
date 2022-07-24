package projectC.service.appS;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import projectC.models.entities.Log;
import projectC.repositories.LogRepository;

//TODO Documentation
@Service
public class ToolsServiceImpl implements ToolsService {
	
	private final LogRepository logRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public ToolsServiceImpl(LogRepository logRepository, ModelMapper modelMapper) {
		this.logRepository = logRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void createLog(LocalDateTime date, String logOperation, String description) {
		Log log = new Log();
		log.setDateAndTimeOfLog(date);
		log.setTypeOfOperation(logOperation);
		log.setDescription(description);
		this.logRepository.saveAndFlush(log);	
	}
	
	@Override
	public SSLContext getInsecureContext() {
        TrustManager[] noopTrustManager = new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] xcs, String string) {}
                    public void checkServerTrusted(X509Certificate[] xcs, String string) {}
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        
        try {
            SSLContext sc = SSLContext.getInstance("ssl");
            sc.init(null, noopTrustManager, null);
            return sc;
        } catch (KeyManagementException | NoSuchAlgorithmException ignored) {
            return null;
        }
    }
	
	@Override
	public String[][] getResponse(String urlLink) {
		Gson gson = new Gson();
		StringBuilder responseStrb = new StringBuilder();
		HttpClient httpClient = HttpClient.newBuilder()
	            .sslContext(this.getInsecureContext())
	            .build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(urlLink))
				.build();
		
		httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(responseStrb::append).join();
		return gson.fromJson(responseStrb.toString(), String[][].class);
	}

	@Override
	public boolean checkPosibleToParseToInt(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public <IT, RT> List<RT> mapList(List<IT> inputList, Class<RT> targetClass) {
	    return inputList
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
