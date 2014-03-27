package strategy;

/**
 * Created with IntelliJ IDEA.
 * User: sajit
 * Date: 3/24/14
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreStrategy {

    Integer getMisMatchScore(Integer[][] matrix);

    Integer getSmoothnessScore(Integer[][] matrix);

    Integer getMaxValueScore(Integer[][] matrix);

    Integer getEmptyCellScore(Integer[][] matrix);
}
