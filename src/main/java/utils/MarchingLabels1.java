package utils;

import model.Ranges;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

public class MarchingLabels1 {
    private List<Ranges> availableRanges = new ArrayList<>();

    public MarchingLabels1(Ranges... ranges){
        for(Ranges range:ranges){
            this.availableRanges.add(range);
        }
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
    public List<Character> marchingLabels(int item){
        NavigableMap<Integer,Character> listInterval = createNavigableMap();
        List<Character> listChar = new ArrayList<>();
        for(Ranges range:availableRanges){
            if(range.isInInterval(item)){
                listChar.add(range.getLabel());
            }
        }
        return listChar;
    }

    public NavigableMap<Integer, Character> createNavigableMap(){

    }
}
