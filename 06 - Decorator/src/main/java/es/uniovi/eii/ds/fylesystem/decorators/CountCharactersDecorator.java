package es.uniovi.eii.ds.fylesystem.decorators;

import es.uniovi.eii.ds.fylesystem.Output;
import java.io.IOException;

public class CountCharactersDecorator implements Output {
    private final Output output;
    private int chars = 0;

    public CountCharactersDecorator(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        output.write(c);
        chars++;
    }

    @Override
    public void close() throws IOException {
        output.close();
    }

    public int getCount() {
        return chars;
    }
}