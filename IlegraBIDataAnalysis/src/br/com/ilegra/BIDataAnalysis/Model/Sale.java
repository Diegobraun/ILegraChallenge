package br.com.ilegra.BIDataAnalysis.Model;

public class Sale extends Entity{
	private Integer saleId;
	private Double salePrice;
	
	public Sale(Integer salesId, Double salePrice, String name) {
		super(003, name);
		this.saleId = salesId;
		this.salePrice = salePrice;
	}

	public Integer getSaleId() {
		return saleId;
	}


	public Double getSalePrice() {
		return salePrice;
	}

	
	
}
