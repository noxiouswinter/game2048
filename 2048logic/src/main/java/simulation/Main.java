package simulation;

import game.Game;
import game.MatrixMoveInfo;
import game.MyGame;
import strategy.GameStrategy;
import strategy.SimpleStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/16/14
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args){
        MyGame game = new MyGame();
        GameStrategy strategy = new SimpleStrategy();
        Game x = new Game();
        game.initializeMatrix();
        int moveCount = 0;
        while(!game.isGameOver() && !game.isGameWon()){
            boolean result = game.addTile(x.getRandomPopUpInt());
            //printMatrix(game.getMatrix());
            MatrixMoveInfo moveInfo = strategy.bestMove(game.getMatrix());
            game.setMatrix(moveInfo.outputMatrix);
            moveCount++;
            if(moveCount%100==0){
                System.out.println("Completed " + moveCount + " Moves");
                printMatrix(moveInfo.outputMatrix);
            }

        }
        if(game.isGameOver()){
            printMatrix(game.getMatrix());
            System.out.println("Lost! Game Ended");
        }
        if(game.isGameWon()){
            System.out.println("Jesus is my lord and savior");
        }

    }

    private static void printMatrix(Integer[][] outputMatrix) {
        for(int i=0;i<outputMatrix.length;i++){
            for(int j=0;j<outputMatrix[i].length;j++){
                System.out.print(" " + outputMatrix[i][j]);
            }
           System.out.println();
        }
        System.out.println(" ** *** * ****** ");
        //To change body of created methods use File | Settings | File Templates.
    }
}
