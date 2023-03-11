import javax.print.Doc;
import java.util.Scanner;

public class Doctor extends Person {
    int doctorId;
    String specialty;
    String licenseNumber;


    public Doctor(String name, String specialty, String licenseNumber, String address, String mobileNumber, String eMail, String gender,String fileName) {
        super(name, address, mobileNumber, eMail, gender);
        this.doctorId = generateId(fileName);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }

    public static void registerDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registering new doctor :: ");

        System.out.print("Name: " );
        String name = sc.nextLine();

        System.out.print("Specialty: " );
        String specialty = sc.nextLine();

        System.out.print("License Number: " );
        String licenseNumber = sc.nextLine();

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

        Doctor newDoctor = new Doctor(name, specialty, licenseNumber, address, mobileNumber, eMail, gender, "doctor.csv");
        WritingToCSV.addDataToCSVFile("doctor.csv", newDoctor.generateCSVString());
    }

    @Override
    public String generateCSVString() {
        return doctorId + "|||" + specialty + "|||" + licenseNumber + "|||" + super.generateCSVString();
    }
}
