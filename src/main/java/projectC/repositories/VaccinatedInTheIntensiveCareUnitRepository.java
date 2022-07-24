package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.VaccinatedInTheIntensiveCareUnit;

//TODO Documentation
@Repository
public interface VaccinatedInTheIntensiveCareUnitRepository
		extends JpaRepository<VaccinatedInTheIntensiveCareUnit, String> {

}
