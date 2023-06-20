package metier;
import java.util.*;

public class Renne extends Piece
{


    public Renne(int lig, int col)
    {
        super(lig, col);
    }


    public boolean peutDeplacer(int lig, int col, List<Piece> tabPiece)
    {
        
        if (!this.destValide(lig, col))                   return false;
        if (this.obstacle(lig, col, tabPiece, this))      return false;
        if (this.getLig() == lig && this.getCol() == col) return false;
       
        for( Piece p:tabPiece )
        {
            if(p.getLig() == lig && p.getCol() == col      &&
               (this.getCol() == col ^ this.getLig() == lig || Math.abs(this.getCol() - col) == Math.abs(this.getLig() - lig)))
            {
                tabPiece.remove(p);
                return true;
            }    
        }

        return false;


        /*if(!this.obstacle(lig,col,tabPiece,this))
        {
            if (destValide(lig, col)) 
            {
                for( Piece p:tabPiece )
                {
                    if(p.getLig() == lig && p.getCol() == col)
                    {
                        tabPiece.remove(p);
                        return true;
                    }    
                }
            }
        }
        return false;*/
    }

    public char getSymbole(){return 'Q';}

}
