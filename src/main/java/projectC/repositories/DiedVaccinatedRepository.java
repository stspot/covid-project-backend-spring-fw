package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DiedVaccinated;

//TODO Documentation
@Repository
public interface DiedVaccinatedRepository extends JpaRepository<DiedVaccinated, String> {

}
