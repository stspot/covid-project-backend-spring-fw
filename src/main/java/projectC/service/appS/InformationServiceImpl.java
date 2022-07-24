package projectC.service.appS;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import projectC.enums.LogOperationEnum;
import projectC.models.entities.CommonInformation;
import projectC.models.entities.DeadByAgeAndGender;
import projectC.models.entities.DiedVaccinated;
import projectC.models.entities.DistributionByDateAndAgeGroup;
import projectC.models.entities.DistributionByDateAndArea;
import projectC.models.entities.DistributionByTypeOfTests;
import projectC.models.entities.HospitalizedVaccinated;
import projectC.models.entities.InfectedVaccinated;
import projectC.models.entities.VaccinatedInTheIntensiveCareUnit;
import projectC.repositories.CommonInformationRepository;
import projectC.repositories.DeadByAgeAndGenderRepository;
import projectC.repositories.DiedVaccinatedRepository;
import projectC.repositories.DistributionByDateAndAgeGroupRepository;
import projectC.repositories.DistributionByDateAndAreaRepository;
import projectC.repositories.DistributionByTypeOfTestsRepository;
import projectC.repositories.HospitalizedVaccinatedRepository;
import projectC.repositories.InfectedVaccinatedRepository;
import projectC.repositories.VaccinatedInTheIntensiveCareUnitRepository;

import static projectC.settings.DataLinksSettings.*;
import static projectC.settings.SiteSettings.*;

//TODO Documentation
@Service
public class InformationServiceImpl implements InformationService {

	private final CommonInformationRepository commonInformationRepository;
	private final InfectedVaccinatedRepository infectedVaccinatedRepository;
	private final DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository;
	private final DistributionByDateAndAreaRepository distributionByDateAndAreaRepository;
	private final DeadByAgeAndGenderRepository deadByAgeAndGenderRepository;
	private final HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository;
	private final DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository;
	private final VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository;
	private final DiedVaccinatedRepository diedVaccinatedRepository;
	private final ToolsService toolsService;

	@Autowired
	public InformationServiceImpl(CommonInformationRepository commonInformationRepository,
			ToolsService toolsService, 
			InfectedVaccinatedRepository infectedVaccinatedRepository, 
			DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository, 
			DistributionByDateAndAreaRepository distributionByDateAndAreaRepository, 
			DeadByAgeAndGenderRepository deadByAgeAndGenderRepository, 
			HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository, 
			DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository, VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository, DiedVaccinatedRepository diedVaccinatedRepository) {
		this.commonInformationRepository = commonInformationRepository;
		this.infectedVaccinatedRepository = infectedVaccinatedRepository;
		this.distributionByTypeOfTestsRepository = distributionByTypeOfTestsRepository;
		this.distributionByDateAndAreaRepository = distributionByDateAndAreaRepository;
		this.deadByAgeAndGenderRepository = deadByAgeAndGenderRepository;
		this.hospitalizedVaccinatedRepository = hospitalizedVaccinatedRepository;
		this.distributionByDateAndAgeGroupRepository = distributionByDateAndAgeGroupRepository;
		this.vaccinatedInTheIntensiveCareUnitRepository = vaccinatedInTheIntensiveCareUnitRepository;
		this.diedVaccinatedRepository = diedVaccinatedRepository;
		this.toolsService = toolsService;
	}

