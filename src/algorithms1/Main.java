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

        analyizeInjectedData( factor );

        analyizeSelectedData( factor );

    }

    private static void analyizeSelectedData(int factor) {
        List<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(5, 2, 4, 8, 6, 1, 3, 9));
        SortMachine sorte = new SortMachine(dataSet);
        List<Integer> resultSet = new ArrayList<Integer>(0);
        Long startTime = System.currentTimeMillis();
        int c = 0;
        while (true) {
            c++;
            if (c > factor) {
                break;
            }
            resultSet = sorte.selectSort();
        }
        Long timeCost = System.currentTimeMillis() - startTime;
        Double avgTimeCost = new Double(timeCost) / new Double(factor);
        displayAnalysis("Select Sort", factor, dataSet, resultSet, timeCost, avgTimeCost);
    }

    private static void analyizeInjectedData(int factor) {
        List<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(5, 2, 4, 8, 6, 1, 3, 9));
        SortMachine sorte = new SortMachine(dataSet);
        List<Integer> resultSet = new ArrayList<Integer>(0);
        Long startTime = System.currentTimeMillis();
        int c = 0;
        while (true) {
            c++;
            if (c > factor) {
                break;
            }
            resultSet = sorte.insertSort();
        }
        Long timeCost = System.currentTimeMillis() - startTime;
        Double avgTimeCost = new Double(timeCost) / new Double(factor);
        displayAnalysis("Inserted Sort", factor, dataSet, resultSet, timeCost, avgTimeCost);
    }

    private static void displayAnalysis(String title, int cycles, List<Integer> dataSet, List<Integer> resultSet, Long timeCost, Double avgTimeCost) {
        System.out.println("************************************************");
        System.out.println(title);
        System.out.println("************************************************");
        System.out.println("            Input set: " + dataSet.toString());
        System.out.println("           Output set: " + resultSet.toString());
        System.out.println("       Time Cost (ms): " + timeCost);
        System.out.println("  Avg. Time Cost (ms): " + avgTimeCost);
        System.out.println("************************************************");
    }

}
