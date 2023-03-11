import java.util.Scanner;

public class Patient extends Person{
    public static int patientId;
    private String[] records;
    private String[] appointments;
    private String[] bills;

    public Patient(String name, String address, String mobileNumber, String eMail, String gender, String fileName) {
        super(name, address, mobileNumber, eMail, gender);
        this.patientId = generateId(fileName);
    }

    public static void registerPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registering new patient :: ");
        System.out.print("Name: " );
        String name = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.print("E-Mail: ");
        String eMail = sc.nextLine();

        String gender;
        do {
            System.out.print("Gender(male/female): ");
            gender = sc.nextLine();
        } while (!ErrorChecking.isValidGender(gender));

        Patient newPatient = new Patient(name, address, mobileNumber, eMail, gender, "patient.csv");
        WritingToCSV.addDataToCSVFile("patient.csv", newPatient.generateCSVString());
    }

    public static String getPatientIdAndName() {
        return "Patient Id: " + patientId + "\nPatient " + name;
    }
    public static void getRecordsByPatientId(){

    }

    @Override
    public String generateCSVString() {
        return patientId + "|||" + super.generateCSVString();
    }
}
