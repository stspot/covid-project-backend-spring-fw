package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DistributionByDateAndAgeGroup;

//TODO Documentation
@Repository
public interface DistributionByDateAndAgeGroupRepository
	extends JpaRepository<DistributionByDateAndAgeGroup, String> {

}
