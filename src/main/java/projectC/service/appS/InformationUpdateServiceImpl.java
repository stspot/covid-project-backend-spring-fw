package projectC.service.appS;

import static projectC.settings.DataLinksSettings.COMMON_INFORMATION_JSON_LINK;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectC.enums.LogOperationEnum;
import projectC.exceptions.CommonInformationException;
import projectC.models.entities.CommonInformation;
import projectC.repositories.CommonInformationRepository;

//TODO Documentation
@Service
public class InformationUpdateServiceImpl implements InformationUpdateService {

	private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/d");
	private final ToolsService toolsService;

	private final CommonInformationRepository commonInformationRepository;

	@Autowired
	public InformationUpdateServiceImpl(ToolsService toolsService,
			CommonInformationRepository commonInformationRepository) {
		this.toolsService = toolsService;
		this.commonInformationRepository = commonInformationRepository;
	}

	//TODO Documentation
	@Override
	public void updateCommonInformationFromPublicSiteToDb() throws CommonInformationException {
		String[][] resultArray = this.toolsService.getResponse(COMMON_INFORMATION_JSON_LINK);
		CommonInformation commonInformation = new CommonInformation();
		CommonInformation lastRecordObject = this.commonInformationRepository.findAll().stream()
				.sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate())).findFirst().orElse(null);
		
		if(lastRecordObject == null) {
			throw new CommonInformationException("Method: updateCommonInformationFromPublicSiteToDb -> "
					+ "lastRecordObject is NULL");
		}

		for (int i = resultArray.length - 1; i >= 1; i--) {
			int updaterCount = 10;
			LocalDate actualDateFromArray = LocalDate.parse(resultArray[i][0], DATE_FORMATTER);
			if (actualDateFromArray.compareTo(lastRecordObject.getDate()) > 0) {
				for (int j = resultArray[i].length - 1; j >= 0 ; j--) {
					commonInformation = new CommonInformation(LocalDate.parse(resultArray[i][0], DATE_FORMATTER),
							Integer.parseInt(resultArray[i][1]), Integer.parseInt(resultArray[i][2]),
							Integer.parseInt(resultArray[i][3]), Integer.parseInt(resultArray[i][4]),
							Integer.parseInt(resultArray[i][5]), Integer.parseInt(resultArray[i][6]),
							Integer.parseInt(resultArray[i][7]), Integer.parseInt(resultArray[i][8]),
							Integer.parseInt(resultArray[i][9]), Integer.parseInt(resultArray[i][10]),
							Integer.parseInt(resultArray[i][11]), Integer.parseInt(resultArray[i][12]));
				}
				this.commonInformationRepository.saveAndFlush(commonInformation);
			} else {
				if(updaterCount == 0) break;
				updaterCount--;
			}
		}
		this.toolsService.createLog(LocalDateTime.now(), LogOperationEnum.DB.name(),
				"Updated common information in DB!");
	}
	
	@Override
	public void updateDistributionByDataAndAreaFromPublicSitetoDb() {
		// TODO updateDistributionByDataAndAreaFromPublicSitetoDb()

	}

	@Override
	public void updateDistributionByDateAndAgeGroupFromPublicSitetoDb() {
		// TODO updateDistributionByDateAndAgeGroupFromPublicSitetoDb()

	}

	@Override
	public void updateDistributionByTypeOfTestsFromPublicSitetoDb() {
		// TODO updateDistributionByTypeOfTestsFromPublicSitetoDb()

	}

	@Override
	public void updateDeadBySexAndAgeGroupsFromPublicSitetoDb() {
		// TODO updateDeadBySexAndAgeGroupsFromPublicSitetoDb()

	}

	@Override
	public void updateInfectedVaccinatedFromPublicSiteToDb() {
		// TODO updateInfectedVaccinatedFromPublicSiteToDb()

	}

	@Override
	public void updateHospitalizedVaccinatedFromPublicSitetoDb() {
		// TODO updateHospitalizedVaccinatedFromPublicSitetoDb()

	}

	@Override
	public void updateVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb() {
		// TODO updateVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb()

	}

	@Override
	public void updateDiedVaccinatedFromPublicSitetoDb() {
		// TODO updateDiedVaccinatedFromPublicSitetoDb()

	}
}
