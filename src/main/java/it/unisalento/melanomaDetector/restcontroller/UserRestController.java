package it.unisalento.melanomaDetector.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.melanomaDetector.domain.Login;
import it.unisalento.melanomaDetector.domain.User;
import it.unisalento.melanomaDetector.dto.UserDTO;
import it.unisalento.melanomaDetector.exceptions.UserNotFoundException;
import it.unisalento.melanomaDetector.exceptions.UserNotSavedException;
import it.unisalento.melanomaDetector.iservice.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8100", "http://192.168.1.4:8100/" })
public class UserRestController {

	@Autowired
	IUserService userService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO loginUser(@RequestBody Login login) throws UserNotFoundException {
		User user = userService.getByEmailAndPassword(login.getEmail(), login.getPassword());

		if (user == null)
			throw new UserNotFoundException();

		return this.fillDTO(user);
	}

	@PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(@RequestBody UserDTO user) throws UserNotSavedException {
		User toSave = new User();
		toSave.setAge(user.getAge());
		toSave.setCodiceFiscale(user.getCodiceFiscale());
		toSave.setEmail(user.getEmail());
		toSave.setId(user.getId());
		toSave.setName(user.getName());
		toSave.setPassword(user.getPassword());
		toSave.setSurname(user.getSurname());
		User saved = userService.save(toSave);

		if (saved == null)
			throw new UserNotSavedException();

		return saved;
	}

	private UserDTO fillDTO(User user) {
		UserDTO u = new UserDTO();
		u.setAge(user.getAge());
		u.setCodiceFiscale(user.getCodiceFiscale());
		u.setEmail(user.getEmail());
		u.setId(user.getId());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setSurname(user.getPassword());
		return u;
	}
}
