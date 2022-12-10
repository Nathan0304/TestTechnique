package utils;

import model.Ranges;

import java.util.*;

public class MarchingLabels {
    private NavigableMap<Integer,List<Character>> availableRanges;

    public MarchingLabels(Ranges... ranges){
        this.availableRanges = createNavigableMap(ranges);
    }
    public List<Character> marchingLabels(int item){
        List<Character> listChar;
        Map.Entry<Integer,List<Character>> foundValue = this.availableRanges.floorEntry(item);
        listChar = (foundValue != null)?foundValue.getValue():new ArrayList<>();
        return listChar;
    }

    public NavigableMap<Integer, List<Character>> createNavigableMap(Ranges... ranges){
        NavigableMap<Integer,List<Character>> navigableMap = new TreeMap<>();
        for(Ranges range:ranges){
            addRangeToNavigableMap(range, navigableMap);
        }
        return navigableMap;
    }

    public void addRangeToNavigableMap(Ranges range, NavigableMap<Integer, List<Character>> navigableMap){
        Integer upperBound = range.getUpperBound();
        Integer lowerBound = range.getLowerBound();
        Character label = range.getLabel();
        SortedMap<Integer,List<Character>> intervalsInNavigableMap = navigableMap.subMap(range.getLowerBound(),range.getUpperBound());
        Set<Integer> setCleIntervalNavigableMap = intervalsInNavigableMap.keySet();
        for(int key: setCleIntervalNavigableMap){
            navigableMap.get(key).add(label);
        }
        addLowerBoundValueToNavigableMap(setCleIntervalNavigableMap, lowerBound, label, navigableMap);
        addUpperBoundValueToNavigableMap(intervalsInNavigableMap, upperBound, navigableMap, label);
    }

    public void addLowerBoundValueToNavigableMap(Set<Integer> setCleIntervalNavigableMap, Integer lowerBound, Character label,
                                   NavigableMap<Integer,List<Character>> navigableMap){
        if(!setCleIntervalNavigableMap.contains(lowerBound)){
            Map.Entry<Integer, List<Character>> ceilingEntry = navigableMap.floorEntry(lowerBound);
            List<Character> lowerBoundCharactereList;
            if(ceilingEntry!=null){
                lowerBoundCharactereList = new ArrayList<>(List.copyOf(ceilingEntry.getValue()));
                lowerBoundCharactereList.add(label);
            }else{
                lowerBoundCharactereList = new ArrayList<>(Collections.singletonList(label));
            }
            navigableMap.put(lowerBound,lowerBoundCharactereList);
        }
    }

    public void addUpperBoundValueToNavigableMap(SortedMap<Integer,List<Character>> intervalsInNavigableMap, Integer upperBound,
                                                 NavigableMap<Integer,List<Character>> navigableMap, Character label){
        if(!navigableMap.containsKey(upperBound)){
            List<Character> newUpperBound = new ArrayList<>(List.copyOf(navigableMap.get(intervalsInNavigableMap.lastKey())));
            newUpperBound.remove(label);
            navigableMap.put(upperBound,newUpperBound);
        }
    }
}
