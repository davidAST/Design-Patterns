package es.uniovi.eii.ds.fylesystem.decorators;

import es.uniovi.eii.ds.fylesystem.Output;
import java.io.IOException;

public class RemoveSpacesDecorator implements Output {
    private Output output;
    private boolean wasLastSpace = false;

    public RemoveSpacesDecorator(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        if (c == ' ') {
            if (wasLastSpace) {
                return; 
            }
            wasLastSpace = true;
        } else {
            wasLastSpace = false;
        }
        output.write(c);
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
