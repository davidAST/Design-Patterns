package es.uniovi.eii.ds.Platforms;

import es.uniovi.eii.ds.android.AndroidAPI;
import es.uniovi.eii.ds.ballgame.BallGame;

public class AndroidGame {

    private BallGame game;

    public AndroidGame() {
        game = new BallGame(new AndroidAPI());
	    
    }

    public void play() {
        game.play();
    }
}
