

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements KeyListener
{
		
	Panneau panneau;

	Map laMap;
	
	char touche_pacman = 'q';
	
	
	public FenetreJeu(){
		super();
		build();
		
		addKeyListener(this); // on ajoute le KeyListener ici
	}

	private void build() {
		new JFrame();
		
		setTitle("Pacman");
		setSize(580,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panneau = new Panneau();
		
		setContentPane( this.panneau );
		
		setVisible(true);
	}
	
		
	
	
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	
	
	public char getTouchePacman()
	{
		return this.touche_pacman;
	}
	
	
	public void peindreMurs( Map map )
	{
		this.laMap = map;
		this.getPanneau().peindre(map);
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// changer la direction de déplacement du pacman
		this.touche_pacman =  e.getKeyChar();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	public void init()
	{
		 addKeyListener(this);
	}
	public void start()
	{
		requestFocus();
	}
	
	
}
