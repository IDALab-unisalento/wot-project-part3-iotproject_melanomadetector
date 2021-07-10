package it.unisalento.melanomaDetector.dto;

import javax.validation.constraints.NotEmpty;

public class ReadingsDTO {

	int id;

	@NotEmpty
	String image;

	@NotEmpty
	String highestPredictionClass;

	@NotEmpty
	float highestPredictionScore;

	@NotEmpty
	int risk;

	@NotEmpty
	UserDTO user;

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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
