package es.uniovi.eii.ds.graphics;

// This class is supposed to be provided by the graphics library, 
// and it is used as is by the game and the different platforms.
//
public class Image2D {
		
	private int width, height;
	private byte[] pixels;
	private String name;

	public Image2D(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public byte[] getPixels() {
		return pixels;
	}
}