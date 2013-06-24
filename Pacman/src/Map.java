import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;


public class Map {
	private int w;
	private int h;
	private Case tab[][];
	
	public Case[][] getTab() {
		return tab;
	}

	public void setTab(Case[][] tab) {
		this.tab = tab;
	}

	public Map(String path){
		this.load(path);
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
				return;
			}
				
			if(scanner.hasNextInt()){
				this.h = scanner.nextInt();
				System.out.println(this.h);
			}
			else{
				System.out.println("Erreur lecture h");
				return;
			}
			
			this.tab = new Case[this.h][this.w];
			
			for(int i = 0 ; i < this.h ; i++){
				String tmp;
				if(scanner.hasNextLine()){
					tmp = scanner.nextLine();
				}
				for(int j = 0 ; j < this.w ; j ++){
					this.tab[i][j].setType((Case.Type)(tmp.charAt(j) - '0'));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void save(String path){
		
	}
}
