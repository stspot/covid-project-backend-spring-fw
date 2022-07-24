package projectC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectC.models.entities.DeadBySexAndAgeGroups;

@Repository
public interface DeadBySexAndAgeGroupsRepository extends JpaRepository<DeadBySexAndAgeGroups, Long> {

}
