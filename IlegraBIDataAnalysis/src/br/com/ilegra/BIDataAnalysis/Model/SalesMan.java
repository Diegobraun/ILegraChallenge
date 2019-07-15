package br.com.ilegra.BIDataAnalysis.Model;

public class SalesMan extends Entity{
	private String cpf;
	private Double salary;
	
	public SalesMan(String name,String cpf, Double salary) {
		super(001,name);
		this.cpf = cpf;
		this.salary = salary;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
