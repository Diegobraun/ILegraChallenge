package br.com.ilegra.BIDataAnalysis.Model;

public class Customer extends Entity{
	private String cnpj;
	private String businessArea;
	public Customer(String name, String cnpj, String businessArea) {
		super(002, name);
		this.cnpj = cnpj;
		this.businessArea = businessArea;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	
	
}
