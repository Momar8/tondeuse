package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FichierUtils {

	public static List<String> lectureFichier(String nomFichier) throws IOException {   
		return Files.lines(Paths.get(nomFichier)).toList();
	}
	
	public static Boolean checkValidite(List<String> lines) throws IOException {   
		if(lines == null || lines.size() < 3) {
			throw new IllegalArgumentException("Chemin ou nom de fichier incorrecte");
		}
		return true;
	}
	

}
