import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Map {
	private int w;
	private int h;
	private Case tabConst[][];
	private Case tabVar[][];
	
	private String chemin;
	

	public Case getCaseTabConst(int i, int j) {
		return tabConst[i][j];
	}

	public Case getCaseTabVar(int i, int j) {
		return tabVar[i][j];
	}

	public void setCaseTabConst(int i, int j, Case c) {
		tabConst[i][j] = c;
	}

	public void setCaseTabVar(int i, int j, Case c) {
		tabVar[i][j] = c;
	}
	
	public Map(String path){
		this.load(path);
		
		this.chemin = path;
		
	}
	
	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	public void load(String path){
		/* Chargement du texte */
		File f = new File(path);
		try {
			Scanner scanner = new Scanner(f);
			if(scanner.hasNextInt()){
				this.w = scanner.nextInt();
				System.out.println(this.w);
			}
			else{
				System.out.println("Erreur lecture w");
				scanner.close();
				return;
			}
				
			if(scanner.hasNextInt()){
				this.h = scanner.nextInt();
				System.out.println(this.h);
			}
			else{
				System.out.println("Erreur lecture h");
				scanner.close();
				return;
			}
			
			
			
			// le nextInt ne prend surement pas le caractère de fin de ligne (\n)
			if(scanner.hasNextLine()) scanner.nextLine();

			
			/* Chargement des cases fixes de la map */
			this.tabConst = new Case[this.h][this.w];
			
			for( int i = 0 ; i < this.h ; i++)
			{
				String tmp = "";
				
				if(scanner.hasNextLine())
				{
					tmp = scanner.nextLine();
					System.out.println(tmp);
					
					for(int j = 0 ; j < tmp.length() ; j ++)
					{
						this.tabConst[i][j] = new Case( tmp.charAt(j) );
					}
				}
			}
			
			// sauter 1 ligne
			if(scanner.hasNextLine()) scanner.nextLine();
			
			/* Chargement des cases variables de la map */
			this.tabVar = new Case[this.h][this.w];
			
			for( int i = 0 ; i < this.h ; i++)
			{
				String tmp = "";
				
				if(scanner.hasNextLine())
				{
					tmp = scanner.nextLine();
					System.out.println(tmp);
					
					for(int j = 0 ; j < tmp.length() ; j ++)
					{
						this.tabVar[i][j] = new Case( tmp.charAt(j) );
					}
				}
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public String toString()
	{
		
		String tmp = "";
		for( int i = 0 ; i < this.h ; i++ )
		{
			for( int j = 0 ; j < this.w ; j++ )
			{
				tmp += this.tabConst[i][j].getType();
			}
			tmp = tmp + "\n";
		}
		
		return tmp;
		
	}
	
	public void save(String path){

	}
}
