package utils;

import main.java.model.Ranges;

import java.util.ArrayList;
import java.util.List;

public class MarchingLabels {
    private List<Ranges> availableRanges;

    public MarchingLabels(Ranges... ranges){
        for(Ranges range:ranges){
            this.availableRanges.add(range);
        }
    }
    public List<Character> marchingLabels1(int item){
        List<Character> listChar = new ArrayList<Character>();
        for(Ranges range:availableRanges){
            if(range.isInInterval(item)){
                listChar.add(range.getLabel());
            }
        }
        return listChar;
    }
}
