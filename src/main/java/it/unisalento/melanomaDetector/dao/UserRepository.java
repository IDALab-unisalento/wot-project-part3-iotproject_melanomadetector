package it.unisalento.melanomaDetector.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unisalento.melanomaDetector.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String email, String password);

	public User findByEmailAndPasswordAndType(String email, String password, String type);
}
