package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.HospitalizedVaccinatedViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.hospitalizedVaccinated.HospitalizedVaccinatedService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_HOSPITALIZED_VACCINATED)
public class HospitalizedVaccinatedController {
	
	private final HospitalizedVaccinatedService hospitalizedVaccinatedService;
	private final ToolsService toolsService;
	
	@Autowired
	public HospitalizedVaccinatedController(
			HospitalizedVaccinatedService hospitalizedVaccinatedService,
			ToolsService toolsService) {
		this.hospitalizedVaccinatedService = hospitalizedVaccinatedService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<HospitalizedVaccinatedViewModel>> getAllDeadByAgeAndGender() {
		List<HospitalizedVaccinatedViewModel> outputList = 
				this.toolsService.mapList(this.hospitalizedVaccinatedService.getAllHospitalizedVaccinated(), 
						HospitalizedVaccinatedViewModel.class);
		return new ResponseEntity<List<HospitalizedVaccinatedViewModel>>(outputList, HttpStatus.OK);
	}
	
}
