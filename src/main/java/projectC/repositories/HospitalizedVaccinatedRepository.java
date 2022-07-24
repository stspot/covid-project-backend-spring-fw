package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.HospitalizedVaccinated;

//TODO Documentation
@Repository
public interface HospitalizedVaccinatedRepository extends JpaRepository<HospitalizedVaccinated, String> {

}
