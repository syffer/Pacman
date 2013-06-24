
public class Case {
	public enum Type {MUR,VIDE,TP,MUR_SPAWN};
	private Type type;
	
	
	public Case( char x )
	{
		if( x == '1' ) this.type = Type.MUR;
		else if( x == '0' ) this.type = Type.VIDE;
		else this.type =  Type.MUR_SPAWN;
	}
	
	
	
	public void setType(Type t){
		type = t;
	}

	public Type getType() {
		return type;
	}
	
	
	public boolean estMur()
	{
		return this.getType() == Type.MUR;
	}
	
	public boolean estVide()
	{
		return this.getType() == Type.VIDE;
	}
	
	
	
}
