import javax.swing.SwingUtilities;


public class Pacman {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreJeu fenPrin = new FenetreJeu();
				fenPrin.setVisible(true);
			}
		});
	}
}
