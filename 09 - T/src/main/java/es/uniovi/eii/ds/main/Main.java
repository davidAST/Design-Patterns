package es.uniovi.eii.ds.main;

import es.uniovi.eii.ds.Platforms.AndroidGame;
import es.uniovi.eii.ds.Platforms.PS5Game;
import es.uniovi.eii.ds.Platforms.WindowsGame;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("ANDROID Game");
		AndroidGame gameA = new AndroidGame();
		gameA.play();

		System.out.println("WINDOWS Game");
		WindowsGame gameW = new WindowsGame();
		gameW.play();
		
		System.out.println("PS5 Game");
		PS5Game gameP = new PS5Game();
		gameP.play();
	}
}
