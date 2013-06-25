import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame {
		
	Panneau panneau;
	JFrame fen;
	
	public FenetreJeu(){
		super();
		build();
	}

	private void build() {
		this.fen = new JFrame();
		
		fen.setTitle("Pacman");
		fen.setSize(600,400);
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panneau = new Panneau();
		
		fen.setContentPane( this.panneau );
		
		fen.setVisible(true);
	}
	
		
	
	
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	
	
	public void peindreMurs( Map map )
	{
		this.getPanneau().peindreMurs(map);
	}
}
