package es.uniovi.eii.ds.forms;

public class TextField extends AbstractField {

	public TextField(String label) {
		super(label);
	}

	@Override
	public boolean isValid(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void printErrorMessage() {
		System.out.println("Please enter letters only.");
	}
	
	/*
	@Override
	public void prompt() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		boolean isValid = false; 
		do {
			try {
				System.out.print(label + ": ");
				value = console.readLine();
				isValid = true;
				for (char ch : value.toCharArray()) {
					if (!Character.isLetter(ch)) {
						isValid = false;
						break;
					}
				}
				if (!isValid) {
					System.out.println("Please enter letters only.");
				}
			} catch (IOException e) {
				System.out.println("Error reading input. Please try again.");
			}
		} while (!isValid);
	}
	 */
}
