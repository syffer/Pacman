import java.awt.Dimension;
import java.awt.Point;



public abstract class Dessin implements Dessinable
{
	Point position;
	Dimension dimension;
	
	public Dessin( Point pos , Dimension dim )
	{
		this.position = pos;
		this.dimension = dim;
	}

	
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	
	
}