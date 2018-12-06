package ExceptionHandling;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)

public class EmployeeException extends RuntimeException{
	public EmployeeException(String exception)
	{
	super(exception);
	}
}
