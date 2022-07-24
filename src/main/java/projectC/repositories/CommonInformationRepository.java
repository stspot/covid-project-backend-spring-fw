package projectC.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.CommonInformation;

//TODO Documentation
@Repository
public interface CommonInformationRepository extends JpaRepository<CommonInformation, String> {

	Optional<CommonInformation> findByDate(LocalDate date);
	
}
