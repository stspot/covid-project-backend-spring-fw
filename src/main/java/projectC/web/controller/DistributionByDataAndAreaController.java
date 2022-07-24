package projectC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectC.models.view.DistributionByDataAndAreaViewModel;
import projectC.service.appS.ToolsService;
import projectC.service.distributionByDataAndArea.DistributionByDateAndAreaService;

import static projectC.settings.WebPathSettings.*;
import java.util.List;

@RestController
@RequestMapping(path = REQUEST_MAPPING_DISTRIBUTED_BY_DATE_AND_AREA)
public class DistributionByDataAndAreaController {

	private final DistributionByDateAndAreaService distributionByDataAndAreaService;
	private final ToolsService toolsService;
	
	@Autowired
	public DistributionByDataAndAreaController(
			DistributionByDateAndAreaService distributionByDataAndAreaService,
			ToolsService toolsService) {
		this.distributionByDataAndAreaService = distributionByDataAndAreaService;
		this.toolsService = toolsService;
	}

	@GetMapping(ALL)
	public ResponseEntity<List<DistributionByDataAndAreaViewModel>> getAllDeadByAgeAndGender() {
		List<DistributionByDataAndAreaViewModel> outputList = 
				this.toolsService.mapList(this.distributionByDataAndAreaService.getAllDistributionByDateAndArea(), 
						DistributionByDataAndAreaViewModel.class);
		return new ResponseEntity<List<DistributionByDataAndAreaViewModel>>(outputList, HttpStatus.OK);
	}
	
}
