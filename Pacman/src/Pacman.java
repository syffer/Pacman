import javax.swing.SwingUtilities;

public class Pacman {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				// chargement des maps dans les classes appropriées
				Map maMap = new Map("rsc\\map.txt");
				Map mapPoint = new Map("rsc\\mapPoint.txt");
				
				// création de la fenêtre et des pastilles
				FenetreJeu fenPrin = new FenetreJeu();
				fenPrin.peindreMurs(maMap,mapPoint);
			
			
			}
		});
	}
}
