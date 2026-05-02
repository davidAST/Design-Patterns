package es.uniovi.eii.ds;

import es.uniovi.eii.ds.poll.model.Poll;

public interface PollObserver {
    void update(Poll poll);
}
