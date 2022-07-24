package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DistributionByTypeOfTests;

//TODO Documentation
@Repository
public interface DistributionByTypeOfTestsRepository extends JpaRepository<DistributionByTypeOfTests, String> {

}
