import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame {
		
	JPanel panneau;
	
	public FenetreJeu(){
		super();
		build();
	}

	private void build() {
		setTitle("Pacman");
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(true);
		Dimension min = new Dimension(200, 200);
		Dimension max = new Dimension(500, 700);
		setMinimumSize(min);
		setMaximumSize(max);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane( buildContentPanel());
	}
	
	private JPanel buildContentPanel(){
		this.panneau  = new JPanel();
		panneau.setLayout(new FlowLayout());
		panneau.setBackground(Color.RED);
		
		return panneau;
	}
	
	
	public void peindreMurs( Map map )
	{
		int w = 18;
		int h = 12;
		
		Case tableau[][] = map.getTab();
		Graphics g = panneau.getGraphics();
		
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

		panneau.repaint();
	}
}
