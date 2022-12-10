package utils;

import model.Ranges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateIntervals {
    public List<Ranges> GenerateIntervalsRange(int nombreRanges){
        int upperRandomBound = 1000000;
        Random random = new Random();
        List<Ranges> listGeneratedRanges = new ArrayList<>();
        for(int i=0; i<nombreRanges; i++){
            int lowerBound = random.nextInt(upperRandomBound);
            int upperBound = lowerBound + random.nextInt(upperRandomBound-lowerBound);
            char lettre = (char) (65+random.nextInt(26));
            Ranges randomRange = new Ranges(lowerBound,upperBound,lettre);
            listGeneratedRanges.add(randomRange);
        }
        return listGeneratedRanges;
    }
}
