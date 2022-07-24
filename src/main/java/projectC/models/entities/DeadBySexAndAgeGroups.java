package projectC.models.entities;

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
@Table(name = "deads_by_sec_and_age_groups")
public class DeadBySexAndAgeGroups extends BaseEntity {
	
	private LocalDate date;
	private String gender;
	private String ageRange;
	private int numberOfCases;

}
