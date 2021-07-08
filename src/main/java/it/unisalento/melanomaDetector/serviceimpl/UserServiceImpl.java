package it.unisalento.melanomaDetector.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.melanomaDetector.dao.UserRepository;
import it.unisalento.melanomaDetector.domain.User;
import it.unisalento.melanomaDetector.iservice.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return this.userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User save(User user) {
		return this.userRepo.save(user);
	}

}
