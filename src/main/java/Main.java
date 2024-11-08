import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
public static void main (String[] args) {

    /*
    NameHold nameHold = new NameHold(1000, 10000, 5);

    System.out.println("Set 1000 size for testing purposes: " + nameHold.getNames1000().size());
    System.out.println("Set 10,000 size for testing also: " + nameHold.getNames10000().size());

    */
    NameHold nameHolder = new NameHold(1000, 10000, 5);

    //Getting the sets of names
    Set<String> names1000 = nameHolder.getNames1000();
    Set<String> names10000 = nameHolder.getNames10000();

    //realized that a list would be better, converting:
    List<String> namesList1000 = new ArrayList<>(names1000);
    List<String> namesList10000 = new ArrayList<>(names10000);

    //100 entries from each list
    List<String> selectedNames1000 = namesList1000.subList(0, 100);
    List<String> selectedNames10000 = namesList10000.subList(0, 100);

    LinearProbingWithCount<String, String> linearTable = new LinearProbingWithCount<>();
    DoubleHashingWithCount<String, String> doubleHashTable = new DoubleHashingWithCount<>();


    List<Integer> linProbes = new ArrayList<>();
    List<Integer> doubHashProbes = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
       //clearing both tables before starting again
        linearTable.clear();
        doubleHashTable.clear();

            for (String name : selectedNames1000) {
                linearTable.add(name, name);
                doubleHashTable.add(name, name);
            }

            //tracking number of probes for this turn
            int LinProbesPerIt = 0;
            int DblHashProbesPerIt = 0;

            //Proforming unsuccesfull searches
            for (String name : selectedNames10000) {
                //tracking probes for linear probing
                int linearProbes = linearTable.search(name);
                LinProbesPerIt += linearProbes;

                int DoubleHashProbes = doubleHashTable.search(name);
                DblHashProbesPerIt += DoubleHashProbes;
            }

            //Adding the counts to the list
            linProbes.add(LinProbesPerIt);
            doubHashProbes.add(DblHashProbesPerIt);
        }

        //STATS start here!:

        double avgLinProbes = calculateAverage(linProbes);
        double stdDevLinearProbes = calculateStandardDeviation(linProbes, avgLinProbes);

        double avgDoubHashProbes = calculateAverage(doubHashProbes);
        double stdDevDoubHashProbes = calculateStandardDeviation(doubHashProbes, avgDoubHashProbes);


        } //end main

    public static double calculateAverage(List<Integer> probes) {
        double sum = 0;
        for (int probe : probes) {
            sum += probe;
        }
        return sum / probes.size();
    } //end calcualteaverage


    public static double calculateStandardDeviation(List<Integer> probes, double average) {
        double sum = 0;
        for (int probe : probes) {
            sum += Math.pow(probe - average, 2);
        }
        return Math.sqrt(sum / probes.size());
    } // end standdev

} //end main

