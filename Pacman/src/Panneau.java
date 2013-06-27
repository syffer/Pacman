import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;


import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Panneau extends JPanel
{
		
	
	public LinkedList<DessinerDessin> listeGraphique = new LinkedList<DessinerDessin>();
			
	
	@Override
	public void paintComponent(Graphics imMap) 
	{
		
		for (Iterator<DessinerDessin> iter = listeGraphique.iterator(); iter.hasNext();) {
			Dessiner d = (Dessiner) iter.next();
			d.draw(imMap);	
		}
		
		
		
	}
	
	
	public void peindre()
	{
		
		Graphics imMap = this.getGraphics();
		this.paintComponent(imMap);
	}

	
	
	
	
	// opérations sur la liste
	public void ajouterDessin( DessinerDessin d )
	{
		this.listeGraphique.addLast(d);
	}
	
	public void retirerDessin( DessinerDessin d )
	{
		this.listeGraphique.remove(d);
	}
	
	
	public void remplacer( DessinerDessin dessin_a_remplacer , DessinerDessin dessin_remplacant )
	{
		this.retirerDessin(dessin_a_remplacer);
		this.ajouterDessin(dessin_remplacant);
		
		
	}
	
	
	
	public void remplacerParVide( DessinerDessin dessin_a_remplacer )
	{
		this.remplacer(dessin_a_remplacer,new DessinerVide(dessin_a_remplacer.getPosition(),dessin_a_remplacer.getDimension() ) );
				
	}
	
	
	
	public DessinerDessin trouver( Point position )
	{
		DessinerDessin d;
		for (Iterator<DessinerDessin> iter = listeGraphique.iterator(); iter.hasNext();) {
			d = iter.next();
			if( d.getPosition().getX() == position.getX() && d.getPosition().getY() == position.getY()  )
			{
				return d;
			}				
		}
		
		//pas bien du tout
		return new DessinerVide( new Point(-1,-1) , new Dimension(-1,-1) );
		
	}
	
	
	
	
}