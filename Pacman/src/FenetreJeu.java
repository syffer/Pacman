

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements KeyListener
{
		
	Panneau panneau;

	Map laMap;
	DessinerPacman savePacman;
	
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
		
				// partie création murs
				int w = 20;
				int h = 20;
				DessinerDessin d = null;
				
				
				for( int i = 0 ; i < laMap.getH() ; i++ )
				{
					for( int j = 0 ; j < laMap.getW() ; j++)
					{
						switch(laMap.getCaseTabConst(i, j).getType()){
						case MUR:
							d = new DessinerMurs( new Point(j*w, i*h) , new Dimension( w , h ) );
							
							break;
						case VIDE:
							d = new DessinerVide( new Point(j*w, i*h) , new Dimension( w , h ) );
							
							break;
						case MUR_SPAWN:
							d = new DessinerMurSpawn( new Point(j*w, i*h) , new Dimension( w , h ) );
							
							break;
						default:
							// rajouter ici exception
							new Exception_Pacman("erreur lors du chargement des murs");
							
							break;
						}
						this.panneau.ajouterDessin( d );
						
					}
				}
				
				//partie création points/pastilles
				
				// ---> les redimmensionner  -> pas beau ...
				for( int i = 0 ; i < laMap.getH() ; i++ )
				{
					for( int j = 0 ; j < laMap.getW() ; j++)
					{
						switch(laMap.getCaseTabVar(i, j).getType()){
						case PASTILLE:
							int wPastille = w/3;
							int hPastille = w/3;
							int potition1 = j*w + w/2 - wPastille/2;
							int position2 = i*h + h/2 - hPastille;
							d = new DessinerPastille( new Point(potition1, position2) , new Dimension( wPastille , hPastille ) );
							
							break;
						case NON_PASTILLE:
							// ne rien faire
							break;
						case PASTILLE_SPE:
							int wSpe = w*2/3;
							int hSpe = h*2/3;
							int potition11 = j*w + w/2 - wSpe/2;
							int position22 = i*h + h/2 - hSpe/2;
							d = new DessinerPastille( new Point(potition11, position22) , new Dimension( wSpe , hSpe ) );
							
							break;
							
						case PACMAN_POS:
							d = new DessinerPacman( new Point(j*w,i*h) , new Dimension( w , h ) );
							savePacman = (DessinerPacman)d;
							break;
						default:
							// indiquer une erreur
							// le faire autrement ... -> Exception
							new Exception_Pacman("erreur lors du chargement des pastilles");
							
							break;
							
						}
						
						this.panneau.ajouterDessin( d );
					}
				}
		
		
		this.getPanneau().peindre();
	}
	
	
	public void rePeindre()
	{
		this.panneau.peindre();
	}

	
	
	// appuie sur une touche
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
