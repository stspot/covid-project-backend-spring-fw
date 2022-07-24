package projectC.service.appS;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import projectC.exceptions.CommonInformationException;
import projectC.repositories.CommonInformationRepository;
import projectC.repositories.DeadByAgeAndGenderRepository;
import projectC.repositories.DiedVaccinatedRepository;
import projectC.repositories.DistributionByDateAndAgeGroupRepository;
import projectC.repositories.DistributionByDateAndAreaRepository;
import projectC.repositories.DistributionByTypeOfTestsRepository;
import projectC.repositories.HospitalizedVaccinatedRepository;
import projectC.repositories.InfectedVaccinatedRepository;
import projectC.repositories.VaccinatedInTheIntensiveCareUnitRepository;

import static projectC.settings.SiteSettings.*;

//TODO Documentation
@Service
public class LoaderServiceImpl implements LoaderService {
	
	private final InformationService informationService;
	private final CommonInformationRepository commonInformationRepository;
	private final InfectedVaccinatedRepository infectedVaccinatedRepository;
	private final DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository;
	private final DistributionByDateAndAreaRepository distributionByDateAndAreaRepository;
	private final DeadByAgeAndGenderRepository deadByAgeAndGenderRepository;
	private final HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository;
	private final DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository;
	private final VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository;
	private final DiedVaccinatedRepository diedVaccinatedRepository;
	private final InformationUpdateService informationUpdateService;

	@Autowired
	public LoaderServiceImpl(InformationService informationService,
			CommonInformationRepository commonInformationRepository, InfectedVaccinatedRepository infectedVaccinatedRepository, DistributionByTypeOfTestsRepository distributionByTypeOfTestsRepository, DistributionByDateAndAreaRepository distributionByDateAndAreaRepository, DeadByAgeAndGenderRepository deadByAgeAndGenderRepository, HospitalizedVaccinatedRepository hospitalizedVaccinatedRepository, DistributionByDateAndAgeGroupRepository distributionByDateAndAgeGroupRepository, VaccinatedInTheIntensiveCareUnitRepository vaccinatedInTheIntensiveCareUnitRepository, DiedVaccinatedRepository diedVaccinatedRepository, InformationUpdateService informationUpdateService) {
		this.informationService = informationService;
		this.commonInformationRepository = commonInformationRepository;
		this.infectedVaccinatedRepository = infectedVaccinatedRepository;
		this.distributionByTypeOfTestsRepository = distributionByTypeOfTestsRepository;
		this.distributionByDateAndAreaRepository = distributionByDateAndAreaRepository;
		this.deadByAgeAndGenderRepository = deadByAgeAndGenderRepository;
		this.hospitalizedVaccinatedRepository = hospitalizedVaccinatedRepository;
		this.distributionByDateAndAgeGroupRepository = distributionByDateAndAgeGroupRepository;
		this.vaccinatedInTheIntensiveCareUnitRepository = vaccinatedInTheIntensiveCareUnitRepository;
		this.diedVaccinatedRepository = diedVaccinatedRepository;
		this.informationUpdateService = informationUpdateService;
	}

	@PostConstruct
	@Override
	public void loadCommonInformationToDb() {
		
		if(this.commonInformationRepository.count() == 0)
			this.informationService.loadCommonInformationFromPublicSiteToDb();
		
		if(this.distributionByDateAndAreaRepository.count() == 0)
			this.informationService.loadDistributionByDataAndAreaFromPublicSitetoDb();
		
		if(this.distributionByTypeOfTestsRepository.count() == 0)
			this.informationService.loadDistributionByTypeOfTestsFromPublicSitetoDb();
		
		if(this.infectedVaccinatedRepository.count() == 0)
			this.informationService.loadInfectedVaccinatedFromPublicSiteToDb();
		
		if(this.deadByAgeAndGenderRepository.count() == 0)
			this.informationService.loadDeadBySexAndAgeGroupsFromPublicSitetoDb();
		
		if(this.hospitalizedVaccinatedRepository.count() == 0)
			this.informationService.loadHospitalizedVaccinatedFromPublicSitetoDb();
		
		if(this.distributionByDateAndAgeGroupRepository.count() == 0)
			this.informationService.loadDistributionByDateAndAgeGroupFromPublicSitetoDb();
		
		if(this.vaccinatedInTheIntensiveCareUnitRepository.count() == 0)
			this.informationService.loadVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb();
		
		if(this.diedVaccinatedRepository.count() == 0)
			this.informationService.loadDiedVaccinatedFromPublicSitetoDb();
	}
	
//	@Scheduled(zone = "GMT+2:00", cron = "0 0 12 * * ?")
	@Scheduled(initialDelay = 10000, fixedRate = 86400000)
	public void updateInformationToDb() throws CommonInformationException {
		System.out.println("-----------------------------------------------------------------------------");
		this.informationUpdateService.updateCommonInformationFromPublicSiteToDb();                
		this.informationUpdateService.updateDeadBySexAndAgeGroupsFromPublicSitetoDb();
		this.informationUpdateService.updateDiedVaccinatedFromPublicSitetoDb();
		this.informationUpdateService.updateDistributionByDataAndAreaFromPublicSitetoDb();
		this.informationUpdateService.updateDistributionByDateAndAgeGroupFromPublicSitetoDb();
		this.informationUpdateService.updateDistributionByTypeOfTestsFromPublicSitetoDb();
		this.informationUpdateService.updateHospitalizedVaccinatedFromPublicSitetoDb();
		this.informationUpdateService.updateInfectedVaccinatedFromPublicSiteToDb();
		this.informationUpdateService.updateVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb();
		System.out.println("Methods were updated! " + LocalDateTime.now().format(DATE_TIME_FORMATTER));
		System.out.println("-----------------------------------------------------------------------------");
	}
}
