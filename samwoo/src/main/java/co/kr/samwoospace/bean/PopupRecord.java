package co.kr.samwoospace.bean;

public class PopupRecord {
	private int num;
	private String bbsId;
	private String bbsName;
	private String title;
	private String startDate;
	private String endDate;
	private String expose;
	private int width;
	private int height;
	private int positionTop;
	private int positionLeft;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getExpose() {
		return expose;
	}
	public void setExpose(String expose) {
		this.expose = expose;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getPositionTop() {
		return positionTop;
	}
	public void setPositionTop(int positionTop) {
		this.positionTop = positionTop;
	}
	public int getPositionLeft() {
		return positionLeft;
	}
	public void setPositionLeft(int positionLeft) {
		this.positionLeft = positionLeft;
	}
	public String toString() {
		return title + " : " + title;
	}
	public String getBbsId() {
		return bbsId;
	}
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsName() {
		return bbsName;
	}
	public void setBbsName(String bbsName) {
		this.bbsName = bbsName;
	}
	
}
