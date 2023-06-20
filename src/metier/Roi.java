package metier;
import java.util.List;
public class Roi extends Piece
{
    public Roi(int lig, int col)
    {
        super(lig, col);
    }
    
    
    public boolean peutDeplacer(int lig, int col, List<Piece> tabPiece)
    {        
        
        if (!this.destValide(lig, col))                   return false;     //Regarde si on sort du chess
        if (this.getLig() == lig && this.getCol() == col) return false;     //Regarde si on bouge pas sur nous même

        for (Piece piece : tabPiece) 
        {
            if ( piece.getCol() == col && piece.getLig() == lig                            &&   //Regarde si il y a une piece ou on veut aller
                (this.getLig()+1 == lig || this.getLig()-1 == lig || this.getLig() == lig) &&   //Regarde si on bouge bien de une seule case(ou pas) en ligne
                (this.getCol()+1 == col || this.getCol()-1 == col || this.getCol() == col))     //Regarde si on bouge bien de une seule case(ou pas) en colonne 
            {
                tabPiece.remove(piece);
                return true;
            }    
        }
        
        return false;
    }

    public char getSymbole(){return 'K';}
}
