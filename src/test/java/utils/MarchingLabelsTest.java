import model.Ranges;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import utils.MarchingLabels;

import java.util.ArrayList;
import java.util.Arrays;

public class MarchingLabelsTest {

    @Test
    public void MarchingLabels1Interval(){
        Ranges range = new Ranges(1,10,'A');
        MarchingLabels marchingLabels = new MarchingLabels(range);
        Assertions.assertEquals(new ArrayList<Character>(Arrays.asList('A')), marchingLabels.marchingLabels1(3));
    }
}
