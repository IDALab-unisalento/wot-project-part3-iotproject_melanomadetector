package it.unisalento.melanomaDetector.dto;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

public class ReadingsDTO {

	@NotEmpty
	int id;

	@Lob
	byte[] image;

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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
