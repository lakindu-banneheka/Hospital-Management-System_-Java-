import java.util.Scanner;

public class Patient extends Person{
    private int patientId;
    private String[] records;
    private String[] appointments;
    private String[] bills;

    public Patient(String name, String address, String mobileNumber, String eMail, String gender) {
        super(name, address, mobileNumber, eMail, gender);
    }

    public void registerPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("name: " );
        String name = sc.nextLine();

        System.out.print("address: ");
        String address = sc.nextLine();

        System.out.print("mobileNumber: ");
        String mobileNumber = sc.nextLine();

        System.out.print("eMail: ");
        String eMail = sc.nextLine();

        String gender;
        do {
            System.out.print("gender: ");
            gender = sc.nextLine();
        } while ((Person.Gender.MALE.toString().compareToIgnoreCase(gender) <= 0  || Person.Gender.FEMALE.toString().compareToIgnoreCase(gender) <= 0 ));

        Patient per = new Patient(name, address, mobileNumber, eMail, gender);

    }

//    public String toString() {
//        return "name: "+ this.name + "\nmobile number: " + this.mobileNumber + "\ndate of Birth: " + this.dateOfBirth;
//    }


}
