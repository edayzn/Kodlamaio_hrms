package kodlamaio.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
@RestController
@CrossOrigin
@RequestMapping("/api/cv")
public class CvController {

	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public Result addCv(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAllCv() {
		return this.cvService.getAll();
	}

	@GetMapping("/findByFirstname")
	public DataResult<List<Cv>> findByFirstname(String identification_number) {
		return this.cvService.findByJobSeeker(identification_number);
	}

}
