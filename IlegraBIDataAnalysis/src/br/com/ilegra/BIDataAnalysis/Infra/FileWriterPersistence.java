package br.com.ilegra.BIDataAnalysis.Infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers.ManagerCustomers;
import br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers.ManagerSales;
import br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers.ManagerSalesman;

public class FileWriterPersistence {
	private String filePath = "/home/diegobraun/Documentos/IlegraChallenge/data/out/outputfile.dat";
	
	private ManagerCustomers managerCustomers = new ManagerCustomers();
	private ManagerSales managerSales = new ManagerSales();
	private ManagerSalesman managerSalesman = new ManagerSalesman();

	public FileWriterPersistence() {
		this.managerCustomers.getAllTheCustomersEver();
		this.managerSales.getAllTheSalesEver();
		this.managerSalesman.getAllTheSalesmanEver();
	}
	public void InsertReportAtOutputFile() throws FileNotFoundException {

		File file = new File(filePath);
		
		PrintStream printStream = new PrintStream(file);
		printStream.append("Amount of clients in the input file: " + this.managerCustomers.getCustomerRecords().size() + "\r\n");
		printStream.append("Amount of salesman in the input file: " + this.managerSalesman.getSalesMenRecords().size() + "\r\n");
		printStream.append("Id of the most expensive sale: " + this.managerSales.returnIdFromTheMostExpensiveSale() + "\r\n");
		printStream.append("Worst salesman ever: " + this.managerSales.returnNameOfTheWorstSalesmanEver() + "\r\n");
		printStream.close();
	}
}

