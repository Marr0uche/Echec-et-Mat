package controleur;
import	ihmgui.*;
import	metier.Metier;
//import iut.algo.Clavier;
import metier.Piece;

public class Controleur extends Controle
{
	private   Metier      metier;       // Classe M�tier
	private   FrameGrille frame;        // Classe Vue

	public Controleur()
	{
		metier = new Metier();				// instanciation de votre classe m�tier
		frame  = new FrameGrille ( this );  // instanciation de la fen�tre graphique


		frame.setSize     ( 650, 400            );
		frame.setLocation ( 200,  10            );
		frame.setTitle    ( "Chess"             );
		frame.setVisible  ( true                );
	}


	/*--------------------------------------------------------*/
	/* M�thodes qui peuvent �tre d�clar�es pour controler  ou */
	/* ou intercepter des actions de l'IHM graphique.         */
	/* Dans cet exemple toutes les m�thodes possibles ne sont */
	/* pas g�r�es, reportez vous � la documentation  compl�te */
	/* des ressources.                                        */
	/*--------------------------------------------------------*/


	public void niveauSuivant()
	{
		boolean bOk = this.metier.niveauSuivant();
		if (bOk && this.metier.getEnsPiece().isEmpty()) { this.frame.setVisible(false);}
	}

	public void glisser (int ligne1, int colonne1, int ligne2, int colonne2)
	{
		
		Piece p1 = null;
		for (Piece piece : this.metier.getEnsPiece()) 
			if (piece.getCol() == colonne1 && piece.getLig() == ligne1) 
				p1 = piece;
		
		if (p1 != null) 
		{
			p1.deplacer(ligne2, colonne2, this.metier.getEnsPiece());
		}
	
		this.niveauSuivant();
		frame.majIHM();
	}


	/* M�thode utilis�e par l'IHM (paintComponnent)         */

	public String setImage ( int ligne, int colonne, int couche)
	{
		char   symbole;
		String rep = "../images/";
		String sImage=null;

		if ( couche==0)
		{
			symbole = this.metier.getSymbole (ligne, colonne);

			if      ( symbole == 'C' /*&& ligne == 1 && colonne == 1*/ ) sImage = rep + "cavalier.gif";
			else if ( symbole == 'F' /*&& ligne == 1 && colonne == 0*/ ) sImage = rep + "fou.gif";
			else if ( symbole == 'P' /*&& ligne == 1 && colonne == 2*/ ) sImage = rep + "pion.gif";
			else if ( symbole == 'Q' /*&& ligne == 0 && colonne == 1*/ ) sImage = rep + "reine.gif";
			else if ( symbole == 'K' /*&& ligne == 2 && colonne == 1*/ ) sImage = rep + "roi.gif";
			else if ( symbole == 'T' /*&& ligne == 2 && colonne == 1*/) sImage = rep + "tour.gif";
			else                                                        sImage = rep + "vide52.gif";
		}

		return sImage;
	}

	public String  setTextLabel      (int numLbl)
	{
		return metier.getMessage ();
	}


	public int     setNbLigne        () { return metier.getNbLigne();                  }
	public int     setNbColonne      () { return metier.getNbColonne();                }
	public boolean setNumLigneColonne() { return true;                                 }
	public int     setLargeurImg     () { return 50;                                   }
	public String  setFondGrille     () 
	{
		if (this.metier.getNomNiveau().equals("Débutant")) 
		return "../images/plateauvert.gif";

		return "";
		 
	}
    public static void main(String[] args) 
	{
        new Controleur();
    }
}