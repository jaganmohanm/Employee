package ExceptionHandling;

import java.util.Date;

public class ResponseDetails {
	 
	

	private String message;
	  private String status;

	  public ResponseDetails() {
		super();
	}
	  
	public ResponseDetails( String message, String status) {
	    super();
	    
	 this.message = message;
	    this.status = status;
	  }
	  public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
		public String toString() {
			return "ResponseDetails [message=" + message + ", status=" + status + "]";
		}
}