
public class Case {
	public enum Type {MUR,VIDE,TP,MUR_SPAWN};
	private Type type;
	
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
	
	public static Type(int v){
	}
	
}
