package projectC.models.entities;

//TODO Documentation and checking fields
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "logs")
public final class Log extends BaseEntity {

	@PastOrPresent
	@Column(name = "date_and_time_of_log")
	private LocalDateTime dateAndTimeOfLog;
	@Column(name = "type_of_operation")
	private String typeOfOperation;
	@Column(name = "description")
	@Length(min = 1, max = 255, message = "The description must be between 1 and 255 symbols")
	private String description;
	
}
