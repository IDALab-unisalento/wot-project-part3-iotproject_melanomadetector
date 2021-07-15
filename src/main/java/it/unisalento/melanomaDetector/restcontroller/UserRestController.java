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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRestController {

	@Autowired
	IUserService userService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO loginUser(@RequestBody Login login) throws UserNotFoundException {
		User user = userService.getByEmailAndPasswordAndType(login.getEmail(), login.getPassword(), login.getType());

		if (user == null)
			return null;

		return this.fillDTO(user);
	}

	@PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User signup(@RequestBody UserDTO user) throws UserNotSavedException {
		User toSave = new User();
		toSave.setAge(user.getAge());
		toSave.setCodiceFiscale(user.getCodiceFiscale());
		toSave.setEmail(user.getEmail());
		toSave.setName(user.getName());
		toSave.setPassword(user.getPassword());
		toSave.setSurname(user.getSurname());
		toSave.setType(user.getType());
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
		u.setType(user.getType());
		u.setPassword(user.getPassword());
		u.setSurname(user.getSurname());
		return u;
	}
}
