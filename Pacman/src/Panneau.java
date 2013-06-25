import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Panneau extends JPanel
{
	static boolean b = false;
	Graphics gg;

	Map laMap;
	
	
	
	@Override
	public void paintComponent(Graphics g) 
	{
		// TODO Auto-generated method stub
		super.paintComponents(g);
	
		if( !b )
		{
			g.setColor(Color.red);
			g.fillRect(0, 0, 1000 ,1000);
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
						g.setColor(Color.BLUE);
						break;
					case VIDE:
						g.setColor(Color.DARK_GRAY);
						break;
					case TP:
						g.setColor(Color.GREEN);
						break;
					case MUR_SPAWN:
						g.setColor(Color.YELLOW);
						break;
						
					}

					g.fillRect(j*w,i*h, w, h);

				}
			}
		}
		
						
	}
	
		
	
	public void peindreMurs( Map map )
	{
		
		
		
		Case tableau[][] = map.getTab();
		Graphics g = this.getGraphics();
		
		/*
		for( int i = 0 ; i < map.getH() ; i++ )
		{
			for( int j = 0 ; j < map.getW() ; j++)
			{
				switch(tableau[i][j].getType()){
				case MUR:
					g.setColor(Color.BLUE);
					break;
				case VIDE:
					g.setColor(Color.DARK_GRAY);
					break;
				case TP:
					g.setColor(Color.GREEN);
					break;
				case MUR_SPAWN:
					g.setColor(Color.YELLOW);
					break;
					
				}

				g.fillRect(j*w,i*h, w, h);

			}
		}
		*/
		
		//gg = g;
		laMap = map;
		b = true;
		this.paintComponent(g);
	}
	
	
}