package strategy;

import game.Game;
import game.MatrixMoveInfo;
import game.MatrixMover;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/16/14
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 *
 * http://stackoverflow.com/questions/22342854/what-is-the-optimal-algorithm-for-the-game-2048
 */
public class OrderedWeightsStrategy implements GameStrategy{

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
        Comparator<MatrixMoveInfo> moveComparator = new Comparator<MatrixMoveInfo>(){

            @Override
            public int compare(MatrixMoveInfo o1, MatrixMoveInfo o2) {
                  monoticinity
                //return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        Collections.sort(moveInfoList, moveComparator);
        MatrixMoveInfo bestMove = moveInfoList.get(moveInfoList.size()-1);
        //System.out.println("Best Move " + bestMove);
        return bestMove;
    }

}
