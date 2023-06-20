package metier;
import java.util.List;

public class Fou extends Piece
{

    public Fou(int lig, int col)
    {
        super(lig,col);
    }
    public boolean peutDeplacer(int lig, int col,List<Piece> tabPiece)
    {
        if(!this.destValide(lig, col))                                      return false;  //test si ne sort pas du plateau
        if(this.getCol() == col || this.getLig() == lig)                    return false;  //test si on ne se déplace pas sur la même case
        if(Math.abs(this.getCol() - col) != Math.abs(this.getLig() - lig))  return false;  //test si se déplace bien en diagonale
        if(this.obstacle(lig,col,tabPiece,this))                            return false;  //test si une pièce se trouve sur le trajet
        
        for(Piece p : tabPiece)     //cherche une pièce sur la case du déplacement
            if(p.getLig() == lig && p.getCol() == col)
            {
                tabPiece.remove(p);
                return true;
            } 
    
        return false;
    }
    
    
    public char getSymbole() {return 'F';}
}
