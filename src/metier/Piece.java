package metier;
import java.util.List;

public abstract class Piece
{
    private int  lig;
    private int col;

    public Piece(int lig, int col)
    {
        this.lig = lig;
        this.col = col;
    }

    /*Méthode pour deplacer une pièce */
    public void deplacer(int lig,int col,List<Piece> tabPiece)
    {
        if (this.peutDeplacer(lig, col,tabPiece)) 
        {
            this.lig = lig;
            this.col = col;    
        }
    }

    /*Accesseurs */

    public int getCol() {return col;}
    public int getLig() {return lig;}


    /*Méthodes */

    abstract boolean peutDeplacer(int lig, int col,List<Piece> tabPiece);

    //Cherche si une pièce se trouve sur le chemin d'un déplacement 
    public boolean obstacle(int lig, int col, List<Piece> tabPiece,Piece piece)
    {
        int ligIncrement;
        int colIncrement;

        if(this.getLig() < lig) ligIncrement = 1;
        else
        {
            if(this.getLig() > lig) ligIncrement = -1;
            else                    ligIncrement = 0;
        }

        if(this.getCol() < col) colIncrement = 1;
        else
        {
            if(this.getCol() > col) colIncrement = -1;
            else                    colIncrement =  0;
        }

        int cptLig = this.getLig();
        int cptCol = this.getCol();
        while(cptLig != lig || cptCol != col)
        {
            for(Piece p : tabPiece)     //cherche une pièce sur la case tester
                if(p.getLig() == cptLig && p.getCol() == cptCol && piece != p)
                    return true;
                
            
            cptLig += ligIncrement;
            cptCol += colIncrement;
        }
        return false;
    }

    /*Méthode utilisée pour voir si la destination est sur le plateau */
    public boolean destValide(int lig, int col)
    {
        if (lig >  3 || lig <  0 || col > 3  || col < 0)
            return false;  
            
        return true;
    }

    public abstract char getSymbole();

    public String toString() { return this.getSymbole() + "( " + this.lig + ";" + this.col + ")";}
}