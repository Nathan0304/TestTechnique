package utils;

import model.Ranges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderPerso {

    public List<Ranges> readFileListeIntervals(String fileName) throws IOException {
        List<Ranges> newRangesList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));){
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] fileRange = currentLine.split(",");
                Ranges newRange = new Ranges(Integer.parseInt(fileRange[0]), Integer.parseInt(fileRange[1]), fileRange[2].charAt(0));
                newRangesList.add(newRange);
                currentLine = reader.readLine();
            }
        }
        return newRangesList;
    }

    public List<Integer> readFileListeItems(String fileName) throws IOException {
        List<Integer> newItemsList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));){
            String currentLine = reader.readLine();
            while (currentLine != null) {
                newItemsList.add(Integer.valueOf(currentLine));
                currentLine = reader.readLine();
            }
        }

        return newItemsList;
    }
}
