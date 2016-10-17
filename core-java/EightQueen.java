import java.util.*;

public class EightQueen {

    static ArrayList<Block> board = new ArrayList<Block>();
    static int size = 8;
    static int number = 0;

    // Check for queen existance in same row, col or digagonal
    public static boolean place(int row, int col){
        for(int i=0; i<board.size(); i++){
            Block currentBlock = board.get(i);
            if(row == currentBlock.getRow()){
                return true;
            }
            if(col == currentBlock.getCol()){
                return true;
            }
            if((row-currentBlock.getRow()) == (col-currentBlock.getCol())){
                return true;
            }
        }
        return false;
    }

    // Place queen on board and print board after finished
    public static void place_queen(int row){
        if(row>size){
            number++;
            System.out.print(number + ": [");
            for (int i=0; i<board.size(); i++){
                System.out.print("(" + board.get(i).getRow() + "," +
                        board.get(i).getCol()+ "), ");
            }
            System.out.print("]");
            System.out.println();
        }else{
            for(int col=0; col<size+1; col++){
                if(!place(row,col)){
                    Block tempBlock = new Block(row, col);
                    System.out.println(tempBlock);
                    board.add(tempBlock);
                    place_queen(row+1);
                    System.out.println(tempBlock);
                    board.remove(tempBlock);
                }
            }
        }
    }

    public static void main(String args[]){
        place_queen(1);
    }
}

class Block{
    private int row;
    private int col;

    public Block(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
