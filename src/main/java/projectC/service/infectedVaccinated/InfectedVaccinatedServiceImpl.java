package projectC.service.infectedVaccinated;

import java.util.List;

import org.springframework.stereotype.Service;
import projectC.models.entities.InfectedVaccinated;
import projectC.models.service.InfectedVaccinatedServiceModel;
import projectC.repositories.InfectedVaccinatedRepository;
import projectC.service.appS.ToolsService;

@Service
public class InfectedVaccinatedServiceImpl implements InfectedVaccinatedService {

	private final ToolsService toolsService;
	private final InfectedVaccinatedRepository infectedVaccinatedRepository;
	
	public InfectedVaccinatedServiceImpl(ToolsService toolsService,
			InfectedVaccinatedRepository infectedVaccinatedRepository) {
		super();
		this.toolsService = toolsService;
		this.infectedVaccinatedRepository = infectedVaccinatedRepository;
	}
	
	@Override
	public List<InfectedVaccinatedServiceModel> getAllInfectedVaccinated() {
		List<InfectedVaccinated> resultList = this.infectedVaccinatedRepository.findAll();
		return this.toolsService.mapList(resultList, InfectedVaccinatedServiceModel.class);
	}

}
