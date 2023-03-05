import java.util.Scanner;
public class TestMain {
    public static void main(String[] args) {
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

        Person per = new Person(name, address, mobileNumber, eMail, gender);

        System.out.println(per.toString());
    }
}
