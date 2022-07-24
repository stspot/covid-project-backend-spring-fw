package projectC.service.commonInfo;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import projectC.exceptions.DateExistException;
import projectC.models.entities.CommonInformation;
import projectC.models.service.CommonInformationServiceModel;
import projectC.models.service.PercentPTestServiceModel;
import projectC.repositories.CommonInformationRepository;

import static projectC.settings.SiteSettings.*;

//TODO Documentation
@Service
public class CommonInformationServiceImpl implements CommonInformationService {
	
	private final ModelMapper modelMapper;
	private final CommonInformationRepository commonInformationRepository;
	
	public CommonInformationServiceImpl(ModelMapper modelMapper,
			CommonInformationRepository commonInformationRepository) {
		this.modelMapper = modelMapper;
		this.commonInformationRepository = commonInformationRepository;
	}

	//TODO Documentation
	@Override
	public List<CommonInformationServiceModel> getAllCommonInformation() {
		List<CommonInformation> commonInformationList = this.commonInformationRepository.findAll();
		List<CommonInformationServiceModel> cils = commonInformationList
				.stream()
				.map(el -> this.modelMapper.map(el, CommonInformationServiceModel.class))
				.sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate()))
				.collect(Collectors.toList());	
		for (int i = 0; i < cils.size(); i++) {
			double percent = (cils.get(i).getNewCasesPerDay() * 1.0 / cils.get(i).getTestsPerDay())*100;
			cils.get(i).setPercentPTest(percent);
			//TODO double percentIncreasment
		}
		return cils;
	}
	
	//TODO Documentation
	@Override
	public CommonInformationServiceModel getAllInformationForCurrentDayByDate(LocalDate currentDate) {
		return this.getAllCommonInformation()
			.stream()
			.filter(e -> e.getDate().compareTo(currentDate) == 0)
			.findFirst()
			.orElseThrow(() -> new NullPointerException("The object is NULL "
					+ "(getAllInformationForCurrentDayByDate(LocalDate currentDate))!"));
			}
	
	@Override
	public void addDataForCurrentDay(CommonInformationServiceModel inputObject) throws DateExistException {
        CommonInformation foundCm = this.commonInformationRepository.findByDate(inputObject.getDate()).orElse(null);
        if(foundCm != null && inputObject.getDate().compareTo(foundCm.getDate()) == 0) {
        	throw new DateExistException("The date exist / There is no record with this date!");
        }
		CommonInformation cm = this.modelMapper.map(inputObject, CommonInformation.class);
		this.commonInformationRepository.saveAndFlush(cm);
	}

	/* ================================ Deprecated Methods ============================================ */
	
	//TODO Documentation
	@Deprecated
	@Override
	public List<PercentPTestServiceModel> getPercentPTestForEveryDay() {
		List<PercentPTestServiceModel> resultList = new ArrayList<PercentPTestServiceModel>();
		List<CommonInformation> allInfo = this.commonInformationRepository.findAll()
				.stream()
				.sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate()))
				.collect(Collectors.toList());
		for (int i = 0; i < allInfo.size(); i++) {
			PercentPTestServiceModel percentPTestServiceModel = new PercentPTestServiceModel();
			double percent = (allInfo.get(i).getNewCasesPerDay() * 1.0 / allInfo.get(i).getTestsPerDay())*100;
			LocalDate ld = allInfo.get(i).getDate();
			percentPTestServiceModel.setDate(ld);
			percentPTestServiceModel.setPercentPTest(percent);
			percentPTestServiceModel.setNewCasesPerDay(allInfo.get(i).getNewCasesPerDay());
			resultList.add(percentPTestServiceModel);
		}
		return resultList;
	}

	//TODO Documentation
	@Deprecated
	@Override
	public List<PercentPTestServiceModel> getAllInformationForCurrentYearAndMonth(int inputYear, int inputMonth) {
		List<PercentPTestServiceModel> resultList = new ArrayList<PercentPTestServiceModel>();
				for (int i = 0; i < this.getPercentPTestForEveryDay().size(); i++) {
					PercentPTestServiceModel currentElement = this.getPercentPTestForEveryDay().get(i);
					String dateStr = currentElement.getDate().format(DATE_FORMATTER);
					String[] dateArr = dateStr.split("/");
					int month = Integer.parseInt(dateArr[1]);
					int year = Integer.parseInt(dateArr[0]);
					if(inputMonth == month && inputYear == year) {
						resultList.add(currentElement);
					}	
				}
				return resultList;
				//TODO speed optimization!
	}
}
