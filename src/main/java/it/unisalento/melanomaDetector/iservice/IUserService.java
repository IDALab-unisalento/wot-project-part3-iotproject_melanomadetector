package it.unisalento.melanomaDetector.iservice;

import it.unisalento.melanomaDetector.domain.User;

public interface IUserService {

	public User getByEmailAndPassword(String email, String password);

	public User getByEmailAndPasswordAndType(String email, String password, String type);

	public User save(User user);

	public User getById(int id);
}
