package Framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CSVParser {
    public static Iterator<Object[]> loadMessageFromFile() {
        List<Object[]> list = new ArrayList<Object[]>();
        String filePath = new File("src/main/resources/Data.csv").getAbsolutePath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            String line = reader.readLine();


            while (line != null) {
                list.add(new Object[]{line});
                line = reader.readLine();
            }
        } catch (Exception e) {
        }
        return list.iterator();
    }
}

