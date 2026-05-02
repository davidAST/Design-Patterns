package es.uniovi.eii.ds.fylesystem.decorators;

import java.io.IOException;

import es.uniovi.eii.ds.fylesystem.*;

public class NormalizeDecorator implements Output {

    private Output output;
    private boolean prevWasR = false;

    public NormalizeDecorator(Output output) {
        this.output = output;
    }

    @Override
    public void write(char c) throws IOException {
        if (c == '\r') {
            prevWasR = true;
        }
        else {
            if (prevWasR && c == '\n') {
            output.write(c);
            }
            else if (prevWasR) {
                output.write('\r');
                output.write(c);
            }
            else {
                output.write(c);
            }
            prevWasR = false;
        }
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
