public class Pacman 
{

	public static void main(String[] args) {
		Map maMap = new Map("rsc\\map.txt");				
		
		
		
		FenetreJeu fenPrin = new FenetreJeu();
		fenPrin.peindreMurs(maMap);
		
		boolean gagner = false;
		
		
		// les coordonnees du pacman
		Coordonnees c = trouverPacman(maMap);
				
		do
		{
		
		Map mapCopie = maMap.cloner();
			
		// reste a rajouter les collisions avec les murs et autres ... 
		
		switch( fenPrin.getTouchePacman() )
		{
		case 'z':
			// vers le haut
			if( mapCopie.getCaseTabConst(c.getX(), c.getY() - 1 ).getType() !=  Case.Type.MUR )
			{
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('5') );
				c.setY(c.getY() - 1);
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('8') );
			}
			
			break;
		case 'q':
			// vers la gauche
			if( mapCopie.getCaseTabConst(c.getX() - 1 , c.getY()  ).getType() !=  Case.Type.MUR )
			{
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('5') );
				c.setX( c.getX() - 1 );
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('8') );
			}
			
			break;
		case 's':
			// vers le bas
			if( mapCopie.getCaseTabConst(c.getX(), c.getY() + 1 ).getType() !=  Case.Type.MUR )
			{
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('5') );
				c.setY(c.getY() + 1);
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('8') );
			}
			
			break;
		case 'd':
			// vers la droite
			if( mapCopie.getCaseTabConst(c.getX() + 1 , c.getY()  ).getType() !=  Case.Type.MUR )
			{
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('5') );
				c.setX(c.getX()+1);
				mapCopie.setCaseTabVar(c.getX(),c.getY() , new Case('8') );
			}
			
			break;
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maMap = mapCopie;
		fenPrin.peindreMurs(maMap);
		
		}while(!gagner);
		
		
	}
	
	public static Coordonnees trouverPacman( Map map )
	{
		Coordonnees c = new Coordonnees(-1,-1);
		int i = -1;
		int j = -1;
		boolean trouver = false;
		while( !trouver && i < map.getH() )
		{
			i++;
			while( !trouver && j < map.getW())
			{
				j++;
				if( map.getCaseTabVar(i, j).getType() == Case.Type.PACMAN_POS )
				{
					trouver = true;
					c.setX(i);
					c.setY(j);
				}
			}
			j = 0;
		}
		return c;
		
	}

	
}
