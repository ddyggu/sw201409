package co.kr.samwoospace.bean;

/**
 * 고객문의, FAQ 관련 DTO 오브젝트
 * 
 * @author roscoe
 *
 */
public class ConsultRecord {
	
	private String company;
	private String name;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email1;
	private String email2;
	private String title;
	private String contents;
	private String date;
	private String a_writer;
	private String a_answer;
	private String a_date;
	private int num;
	private int readCounts;
	private String bbsId;
	private String bbsName;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getA_writer() {
		return a_writer;
	}
	public void setA_writer(String a_writer) {
		this.a_writer = a_writer;
	}
	public String getA_answer() {
		return a_answer;
	}
	public void setA_answer(String a_answer) {
		this.a_answer = a_answer;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public void setBbsName(String bbsname) {
		this.bbsName = bbsname;
	}
	public int getReadCounts() {
		return readCounts;
	}
	public void setReadCounts(int readCounts) {
		this.readCounts = readCounts;
	}
	
}
