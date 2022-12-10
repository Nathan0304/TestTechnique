package utils;

import java.io.InputStream;

public class fileReader {

    public void readFile(String fileName) {
        String expectedData = "Hello, world!";

        Class clazz = FileOperationsTest.class;
        InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
        String data = readFromInputStream(inputStream);

        Assert.assertThat(data, containsString(expectedData));
    }
}
