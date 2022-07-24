package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.InfectedVaccinated;

//TODO Documentation
@Repository
public interface InfectedVaccinatedRepository 
			extends JpaRepository<InfectedVaccinated, String> {

}
