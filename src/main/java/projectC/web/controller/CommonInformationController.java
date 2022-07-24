package projectC.web.controller;

//TODO Documentation
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projectC.exceptions.DateExistException;
import projectC.models.binding.CommonInformationBindingModel;
import projectC.models.service.CommonInformationServiceModel;
import projectC.models.service.PercentPTestServiceModel;
import projectC.models.view.CommonInformationViewModel;
import projectC.models.view.PercentPTestViewModel;
import projectC.service.commonInfo.CommonInformationService;

import static projectC.settings.SiteSettings.*;
import static projectC.settings.WebPathSettings.*;

@CrossOrigin("http://localhost:81")
@RestController
@RequestMapping(path = REQUEST_MAPPING_COMMON_INFORMATION)
public class CommonInformationController {

	private final CommonInformationService commonInformationService;
	private final ModelMapper modelMapper;
	
	public CommonInformationController(ModelMapper modelMapper,
			CommonInformationService commonInformationService) {
		this.commonInformationService = commonInformationService;
		this.modelMapper = modelMapper;
	}
	
	/**
	 * @author Zvezdomir Stefchev
	 * @return The list with all common information for Covid-19 in JSON format
	 */
	@GetMapping(path = ALL)
	public ResponseEntity<List<CommonInformationViewModel>> getAllCommonInformation() {
		List<CommonInformationServiceModel> commonInformationList
		 = this.commonInformationService.getAllCommonInformation();
		List<CommonInformationViewModel> outputList = commonInformationList
				.stream()
				.map(el -> this.modelMapper.map(el, CommonInformationViewModel.class))
				.collect(Collectors.toList());
		return new ResponseEntity<List<CommonInformationViewModel>>(outputList, HttpStatus.OK);
	}
	
	//TODO Documentation
	//TODO Comments
	@PostMapping("/add")
	public ResponseEntity<Boolean> addDataForCurrentDay(@RequestBody CommonInformationBindingModel inputObject) throws DateExistException{
		this.commonInformationService
			.addDataForCurrentDay(this.modelMapper.map(inputObject, CommonInformationServiceModel.class));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	//--------------------------------------DEPRECATED--------------------------------------------
	//--------------------------------------NOT-USING---------------------------------------------
	
	//TODO Documentation
		@GetMapping(path = "/get-p-test-for-every-day")
		public ResponseEntity<List<PercentPTestViewModel>> getPercentPTestForEveryDay(){
			List<PercentPTestViewModel> resultList = this.commonInformationService.getPercentPTestForEveryDay()
					.stream()
					.map(e -> this.modelMapper.map(e, PercentPTestViewModel.class))
					.collect(Collectors.toList());
			return new ResponseEntity<List<PercentPTestViewModel>>(resultList, HttpStatus.OK);
		}
		
		//TODO Documentation
		@Deprecated
		@GetMapping(path = "/get-p-test-for-every-day/{year}/{month}")
		public ResponseEntity<List<PercentPTestViewModel>> getAllInformationForCurrentYearAndMonth(
				@PathVariable int year, @PathVariable int month){
			List<PercentPTestServiceModel> pptsmList = 
					this.commonInformationService.getAllInformationForCurrentYearAndMonth(year, month);
			List<PercentPTestViewModel> pptvmList = 
					pptsmList.stream()
					.map(e -> this.modelMapper.map(e, PercentPTestViewModel.class))
					.collect(Collectors.toList());
			return new ResponseEntity<List<PercentPTestViewModel>>(pptvmList, HttpStatus.OK);
		}
		
		//TODO Documentation
		@GetMapping(path = ALL + "/{currentDateStr}")
		public ResponseEntity<CommonInformationViewModel> getAllInformationForCurrentDayByDate(@PathVariable String currentDateStr){
			LocalDate currentDate = LocalDate.parse(currentDateStr, DATE_FORMATTER_2);
			CommonInformationServiceModel pptsm = this.commonInformationService.getAllInformationForCurrentDayByDate(currentDate);
			CommonInformationViewModel pptvm = this.modelMapper.map(pptsm, CommonInformationViewModel.class);
			return new ResponseEntity<CommonInformationViewModel>(pptvm, HttpStatus.OK);
		}
	
}
