package co.kr.samwoospace.bean;

public class ClubInfoRecord {
	private int num;
	private String clubname;
	private String targetGroup;
	private String activityGroup;
	private String president;
	private String description;
	private String bbsId;
	private String bbsName;
	private String facebook;
	private String twitter;
	private String etc_community;
	private String thumbUrl;
	private String fileName;
	private String encodedFileName;
	
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public String getTargetGroup() {
		return targetGroup;
	}
	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}
	public String getActivityGroup() {
		return activityGroup;
	}
	public void setActivityGroup(String activityGroup) {
		this.activityGroup = activityGroup;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getEtc_community() {
		return etc_community;
	}
	public void setEtc_community(String etc_community) {
		this.etc_community = etc_community;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
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
	public String toString() {
		return clubname;
	}
	
}
