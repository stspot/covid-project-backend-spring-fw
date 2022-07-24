package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DeadByAgeAndGender;

//TODO Documentation
@Repository
public interface DeadByAgeAndGenderRepository extends JpaRepository<DeadByAgeAndGender, String>{

}
