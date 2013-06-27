import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Panneau extends JPanel
{
	
	Map laMap;
	
	//Graphics save;
		
	
	@Override
	public void paintComponent(Graphics imMap) 
	{
		
		// partie création murs
		int w = 20;
		int h = 20;
		
		for( int i = 0 ; i < laMap.getH() ; i++ )
		{
			for( int j = 0 ; j < laMap.getW() ; j++)
			{
				switch(laMap.getCaseTabConst(i, j).getType()){
				case MUR:
					imMap.setColor(Color.BLUE);
					break;
				case VIDE:
					imMap.setColor(Color.black);
					break;
				case TP:
					imMap.setColor(Color.GREEN);
					break;
				case MUR_SPAWN:
					imMap.setColor(Color.DARK_GRAY);
					break;
				default:
					// rajouter ici exception
					new Exception_Pacman("erreur lors du chargement des murs");
					imMap.setColor(Color.GREEN);
					break;
				}

				imMap.fillRect(j*w,i*h, w, h);

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
					imMap.setColor(Color.white);
					imMap.fillOval(j*w + w/2 - wPastille/2,i*h + h/2 - hPastille, wPastille, hPastille);
					break;
				case NON_PASTILLE:
					// ne rien faire
					break;
				case PASTILLE_SPE:
					int wSpe = w*2/3;
					int hSpe = h*2/3;
					imMap.setColor(Color.white);
					imMap.fillOval( j*w + w/2 - wSpe/2, i*h + h/2 - hSpe/2, wSpe, hSpe);
					break;
					
				case PACMAN_POS:
					imMap.setColor( new Color(252,249,20) ); //<--
					imMap.fillOval( j*w  , i*h , w , h );
					break;
				default:
					// indiquer une erreur
					// le faire autrement ... -> Exception
					new Exception_Pacman("erreur lors du chargement des pastilles");
					
					imMap.setColor(Color.RED);
					imMap.fillOval(j*w,i*h, w, h);
					break;
					
				}
			}
		}
		
		
	}
	
	
	public void peindre( Map map )
	{
		this.setMap(map);
		Graphics imMap = this.getGraphics();
		
		
		this.paintComponent(imMap);
	}
	

	public void setMap( Map map )
	{
		this.laMap = map;
	}
	
	
}