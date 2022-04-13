package lab.lab8;

import Chess.Board;
import Chess.Knight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        // initialize board and knight
        final Board board = new Board();
        final Knight knight = new Knight(0, 0, board);

        // initialize knight property of PossibleMove class
        PossibleMove.knight = knight;

        // get legal moves
        int[][] legalMoves = knight.getLegalMoves(knight.pos);

        // loop until we cant move
        while(legalMoves.length != 0)
        {
            // get a list of possible moves and the amount of moves we can make from them
            // sort them in ascending order
            List<PossibleMove> possibleMoves = Arrays.stream(legalMoves)
                    .map(PossibleMove::new)
                    .sorted(Comparator.comparingInt(a -> a.legalMovesFrom))
                    .collect(Collectors.toList());

            // move our knight to the best possible square
            knight.move(possibleMoves.get(0).dest);

            // update our new legal moves
            legalMoves = knight.getLegalMoves(knight.pos);
        }

        board.print();
        System.out.println("Total moves: " + (knight.getMoveAmount()));
    }
}

// class to represent a possible move
class PossibleMove
{
    // move coordinate target
    public final int[] dest;
    // possible amount of moves from "dest"
    public final int legalMovesFrom;
    // the knight object to calculate from
    public static Knight knight;

    public PossibleMove(int[] pos)
    {
        this.dest = pos;

        // get the amount of legal moves possible from "pos"
        legalMovesFrom = knight.getLegalMoves(pos).length;
    }
}