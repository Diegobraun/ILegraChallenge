
package br.com.ilegra.BIDataAnalysis.Model.EntitiesManagers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ilegra.BIDataAnalysis.Infra.FileReaderPersistence;
import br.com.ilegra.BIDataAnalysis.Model.Customer;

public class ManagerCustomers{
	private static List<Customer> customersRecords = new ArrayList<Customer>();
	
	public void addCustomer(Customer customer) {
		customersRecords.add(customer);
	}

	public List<Customer> getCustomerRecords() {
		return Collections.unmodifiableList(customersRecords);
	}
	
	public void getAllTheCustomersEver() {
		for (int i = 0; i < FileReaderPersistence.getFileLines().size();i++) {
			if (FileReaderPersistence.getFileLines().get(i).startsWith("002ç")) {
					String [] singularCustomerValues = FileReaderPersistence.getFileLines().get(i).split("ç");
					customersRecords.add(new Customer(singularCustomerValues[2], singularCustomerValues[1], singularCustomerValues[3]));
			}
		}
	}
	
}

