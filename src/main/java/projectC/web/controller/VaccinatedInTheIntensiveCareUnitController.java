package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.VaccinatedInTheIntensiveCareUnitViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.vaccinatedInTheIntensiveCareUnit.VaccinatedInTheIntensiveCareUnitService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_VACCINATED_IN_THE_INTENSIVE_CARE_UNIT)
public class VaccinatedInTheIntensiveCareUnitController {

	private final VaccinatedInTheIntensiveCareUnitService vaccinatedInTheIntensiveCareUnitService;
	private final ToolsService toolsService;
	
	@Autowired
	public VaccinatedInTheIntensiveCareUnitController(
			VaccinatedInTheIntensiveCareUnitService vaccinatedInTheIntensiveCareUnitService,
			ToolsService toolsService) {
		this.vaccinatedInTheIntensiveCareUnitService = vaccinatedInTheIntensiveCareUnitService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<VaccinatedInTheIntensiveCareUnitViewModel>> getAllDeadByAgeAndGender() {
		List<VaccinatedInTheIntensiveCareUnitViewModel> outputList = 
				this.toolsService.mapList(this.vaccinatedInTheIntensiveCareUnitService.getAllVaccinatedInTheIntensiveCareUnit(), 
						VaccinatedInTheIntensiveCareUnitViewModel.class);
		return new ResponseEntity<List<VaccinatedInTheIntensiveCareUnitViewModel>>(outputList, HttpStatus.OK);
	}
	
}
