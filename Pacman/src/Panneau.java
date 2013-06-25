import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Panneau extends JPanel
{
	static boolean peutDessiner = false;

	Map laMap;
	
	@Override
	public void paintComponent(Graphics imMap) 
	{
	
		if( !peutDessiner )
		{
			imMap.setColor(Color.red);
			imMap.fillRect(0, 0, 1000 ,1000);
		}
		else 
		{
			int w = 18;
			int h = 12;
			
			Case tableau[][] = laMap.getTab();
			
			for( int i = 0 ; i < laMap.getH() ; i++ )
			{
				for( int j = 0 ; j < laMap.getW() ; j++)
				{
					switch(tableau[i][j].getType()){
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
						
					}

					imMap.fillRect(j*w,i*h, w, h);

				}
			}
		}
		
		paintComponents(imMap);						
	}
	
		
	
	public void peindreMurs( Map map )
	{
		Graphics imMap = this.getGraphics();
		laMap = map;
		peutDessiner = true;
		this.paintComponent(imMap);
	}
	
	
}