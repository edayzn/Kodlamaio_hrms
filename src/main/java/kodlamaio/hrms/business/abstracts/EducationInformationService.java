package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;


public interface EducationInformationService {
	DataResult<List<EducationInformation>> getAll();
	Result add(EducationInformation educationInformation);
}
