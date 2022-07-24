package projectC.service.diedVaccinated;

import java.util.List;

import projectC.models.service.DiedVaccinatedServiceModel;

public interface DiedVaccinatedService {

	List<DiedVaccinatedServiceModel> getAllDeadByAgeAndGender();
}
