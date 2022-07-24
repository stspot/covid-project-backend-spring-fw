package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DistributionByDateAndArea;

//TODO Documentation
@Repository
public interface DistributionByDateAndAreaRepository extends JpaRepository<DistributionByDateAndArea, String> {

}
