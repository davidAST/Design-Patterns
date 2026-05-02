package es.uniovi.eii.ds.poll.ui;

import java.io.*;

import es.uniovi.eii.ds.PollObservable;
import es.uniovi.eii.ds.poll.model.Poll;

public class PollConsoleUI {

	public void fill(PollObservable observable) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Valid answers: [yes] / [no]");

		while (true) {
			System.out.println();
			System.out.println(observable.getPoll().question());
			System.out.print("> ");

			// Read the user's input (it doesn't check if the number of words is correct)
			String[] line = input.readLine().split(" ");

			if (line[0].equals("exit")) {
				System.out.println("Bye!");
				return;
			}

			if (line[0].equals("yes")) {
				observable.recordYes();
			}
			if (line[0].equals("no")) {
				observable.recordNo();
			}
		}
	}
}

