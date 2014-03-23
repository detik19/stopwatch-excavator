package net.rt.stopwatch.model;

public class Operator {
	private String name;
	private String nrp;
	private String KU;
	public String getKU() {
		return KU;
	}
	public void setKU(String kU) {
		KU = kU;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	private String site;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrp() {
		return nrp;
	}
	public void setNrp(String nrp) {
		this.nrp = nrp;
	}

}
