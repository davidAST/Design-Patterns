package es.uniovi.eii.ds.editor.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Drawing  {
	
	private List<Figure> figures = new ArrayList<>();

	
	public void addFigure(Figure figure) {
		figures.add(figure);
	}

	public Optional<Figure> getFigure(int x, int y) {
		for (Figure figure : figures) {
			if (figure.figureSelected(new Point(x,y))) {
				return Optional.of(figure);
			}
		}
		return Optional.empty();
	}
	

	public void draw() {
		for (Figure figure : figures) {
			figure.draw();
		}
	}
}
