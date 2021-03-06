package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.entities.Photo;
import kodlamaio.hrms.core.utilities.results.Result;
@CrossOrigin
@RestController
@RequestMapping("/api/photo")
public class PhotoController {
	private PhotoService photoService;
	@Autowired
	public PhotoController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@PostMapping("/add")
	public Result add(@ModelAttribute("photo") Photo photo, @RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		return this.photoService.add(photo, multipartFile);
	}
	@PostMapping("/update")
	@Transactional
	public Result update(int user_id, MultipartFile multipartFile) throws IOException {
		return this.photoService.update(user_id, multipartFile);
	}
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable("id") String id) throws IOException{
		return this.photoService.delete(id);
	}
	
}
