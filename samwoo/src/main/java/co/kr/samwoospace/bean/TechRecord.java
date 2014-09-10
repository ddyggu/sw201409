package co.kr.samwoospace.bean;

public class TechRecord extends BoardRecord {
	private String division;
	private String encodedFileName;
	private String thumbUrl;
	private String fileName;
	
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEncodedFileName() {
		return encodedFileName;
	}

	public void setEncodedFileName(String encodedFileName) {
		this.encodedFileName = encodedFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	
}
