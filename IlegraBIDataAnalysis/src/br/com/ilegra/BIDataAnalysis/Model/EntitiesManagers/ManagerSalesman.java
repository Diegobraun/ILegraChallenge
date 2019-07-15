package br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ilegra.BIDataAnalysis.Infra.FileReaderPersistence;
import br.com.ilegra.BIDataAnalysis.Model.SalesMan;

public class ManagerSalesman{
	private List<SalesMan> salesMenRecords = new ArrayList<SalesMan>();
	
	public void addSalesMan(SalesMan salesMan) {
		salesMenRecords.add(salesMan);
	}

	public List<SalesMan> getSalesMenRecords() {
		return Collections.unmodifiableList(salesMenRecords);
	}

	public void getAllTheSalesmanEver() {
		for (int i = 0; i < FileReaderPersistence.getFileLines().size();i++) {
			if (FileReaderPersistence.getFileLines().get(i).startsWith("001ç")) {
					String [] singularSalesmanValues = FileReaderPersistence.getFileLines().get(i).split("ç");
					salesMenRecords.add(new SalesMan(singularSalesmanValues[2], singularSalesmanValues[1], Double.parseDouble(singularSalesmanValues[3])));
			}
		}
	}
	
	
	
}
