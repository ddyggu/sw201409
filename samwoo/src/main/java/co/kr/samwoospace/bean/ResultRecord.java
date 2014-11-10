package co.kr.samwoospace.bean;

public class ResultRecord extends BoardRecord {
	private String division;
	private String category;
	private String category_name;
	private String mainExpose;
	private String encodedFileName;
	private String thumbUrl;
	private String fileName;
	private String location;
	private String lotArea;
	private String totalArea;
	private String size;
	
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getMainExpose() {
		return mainExpose;
	}
	public void setMainExpose(String mainExpose) {
		this.mainExpose = mainExpose;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEncodedFileName() {
		return encodedFileName;
	}
	public void setEncodedFileName(String encodedFileName) {
		this.encodedFileName = encodedFileName;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLotArea() {
		return lotArea;
	}
	public void setLotArea(String lotArea) {
		this.lotArea = lotArea;
	}
	public String getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
