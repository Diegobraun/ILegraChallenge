
package br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ilegra.BIDataAnalysis.Infra.FileReaderPersistence;
import br.com.ilegra.BIDataAnalysis.Model.Sale;

public class ManagerSales{
	private List<Sale> salesRecords = new ArrayList<Sale>();;

	public void addSalesMan(Sale sale) {
		salesRecords.add(sale);
	}

	public List<Sale> getSalesRecords() {
		return Collections.unmodifiableList(salesRecords);
	}

	public void getAllTheSalesEver() {
		for (int i = 0; i < FileReaderPersistence.getFileLines().size();i++) {
			if (FileReaderPersistence.getFileLines().get(i).startsWith("003ç")) {
					String [] singularCustomerValues = FileReaderPersistence.getFileLines().get(i).split("ç");
					salesRecords.add(new Sale(Integer.parseInt(singularCustomerValues[1]), getSalesPrice(singularCustomerValues[2]), singularCustomerValues[3]));
			}
		}
	}

	private Double getSalesPrice(String sale) {
		double pricePattern = 0;
		String separateOfSales[] = sale.split(",");
		for (int i = 0; i < separateOfSales.length; i++) {
			String separateOfSalesProperties[] = separateOfSales[i].split("-");
			pricePattern = pricePattern + Double.parseDouble(separateOfSalesProperties[1].replace("[", ""))
					* Double.parseDouble(separateOfSalesProperties[2].replace("]", ""));
		}
		return pricePattern;
	}
	
	public Integer returnIdFromTheMostExpensiveSale() {
		Sale mostExpensive = null;
		for (int i = 0;i < salesRecords.size();i++) {
			if (i == 0)
				mostExpensive = salesRecords.get(i);
			else {
				if (salesRecords.get(i).getSalePrice() > mostExpensive.getSalePrice()) {
					mostExpensive = salesRecords.get(i);
				}
			}
		}
		return mostExpensive.getId();
	}
	
	public String returnNameOfTheWorstSalesmanEver() {
		Sale worst = null;
		for (int i = 0;i < salesRecords.size();i++) {
			if (i == 0)
				worst = salesRecords.get(i);
			else {
				if (salesRecords.get(i).getSalePrice() < worst.getSalePrice()) {
					worst = salesRecords.get(i);
				}
			}
		}
		return worst.getName();
	}
	
}

