package co.kr.samwoospace.bean;

public enum Division {
	A("건설사업관리"), B("건축설계"), C("미디어 사업"), D("기술 연구소");
	
	private String name;
	
	private Division(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
