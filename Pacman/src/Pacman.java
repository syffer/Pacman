

import javax.swing.SwingUtilities;

public class Pacman 
{

	public static void main(String[] args) {
		Map maMap = new Map("rsc\\map.txt");				
		
		FenetreJeu fenPrin = new FenetreJeu();
		fenPrin.peindreMurs(maMap);
	}

	
}
