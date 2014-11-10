package co.kr.samwoospace.bean;

public enum Category {

	RD("Residence", "주거시설"),
	EDLA("Education_Laboratory","교육/연구시설"),   		
	MEWE("Medical_Welfare","의료/복지시설"), 
	OF("Office","업무시설"),			 
	CA("Culture_Assembly", "문화/집회시설"),
	MICO("Military_Correctional","군사/교정시설"),	 			
	ETC("ETC","기타");
	
	private String description;
	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Category(String description, String name) {
		this.setDescription(description);
		this.setName(name);
	}

	
}
