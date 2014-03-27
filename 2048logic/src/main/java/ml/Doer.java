package ml;

import game.Game;
import org.jblas.DoubleMatrix;
import simulation.Main;
import strategy.AStrategy;
import strategy.ScoreStrategy;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/26/14
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Doer {

    Random random = new Random();
    public static void main(String[] args){
        Doer doer = new Doer();
        int emptyCellCount = 6;
        int rows = 3;
        DoubleMatrix x = new DoubleMatrix(rows,4);
        for(int i=0;i<rows;i++){
            Integer[][] matrix = doer.generateRandomMatrix(emptyCellCount);
            Integer[][] logMatrix = doer.getLog(matrix);
            //Main.printMatrix(matrix);
            //Main.printMatrix(logMatrix);
            //maxValueScore, smoothnessScore,montocityScore,emptyCellScore
            DoubleMatrix dm = doer.extractFeatures(logMatrix);
            //dm.print();
            x.putRow(i,dm);


        }

        //x.print();

    }

    public DoubleMatrix extractFeatures(Integer[][] logMatrix) {
        ScoreStrategy scoreStrategy = new AStrategy();
        double emptyCellScore = scoreStrategy.getEmptyCellScore(logMatrix);

        double maxValueScore = scoreStrategy.getMaxValueScore(logMatrix),
                smoothnessScore = scoreStrategy.getSmoothnessScore(logMatrix),
                montocityScore = scoreStrategy.getMisMatchScore(logMatrix);
        return new DoubleMatrix(new double[][] {{maxValueScore, smoothnessScore,montocityScore,emptyCellScore}});
    }

    public Integer[][] generateRandomMatrix(int emptyCellCount) {
        Integer[][] matrix = new Integer[Game.ROWS][Game.COLUMNS];
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(count<emptyCellCount){
                    matrix[i][j] = 0;
                }
                else{
                    matrix[i][j] = getRandomPower2();
                }
                count++;
            }
        }
        return matrix;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Integer[][] getLog(Integer[][] matrix) {
        Integer[][] log = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int input = matrix[i][j].intValue();
                if(input==0){
                    log[i][j] = (int)(Math.log(1)/Math.log(2));
                }
                else
                    log[i][j] = (int)(Math.log(input)/Math.log(2));
            }
        }
        return log;  //To change body of created methods use File | Settings | File Templates.
    }

    private int getRandomPower2() {
        int max = 10;
        int min = 1;
        int randomNumber = random.nextInt(max - min) + min;
        return (int)Math.pow(2,randomNumber);  //To change body of created methods use File | Settings | File Templates.
    }
}
