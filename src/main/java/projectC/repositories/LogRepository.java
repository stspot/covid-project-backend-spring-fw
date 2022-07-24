package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.Log;

//TODO Documentation
@Repository
public interface LogRepository extends JpaRepository<Log, String> {

}
