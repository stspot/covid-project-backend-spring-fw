package projectC.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.service.DiedVaccinatedServiceModel;
import projectC.models.view.DiedVaccinatedViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.diedVaccinated.DiedVaccinatedService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_DEAD_VACCINATED)
public class DiedVaccinatedController {
	
	private final DiedVaccinatedService diedVaccinatedService;
	private final ToolsService toolService;
	
	@Autowired
	public DiedVaccinatedController(DiedVaccinatedService diedVaccinatedService, 
			ToolsService toolService) {
		this.diedVaccinatedService = diedVaccinatedService;
		this.toolService = toolService;
	}
	
	@GetMapping(ALL)
	public ResponseEntity<List<DiedVaccinatedViewModel>> getAllDeadByAgeAndGender() {
		List<DiedVaccinatedServiceModel> list = this.diedVaccinatedService.getAllDeadByAgeAndGender();
		return new ResponseEntity<List<DiedVaccinatedViewModel>>(
				this.toolService.mapList(list, DiedVaccinatedViewModel.class), HttpStatus.OK);
	}
}
