package it.unisalento.melanomaDetector.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unisalento.melanomaDetector.domain.Readings;


@Repository
public interface ReadingsRepository extends JpaRepository<Readings, Integer> {

	public List<Readings> getByUserId(int id);

	public List<Readings> findByUserCodiceFiscale(String codiceFiscale);
}
