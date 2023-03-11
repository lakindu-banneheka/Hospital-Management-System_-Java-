import java.util.Scanner;

public class Record {
    private int recordId;
    private int doctorId;
    private int patientId;
    private String symptoms;
    private String diagnoses;
    private String treatments;
    private String notes;

    public Record(int recordId,int patientId,int doctorId,String symptoms,String diagnoses,String treatments,String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.symptoms = symptoms;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
        this.notes = notes;

        saveToCSV();
    }


    public static void addRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter record details," );

        int patientId = Person.getValidPersonId("Patient","patient.csv");

        int doctorId = Person.getValidPersonId("Doctor","patient.csv");

        System.out.print("Symptoms: ");
        String symptoms = sc.nextLine();

        System.out.print("Diagnoses: ");
        String diagnoses = sc.nextLine();

        System.out.print("Treatments: " );
        String treatments = sc.nextLine();

        System.out.print("Notes: " );
        String notes = sc.nextLine();

        ReadingFromCSV.getDataFromCSVFile("record.csv");
        int recordId = ReadingFromCSV.readData.size() + 1;
        new Record(recordId,patientId,doctorId,symptoms,diagnoses,treatments,notes);
    }
    public void saveToCSV(){
        WritingToCSV.addDataToCSVFile("record.csv", generateCSVString());
    }
    public String generateCSVString() {
        return this.recordId + "|||" + this.patientId + "|||" + this.doctorId + "|||" + this.symptoms + "|||" + this.diagnoses + "|||" + this.treatments + "|||" + this.notes;
    }
    public String toString() {
        return  "Record ID: " + this.recordId +
                "\nPatient id : " + patientId +
                "\ndoctor ID: " + doctorId +
                "\nSymptoms" + this.symptoms +
                "\nDiagnoses" + this.diagnoses +
                "\nTreatments" + this.treatments +
                "\nNotes" + this.notes;
    }

}
