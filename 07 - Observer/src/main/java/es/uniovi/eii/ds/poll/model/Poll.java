package es.uniovi.eii.ds.poll.model;

public class Poll 
{
	private int yeses;
	private int noes;
	private String question;
	
	public Poll(String question) {
		this.question = question;
	}

	public String question() {
		return question;
	}

	public int yeses() {
		return yeses;
	}

	public int noes() {
		return noes;
	}

	public void recordYes() {
		yeses++;
		/* updatePieChart();
		updateBarChart();
		saveResults(); */
	}

	public void recordNo() {
		noes++;
		/* updatePieChart();
		updateBarChart();
		saveResults(); */
	}

	/* private void updateBarChart() {
		System.out.println("Drawing a bar chart...");
	}

	private void updatePieChart() {
		System.out.println("Drawing a pie chart...");
	}

	private void saveResults() {
		System.out.println("Saving the results in a database...");
	} */
}
