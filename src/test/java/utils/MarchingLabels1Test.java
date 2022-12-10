package utils;

import model.Ranges;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import utils.MarchingLabels;

import java.util.*;

public class MarchingLabelsTest {

    GenerateIntervals generateIntervals = new GenerateIntervals();

    @Test
    public void MarchingLabels1Interval(){
        Ranges range = new Ranges(1,10,'A');
        MarchingLabels marchingLabels = new MarchingLabels(range);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('A')), marchingLabels.marchingLabels1(3));
    }

    @Test
    public void MarchingLabels3IntervalDisjoint(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(20,30,'B');
        Ranges range3 = new Ranges(40,50,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('B')), marchingLabels.marchingLabels1(25));
    }

    @Test
    public void MarchingLabels3IntervalColles(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('C')), marchingLabels.marchingLabels1(25));
    }

    @Test
    public void MarchingLabels3IntervalCollesLowerBound(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('B')), marchingLabels.marchingLabels1(10));
    }

    @Test
    public void MarchingLabels3IntervalsJoints(){
        Ranges range1 = new Ranges(1,20,'A');
        Ranges range2 = new Ranges(10,30,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('A','B')), marchingLabels.marchingLabels1(15));
    }

    @Test
    public void MarchingLabelsHorsInterval(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList()), marchingLabels.marchingLabels1(100));
    }

    @Test
    public void MarchingLabelTestPerformance10000Ranges10000Tests(){
        List<Ranges> listGeneratedRanges = generateIntervals.GenerateIntervalsRange(10000);
        int[] listItems = new Random().ints(0,1000000).distinct().limit(10000L).toArray();
        MarchingLabels marchingLabels = new MarchingLabels(listGeneratedRanges.toArray(Ranges[]::new));
        long t0 = System.currentTimeMillis();
        for(int item: listItems){
            marchingLabels.marchingLabels1(item);
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Temps : "+(t1-t0));
    }

    @Test
    public void MarchingLabelTestPerformance10000Ranges100000Tests(){
        List<Ranges> listGeneratedRanges = generateIntervals.GenerateIntervalsRange(10000);
        int[] listItems = new Random().ints(0,1000000).distinct().limit(100000L).toArray();
        MarchingLabels marchingLabels = new MarchingLabels(listGeneratedRanges.toArray(Ranges[]::new));
        long t0 = System.currentTimeMillis();
        for(int item: listItems){
            marchingLabels.marchingLabels1(item);
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Temps : "+(t1-t0));
    }

    @Test
    public void MarchingLabelTestPerformance1000Ranges1000000Tests(){
        List<Ranges> listGeneratedRanges = generateIntervals.GenerateIntervalsRange(10000);
        int[] listItems = new Random().ints(0,1000000).distinct().limit(1000000L).toArray();
        MarchingLabels marchingLabels = new MarchingLabels(listGeneratedRanges.toArray(Ranges[]::new));
        long t0 = System.currentTimeMillis();
        for(int item: listItems){
            marchingLabels.marchingLabels1(item);
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Temps : "+(t1-t0));
    }
}
