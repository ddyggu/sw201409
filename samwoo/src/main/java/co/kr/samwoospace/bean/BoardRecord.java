package co.kr.samwoospace.bean;

import org.springframework.web.multipart.MultipartFile;

public class BoardRecord {
	private Integer num;
	private String title;
	private String writer;
	private String contents;
	private String date;
	private int readCounts;
	private int groupNum;
	private int step;
	private int depth;
	private String bbsId;
	private String bbsName;
	private MultipartFile file;
	
	public BoardRecord() {}
	public BoardRecord(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReadCounts() {
		return readCounts;
	}
	public void setReadCounts(int readCounts) {
		this.readCounts = readCounts;
	}
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("title : "); sb.append(title); sb.append("\n");
		sb.append("content : "); sb.append(contents); sb.append("\n");
		return sb.toString();
	}
	
}
