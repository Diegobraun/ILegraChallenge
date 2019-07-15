package br.com.ilegra.BIDataAnalysis.Application;

import java.io.FileNotFoundException;

import br.com.ilegra.BIDataAnalysis.Infra.Scheduler;

public class Starter {
	public static void main(String[] args) throws FileNotFoundException {
		Scheduler scheduler = new Scheduler();
		scheduler.shutOnScheduler();
	}
}
																													