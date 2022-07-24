package projectC.service.vaccinatedInTheIntensiveCareUnit;

import java.util.List;

import org.springframework.stereotype.Service;
import projectC.models.entities.VaccinatedInTheIntensiveCareUnit;
import projectC.models.service.VaccinatedInTheIntensiveCareUnitServiceModel;
import projectC.repositories.VaccinatedInTheIntensiveCareUnitRepository;
import projectC.service.appS.ToolsService;

@Service
public class VaccinatedInTheIntensiveCareUnitServiceImpl implements VaccinatedInTheIntensiveCareUnitService {

	private final ToolsService toolsService;
	private final VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository;
	
	public VaccinatedInTheIntensiveCareUnitServiceImpl(ToolsService toolsService,
			VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository) {
		super();
		this.toolsService = toolsService;
		this.vaccinatedInTheIntensiveCareUnitRepository = vaccinatedInTheIntensiveCareUnitRepository;
	}
	
	@Override
	public List<VaccinatedInTheIntensiveCareUnitServiceModel> getAllVaccinatedInTheIntensiveCareUnit() {
		List<VaccinatedInTheIntensiveCareUnit> resultList = this.vaccinatedInTheIntensiveCareUnitRepository.findAll();
		return this.toolsService.mapList(resultList, VaccinatedInTheIntensiveCareUnitServiceModel.class);
	}

}
