import javax.swing.JFrame;

public class FenetreJeu extends JFrame {
	public FenetreJeu(){
		super();
		build();
	}

	private void build() {
		setTitle("Pacman");
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
