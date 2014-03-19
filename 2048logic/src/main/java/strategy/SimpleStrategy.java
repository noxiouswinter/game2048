package strategy;

import game.Game;
import game.MatrixMoveInfo;
import game.MatrixMover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStrategy implements GameStrategy{
    MatrixMover mover = new MatrixMover();
    @Override
    public MatrixMoveInfo bestMove(Integer[][] matrix) {
        List<MatrixMoveInfo> moveInfoList = new ArrayList<MatrixMoveInfo>();
        for(Game.Action action : Game.Action.values()){
                if(!action.equals(Game.Action.EXIT)){
                    MatrixMoveInfo moveInfo = mover.moveMatrix(matrix,action);
                    //System.out.println(moveInfo + "  Action = " + action.toString());
                    moveInfoList.add(moveInfo);
                }

        }
        //Comparator<MatrixMoveInfo> moveComparator = new SimpleMoveComparator();
        Comparator<MatrixMoveInfo> moveComparator = new OrderedWeightComparator();
        Collections.sort(moveInfoList,moveComparator);
        MatrixMoveInfo bestMove = moveInfoList.get(moveInfoList.size()-1);
        //MatrixMoveInfo bestMove = moveInfoList.get(0);
        //System.out.println("Best Move " + bestMove);
        return bestMove;
    }
}
