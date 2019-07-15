package br.com.ilegra.BIDataAnalysis.Infra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderPersistence {
	private static String filePath = "/home/diegobraun/Documentos/IlegraChallenge/data/in/";
	private static Scanner scannerFileReader;
	private static List<String> fileLines = new ArrayList<String>();
	
	public static void ReadFile(String nameOfSpecificFile) throws FileNotFoundException {
		scannerFileReader = new Scanner((Readable) new FileReader(filePath + nameOfSpecificFile));
		
		while(scannerFileReader.hasNext()) {
			
			String fileActualLine = scannerFileReader.nextLine();
			
			if (fileActualLine.contains("001ç")) {
				String [] arrayThatWasCreatedToStorageASpecificRecord = fileActualLine.split("001ç");
				for (int i = 1; i < arrayThatWasCreatedToStorageASpecificRecord.length;i++) {
					fileLines.add("001ç" + arrayThatWasCreatedToStorageASpecificRecord[i]);	
				}
				
			} else if (fileActualLine.contains("002ç")) {
				String [] arrayThatWasCreatedToStorageASpecificRecord = fileActualLine.split("002ç");
				for (int i = 1; i < arrayThatWasCreatedToStorageASpecificRecord.length; i++) {
					fileLines.add("002ç" + arrayThatWasCreatedToStorageASpecificRecord[i]);
				}
				
			} else if (fileActualLine.contains("003ç")) {
				String [] arrayThatWasCreatedToStorageASpecificRecord = fileActualLine.split("003ç");
				for (int i = 1; i < arrayThatWasCreatedToStorageASpecificRecord.length; i++) {
					fileLines.add("003ç" + arrayThatWasCreatedToStorageASpecificRecord[i]);
				}
			}
		}
		scannerFileReader.close();
	}
	
	public static List<String> getFileLines(){
		return fileLines;
	}
}
