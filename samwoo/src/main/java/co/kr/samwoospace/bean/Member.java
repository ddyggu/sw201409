package co.kr.samwoospace.bean;

public class Member {
	private String id;
	private String pass;
	private String name;
	
	public Member() { }
	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "id : " + id + ", password : " + pass + ", name : " + name;
	}
	
}
