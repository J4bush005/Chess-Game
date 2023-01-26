import java.util.LinkedList;

public class ChessPiece {
   int xcord;
   int ycord;
   int score;
   int x;
   int y;
   boolean isWhite;
   LinkedList<ChessPiece> pieces;
   String name;


   public ChessPiece(int xcord, int ycord, boolean isWhite, String name, LinkedList<ChessPiece> pieces) {
        this.xcord = xcord;
        this.ycord = ycord;
        this.isWhite = isWhite;
        this.pieces = pieces;
        this.name = name;
        x = xcord * 64;
        y = ycord * 64;
        pieces.add(this);
   }

   public void move(int xcord, int ycord) {
        if(Frame.getPieces(xcord * 64, ycord * 64) != null) {
            if(Frame.getPieces(xcord * 64, ycord * 64).isWhite != isWhite) {
                Frame.getPieces(xcord * 64, ycord * 64).kill();
            } else {
                x = this.xcord * 64;
                y = this.ycord * 64;
                return;
            }
           
        }
        this.xcord = xcord;
        this.ycord = ycord;
        x = xcord * 64;
        y = ycord * 64;
   }

   public void kill() {
    pieces.remove(this);
   }
}
