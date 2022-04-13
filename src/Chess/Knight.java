package Chess;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Knight
{
    public final int[] pos = new int[2];

    // amount of moves made
    private int moves = 0;

    // board we are using
    private final Board board;

    public Knight(int x, int y, Board board)
    {
        this.board = board;
        this.move(x, y);
    }

    public int[][] getLegalMoves(int x, int y)
    {
        List<List<Integer>> legalMoves = new ArrayList<List<Integer>>();

        // candidate coords based on how a knight moves
        int[][] canditates = {
                { x + 2, y + 1 },
                { x + 1, y + 2 },
                { x - 2, y + 1 },
                { x - 1, y + 2 },
                { x - 2, y - 1 },
                { x - 1, y - 2 },
                { x + 1, y - 2 },
                { x + 2, y - 1 }
        };

        // for every candidate move we check that its in bounds of the board and the knight hasn't moved there before
        for (int[] canditate : canditates)
        {
            if(board.isInbounds(canditate) && board.isEmpty(canditate))
                legalMoves.add(new ArrayList<Integer>(Arrays.asList(canditate[0], canditate[1])));
        }

        // return as int[][]
        return legalMoves.stream()
                .map(e -> e.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public int[][] getLegalMoves(int[] curPos)
    {
        return this.getLegalMoves(curPos[0], curPos[1]);
    }

    public void move(int x, int y)
    {
        this.pos[0] = x;
        this.pos[1] = y;

        // set the board square we moved to with the move num, also increment move number
        this.board.setMoveNum(x, y, ++moves);
    }

    public void move(int[] dest)
    {
        this.move(dest[0], dest[1]);
    }

    public int getMoveAmount()
    {
        return moves;
    }
}
