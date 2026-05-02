package es.uniovi.eii.ds.observers;

import es.uniovi.eii.ds.PollObserver;
import es.uniovi.eii.ds.poll.model.Poll;

public class SaveResults implements PollObserver {

    @Override
    public void update(Poll poll) {
        System.out.println("Saving the results in a database...");
    }
    
}
