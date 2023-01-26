import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class Frame {
    public static LinkedList<ChessPiece> pieces = new LinkedList<ChessPiece>();
    public static ChessPiece pickPiece = null;
    public static void board() throws IOException {
    //Followed a tutorial to add the pieces to the board
    BufferedImage all = ImageIO.read(new File("C:\\Users\\jtfor\\Downloads\\chess.png"));
    Image imgs[] = new Image[12];
    int ind = 0;
    for(int y = 0; y < 400; y+= 200) {
        for(int x = 0; x < 1200; x += 200) {
            imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
            ind++;
        }
    }
    //Adding Pieces to the board
    //White Pieces
    ChessPiece whitePawn1 = new ChessPiece(1, 6, true, "pawn", pieces);
    ChessPiece whitePawn2 = new ChessPiece(2, 6, true, "pawn", pieces);
    ChessPiece whitePawn3 = new ChessPiece(3, 6, true, "pawn", pieces);
    ChessPiece whitePawn4 = new ChessPiece(4, 6, true, "pawn", pieces);
    ChessPiece whitePawn5 = new ChessPiece(5, 6, true, "pawn", pieces);
    ChessPiece whitePawn6 = new ChessPiece(6, 6, true, "pawn", pieces);
    ChessPiece whitePawn7 = new ChessPiece(7, 6, true, "pawn", pieces);
    ChessPiece whitePawn8 = new ChessPiece(0, 6, true, "pawn", pieces);

    ChessPiece whiteKnight = new ChessPiece(1, 7, true, "knight", pieces);
    ChessPiece whiteKnight2 = new ChessPiece(6, 7, true, "knight", pieces);

    ChessPiece whiteRook = new ChessPiece(0, 7, true, "rook", pieces);
    ChessPiece whiteRook2 = new ChessPiece(7, 7, true, "knight", pieces);

    ChessPiece whiteBishop = new ChessPiece(2, 7, true, "bishop", pieces);
    ChessPiece whiteBishop2 = new ChessPiece(5, 7, true, "bishop", pieces);

    ChessPiece whiteQueen = new ChessPiece(3, 7, true, "queen", pieces);

    ChessPiece whiteKing = new ChessPiece(4, 7, true, "king", pieces);

    //Black Pieces
    ChessPiece blackPawn1 = new ChessPiece(1, 1, false, "pawn", pieces);
    ChessPiece blackPawn2 = new ChessPiece(2, 1, false, "pawn", pieces);
    ChessPiece blackPawn3 = new ChessPiece(3, 1, false, "pawn", pieces);
    ChessPiece blackPawn4 = new ChessPiece(4, 1, false, "pawn", pieces);
    ChessPiece blackPawn5 = new ChessPiece(5, 1, false, "pawn", pieces);
    ChessPiece blackPawn6 = new ChessPiece(6, 1, false, "pawn", pieces);
    ChessPiece blackPawn7 = new ChessPiece(7, 1, false, "pawn", pieces);
    ChessPiece blackPawn8 = new ChessPiece(0, 1, false, "pawn", pieces);

    ChessPiece blackKnight = new ChessPiece(1, 0, false, "knight", pieces);
    ChessPiece blackKnight2 = new ChessPiece(6, 0,false, "knight", pieces);

    ChessPiece blackRook = new ChessPiece(0, 0, false, "rook", pieces);
    ChessPiece blackRook2 = new ChessPiece(7, 0, false, "rook", pieces);

    ChessPiece blackBishop = new ChessPiece(2, 0, false, "bishop", pieces);
    ChessPiece blackBishop2 = new ChessPiece(5, 0, false, "bishop", pieces);

    ChessPiece blackQueen = new ChessPiece(3, 0, false, "queen", pieces);

    ChessPiece blackKing = new ChessPiece(4, 0, false, "king", pieces);

    //Create the JFrame
    JFrame frame = new JFrame();
    frame.setBounds(20, 20, 550, 570);
    //frame.setUndecorated(true);
    //Create the JPanel
    JPanel panel = new JPanel() {
        @Override
        public void paint(Graphics g) {
            boolean white = true;
            for(int y = 0; y < 8; y++) {
                for(int x = 0; x < 8; x++){
                    if(white) {
                        g.setColor(Color.white.darker());
                    } else {
                        g.setColor(Color.blue);
                    }
                    g.fillRect(x*64, y*64, 64, 64);
                    white = !white;
                }
                white = !white;
            }
            //Score board
            g.setColor(Color.black);
            g.drawString("Black Team:", 530, 10);
            
            g.setColor(Color.black);
            g.drawString("White Team:", 530, 30);
            for(ChessPiece piece: pieces) {
                int ind = 0;
                /* 
                switch(piece.name.equalsIgnoreCase(null)) {
                    case "king":
                        ind = 0;
                        break;
                    case  "queen":
                        ind = 1;
                        break;
                    case "bishop":
                        ind = 2;
                        break;
                    case "knight":
                        ind = 3;
                        break;
                    case "rook":
                        ind = 4;
                        break;
                    case "pawn":
                        ind = 5;
                        break;

                }
                */
                if(piece.name.equalsIgnoreCase("king")){
                    ind = 0;
                }
                if(piece.name.equalsIgnoreCase("queen")){
                    ind = 1;
                }
                if(piece.name.equalsIgnoreCase("bishop")){
                    ind = 2;
                }
                if(piece.name.equalsIgnoreCase("knight")){
                    ind = 3;
                }
                if(piece.name.equalsIgnoreCase("rook")){
                    ind = 4;
                }
                if(piece.name.equalsIgnoreCase("pawn")){
                    ind = 5;
                }
                if(!piece.isWhite) {
                    ind += 6;
                }
                g.drawImage(imgs[ind], piece.x, piece.y, this);
            }
        }
    };
    //Add the panel to the frame
    frame.add(panel);
    //Add a mouse motion listener
    frame.addMouseMotionListener(new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {
            if(pickPiece != null) {
               pickPiece.x = e.getX() - 32;
               pickPiece.y = e.getY() -32;
               frame.repaint();
                
            }
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    });

    //Add a mouse event listener
    frame.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //Test if it is tracking the right piece 
            System.out.println(getPieces(e.getX(), e.getY()).name);
            pickPiece = getPieces(e.getX(), e.getY());
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pickPiece.move(e.getX() / 64, e.getY() / 64);
            frame.repaint();
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    });
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);

    
}
public static ChessPiece getPieces(int x, int y) {
        int xcord = x / 64;
        int ycord = y / 64;
        for(ChessPiece piece: pieces) {
            if(piece.xcord == xcord && piece.ycord == ycord) {
                return piece;
            }
        }
        return null;
}
   
}