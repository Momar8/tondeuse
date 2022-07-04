package domain;

import utils.Constantes;
import utils.Orientation;
import utils.Position;

public class Tondeuse {
	Position p;
	Orientation orientation;
	String deplacement;

	public Tondeuse(Position p, Orientation orientation, String deplacement) {
		this.p = p;
		this.orientation = orientation;
		this.deplacement = deplacement;
	}



	public String tondre(int pelouseX, int pelouseY) {
		String deplacementResultat = deplacement;
		Position posResultat = p;
		Orientation orienResultat = orientation;
		for(int i = 0; i < deplacementResultat.length(); i++) {
			switch (deplacementResultat.charAt(i)) {
			case Constantes.DROITE -> orienResultat = deplacementDroit(orienResultat);
			case Constantes.GAUCHE -> orienResultat = deplacementGauche(orienResultat);
			case Constantes.AVANCER -> avancer(pelouseX, pelouseY, posResultat, orienResultat);
			default ->  System.out.println("deplacement inconu");
			}
		}
		return posResultat.getX() + " "+posResultat.getY() + " "+orienResultat.name() + " ";

	}



	private void avancer(int pelouseX, int pelouseY, Position posResultat, Orientation orienResultat) {
		if("N".equals(orienResultat.name())){
			if(posResultat.getY() < pelouseY) {
				posResultat.setY(posResultat.getY() + 1);
			}
		}
		else if("E".equals(orienResultat.name())){
			if(posResultat.getX() < pelouseX) {
				posResultat.setX(posResultat.getX() + 1);
			}
		}
		else if("S".equals(orienResultat.name())){
			if(posResultat.getY() > 0 ) {
				posResultat.setY(posResultat.getY() - 1);
			}
		}
		else if("W".equals(orienResultat.name())){
			if(posResultat.getX() > 0 ) {
				posResultat.setX(posResultat.getX() - 1 );
			}
		}
	}



	private Orientation deplacementGauche(Orientation orienResultat) {
		if(Constantes.NORTH.equals(orienResultat.name())){
			orienResultat = Orientation.W;
		}
		else if(Constantes.EAST.equals(orienResultat.name())){
			orienResultat = Orientation.N;
		}
		else if(Constantes.SOUTH.equals(orienResultat.name())){
			orienResultat = Orientation.E;
		}
		else if(Constantes.WEST.equals(orienResultat.name())){
			orienResultat = Orientation.S;
		}
		return orienResultat;
	}



	private Orientation deplacementDroit(Orientation orienResultat) {
		if(Constantes.NORTH.equals(orienResultat.name())){
			orienResultat = Orientation.E;
		}
		else if(Constantes.EAST.equals(orienResultat.name())){
			orienResultat = Orientation.S;
		}
		else if(Constantes.SOUTH.equals(orienResultat.name())){
			orienResultat = Orientation.W;
		}
		else if(Constantes.WEST.equals(orienResultat.name())){
			orienResultat = Orientation.N;
		}
		return orienResultat;
	}

}
