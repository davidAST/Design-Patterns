package es.uniovi.eii.ds.Platforms;

import es.uniovi.eii.ds.ballgame.BallGame;
import es.uniovi.eii.ds.playstation.Playstation5API;

public class PS5Game {
    private BallGame game;

    public PS5Game() {
        game = new BallGame(new Playstation5API());
    }

    public void play() {
        game.play();
    }
}
