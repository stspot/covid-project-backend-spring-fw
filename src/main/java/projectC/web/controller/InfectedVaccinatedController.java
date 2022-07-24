package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.InfectedVaccinatedViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.infectedVaccinated.InfectedVaccinatedService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_INFECTED_VACCINATED)
public class InfectedVaccinatedController {

	private final InfectedVaccinatedService infectedVaccinatedService;
	private final ToolsService toolsService;
	
	@Autowired
	public InfectedVaccinatedController(
			InfectedVaccinatedService infectedVaccinatedService,
			ToolsService toolsService) {
		this.infectedVaccinatedService = infectedVaccinatedService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<InfectedVaccinatedViewModel>> getAllDeadByAgeAndGender() {
		List<InfectedVaccinatedViewModel> outputList = 
				this.toolsService.mapList(this.infectedVaccinatedService.getAllInfectedVaccinated(), 
						InfectedVaccinatedViewModel.class);
		return new ResponseEntity<List<InfectedVaccinatedViewModel>>(outputList, HttpStatus.OK);
	}
	
}
