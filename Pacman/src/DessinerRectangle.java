import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;




public class DessinerRectangle extends DessinerDessin
{

	public Color couleur;
	public Rectangle rect;
	
	public DessinerRectangle( Point position , Dimension dim , Color coul )
	{
		super(position,dim);
		this.couleur = coul;
		this.rect = new Rectangle(position,dim);
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
		g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
		
	}
	
	
	
	
}