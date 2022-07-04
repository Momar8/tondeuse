package utils;

import java.util.ArrayList;
import java.util.List;

import domain.Tondeuse;

public class TondeuseUtils {

	public static List<Tondeuse> lectureTondeuse(List<String> lines) {
		
		List<Tondeuse> listeTondeuse = new ArrayList<>();
		for(int i = 1 ; i< lines.size(); i += 2) {
			var lineSplit = lines.get(i).split(Constantes.SEPARATEUR);
			Position positionInitial = new Position(Integer.parseInt(lineSplit[0]),
				Integer.parseInt(lineSplit[1]));
			Orientation orientation = null;
			
			if("E".equals(lineSplit[2])) {
				orientation = Orientation.E;
			}
			else if("N".equals(lineSplit[2])) {
				orientation = Orientation.N;
			}else if ("S".equals(lineSplit[2])) {
				orientation = Orientation.S;
			} else if ("W".equals(lineSplit[2])) {
				orientation = Orientation.W;
			}
			
			Tondeuse tondeuse = new Tondeuse(positionInitial, orientation,lines.get(i+1));
			listeTondeuse.add(tondeuse);
		}
		return listeTondeuse;
	}
}
