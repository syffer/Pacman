import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Panneau extends JPanel
{
	static boolean peutDessiner = false;

	Map laMap;
	
	//Graphics save;
	
	
	
	@Override
	public void paintComponent(Graphics imMap) 
	{
	
		imMap.setColor(Color.black);
		imMap.fillRect(0, 0, 1000 ,1000);
		
		
		// partie création murs
		int w = 18;
		int h = 12;
		
		for( int i = 0 ; i < laMap.getH() ; i++ )
		{
			for( int j = 0 ; j < laMap.getW() ; j++)
			{
				switch(laMap.getCaseTabConst(j, i).getType()){
				case MUR:
					imMap.setColor(Color.BLUE);
					break;
				case VIDE:
					imMap.setColor(Color.DARK_GRAY);
					break;
				case TP:
					imMap.setColor(Color.GREEN);
					break;
				case MUR_SPAWN:
					imMap.setColor(Color.YELLOW);
					break;
				default:
					// indiquer une erreur
					// le faire autrement ... -> Exception
					imMap.setColor(Color.RED);
					imMap.fillOval(j*w,i*h, w, h);
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
				switch(laMap.getCaseTabVar(j, i).getType()){
				case PASTILLE:
					imMap.setColor(Color.ORANGE);
					imMap.fillOval(j*w,i*h, w, h);
					break;
				case NON_PASTILLE:
					// ne rien faire
					break;
				case PASTILLE_SPE:
					imMap.setColor(Color.PINK);
					imMap.fillOval(j*w,i*h, w, h);
					break;
				default:
					// indiquer une erreur
					// le faire autrement ... -> Exception
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