import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadingFromCSV {
    static List<String[]> readData;

    public static void getDataFromCSVFile(String csvFile) {
        BufferedReader reader = null;
        String line = "";
        String delimiter = "|||";
        List<String[]> data = new ArrayList<>();
        readData = data;

        try {
            reader = new BufferedReader(new FileReader(csvFile));

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(delimiter);
                data.add(row);
            }

        } catch (IOException e) {
            System.out.println("Error occurred while reading data from CSV file: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing reader: " + e.getMessage());
            }
        }
    }
}
