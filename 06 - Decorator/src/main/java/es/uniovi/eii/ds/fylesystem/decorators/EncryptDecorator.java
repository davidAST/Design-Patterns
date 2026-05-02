package es.uniovi.eii.ds.fylesystem.decorators;

import java.io.IOException;

import es.uniovi.eii.ds.fylesystem.*;

public class EncryptDecorator implements Output {

    private Output output;

    public EncryptDecorator(Output output) {
        this.output = output;
    }

    @Override
    public void write(char c) throws IOException {
        if (Character.isLetterOrDigit(c)) {
            c = (char) (c + 1);
        }
        output.write(c);
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
