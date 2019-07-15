package br.com.ilegra.BIDataAnalysis.Infra;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;
public class Scheduler {
	private String pathP = "/home/diegobraun/Documentos/IlegraChallenge/data/in";
	public void shutOnScheduler() {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path directoryPath = Paths.get(pathP);
			directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			while (true) {
				WatchKey key = watchService.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
				Path path = (Path) watchEvent.get().context();
				if (path.toString().endsWith(".dat")) {
					FileReaderPersistence.ReadFile(path.toString());
					FileWriterPersistence fileWriterPersistence = new FileWriterPersistence();
					fileWriterPersistence.InsertReportAtOutputFile();
				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
			watchService.close();
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage() + e.getStackTrace());
		}
}
}