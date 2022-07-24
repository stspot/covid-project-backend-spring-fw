package projectC.service.vaccinatedInTheIntensiveCareUnit;

import java.util.List;
import org.springframework.stereotype.Service;
import projectC.models.service.VaccinatedInTheIntensiveCareUnitServiceModel;

@Service
public interface VaccinatedInTheIntensiveCareUnitService {
	
	List<VaccinatedInTheIntensiveCareUnitServiceModel> getAllVaccinatedInTheIntensiveCareUnit();
	
}
