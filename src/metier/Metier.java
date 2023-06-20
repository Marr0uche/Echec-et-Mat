package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

public class Metier 
{
    private List<Piece> ensPiece;
	private String      message;
    private int         niveau;
    private String      categorie;

    public Metier()
    {
        this.niveau = 1;

        this.ensPiece = new ArrayList<Piece>();
        lireNiveau();
    }

    /*Accesseurs */
    public List<Piece> getEnsPiece() { return ensPiece;}
    public int    getNbLigne  ()     { return 4;    }
	public int    getNbColonne()     { return 4;    }
	public String getMessage  ()     { return this.message;          }
    public String getNomNiveau()     { return categorie;}

    /*Incrémenter le niveau lorsque on a fini le précédent */
    public void plusNiveau()
    {
        this.niveau++;
        lireNiveau();
    }

    /*Enlever la dernière pièce du plateau (utilisée lorsque le niveau est réussi) */
    public void removeFromEns(int i) {this.ensPiece.remove(i);}
    


    /* M�thode pour aller au niveau suivant*/
    public boolean niveauSuivant()
    {
        try 
        {
            if (this.ensPiece.size() == 1) 
		    {
                System.out.println("fini");
                this.removeFromEns(0);
                this.plusNiveau();
                return true;
		    }
         
        } catch (Exception e) { return false; }
        return false;
    }

    /*Charger le niveau à partir du .data */
    public void lireNiveau()
    {
        try
        {
            int cptLig = 0;
			Scanner sc = new Scanner ( new FileReader("../images/niveau" + this.niveau + ".txt") );
            
            this.categorie = sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) 
            {
                String ligne = sc.nextLine();

                this.chargerPiece(cptLig,0,ligne.charAt(2));
                this.chargerPiece(cptLig,1,ligne.charAt(6));
                this.chargerPiece(cptLig,2,ligne.charAt(10));
                this.chargerPiece(cptLig,3,ligne.charAt(14));
            
                sc.nextLine();
                cptLig ++;
            }
        } 
        catch (Exception e) {}
    }
    
    public void chargerPiece(int lig,int col, char nom)
    {
        switch(nom)
        {
            case 'K' -> this.ensPiece.add(new Roi       (lig, col));
            case 'Q' -> this.ensPiece.add(new Renne     (lig, col));
            case 'F' -> this.ensPiece.add(new Fou       (lig, col));
            case 'T' -> this.ensPiece.add(new Tour      (lig, col));
            case 'P' -> this.ensPiece.add(new Pion      (lig, col));
            case 'C' -> this.ensPiece.add(new Cavalier  (lig, col));
        }
    }

    public char getSymbole(int lig,int col)
    {
        for(Piece p : ensPiece)
            {
                if (p.getLig() == lig && p.getCol() == col)
                    return p.getSymbole();
            }
        return 'X';
    }
}