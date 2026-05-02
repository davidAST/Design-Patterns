package es.uniovi.eii.ds.fylesystem;

import java.io.*;

public class FileSystem {

	public void copyFile(String filename, Output output) {
		try (InputStream in = getClass().getClassLoader().getResourceAsStream(filename)) {
			try (Reader reader = new InputStreamReader(in)) {
				output.open();
				int c;
				while ((c = reader.read()) != -1) {
					output.write((char) c);
				}
				output.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurred while copying the file.");
		}
	}
}
