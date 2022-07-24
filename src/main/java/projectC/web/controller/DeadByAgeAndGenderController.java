package projectC.web.controller;

import java.util.List;
import static projectC.settings.WebPathSettings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.DeadByAgeAndGenderViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.deadByAgeAndGender.DeadByAgeAndGenderService;

@CrossOrigin("http://localhost:81")
@RestController
@RequestMapping(path = REQUEST_MAPPING_DEAD_BY_AGE_GROUP_AND_GENDER)
public class DeadByAgeAndGenderController {
	
	private final DeadByAgeAndGenderService deadByAgeAndGenderService;
	private final ToolsService toolsService;
	
	@Autowired
	public DeadByAgeAndGenderController(
			DeadByAgeAndGenderService deadByAgeAndGenderService,
			ToolsService toolsService) {
		this.deadByAgeAndGenderService = deadByAgeAndGenderService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<DeadByAgeAndGenderViewModel>> getAllDeadByAgeAndGender() {
		List<DeadByAgeAndGenderViewModel> outputList = 
				this.toolsService.mapList(this.deadByAgeAndGenderService.getAllDeadByAgeAndGender(), 
						DeadByAgeAndGenderViewModel.class);
		return new ResponseEntity<List<DeadByAgeAndGenderViewModel>>(outputList, HttpStatus.OK);
	}
}