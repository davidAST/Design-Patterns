package es.uniovi.eii.ds.observers;

import es.uniovi.eii.ds.PollObserver;
import es.uniovi.eii.ds.poll.model.Poll;

public class StatusBarFromXEveryYVotes implements PollObserver {

    private int startVote;
    private int intervalVote;

    public StatusBarFromXEveryYVotes(int startVote, int intervalVote) {
        this.startVote = startVote;
        this.intervalVote = intervalVote;
    }

    @Override
    public void update(Poll poll) {
        int votes = poll.yeses() + poll.noes();
        if (votes >= startVote) {
            if (votes % intervalVote == 0) {
                int yeses = poll.yeses();
                int noes = poll.noes();

                String result = String.format("Number of YES votes = %d. Number of NO votes = %d",yeses, noes);
                System.out.println(result);
            }
        }
    }

}
