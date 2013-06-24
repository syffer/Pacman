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
	
	public Map(){
		w = -1;
		h = -1;
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
		File f = new File(path);
		Charset encoding = Charset.defaultCharset();
		InputStream in;
		try {
			in = new FileInputStream(f);
			Reader reader = new InputStreamReader(in,encoding);
			//Reader buffer = new BufferedReader(reader);
			int r;
			try {
				while((r=reader.read()) != -1){
				    char ch = (char) r;
				    System.out.print(ch);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String path){
		
	}
}
