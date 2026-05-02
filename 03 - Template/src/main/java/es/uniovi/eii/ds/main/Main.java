package es.uniovi.eii.ds.main;

import es.uniovi.eii.ds.forms.*;

public class Main {

	public static void main(String[] args) {
		
		Form form = new Form();

		form.add(new TextField("First name"))
			.add(new TextField("Surname"))
			.add(new NumericField("Phone"))
			.add(new ChoiceField("City", "Oviedo", "Gijón", "Avilés"));

		form.fill();

		form.show();
	}
}
