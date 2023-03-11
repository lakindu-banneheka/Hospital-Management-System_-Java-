import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Person {


    public enum Gender {
        MALE,
        FEMALE
    }
    static String name;
    private String address;
    private String mobileNumber;
    private String eMail;
    private Gender gender;
    private String dateOfBirth;


    public Person(String name, String address, String mobileNumber, String eMail, String gender) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.eMail = eMail;
        this.gender = (Gender.MALE.toString().compareToIgnoreCase(gender) <= 0 ? Gender.MALE : (Gender.FEMALE.toString().compareToIgnoreCase(gender) <= 0 ? Gender.FEMALE : null));
    }

    public String toString() {
        return "name: "+ name + "\nmobile number: " + this.mobileNumber + "\ngender: " + this.gender;
    }

    public static String getPersonName() {
        return "Name: " + name;
    }

    public static int generateId(String fileName) {
        ReadingFromCSV.getDataFromCSVFile(fileName);
        List<String[]> readData = new ArrayList<>();
        readData = ReadingFromCSV.readData;

        return readData.size() > 0 ? (Integer.parseInt(readData.get(readData.size() -1)[0]) + 1) : 1;
    }

    public String generateCSVString() {
        return this.name.trim() + "|||" + this.address.trim() + "|||" + this.mobileNumber.trim() + "|||" + this.eMail.trim() + "|||" + this.gender;
    }

    public static int getValidPersonId(String person, String fileName){
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.print(person + " Id: " );
            id = sc.nextInt();
            sc.nextLine();
            if(!ErrorChecking.isPersonIdValid(fileName,id)){
                System.out.println("Invalid "+ person +" ID");
            }
        } while (!ErrorChecking.isPersonIdValid(fileName,id));

        return id;
    }
}
