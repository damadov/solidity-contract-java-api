package data;

public class Error {

	/*
	 * 
	 {
	  "error":{
	    "code": 404
	    "message": "File Not Found"
	  }
	}
	 * 
	 */
	
	public String code;
	public String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
