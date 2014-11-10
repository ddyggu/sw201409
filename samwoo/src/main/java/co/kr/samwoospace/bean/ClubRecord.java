package co.kr.samwoospace.bean;

public class ClubRecord extends BoardRecord {
	private String facebook;
	private String twitter;
	private String clubname;
	private String thumbUrl;
	private String encodedFileName;
	private int clubNum;
	
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
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getEncodedFileName() {
		return encodedFileName;
	}
	public void setEncodedFileName(String encodedFileName) {
		this.encodedFileName = encodedFileName;
	}
	public int getClubNum() {
		return clubNum;
	}
	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}
	
}
