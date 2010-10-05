/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kuccello
 */
public class SortMachine {
    private List<Integer> inputs = new ArrayList<Integer>(0);
    private List<Integer> outputs = new ArrayList<Integer>(0);

    public SortMachine(List<Integer> input){
        this.inputs = input;
    }

    /**
     * ------------------------
     * Merge Sort 
     * ------------------------
     * Input:   A sequence of n numbers {a1,a2,...,an}
     *
     * Output:  A permutation (reordering) {a`1,a`2,...,a`n} of the input
     *          sequence such that a`1 <= a`2 <= ... <= a`n
     * -------------------------
     * 1. Divide the inputs into two equally sized input arrays
     * 2. Recursivly sort the the two sub arrays
     * 3. Combine/Merge the two sorted sub arrays to produce one whole array
     */
    public List<Integer> mergeSort(){

        outputs = doMergeSort(inputs);

        return outputs;
    }

    private List<Integer> doMergeSort(List<Integer> inputs){

        List<Integer> resultSet = new ArrayList<Integer>();

        if(inputs.size()<2){
            resultSet = inputs;
        }else if(inputs.size()==2){
            Integer x0 = inputs.get(0);
            Integer x1 = inputs.get(1);
            if(x0 > x1){
                resultSet.add(x1);
                resultSet.add(x0);
            }else{
                resultSet.add(x0);
                resultSet.add(x1);
            }
        }else if(inputs.size()==3){
            Integer x0 = inputs.get(0);
            Integer x1 = inputs.get(1);
            Integer x2 = inputs.get(2);
            if(x0 > x1 && x1 > x2){
                resultSet.add(x2);
                resultSet.add(x1);
                resultSet.add(x0);
            }else if(x2 > x0 && x0 > x1){
                resultSet.add(x1);
                resultSet.add(x0);
                resultSet.add(x2);
            }else if(x1 > x2 && x2 > x0){
                resultSet.add(x0);
                resultSet.add(x2);
                resultSet.add(x1);
            }
        }else{
System.out.println(""+inputs.size());
            int midpoint = Math.round(inputs.size()/2);
System.out.println(""+midpoint);
            List<Integer> i1 = inputs.subList(0, midpoint);
            List<Integer> i2 = inputs.subList(midpoint+1, inputs.size());

            i1 = doMergeSort(i1);
            i2 = doMergeSort(i2);

            i1.addAll(i2);
            resultSet = i1;
        }
        return resultSet;
    }


    /**
     * ------------------------
     * Select Sort O(n^2)
     * ------------------------
     * Input:   A sequence of n numbers {a1,a2,...,an}
     *
     * Output:  A permutation (reordering) {a`1,a`2,...,a`n} of the input
     *          sequence such that a`1 <= a`2 <= ... <= a`n
     * -------------------------
     * Search through A looking for the next smallest number
     * and place it in A at A[i+1] for i
     */
    public List<Integer> selectSort(){

        outputs = new ArrayList<Integer>(inputs);

        int An = outputs.size();

        for(int j = 0; j < An; j++){
            Integer smallestSeen = outputs.get(j);
            int currentlySmallestIndex = j;

            for(int i = j + 1; i < An; i++){

                Integer Xj = outputs.get(i);

                if(Xj < smallestSeen){
                    // new smallest found
                    smallestSeen = Xj;
                    currentlySmallestIndex = i;
                }

            }
            outputs.add(j,smallestSeen);
            outputs.remove(currentlySmallestIndex+1);
            
        }

        return outputs;
    }

    /**
     * ------------------------
     * Insertion Sort [O(n^2)]
     * -------------------------
     * Input:   A sequence of n numbers {a1,a2,...,an}
     *
     * Output:  A permutation (reordering) {a`1,a`2,...,a`n} of the input
     *          sequence such that a`1 <= a`2 <= ... <= a`n
     * -------------------------
     * Psudo Code:
     * for j = 2 to length[A]
     *      do key = A[j]
     *          Insert A[j] into the sorted sequence A[1..j-1]
     *          i = j - 1
     *          while i > 0 and A[i] > key
     *              do A[i + 1] = A[i]
     *                  i = i - 1
     *          A[i + 1] = key
     *
     * @return - sorted array list of values in ascending order
     */
    public List<Integer> insertSort(){

        outputs = new ArrayList<Integer>(inputs);

        int An = outputs.size();

        for(int j = 1; j < An; j++){

            Integer Aj = outputs.get(j);

            for(int x = 0;x<j;x++){
                if(Aj < outputs.get(x)){
                    outputs.add(x,Aj);
                    outputs.remove(j+1);
                    break;
                }
            }
        }

        return outputs;
    }

}
