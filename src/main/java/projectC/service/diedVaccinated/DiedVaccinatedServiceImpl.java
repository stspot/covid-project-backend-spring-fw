package projectC.service.diedVaccinated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectC.models.entities.DiedVaccinated;
import projectC.models.service.DiedVaccinatedServiceModel;
import projectC.repositories.DiedVaccinatedRepository;
import projectC.service.appS.ToolsService;

@Service
public class DiedVaccinatedServiceImpl implements DiedVaccinatedService {

	private final DiedVaccinatedRepository diedVaccinatedRepository;
	private final ToolsService toolsService;
	
	@Autowired
	public DiedVaccinatedServiceImpl(DiedVaccinatedRepository diedVaccinatedRepository, 
			ToolsService toolsService) {
		this.diedVaccinatedRepository = diedVaccinatedRepository;
		this.toolsService = toolsService;
	}

	@Override
	public List<DiedVaccinatedServiceModel> getAllDeadByAgeAndGender() {
		List<DiedVaccinated> list = this.diedVaccinatedRepository.findAll();
		return this.toolsService.mapList(list, DiedVaccinatedServiceModel.class);
	}

}
