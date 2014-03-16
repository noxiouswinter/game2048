package strategy;

import game.Game.Action;
import game.MatrixMoveInfo;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GameStrategy {

    MatrixMoveInfo bestMove(Integer[][] matrix);
}
