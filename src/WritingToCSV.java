import java.io.FileWriter;
import java.io.IOException;

public class WritingToCSV {

    // add new data to existing database(CSV file)
    public static void addDataToCSVFile(String csvFile,String newLine) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(csvFile, true); // set true to append to file

            ReadingFromCSV.getDataFromCSVFile(csvFile);
            if(ReadingFromCSV.readData.size() >= 1 ){
                fileWriter.append('\n'); // add newline character
            }
            fileWriter.append(newLine);

            System.out.println("New line has been added to " + csvFile);

        } catch (IOException e) {
            System.out.println("Error occurred while adding a new line to CSV file: " + e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing fileWriter: " + e.getMessage());
            }
        }
    }
}
