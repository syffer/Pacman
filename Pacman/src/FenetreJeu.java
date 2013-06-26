

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements KeyListener
{
		
	Panneau panneau;
	
	
	Map mapMur;
	Map laMap;
	
	
	public FenetreJeu(){
		super();
		build();
		
		addKeyListener(this); // on ajoute le KeyListener ici
	}

	private void build() {
		new JFrame();
		
		setTitle("Pacman");
		setSize(600,400);
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
	
	
	public void peindreMurs( Map map)
	{
		this.getPanneau().peindre(map);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Case tab[][] = this.laMap.getTab();
		
		for(int i = 0 ; i < this.laMap.getH() ; i++ )
		{
			for( int j = 0 ; j < this.laMap.getW() ; j++ )
			{
				tab[i][j] = new Case( '2' );
			}
		}

		laMap.setTab(tab);
		
		peindreMurs(mapMur,laMap);
	}

	@Override
	public void keyTyped(KeyEvent e) {
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
