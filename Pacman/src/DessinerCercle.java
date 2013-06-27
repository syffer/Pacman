import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;




public class DessinerCercle extends DessinerDessin
{

	public Color couleur;
	public Rectangle cercle;
	
	public DessinerCercle( Point position , Dimension dim , Color coul )
	{
		super(position,dim);
		this.couleur = coul;
		this.cercle = new Rectangle(position,dim);
	}
		
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor( this.getCouleur() );
		g.fillOval(this.cercle.x, this.cercle.y, this.cercle.width, this.cercle.height);
		
	}
	
	
	
	
}