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
@Table(name = "distributions_by_date_and_age_group")
public final class DistributionByDateAndAgeGroup extends BaseEntity {

	private LocalDate date;
	private int group0to1;
	private int group1to5;
	private int group6to9;
	private int group10to14;
	private int group15to19;
	private int group0to19;
	private int group20to29;
	private int group30to39;
	private int group40to49;
	private int group50to59;
	private int group60to69;
	private int group70to79;
	private int group80to89;
	private int group90to1000;
}
