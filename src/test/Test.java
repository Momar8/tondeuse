package test;


import java.io.IOException;
import java.util.stream.Collectors;

import utils.FichierUtils;
import utils.PelouseUtils;
import utils.TondeuseUtils;

public class Test {

	public static void main(String[] args) throws IOException {

		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("Chemin ou nom de fichier incorrecte");
		}

		var lignes = FichierUtils.lectureFichier(args[0]);
		//Vérifier si le fichier est valide
		if(FichierUtils.checkValidite(lignes)) {
			//Récupérer la pelouse
			var cordonneePelouse = PelouseUtils.lecturePelouse(lignes);		
			// Positon Tondeuse
			var coordonneeEtMouvementTondeuse  = TondeuseUtils.lectureTondeuse(lignes);

			System.out.println(coordonneeEtMouvementTondeuse.stream()
					.map(Tondeuse -> Tondeuse.tondre(cordonneePelouse.getP().getX(),cordonneePelouse.getP().getY()))
					.collect(Collectors.joining())
					.trim());
		}

	}
}
