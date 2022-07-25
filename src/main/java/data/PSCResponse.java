package data;

import java.sql.Time;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PSCResponse {
	
	public String token;
	public String action;
	public String status;
	public String responseTime;
	public String message;
	public JsonElement data;
	public Error error;
	public int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public String getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonElement getData() {
		return data;
	}
	public void setData(JsonElement data) {
		this.data = data;
	}




	
	

}
