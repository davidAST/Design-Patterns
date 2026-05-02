package es.uniovi.eii.ds.fylesystem.outputs;

import java.io.*;

import es.uniovi.eii.ds.fylesystem.Output;

public class Internet implements Output {
    
    String url;
    private Writer output;

    public Internet(String url) {
        this.url = url;
    }

    @Override
    public void open() throws IOException {
        output = new StringWriter();
        System.out.println("\n--- START Internet [" + url + "]");
    }

    @Override
    public void write(char c) throws IOException {
        output.append(c);
    }

    @Override
    public void close() {
        System.out.println(output.toString());
        System.out.println("--- END   Internet");
    }
}
