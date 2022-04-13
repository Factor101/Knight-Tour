package Chess;

public class Board
{
    // dimensions of our board
    private final static int size = 8;

    // initialize board squares
    private final Square[][] squares = new Square[size][size];

    public Board()
    {
        // populate board with new Squares
        for(int i = 0; i < size; i++)
        {
            squares[i] = new Square[size];
            for(int j = 0; j < size; j++)
            {
                squares[i][j] = new Square(j, i);
            }
        }
    }

    // tells us if a point is inside the chess board
    public boolean isInbounds(int x, int y)
    {
        return (x >= 0 && x <= size - 1) && (y >= 0 && y <= size - 1);
    }

    public boolean isInbounds(int[] pos)
    {
        return this.isInbounds(pos[0], pos[1]);
    }

    // tells us if we have not already moved here
    public boolean isEmpty(int x, int y)
    {
        return this.squares[x][y].moveNum == 0;
    }

    public boolean isEmpty(int[] pos)
    {
        return isEmpty(pos[0], pos[1]);
    }

    public void setMoveNum(int x, int y, int moveNum)
    {
        this.squares[x][y].moveNum = moveNum;
    }

    public void setMoveNum(int[] pos, int moveNum)
    {
        setMoveNum(pos[0], pos[1], moveNum);
    }

    // prints our board at the end
    public void print()
    {
        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                // format the string to add leading 0's
                System.out.print(String.format("%02d", squares[j][i].moveNum) + " ");
            }
            System.out.println();
        }
    }
}

// class used to represent a square on the board
class Square
{
    public final int x;
    public final int y;
    public int moveNum = 0;

    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}