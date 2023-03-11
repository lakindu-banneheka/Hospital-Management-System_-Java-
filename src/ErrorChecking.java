import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorChecking {
    public static boolean isPersonIdValid(String fileName, int checkId) {
        ReadingFromCSV.getDataFromCSVFile(fileName);
        List<String[]> readData = new ArrayList<>();
        readData = ReadingFromCSV.readData;

        boolean isValid = false;
        for (int i = 0; i < readData.size(); i++) {
            int id = Integer.parseInt(readData.get(i)[0]);
            if(checkId == id){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public static boolean isValidGender(String gender) {
        boolean isValid = false;
        if(Person.Gender.MALE.toString().compareTo(gender.toUpperCase()) == 0  || Person.Gender.FEMALE.toString().compareTo(gender.toUpperCase()) == 0){
            isValid = true;
        }
        return isValid;
    }
}
