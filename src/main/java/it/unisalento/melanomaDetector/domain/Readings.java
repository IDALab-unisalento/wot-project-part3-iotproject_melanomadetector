package it.unisalento.melanomaDetector.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Readings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String image;

	String highestPredictionClass;

	float highestPredictionScore;

	int risk;

	@ManyToOne(optional = false)
	User user;

	public Readings(int id, String image, String highestPredictionClass, float highestPredictionScore, int risk,
			User user) {
		super();
		this.id = id;
		this.image = image;
		this.highestPredictionClass = highestPredictionClass;
		this.highestPredictionScore = highestPredictionScore;
		this.risk = risk;
		this.user = user;
	}

	public Readings() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHighestPredictionClass() {
		return highestPredictionClass;
	}

	public void setHighestPredictionClass(String highestPredictionClass) {
		this.highestPredictionClass = highestPredictionClass;
	}

	public float getHighestPredictionScore() {
		return highestPredictionScore;
	}

	public void setHighestPredictionScore(float highestPredictionScore) {
		this.highestPredictionScore = highestPredictionScore;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
