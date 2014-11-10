package co.kr.samwoospace.bean;

public class ResponStatus {
	private boolean status;
	private String message;

	public ResponStatus() {}
	
	public ResponStatus(boolean status, String message) {
		this.setStatus(status);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
