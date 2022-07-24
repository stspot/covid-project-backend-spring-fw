package projectC.service.hospitalizedVaccinated;

import java.util.List;

import org.springframework.stereotype.Service;
import projectC.models.entities.HospitalizedVaccinated;
import projectC.models.service.HospitalizedVaccinatedServiceModel;
import projectC.repositories.HospitalizedVaccinatedRepository;
import projectC.service.appS.ToolsService;

@Service
public class HospitalizedVaccinatedServiceImpl implements HospitalizedVaccinatedService {

	private final ToolsService toolsService;
	private final HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository;
	
	public HospitalizedVaccinatedServiceImpl(ToolsService toolsService,
			HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository) {
		super();
		this.toolsService = toolsService;
		this.hospitalizedVaccinatedRepository = hospitalizedVaccinatedRepository;
	}
	
	@Override
	public List<HospitalizedVaccinatedServiceModel> getAllHospitalizedVaccinated() {
		List<HospitalizedVaccinated> resultList = this.hospitalizedVaccinatedRepository.findAll();
		return this.toolsService.mapList(resultList, HospitalizedVaccinatedServiceModel.class);
	}

}
