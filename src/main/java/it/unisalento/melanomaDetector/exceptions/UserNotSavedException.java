package it.unisalento.melanomaDetector.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "user not saved")
public class UserNotSavedException extends Exception {

}
