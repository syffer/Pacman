import java.awt.Point;

public class Pacman 
{

	public static void main(String[] args) {
		Map maMap = new Map("rsc\\map.txt");				



		FenetreJeu fenPrin = new FenetreJeu();
		fenPrin.peindreMurs(maMap);

		boolean perdu = false; // perdu si collision avec ennemie
		

		// les coordonnees du pacman
		Coordonnees coordPac = trouverPacman(maMap);
		
		// pour verifier si gagner marche
		// maMap.setNombrePastillles(1);
		do
		{

			// reste a rajouter les collisions avec les murs et autres ... 

			switch( fenPrin.getTouchePacman() )
			{
			case 'z':
				// vers le haut
				if( maMap.getCaseTabConst(coordPac.getY()-1, coordPac.getX()).getType() !=  Case.Type.MUR )
				{
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('5') );
										
					coordPac.setY(coordPac.getY() - 1);
					
									
					
					if( maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE || maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE_SPE )
					{
						maMap.decrementerPastille();
					}
					
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('8') );
				}

				break;
			case 'q':
				// vers la gauche
				if( maMap.getCaseTabConst(coordPac.getY(), coordPac.getX()-1).getType() !=  Case.Type.MUR )
				{
					

					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('5') );
					

					
					

					coordPac.setX( coordPac.getX() - 1 );
							
					
					if( maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE || maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE_SPE )
					{
						maMap.decrementerPastille();
					}
					
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('8') );
				}

				break;
			case 's':
				// vers le bas
				if( maMap.getCaseTabConst(coordPac.getY()+1, coordPac.getX()).getType() !=  Case.Type.MUR )
				{
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('5') );
					coordPac.setY(coordPac.getY() + 1);
					
					if( maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE || maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE_SPE )
					{
						maMap.decrementerPastille();
					}
					
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('8') );
				}

				break;
			case 'd':
				// vers la droite
				if( maMap.getCaseTabConst(coordPac.getY(), coordPac.getX()+1).getType() !=  Case.Type.MUR )
				{
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('5') );
					coordPac.setX(coordPac.getX()+1);
					
					if( maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE || maMap.getCaseTabVar( coordPac.getY() , coordPac.getX() ).getType() == Case.Type.PASTILLE_SPE )
					{
						maMap.decrementerPastille();
					}
					
					maMap.setCaseTabVar(coordPac.getY(),coordPac.getX() , new Case('8') );
				}

				break;
			}

			if(coordPac.getX()<=0 || coordPac.getX() >= maMap.getW()-1){
				maMap.setCaseTabVar(coordPac.getY(), coordPac.getX(), new Case('5'));
				coordPac.setX(maMap.getW()-coordPac.getX()-1);
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			fenPrin.rePeindre();

			
		}while( maMap.getNombrePastillles() != 0  || perdu);


	}

	public static Coordonnees trouverPacman( Map map )
	{
		for(int i=0;i<map.getH();i++){
			for(int j=0;j<map.getW();j++){
				if( map.getCaseTabVar(i, j).getType() == Case.Type.PACMAN_POS )
				{
					return new Coordonnees(j,i);
				}
			}
		}
		return new Coordonnees(-1,-1);
	}
	
	
	public static Point coordonnee_vers_point( Coordonnees c )
	{
		return new Point( c.getY() , c.getX() );		
	}
	


}
