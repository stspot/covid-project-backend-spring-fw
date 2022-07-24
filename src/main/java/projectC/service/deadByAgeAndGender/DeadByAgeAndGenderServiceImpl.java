package projectC.service.deadByAgeAndGender;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectC.models.entities.DeadByAgeAndGender;
import projectC.models.service.DeadByAgeAndGenderServiceModel;
import projectC.repositories.DeadByAgeAndGenderRepository;
import projectC.service.appS.ToolsService;

@Service
public class DeadByAgeAndGenderServiceImpl implements DeadByAgeAndGenderService {

	private final DeadByAgeAndGenderRepository deadByAgeAndGenderRepository;
	private final ToolsService toolsService;
	
	@Autowired
	public DeadByAgeAndGenderServiceImpl(DeadByAgeAndGenderRepository deadByAgeAndGenderRepository,
			ToolsService toolsService) {
		this.deadByAgeAndGenderRepository = deadByAgeAndGenderRepository;
		this.toolsService = toolsService;
	}

	@Override
	public List<DeadByAgeAndGenderServiceModel> getAllDeadByAgeAndGender() {
		List<DeadByAgeAndGender> list = this.deadByAgeAndGenderRepository.findAll();
		return this.toolsService.mapList(list, DeadByAgeAndGenderServiceModel.class);
	}

}
