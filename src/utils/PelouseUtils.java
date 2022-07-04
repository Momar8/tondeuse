package utils;

import java.util.List;

import domain.Pelouse;

public class PelouseUtils {

	public static Pelouse lecturePelouse(List<String> lines) {
		String positionsRead = lines.get(0);

		var positionsPrecises = positionsRead.split(Constantes.SEPARATEUR);
		Position position = new Position(Integer.parseInt(positionsPrecises[0]),
				Integer.parseInt(positionsPrecises[1]));

		return new Pelouse(position);
	}
}
