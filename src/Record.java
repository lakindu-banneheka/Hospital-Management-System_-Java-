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

        int patientId;
        do {
            System.out.print("Patient Id: " );
            patientId = sc.nextInt();
            sc.nextLine();
            if(!ErrorChecking.isPersonIdValid("patient.csv",patientId)){
                System.out.println("Invalid Patient ID");
            }
        } while (!ErrorChecking.isPersonIdValid("patient.csv",patientId));


        System.out.print("Doctor Id: " );
        int doctorId = sc.nextInt();
        sc.nextLine();

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

        WritingToCSV.addDataToCSVFile("record.csv", Integer.toString(recordId).trim() + "," +
//                        Integer.toString(patient.patientId).trim() + "," +
//                        Integer.toString(doctor.doctorId).trim() + "," +
                        symptoms.trim() + "," + diagnoses.trim() + "," +
                        treatments.trim() + "," + notes.trim()
        );
    }
    public String toString() {
        return "Record ID: " + this.recordId + "\nPatient id : " +
//                patient.getPatientIdAndName() +
//                "\ndoctor ID: " + doctor +
                "\nSymptoms" + this.symptoms + "\nDiagnoses" + this.diagnoses + "\nTreatments" + this.treatments +
                "\nNotes" + this.notes;
    }

}
