package ExceptionHandling;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;



@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	HttpHeaders headers;
	HttpStatus status;
	
 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<ResponseDetails> handleAllExceptions(Exception exception, WebRequest request) {
	    ResponseDetails errorDetails = new ResponseDetails( exception.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	@ExceptionHandler(EmployeeException.class)
	  public final ResponseEntity<ResponseDetails> employeeNotFoundException(EmployeeException exception, WebRequest request) {
	    ResponseDetails errorDetails = new ResponseDetails( exception.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	
	
	
}
