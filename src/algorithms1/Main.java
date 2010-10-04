/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kuccello
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int factor = 10000000;

        List<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(5,2,4,8,6,1,3,9));

        SortMachine sorte = new SortMachine(dataSet);

        List<Integer> resultSet = new ArrayList<Integer>(0);

        Long startTime = System.currentTimeMillis();

        int c = 0;
        while(true){
            c++;
            if(c > factor){
                break;
            }

            resultSet = sorte.insertSort();

        }

        Long timeCost = System.currentTimeMillis() - startTime;
        Double avgTimeCost = (new Double(timeCost)/new Double(factor));

        System.out.println("************************************************");
        System.out.println("Insert Sort");
        System.out.println("************************************************");
        System.out.println("  Input set: "+dataSet.toString());
        System.out.println("  Output set: "+resultSet.toString());
        System.out.println("  Time Cost (ms): "+timeCost);
        System.out.println("  Avg. Time Cost (ms): "+ avgTimeCost);
        System.out.println("************************************************");

    }

}
