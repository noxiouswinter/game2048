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
        Comparator<MatrixMoveInfo> moveComparator = new Comparator<MatrixMoveInfo>(){

            @Override
            public int compare(MatrixMoveInfo o1, MatrixMoveInfo o2) {
                if(o1.mergeScore+o1.potenttialMergeScore > o2.mergeScore+ o2.potenttialMergeScore)
                    return 1;
                else if(o1.mergeScore+o1.potenttialMergeScore < o2.mergeScore+ o2.potenttialMergeScore){
                    return -1;
                }
                else{
                    if(o1.mergeScore > o2.mergeScore)
                        return 1;
                    else if(o1.mergeScore < o2.mergeScore)
                        return -1;
                    else return 0;
                }
                //return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        Collections.sort(moveInfoList,moveComparator);
        MatrixMoveInfo bestMove = moveInfoList.get(moveInfoList.size()-1);
        //System.out.println("Best Move " + bestMove);
        return bestMove;
    }
}
