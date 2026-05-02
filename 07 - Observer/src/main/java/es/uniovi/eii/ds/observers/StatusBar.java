package es.uniovi.eii.ds.observers;

import es.uniovi.eii.ds.PollObserver;
import es.uniovi.eii.ds.poll.model.Poll;

public class StatusBar implements PollObserver {
 
    @Override
    public void update(Poll poll) {
        int yeses = poll.yeses();
        int noes = poll.noes();

        String result = String.format("Number of YES votes = %d. Number of NO votes = %d",yeses, noes);
        System.out.println(result);
    }
}
