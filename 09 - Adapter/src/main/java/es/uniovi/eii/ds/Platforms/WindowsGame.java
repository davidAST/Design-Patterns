package es.uniovi.eii.ds.Platforms;

import es.uniovi.eii.ds.ballgame.BallGame;
import es.uniovi.eii.ds.windows.WindowsAPI;

public class WindowsGame {
    private BallGame game;

    public WindowsGame() {
        game = new BallGame(new WindowsAPI());

    }

    public void play() {
        game.play();
    }
}
