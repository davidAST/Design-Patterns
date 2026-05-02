package es.uniovi.eii.ds.fylesystem.outputs;

import java.io.*;

import es.uniovi.eii.ds.fylesystem.Output;

public class FileOutput implements Output {

    String filename;
    FileWriter output;

    public FileOutput(String filename) {
        // Always write inside the project "output" folder
        this.filename = "output/" + filename;
    }

    @Override
    public void open() throws IOException {
        output = new FileWriter(filename);
    }   

    @Override
    public void write(char c) throws IOException {
        output.append(c);
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}