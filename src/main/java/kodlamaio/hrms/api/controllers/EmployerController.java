package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Configuration
@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	 private EmployerService employerService;
	 private JobAdvertisementService jobAdvertisementService;
	 
	 @Autowired
	 public  EmployerController(EmployerService employerService, JobAdvertisementService jobAdvertisementService) {
		 super();
		 this.employerService=employerService;
		 this.jobAdvertisementService=jobAdvertisementService;
	}
	 @GetMapping("/getall")
	 public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll(); 
	 }
	 @PostMapping("/add")
	 public Result add(@RequestBody Employer employer, String passwordAgain) {
		return this.employerService.add(employer,passwordAgain);
	}
	 
	  

}
