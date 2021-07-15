package it.unisalento.melanomaDetector.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.melanomaDetector.domain.Readings;
import it.unisalento.melanomaDetector.domain.User;
import it.unisalento.melanomaDetector.dto.ReadingsDTO;
import it.unisalento.melanomaDetector.dto.UserDTO;
import it.unisalento.melanomaDetector.exceptions.ReadingNotSavedException;
import it.unisalento.melanomaDetector.iservice.IReadingsService;
import it.unisalento.melanomaDetector.iservice.IUserService;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReadingsRestController {

	@Autowired
	IReadingsService readingsService;
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReadingsDTO> getAll(@PathVariable int id) {

		List<Readings> listReading = readingsService.getByUserId(id);

		List<ReadingsDTO> list = new ArrayList<ReadingsDTO>();
		for (Readings reading : listReading) {
			ReadingsDTO u = this.fillDTO(reading);
			if (u != null)
				list.add(u);
		}

		return list;
	}

	@RequestMapping(value = "/user/search/{codiceFiscale}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReadingsDTO> search(@PathVariable String codiceFiscale) {

		List<Readings> listReading = readingsService.getByUserCodiceFiscale(codiceFiscale);

		List<ReadingsDTO> list = new ArrayList<ReadingsDTO>();
		for (Readings reading : listReading) {
			ReadingsDTO u = this.fillDTO(reading);
			if (u != null)
				list.add(u);
		}

		return list;
	}

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Readings save(@RequestBody ReadingsDTO reading) throws ReadingNotSavedException {
		Readings toSave = new Readings();
		toSave.setHighestPredictionClass(reading.getHighestPredictionClass());
		toSave.setHighestPredictionScore(reading.getHighestPredictionScore());
		toSave.setImage(reading.getImage());
		toSave.setRisk(reading.getRisk());
		toSave.setUser(userService.getById(reading.getUser().getId()));
		Readings saved = readingsService.save(toSave);

		if (saved == null)
			throw new ReadingNotSavedException();

		return saved;
	}
	private ReadingsDTO fillDTO(Readings reading) {
		ReadingsDTO r = new ReadingsDTO();
		r.setHighestPredictionClass(reading.getHighestPredictionClass());
		r.setHighestPredictionScore(reading.getHighestPredictionScore());
		r.setId(reading.getId());
		r.setImage(reading.getImage());
		r.setRisk(reading.getRisk());
		r.setUser(this.fillUserDTO(reading.getUser()));
		return r;
	}

	private UserDTO fillUserDTO(User user) {
		UserDTO u = new UserDTO();
		u.setAge(user.getAge());
		u.setCodiceFiscale(user.getCodiceFiscale());
		u.setEmail(user.getEmail());
		u.setId(user.getId());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setType(user.getType());
		u.setSurname(user.getPassword());
		return u;
	}

}
