package game;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 7:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mover {

    public static Integer pull(Integer[] input){
        //first bubble the zeros to the right
        // i <- index of leftmost zero

        int pmtIdx=0,mergeScore = 0; //potential merge target
        for(int i=1;i<input.length;i++){
            if(input[i].intValue() != 0){
                int potentialMergeTarget = input[pmtIdx].intValue();
                int currentNumber = input[i].intValue();
                if(potentialMergeTarget==0){
                    input[pmtIdx] =  currentNumber;
                    input[i] =0;

                }
                else if(currentNumber != potentialMergeTarget){
                    input[pmtIdx+1] = currentNumber;

                    //if the potential merge target is not zero dont do anything
                    //but if its zero..
                    if(i != pmtIdx+1){
                        input[i]=0;
                    }
                    pmtIdx++;

                }
                else{  //merge current number with potential mergeTarget
                    input[pmtIdx] += currentNumber;
                    mergeScore += input[pmtIdx];
                    if(mergeScore>= 512){
                        System.out.println("Mega merge " + mergeScore);
                    }
                    pmtIdx++;
                    input[i]= 0;
                }

                //can this be merged with number at potential merge target
            }
        }
        return mergeScore;
    }

    public static Integer getPotentialMergeScore(Integer[] arr){
        Integer score = 0;
        int i=1;
        while(i<arr.length){
            if(arr[i-1].intValue()==arr[i].intValue() && arr[i].intValue() !=0){
                //adjacent pairs
                score +=2*arr[i].intValue();
                i+=2;
            }
            else
                i++;


        }

       return score;

    }

    public static Integer getPotentialMergeCount(Integer[] arr){
        Integer count = 0;
        int i=1;
        while(i<arr.length){
            if(arr[i-1].intValue()==arr[i].intValue() && arr[i].intValue() !=0){
                //adjacent pairs
                count++;
                i+=2;
            }
            else
                i++;


        }

        return count;

    }
    public static Integer getPotentialMergeValue(Integer[] arr){
        Integer value = 0;
        int i=1;
        while(i<arr.length){
            if(arr[i-1].intValue()==arr[i].intValue() && arr[i].intValue() !=0){
                //adjacent pairs
                value += arr[i].intValue();
                i+=2;
            }
            else
                i++;


        }

        return value;

    }

    public static Integer getOrderMisMatchValue(Integer[] arr){

        Integer misMatchValue = 0;


        Pair<Direction,Integer> movement = Pair.of(getDirection(arr[0],arr[1]),arr[0].intValue()-arr[i].intValue());



        for(int i=2;i<arr.length;i++){
            Direction direction = getDirection(arr[i-1],arr[i]);
            if(direction != Direction.same){

                if(direction != movement.getLeft() && movement.getLeft() !=  Direction.same){

                    int delta =  Math.abs(arr[i]-arr[i-1]);

                }
                    misMatchValue = Math.max();
                trend = direction;
            }

        }
        return misMatchCount;
    }

    public static Integer getOrderMisMatch(Integer[] arr){

        Integer misMatchCount = 0;

        Direction trend  = getDirection(arr[0],arr[1]);
        if(trend== Direction.same){
            trend = null;
        }


        for(int i=2;i<arr.length;i++){
           Direction direction = getDirection(arr[i-1],arr[i]);
           if(direction != Direction.same){

            if(direction != trend && trend != null )
                    misMatchCount++;
            trend = direction;
           }

        }
        return misMatchCount;
    }

    private static Direction getDirection(Integer first,Integer second) {
        final Direction direction;

        if(second.intValue()> first.intValue()){
            direction = Direction.up;
        }
        else if(second.intValue()<first.intValue()){
            direction = Direction.down;
        }
        else{
            direction = Direction.same;
        }
        return direction;

    }


}
enum Direction{
    up,down,same
}
