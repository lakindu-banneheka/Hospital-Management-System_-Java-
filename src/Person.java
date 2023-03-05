
public class Person {


    enum Gender {
        MALE,
        FEMALE
    }
    private String name;
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
        return "name: "+ this.name + "\nmobile number: " + this.mobileNumber + "\ngender: " + this.gender;
    }
}
