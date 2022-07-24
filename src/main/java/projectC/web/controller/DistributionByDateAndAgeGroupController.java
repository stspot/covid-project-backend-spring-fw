package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.DistributionByDateAndAgeGroupViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.distributionByDateAndAgeGroup.DistributionByDateAndAgeGroupService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_DISTRIBUTED_BY_DATE_AND_AGE_GROUP)
public class DistributionByDateAndAgeGroupController {

	private final DistributionByDateAndAgeGroupService distributionByDateAndAgeGroupService;
	private final ToolsService toolsService;
	
	@Autowired
	public DistributionByDateAndAgeGroupController(
			DistributionByDateAndAgeGroupService distributionByDateAndAgeGroupService,
			ToolsService toolsService) {
		this.distributionByDateAndAgeGroupService = distributionByDateAndAgeGroupService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<DistributionByDateAndAgeGroupViewModel>> getAllDeadByAgeAndGender() {
		List<DistributionByDateAndAgeGroupViewModel> outputList = 
				this.toolsService.mapList(this.distributionByDateAndAgeGroupService.getAllDistributionByDateAndAgeGroup(), 
						DistributionByDateAndAgeGroupViewModel.class);
		return new ResponseEntity<List<DistributionByDateAndAgeGroupViewModel>>(outputList, HttpStatus.OK);
	}
	
}
