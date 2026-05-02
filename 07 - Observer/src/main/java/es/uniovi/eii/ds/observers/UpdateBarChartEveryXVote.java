package es.uniovi.eii.ds.observers;

import es.uniovi.eii.ds.PollObserver;
import es.uniovi.eii.ds.poll.model.Poll;

public class UpdateBarChartEveryXVote implements PollObserver {

    private int vote;

    public UpdateBarChartEveryXVote(int vote) {
        this.vote = vote;
    }

    @Override
    public void update(Poll poll) {
        if ((poll.yeses() + poll.noes()) % vote == 0) {
            System.out.println("Drawing a bar chart...");
        }
    }

}
