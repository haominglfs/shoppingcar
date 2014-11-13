package cn.lut.shopping.bean;

public class Product {

	private int pid;
	private String pname;
	private String pdesc;
	private double pprice;
	
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	
	
}
