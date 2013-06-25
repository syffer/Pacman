import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		fen.setResizable(true);
		Dimension min = new Dimension(200, 200);
		Dimension max = new Dimension(500, 700);
		fen.setMinimumSize(min);
		fen.setMaximumSize(max);
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
