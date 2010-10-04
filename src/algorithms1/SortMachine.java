/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms1;

import java.util.ArrayList;
import java.util.Iterator;
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
