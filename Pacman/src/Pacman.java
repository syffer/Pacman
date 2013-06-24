import javax.swing.SwingUtilities;


public class Pacman {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Map maMap = new Map("rsc\\map.txt");
				
				//FenetreJeu fenPrin = new FenetreJeu();
				//fenPrin.setVisible(true);
				
				fenPrin.peindreMurs(maMap);
				
			}
		});
	}
}
