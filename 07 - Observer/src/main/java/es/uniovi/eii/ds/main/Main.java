package es.uniovi.eii.ds.main;

import java.io.*;

import es.uniovi.eii.ds.PollObservable;
import es.uniovi.eii.ds.observers.SaveResults;
import es.uniovi.eii.ds.observers.StatusBar;
import es.uniovi.eii.ds.observers.StatusBarFromXEveryYVotes;
import es.uniovi.eii.ds.observers.UpdateBarChart;
import es.uniovi.eii.ds.observers.UpdateBarChartEveryXVote;
import es.uniovi.eii.ds.observers.UpdatePieChart;
import es.uniovi.eii.ds.observers.UpdatePieChartFromXVote;
import es.uniovi.eii.ds.poll.model.Poll;
import es.uniovi.eii.ds.poll.ui.PollConsoleUI;

@SuppressWarnings("unused") // Because the imports will not be used when commented 
public class Main {
	
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("Are you in favor of nuclear energy?");

		PollObservable observable = new PollObservable(poll);
		/* 
		// ORIGINAL IMPLEMENTATION
		// Bar chart
		// Pie chart
		// Save results
		System.out.println("_____________________________ ORIGINAL IMPLEMENTATION _____________________________");
		observable.subscribe(new UpdateBarChart());
		observable.subscribe(new UpdatePieChart());
		observable.subscribe(new SaveResults());
		 */

		/* 
		// PROGRAM 1 -- Adding a status bar
		// Bar chart
		// Pie chart
		// Save results
		// Status line
		System.out.println("_____________________________ PROGRAM 1 _____________________________");
		observable.subscribe(new UpdateBarChart());
		observable.subscribe(new UpdatePieChart());
		observable.subscribe(new SaveResults());
		observable.subscribe(new StatusBar());
		 */

		/*  
		// PROGRAM 2
		// Pie chart
		// Status line 
		System.out.println("_____________________________ PROGRAM 2 _____________________________");
		observable.subscribe(new UpdatePieChart());
		observable.subscribe(new StatusBar());
		*/

		
		/* 
		// PROGRAM 3 
		// Pie chart starting from 3rd vote
		// Status line with each vote
		System.out.println("_____________________________ PROGRAM 3 _____________________________");
		observable.subscribe(new UpdatePieChartFromXVote(3));
		observable.subscribe(new StatusBar()); 
		*/

		/* 
		// PROGRAM 4 
		// Pie chart starting from 3rd vote
		// Status line with each vote
		// Bar chart every 3 votes
		System.out.println("_____________________________ PROGRAM 4 _____________________________");
		observable.subscribe(new UpdatePieChartFromXVote(3));
		observable.subscribe(new StatusBar());
		observable.subscribe(new UpdateBarChartEveryThirdVote(3));
 		*/

		// PROGRAM 5
		// Pie chart starting from 3rd vote
		// Status line from vote 4 every 2 votes (4, 6, 8...)
		// Bar chart every 3 votes
		System.out.println("_____________________________ PROGRAM 5 _____________________________");
		observable.subscribe(new UpdatePieChartFromXVote(3));
		observable.subscribe(new StatusBarFromXEveryYVotes(4,2));
		observable.subscribe(new UpdateBarChartEveryXVote(3));

		PollConsoleUI ui = new PollConsoleUI();
		ui.fill(observable);
	}
}