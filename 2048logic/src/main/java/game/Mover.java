package game;

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



}
