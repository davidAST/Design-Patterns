package es.uniovi.eii.ds.forms;

public class ChoiceField extends AbstractField {
	private String[] options;


	public ChoiceField(String label, String... options) {
		super(label);
		this.options = options;
	}	

	@Override
	public boolean isValid(String value) {
		for (String each : options) {
			if (value.equalsIgnoreCase(each)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void printErrorMessage() {
		System.out.println("Please enter one of the following options: " + formatOptions() + ". ");
	}

	private String formatOptions() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < options.length; i++) {
			result.append(options[i]);
			if (i < options.length - 2) {
				result.append(", ");
			} else if (i == options.length - 2) {
				result.append(" or ");
			}
		}
		return result.toString();
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
				isValid = false;
				for (String each : options) {
					if (value.equalsIgnoreCase(each)) {
						isValid = true;
						break;
					}
				}
				if (!isValid) {
					System.out.println("Please enter one of the following options: " + formatOptions() + ". ");
				}
			} catch (IOException e) {
				System.out.println("Error reading input. Please try again.");
			}
		} while (!isValid);
	}
	*/

	



	
}
