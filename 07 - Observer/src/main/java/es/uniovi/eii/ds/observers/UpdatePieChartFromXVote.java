package es.uniovi.eii.ds.observers;

import es.uniovi.eii.ds.PollObserver;
import es.uniovi.eii.ds.poll.model.Poll;

public class UpdatePieChartFromXVote implements PollObserver {

    private int vote;

    public UpdatePieChartFromXVote(int vote) {
        this.vote = vote;
    }

    @Override
    public void update(Poll poll) {
        if ((poll.yeses() + poll.noes()) >= vote) {
            System.out.println("Drawing a pie chart...");
        }
    }

}
