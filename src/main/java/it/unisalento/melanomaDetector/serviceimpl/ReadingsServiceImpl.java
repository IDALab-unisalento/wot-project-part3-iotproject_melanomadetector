package it.unisalento.melanomaDetector.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.melanomaDetector.dao.ReadingsRepository;
import it.unisalento.melanomaDetector.domain.Readings;
import it.unisalento.melanomaDetector.iservice.IReadingsService;

@Service
public class ReadingsServiceImpl implements IReadingsService {

	@Autowired
	ReadingsRepository readingsRepo;

	@Override
	public Readings save(Readings reading) {
		return this.readingsRepo.save(reading);
	}

	@Override
	public List<Readings> getByUserId(int userId) {
		return this.readingsRepo.getByUserId(userId);
	}

	@Override
	public List<Readings> getByUserCodiceFiscale(String codiceFiscale) {
		return this.readingsRepo.findByUserCodiceFiscale(codiceFiscale);
	}

}
