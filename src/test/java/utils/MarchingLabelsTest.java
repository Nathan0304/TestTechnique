package utils;

import model.Ranges;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.MarchingLabels;

import java.util.*;

class MarchingLabelsTest {

    private final GenerateIntervals generateIntervals = new GenerateIntervals();

    @Test
    void MarchingLabels1Interval(){
        Ranges range = new Ranges(1,10,'A');
        MarchingLabels marchingLabels = new MarchingLabels(range);
        Assertions.assertEquals(new ArrayList<>(List.of('A')), marchingLabels.marchingLabels(3));
    }

    @Test
    void MarchingLabels3IntervalDisjointValeurIn(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(20,30,'B');
        Ranges range3 = new Ranges(40,50,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<>(List.of('B')), marchingLabels.marchingLabels(25));
    }

    @Test
    void MarchingLabels3IntervalDisjointValeurOutLowerBound(){
        Ranges range1 = new Ranges(5,10,'A');
        Ranges range2 = new Ranges(20,30,'B');
        Ranges range3 = new Ranges(40,50,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(List.of()), marchingLabels.marchingLabels(2));
    }

    @Test
    void MarchingLabels3IntervalDisjointValeurOutUpperBound(){
        Ranges range1 = new Ranges(5,10,'A');
        Ranges range2 = new Ranges(20,30,'B');
        Ranges range3 = new Ranges(40,50,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(List.of()), marchingLabels.marchingLabels(200));
    }

    @Test
    void MarchingLabels3IntervalColles(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<>(List.of('C')), marchingLabels.marchingLabels(25));
    }

    @Test
    void MarchingLabels3IntervalCollesLowerBound(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<>(List.of('B')), marchingLabels.marchingLabels(10));
    }

    @Test
    void MarchingLabels3IntervalsJoints(){
        Ranges range1 = new Ranges(1,20,'A');
        Ranges range2 = new Ranges(10,30,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList('A','B')), marchingLabels.marchingLabels(15));
    }

    @Test
    void MarchingLabelsHorsInterval(){
        Ranges range1 = new Ranges(1,10,'A');
        Ranges range2 = new Ranges(10,20,'B');
        Ranges range3 = new Ranges(20,30,'C');
        MarchingLabels marchingLabels = new MarchingLabels(range1, range2, range3);
        Assertions.assertEquals(new ArrayList<Character>(List.of()), marchingLabels.marchingLabels(100));
    }

    @ParameterizedTest
    @CsvSource({
            "10000, 10000",
            "10000, 100000",
            "10000, 1000000",
            "1000, 10000",
            "100, 10000"
    })
    void MarchingLabelTestPerformance10_000Ranges10_000Tests(int range, long nbrTests){
        List<Ranges> listGeneratedRanges = generateIntervals.GenerateIntervalsRange(range);
        int[] listItems = new Random().ints(0,1000000).distinct().limit(nbrTests).toArray();
        long t0 = System.currentTimeMillis();
        MarchingLabels marchingLabels = new MarchingLabels(listGeneratedRanges.toArray(Ranges[]::new));
        for(int item: listItems){
            marchingLabels.marchingLabels(item);
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Temps pour 10 000 test et 10 000 ranges : "+(t1-t0)+" ms");
    }
}
