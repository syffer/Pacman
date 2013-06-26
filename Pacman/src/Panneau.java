import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Panneau extends JPanel
{
	static boolean peutDessiner = false;

	Map laMap;
	Map mapPoint;
	
	//Graphics save;
	
	
	
	@Override
	public void paintComponent(Graphics imMap) 
	{
	
		//if( !peutDessiner )
		//{
		imMap.setColor(Color.LIGHT_GRAY);
		imMap.fillRect(0, 0, 1000 ,1000);
			
		//}
		//else 
		//{
		
		
		// partie création murs
		int w = 18;
		int h = 12;
		
		Case tableau[][] = laMap.getTab();
		
		for( int i = 0 ; i < laMap.getH() ; i++ )
		{
			for( int j = 0 ; j < laMap.getW() ; j++)
			{
				switch(tableau[i][j].getType()){
				case MUR:
					imMap.setColor( new Color(0,0,230) );
					break;
				case VIDE:
					imMap.setColor(Color.black);
					break;
				case TP:
					imMap.setColor(Color.GREEN);
					break;
				case MUR_SPAWN:
					imMap.setColor(Color.YELLOW);
					break;
				default:
					// rajouter erreur -> exception
					break;
					
				}

				imMap.fillRect(j*w,i*h, w, h);

			}
		}
			
		//}
		
		//paintComponents(imMap);	// ne sert strictement à rien		
		//this.save = imMap;
		
		
		//partie création points/pastilles
		
		// ---> les redimmensionner  -> pas beau ...
		tableau = this.mapPoint.getTab();
		for( int i = 0 ; i < mapPoint.getH() ; i++ )
		{
			for( int j = 0 ; j < mapPoint.getW() ; j++)
			{
				switch(tableau[i][j].getType()){
				case PASTILLE:
					imMap.setColor(Color.white);
					imMap.fillOval(j*w+(w/3),i*h+(h/3), w/3, h/3);
					break;
				case NON_PASTILLE:
					// ne rien faire
					break;
				case PASTILLE_SPE:
					imMap.setColor(Color.white);
					imMap.fillOval(j*w+(w/3),i*h+(h/3), (int)(w/1.5), (int)(h/1.5));
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
	
	

	
	
	public void peindre( Map map , Map point )
	{
		this.setMap(map);
		this.setMapPoint(point);
		Graphics imMap = this.getGraphics();
		
		this.paintComponent(imMap);
	}
	
	
	public void setMapPoint( Map map )
	{
		this.mapPoint = map;
	}
	
	public void setMap( Map map )
	{
		this.laMap = map;
	}
	
	
}