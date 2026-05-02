package es.uniovi.eii.ds;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.eii.ds.poll.model.Poll;

public class PollObservable {
    private Poll poll;
    private List<PollObserver> polls = new ArrayList<>();

    public PollObservable(Poll poll) {
        this.poll = poll;
    }

    public void subscribe(PollObserver observer) {
        polls.add(observer);
    }

    public void unsubscribe(PollObserver observer) {
        polls.remove(observer);
    }

    public void recordYes() {
        poll.recordYes();
        notifyObservers();
    }

    public void recordNo() {
        poll.recordNo();
        notifyObservers();
    }

    private void notifyObservers() {
        for (PollObserver observer : polls) {
            observer.update(poll);
        }
    }

    public Poll getPoll() {
        return poll;
    }
}
