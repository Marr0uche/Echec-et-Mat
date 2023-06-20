package metier;
import java.util.List;

public class Pion extends Piece
{
    //Constructeurs
    public Pion(int lig, int col)
    {
        super(lig,col);
    }

    public boolean peutDeplacer(int lig, int col,List<Piece> tabPiece)
    {
        if(!this.destValide(lig, col))                           return false;  //test si ne sort pas du plateau
        if(col != this.getCol() + 1 && col != this.getCol() - 1) return false;  //test si se déplace bien de 1 à droite ou à gauche
        if(lig != this.getLig() - 1)                             return false;  //test si avance bien de 1

        for(Piece p : tabPiece)     //cherche une pièce sur la case du déplacement           
            if(p.getLig() == lig && p.getCol() == col) 
            {
                tabPiece.remove(p);
                return true; 
            }

        return false;
    }

    public char getSymbole() {return 'P';}
}
    

