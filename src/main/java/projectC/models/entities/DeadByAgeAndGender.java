package projectC.models.entities;

//TODO Documentation and checking fields
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deads_by_age_and_gender")
public final class DeadByAgeAndGender extends BaseEntity{

	private LocalDate date;
	private String gender;
	private String ageRange;
	private int numberOfCases;
}
