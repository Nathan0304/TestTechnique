package utils;

import model.Ranges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarchingLabels1 {
    private final List<Ranges> availableRanges = new ArrayList<>();

    public MarchingLabels1(Ranges... ranges){
        Collections.addAll(this.availableRanges, ranges);
    }
    public List<Character> marchingLabels1(int item){
        List<Character> listChar = new ArrayList<>();
        for(Ranges range:availableRanges){
            if(range.isInInterval(item)){
                listChar.add(range.getLabel());
            }
        }
        return listChar;
    }
}
