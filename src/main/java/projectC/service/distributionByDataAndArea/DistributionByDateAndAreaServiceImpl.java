package projectC.service.distributionByDataAndArea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectC.models.entities.DistributionByDateAndArea;
import projectC.models.service.DistributionByDateAndAreaServiceModel;
import projectC.repositories.DistributionByDateAndAreaRepository;
import projectC.service.appS.ToolsService;

@Service
public class DistributionByDateAndAreaServiceImpl implements DistributionByDateAndAreaService{

	private final ToolsService toolsService;
	private final DistributionByDateAndAreaRepository distributionByDateAndAreaRepository;
	
	@Autowired
	public DistributionByDateAndAreaServiceImpl(ToolsService toolsService,
			DistributionByDateAndAreaRepository distributionByDateAndAreaRepository) {
		super();
		this.toolsService = toolsService;
		this.distributionByDateAndAreaRepository = distributionByDateAndAreaRepository;
	}

	@Override
	public List<DistributionByDateAndAreaServiceModel> getAllDistributionByDateAndArea() {
		List<DistributionByDateAndArea> resultList = this.distributionByDateAndAreaRepository.findAll();
		return this.toolsService.mapList(resultList, DistributionByDateAndAreaServiceModel.class);
	}

}
