
public class Case {
	public enum Type {MUR,VIDE,TP,MUR_SPAWN};
	private Type type;
	
	public void setType(Type t){
		type = t;
	}

	public Type getType() {
		return type;
	}
}
