import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;


import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Panneau extends JPanel
{


	private LinkedList<Dessin> listeGraphique = new LinkedList<Dessin>();


	@Override
	public void paintComponent(Graphics imMap) 
	{

		for (Iterator<Dessin> iter = listeGraphique.iterator(); iter.hasNext();) {
			Dessinable d = (Dessinable) iter.next();
			d.draw(imMap);	
		}
	}


	public void peindre()
	{

		Graphics imMap = this.getGraphics();
		this.paintComponent(imMap);
	}





	// opérations sur la liste
	public void ajouterDessin( Dessin d )
	{
		this.listeGraphique.addLast(d);
	}

	public void retirerDessin( Dessin d )
	{
		this.listeGraphique.remove(d);
	}


	public void remplacer( Dessin dessin_a_remplacer , Dessin dessin_remplacant )
	{
		this.retirerDessin(dessin_a_remplacer);
		this.ajouterDessin(dessin_remplacant);


	}



	public void remplacerParVide( Dessin dessin_a_remplacer )
	{
		this.remplacer(dessin_a_remplacer,new DessinVide(dessin_a_remplacer.getPosition(),dessin_a_remplacer.getDimension() ) );

	}



	public Dessin trouver( Point position )
	{
		Dessin d;
		for (Iterator<Dessin> iter = listeGraphique.iterator(); iter.hasNext();) {
			d = iter.next();
			if( d.getPosition().getX() == position.getX() && d.getPosition().getY() == position.getY()  )
			{
				return d;
			}				
		}

		//pas bien du tout
		return new DessinVide( new Point(-1,-1) , new Dimension(-1,-1) );
	}




}