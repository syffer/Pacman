import javax.swing.SwingUtilities;

public class Pacman {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Map maMap = new Map("rsc\\map.txt");
				
				Map mapPoint = new Map("rsc\\mapPoint.txt");
				
				
				//System.out.println( maMap.toString() );

				FenetreJeu fenPrin = new FenetreJeu();
				fenPrin.peindreMurs(maMap,mapPoint);
			}
		});
	}
}
