package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<List<CoverLetter>> getALL() {
		
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(),"Ön yazı listelendi.");
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResuslt("Ön yazı eklendi");
	}

	@Override
	public Result update(int id, int userId, String coverLetter) {
		this.coverLetterDao.update(id, userId, coverLetter);
		return new SuccessResuslt("Ön yazı güncellendi");
	}

}
