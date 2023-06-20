package metier;
import java.util.List;

public class Cavalier extends Piece
{

    public Cavalier(int lig, int col)
    {
        super(lig,col);
    }
    
    boolean peutDeplacer(int lig, int col,List<Piece> tabPiece)
    {
        //Regarde si ou on veut se déplacer est dans le tablier
        if(!this.destValide(lig, col))
        {
            return false;
        }   
        
        for (Piece piece : tabPiece) 
        {
            //Regarde si le cavalier peut se déplacer ou on veut se déplacer
            if ((this.getCol() + 2 == col && this.getLig()+1 == lig ||
                 this.getCol() - 2 == col && this.getLig()+1 == lig ||
                 this.getCol() + 1 == col && this.getLig()+2 == lig ||
                 this.getCol() - 1 == col && this.getLig()+2 == lig ||
                 this.getCol() + 2 == col && this.getLig()-1 == lig ||
                 this.getCol() - 2 == col && this.getLig()-1 == lig ||
                 this.getCol() + 1 == col && this.getLig()-2 == lig ||
                 this.getCol() - 1 == col && this.getLig()-2 == lig)&& 
                 piece.getCol() == col && piece.getLig() == lig                )  // If y a une piece déja ou on veut aller
            { 
                tabPiece.remove(piece);
                return true; 
            }
        }
        return false;
    }
    
    public char getSymbole(){return 'C';}
}
