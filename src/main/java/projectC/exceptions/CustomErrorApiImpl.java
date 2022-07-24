package projectC.exceptions;

//TODO Documentation
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class CustomErrorApiImpl {

	private HttpStatus status;
	private LocalDateTime errorTime;
	private String message;
	private List<String> errors;
	
	public CustomErrorApiImpl(HttpStatus status, LocalDateTime errorTime, String message, String error) {
		super();
		this.status = status;
		this.errorTime = errorTime;
		this.message = message;
		this.errors = this.createListWithOneError(error);
	}
	
	private List<String> createListWithOneError(String error){
		List<String> list = new ArrayList<String>();
		list.add(error);
		return list;
	}

}
