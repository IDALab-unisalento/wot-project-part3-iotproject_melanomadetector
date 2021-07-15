package it.unisalento.melanomaDetector.iservice;

import java.util.List;

import it.unisalento.melanomaDetector.domain.Readings;

public interface IReadingsService {

	public Readings save(Readings reading);

	public List<Readings> getByUserId(int userId);

	public List<Readings> getByUserCodiceFiscale(String codiceFiscale);

}