	//TODO Documentation
	@Override
	public void loadCommonInformationFromPublicSiteToDb() {
		String[][] resultArra = this.toolsService.getResponse(COMMON_INFORMATION_JSON_LINK);
		CommonInformation commonInformation = new CommonInformation();
		for (int i = 1; i < resultArra.length; i++) {
			for (int j = 0; j < resultArra[i].length; j++) {
				commonInformation = new CommonInformation(LocalDate.parse(resultArra[i][0], DATE_FORMATTER),
						Integer.parseInt(resultArra[i][1]), Integer.parseInt(resultArra[i][2]),
						Integer.parseInt(resultArra[i][3]), Integer.parseInt(resultArra[i][4]),
						Integer.parseInt(resultArra[i][5]), Integer.parseInt(resultArra[i][6]),
						Integer.parseInt(resultArra[i][7]), Integer.parseInt(resultArra[i][8]),
						Integer.parseInt(resultArra[i][9]), Integer.parseInt(resultArra[i][10]),
						Integer.parseInt(resultArra[i][11]), Integer.parseInt(resultArra[i][12]));
			}
			this.commonInformationRepository.saveAndFlush(commonInformation);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load common information in DB!");
	}
	
	//TODO Documentation
	@Override
	public void loadDistributionByTypeOfTestsFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(DISTRIBUTION_BY_TYPES_OF_TESTS_JSON_LINK);
		DistributionByTypeOfTests distributionByTypeOfTests = null;
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				distributionByTypeOfTests = new DistributionByTypeOfTests (
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER), 
						Integer.parseInt(responseArray[i][1]),
						Integer.parseInt(responseArray[i][2]), 
						Integer.parseInt(responseArray[i][3]),
						Integer.parseInt(responseArray[i][4]), 
						Integer.parseInt(responseArray[i][5]),
						Integer.parseInt(responseArray[i][6]), 
						Integer.parseInt(responseArray[i][7]),
						Integer.parseInt(responseArray[i][8]), 
						Integer.parseInt(responseArray[i][9]),
						Integer.parseInt(responseArray[i][10]), 
						Integer.parseInt(responseArray[i][11]),
						Integer.parseInt(responseArray[i][12]));
			}
			
			this.distributionByTypeOfTestsRepository.saveAndFlush(distributionByTypeOfTests);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load distribution by type of tests information in DB!");
	}

	//TODO Documentation
	@Override
	public void loadDistributionByDataAndAreaFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(DISTRIBUTION_BY_DATE_AND_AREA_JSON_LINK);
		
		DistributionByDateAndArea distributionByDateAndArea = null;
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				distributionByDateAndArea = new DistributionByDateAndArea (
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER), 
						Integer.parseInt(responseArray[i][1]),
						Integer.parseInt(responseArray[i][2]), 
						Integer.parseInt(responseArray[i][3]),
						Integer.parseInt(responseArray[i][4]), 
						Integer.parseInt(responseArray[i][5]),
						Integer.parseInt(responseArray[i][6]), 
						Integer.parseInt(responseArray[i][7]),
						Integer.parseInt(responseArray[i][8]), 
						Integer.parseInt(responseArray[i][9]),
						Integer.parseInt(responseArray[i][10]), 
						Integer.parseInt(responseArray[i][11]),
						Integer.parseInt(responseArray[i][12]),
						Integer.parseInt(responseArray[i][13]),
						Integer.parseInt(responseArray[i][14]),
						Integer.parseInt(responseArray[i][15]),
						Integer.parseInt(responseArray[i][16]),
						Integer.parseInt(responseArray[i][17]),
						Integer.parseInt(responseArray[i][18]),
						Integer.parseInt(responseArray[i][19]),
						Integer.parseInt(responseArray[i][20]),
						Integer.parseInt(responseArray[i][21]),
						Integer.parseInt(responseArray[i][22]),
						Integer.parseInt(responseArray[i][23]),
						Integer.parseInt(responseArray[i][24]),
						Integer.parseInt(responseArray[i][25]),
						Integer.parseInt(responseArray[i][26]),
						Integer.parseInt(responseArray[i][27]),
						Integer.parseInt(responseArray[i][28]),
						Integer.parseInt(responseArray[i][29]),
						Integer.parseInt(responseArray[i][30]),
						Integer.parseInt(responseArray[i][31]),
						Integer.parseInt(responseArray[i][32]),
						Integer.parseInt(responseArray[i][33]),
						Integer.parseInt(responseArray[i][34]),
						Integer.parseInt(responseArray[i][35]),
						Integer.parseInt(responseArray[i][36]),
						Integer.parseInt(responseArray[i][37]),
						Integer.parseInt(responseArray[i][38]),
						Integer.parseInt(responseArray[i][39]),
						Integer.parseInt(responseArray[i][40]),
						Integer.parseInt(responseArray[i][41]),
						Integer.parseInt(responseArray[i][42]),
						Integer.parseInt(responseArray[i][43]),
						Integer.parseInt(responseArray[i][44]),
						Integer.parseInt(responseArray[i][45]),
						Integer.parseInt(responseArray[i][46]),
						Integer.parseInt(responseArray[i][47]),
						Integer.parseInt(responseArray[i][48]),
						Integer.parseInt(responseArray[i][49]),
						Integer.parseInt(responseArray[i][50]),
						Integer.parseInt(responseArray[i][51]),
						Integer.parseInt(responseArray[i][52]),
						Integer.parseInt(responseArray[i][53]),
						Integer.parseInt(responseArray[i][54]),
						Integer.parseInt(responseArray[i][55]),
						Integer.parseInt(responseArray[i][56]));
			}
			this.distributionByDateAndAreaRepository.saveAndFlush(distributionByDateAndArea);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load distribution by date and area information in DB!");
		
	}

	//TODO Documentation
	@Override
	public void loadDistributionByDateAndAgeGroupFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(DISTRIBUTION_BY_DATE_AND_AGE_GROUP_JSON_LINK);
		DistributionByDateAndAgeGroup distributionByDateAndAgeGroup = null;
		for (int i = 1; i < responseArray.length; i++) {	
			distributionByDateAndAgeGroup = new DistributionByDateAndAgeGroup();
			for (int j = 0; j < responseArray[i].length; j++) {
				
				distributionByDateAndAgeGroup.setDate(LocalDate.parse(responseArray[i][0], DATE_FORMATTER));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][1]))
					distributionByDateAndAgeGroup.setGroup0to1(Integer.parseInt(responseArray[i][1]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][2]))
					distributionByDateAndAgeGroup.setGroup1to5(Integer.parseInt(responseArray[i][2]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][3]))
					distributionByDateAndAgeGroup.setGroup6to9(Integer.parseInt(responseArray[i][3]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][4]))
					distributionByDateAndAgeGroup.setGroup10to14(Integer.parseInt(responseArray[i][4]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][5]))
					distributionByDateAndAgeGroup.setGroup15to19(Integer.parseInt(responseArray[i][5]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][6]))
					distributionByDateAndAgeGroup.setGroup0to19(Integer.parseInt(responseArray[i][6]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][7]))
					distributionByDateAndAgeGroup.setGroup20to29(Integer.parseInt(responseArray[i][7]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][8]))
					distributionByDateAndAgeGroup.setGroup30to39(Integer.parseInt(responseArray[i][8]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][9]))
					distributionByDateAndAgeGroup.setGroup40to49(Integer.parseInt(responseArray[i][9]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][10]))
					distributionByDateAndAgeGroup.setGroup50to59(Integer.parseInt(responseArray[i][10]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][11]))
					distributionByDateAndAgeGroup.setGroup60to69(Integer.parseInt(responseArray[i][11]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][12]))
					distributionByDateAndAgeGroup.setGroup70to79(Integer.parseInt(responseArray[i][12]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][13]))
					distributionByDateAndAgeGroup.setGroup80to89(Integer.parseInt(responseArray[i][13]));
				
				if(this.toolsService.checkPosibleToParseToInt(responseArray[i][14]))
					distributionByDateAndAgeGroup.setGroup90to1000(Integer.parseInt(responseArray[i][14]));
				
				this.distributionByDateAndAgeGroupRepository.saveAndFlush(distributionByDateAndAgeGroup);
			}
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load distribution by date and age group information in DB!");
		
	}

	//TODO Documentation
	@Override
	public void loadInfectedVaccinatedFromPublicSiteToDb() {
		Gson gson = new Gson();
		StringBuilder responseStrb = new StringBuilder();
//		HttpClient httpClient = HttpClient.newHttpClient().sslContext(this.insecureContext());
		HttpClient httpClient = HttpClient.newBuilder()
	            .sslContext(this.toolsService.getInsecureContext())
	            .build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(INFECTED_VACCINATED_JSON_LINK))
				.build();
		
		httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(responseStrb::append).join();
		String response = responseStrb.toString();
		String[][] resultArra = gson.fromJson(response, String[][].class);
		InfectedVaccinated infectedVaccinated = new InfectedVaccinated();

		for (int i = 1; i < resultArra.length; i++) {
			for (int j = 0; j < resultArra[i].length; j++) {
				infectedVaccinated = new InfectedVaccinated(
						LocalDate.parse(resultArra[i][0], DATE_FORMATTER),
						resultArra[i][1], 
						resultArra[i][2],
						resultArra[i][3], 
						Integer.parseInt(resultArra[i][4]));
			}
			this.infectedVaccinatedRepository.saveAndFlush(infectedVaccinated);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load infected vaccinated information in DB!");
	}
	
	//TODO Documentation
	@Override
	public void loadDeadBySexAndAgeGroupsFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(DIED_BY_SEX_AND_AGE_GROUPS_JSON_LINK);
		DeadByAgeAndGender deadByAgeAndGender = null;
		
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				deadByAgeAndGender = new DeadByAgeAndGender (
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER),
						responseArray[i][1], 
						responseArray[i][2], 
						Integer.parseInt(responseArray[i][3]));
			}
			this.deadByAgeAndGenderRepository.saveAndFlush(deadByAgeAndGender);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load dead by age and sex information in DB!");
	}

	//TODO Documentation
	@Override
	public void loadHospitalizedVaccinatedFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(HOSPITALIZED_VACCINATED_JSON_LINK);
		HospitalizedVaccinated hospitalizedVaccinated = null;
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				hospitalizedVaccinated = new HospitalizedVaccinated(
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER),
						responseArray[i][1], 
						responseArray[i][2],
						responseArray[i][3], 
						Integer.parseInt(responseArray[i][4]));
			}
			this.hospitalizedVaccinatedRepository.saveAndFlush(hospitalizedVaccinated);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load hospitalized vaccinated information in DB!");
	}

	//TODO Documentation
	@Override
	public void loadVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb() {
		// TODO loadVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb
		String[][] responseArray = this.toolsService.getResponse(VACCINATED_IN_THE_INTENSIVE_CARE_UNIT_JSON_LINK);
		VaccinatedInTheIntensiveCareUnit inTheIntensiveCareUnit = null;
		
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				inTheIntensiveCareUnit = new VaccinatedInTheIntensiveCareUnit(
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER),
						responseArray[i][1], 
						responseArray[i][2],
						responseArray[i][3], 
						Integer.parseInt(responseArray[i][4]));
			}
			this.vaccinatedInTheIntensiveCareUnitRepository.saveAndFlush(inTheIntensiveCareUnit);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load vaccinateds in the intensive care unit information in DB!");
		
	}

	//TODO Documentation
	@Override
	public void loadDiedVaccinatedFromPublicSitetoDb() {
		String[][] responseArray = this.toolsService.getResponse(DIED_VACCINATED_JSON_LINK);
		DiedVaccinated diedVaccinated = null;
		
		for (int i = 1; i < responseArray.length; i++) {
			for (int j = 0; j < responseArray[i].length; j++) {
				diedVaccinated = new DiedVaccinated(
						LocalDate.parse(responseArray[i][0], DATE_FORMATTER),
						responseArray[i][1], 
						responseArray[i][2],
						responseArray[i][3], 
						Integer.parseInt(responseArray[i][4]));
			}
			this.diedVaccinatedRepository.saveAndFlush(diedVaccinated);
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"First load dieds vaccinated information in DB!");
		
	}
}
