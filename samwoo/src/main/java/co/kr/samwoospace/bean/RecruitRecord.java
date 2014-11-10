package co.kr.samwoospace.bean;

public class RecruitRecord extends BoardRecord {
	
	private String division;
	private String career;
	private String startDate;
	private String endDate;
	private String mainExpose;
	private String isEnd;
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	
	public String getMainExpose() {
		return mainExpose;
	}
	public void setMainExpose(String mainExpose) {
		this.mainExpose = mainExpose;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}
	
}
