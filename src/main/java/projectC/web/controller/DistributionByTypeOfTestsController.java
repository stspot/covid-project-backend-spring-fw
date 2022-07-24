package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.DistributionByTypeOfTestsViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.distributionByTypeOfTests.DistributionByTypeOfTestsService;

import static projectC.settings.WebPathSettings.*;

import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_DISTRIBUTED_BY_TYPE_OF_TESTS)
public class DistributionByTypeOfTestsController {

	private final DistributionByTypeOfTestsService distributionByTypeOfTestsService;
	private final ToolsService toolsService;
	
	@Autowired
	public DistributionByTypeOfTestsController(
			DistributionByTypeOfTestsService distributionByTypeOfTestsService,
			ToolsService toolsService) {
		this.distributionByTypeOfTestsService = distributionByTypeOfTestsService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<DistributionByTypeOfTestsViewModel>> getAllDeadByAgeAndGender() {
		List<DistributionByTypeOfTestsViewModel> outputList = 
				this.toolsService.mapList(this.distributionByTypeOfTestsService.getAllDistributionByTypeOfTests(), 
						DistributionByTypeOfTestsViewModel.class);
		return new ResponseEntity<List<DistributionByTypeOfTestsViewModel>>(outputList, HttpStatus.OK);
	}
}
