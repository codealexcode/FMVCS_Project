import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hospital {

    private List<Nurse> availableNurses;
    private List<Doctor> availableDoctors;
    private List<ExaminingRoom> availableExaminingRooms;
    private List<Receptionist> availableReceptionists;
    private List<Patient> patients;

    // CONSTRUCTOR
    public Hospital(){
        this.availableNurses = new ArrayList<Nurse>();
        this.availableDoctors = new ArrayList<Doctor>();
        this.availableExaminingRooms = new ArrayList<ExaminingRoom>();
        this.availableReceptionists = new ArrayList<Receptionist>();
        this.patients = new ArrayList<Patient>();
    }

    // GETTERS
    public List<Nurse> getAvailableNursesNurses(){
        return this.availableNurses;
    }

    public List<ExaminingRoom> getAvailableExaminingRooms(){
        return this.availableExaminingRooms;
    }

    public List<Doctor> getAvailableDoctors(){
        return this.availableDoctors;
    }

    public List<Patient> getPatients() {return this.patients;}

    // INITIALIZE HOSPITAL DEFAULT VALUES
    private void initHospital(){
        int numberOfStaff = 5;
        for(int i = 0; i < numberOfStaff; i++){
            this.availableNurses.add(new Nurse());
            this.availableDoctors.add(new Doctor());
            this.availableExaminingRooms.add(new ExaminingRoom());
            this.availableExaminingRooms.add(new ExaminingRoom());
        }
        this.availableReceptionists.add(new Receptionist());
        this.availableReceptionists.add(new Receptionist());
        printInit();
    }

    // RUN THE HOSPITAL
    public void runHospital(){
        int clock = 1000;
        int patientCounter = 0;
        boolean start = true;
        boolean run = true;

        initHospital();

        while (run){
            //System.out.println("HOSPITAL IS RUNNING");
            sleep(1000);
            if(start) {
                // 2 patients arrive
                patientCounter++;
                startNewPatientTask(patientCounter, this);
                sleep(5000);
                patientCounter++;
                startNewPatientTask(patientCounter, this);
                start = false;
            }
        }
    }

    private boolean newPatientArrive(){
        int randInt = new Random().nextInt(10) + 1;
        return randInt > 6;
    }

    private void startNewPatientTask(int taskId, Hospital hospital){
        Patient patient = new Patient();
        this.patients.add(patient);
        patientTask newPatientTask = new patientTask(taskId, patient, hospital);
        Thread task1 = new Thread(newPatientTask);
        task1.start();
    }

    private void printInit(){
        System.out.println("HOSPITAL INIT:");
        System.out.println("AVAILABLE NURSES: " + this.availableNurses.size());
        System.out.println("AVAILABLE DOCTORS: " + this.availableDoctors.size());
        System.out.println("AVAILABLE ROOMS: " + this.availableExaminingRooms.size());
        System.out.println("AVAILABLE RECEPTIONISTS: " + this.availableReceptionists.size());
        System.out.println("");
        System.out.println("");
    }

    public void printHospital(){
        System.out.flush();
        System.out.println("-----  HOSPITAL  -----");
        System.out.println("PATIENTS INSIDE: " + this.patients.size());
        System.out.println("AVAILABLE NURSES: " + this.availableNurses.size());
        System.out.println("AVAILABLE DOCTORS: " + this.availableDoctors.size());
        System.out.println("AVAILABLE ROOMS: " + this.availableExaminingRooms.size());
        //System.out.println("AVAILABLE RECEPTIONISTS: " + this.availableReceptionists.size());
    }

    private void sleep(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

