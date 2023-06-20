package metier;
import java.util.List;

public class Tour extends Piece
{

    public Tour(int lig, int col)
    {
        super(lig,col);
    }

    boolean peutDeplacer(int lig, int col, List<Piece> tabPiece)
    {
        //Regarde si ou on veut se déplacer est dans le tablier
        if(!this.destValide(lig, col)) return false;

        
        for (Piece piece : tabPiece) 
        {
            //Regarde si la Tour peut se deplacer ou on veut aller
            if ( this.getCol() == col ^ this.getLig() == lig &&      //Regarde si on reste sur la même ligne ou la même colonne mais pas les deux 
                !this.obstacle(lig,col,tabPiece,this)        &&      //Regarde si y a une pièce entre ou nous sommes et ou on veut aller
                 piece.getCol() == col && piece.getLig() == lig )    //Si il y a une pièce ou on veut aller
            {
                tabPiece.remove(piece);
                return true;
            }
        }

        return false;
    }

    public char getSymbole() {return 'T';}
    
}
