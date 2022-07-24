package projectC.service.distributionByDateAndAgeGroup;

import java.util.List;

import org.springframework.stereotype.Service;

import projectC.models.entities.DistributionByDateAndAgeGroup;
import projectC.models.service.DistributionByDateAndAgeGroupServiceModel;
import projectC.repositories.DistributionByDateAndAgeGroupRepository;
import projectC.service.appS.ToolsService;

@Service
public class DistributionByDateAndAgeGroupServiceImpl implements DistributionByDateAndAgeGroupService {

	private final ToolsService toolsService;
	private final DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository;
	
	public DistributionByDateAndAgeGroupServiceImpl(ToolsService toolsService,
			DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository) {
		super();
		this.toolsService = toolsService;
		this.distributionByDateAndAgeGroupRepository = distributionByDateAndAgeGroupRepository;
	}

	@Override
	public List<DistributionByDateAndAgeGroupServiceModel> getAllDistributionByDateAndAgeGroup() {
		List<DistributionByDateAndAgeGroup> resultList = this.distributionByDateAndAgeGroupRepository.findAll();
		return this.toolsService.mapList(resultList, DistributionByDateAndAgeGroupServiceModel.class);
	}

}
