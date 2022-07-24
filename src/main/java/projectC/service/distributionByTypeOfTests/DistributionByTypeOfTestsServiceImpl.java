package projectC.service.distributionByTypeOfTests;

import java.util.List;

import org.springframework.stereotype.Service;
import projectC.models.entities.DistributionByTypeOfTests;
import projectC.models.service.DistributionByTypeOfTestsServiceModel;
import projectC.repositories.DistributionByTypeOfTestsRepository;
import projectC.service.appS.ToolsService;

@Service
public class DistributionByTypeOfTestsServiceImpl implements DistributionByTypeOfTestsService {

	private final ToolsService toolsService;
	private final DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository;
	
	public DistributionByTypeOfTestsServiceImpl(ToolsService toolsService,
			DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository) {
		super();
		this.toolsService = toolsService;
		this.distributionByTypeOfTestsRepository = distributionByTypeOfTestsRepository;
	}
	
	@Override
	public List<DistributionByTypeOfTestsServiceModel> getAllDistributionByTypeOfTests() {
		List<DistributionByTypeOfTests> resultList = this.distributionByTypeOfTestsRepository.findAll();
		return this.toolsService.mapList(resultList, DistributionByTypeOfTestsServiceModel.class);
	}

}
