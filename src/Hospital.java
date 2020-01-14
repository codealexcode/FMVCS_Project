import java.util.Random;

public class Hospital {

    private int availableNurses;
    private int availableDoctors;
    private int availableExaminingRooms;
    private int availableReceptionists;
    private int patients;
    private RessourceProvider ressourceProvider;

    // CONSTRUCTOR
    public Hospital(RessourceProvider ressourceProvider){
        this.availableNurses = 5;
        this.availableDoctors = 5;
        this.availableExaminingRooms = 10;
        this.availableReceptionists = 2;
        this.patients = 0;
        this.ressourceProvider = ressourceProvider;
    }

    // GETTERS
    public int getAvailableNursesNurses(){
        return this.availableNurses;
    }
    public void increaseAvailableNurse() {this.availableNurses++;}
    public void decreaseAvailableNurse() {this.availableNurses--;}

    public int getAvailableExaminingRooms(){
        return this.availableExaminingRooms;
    }
    public void increaseAvailableRooms() {this.availableExaminingRooms++;}
    public void decreaseAvailableRooms() {this.availableExaminingRooms--;}

    public int getAvailableDoctors(){
        return this.availableDoctors;
    }
    public void increaseAvailableDoctors() {this.availableDoctors++;}
    public void decreaseAvailableDoctors() {this.availableDoctors--;}

    public int getPatients() {return this.patients;}
    public void increasePatients() {this.patients++;}
    public void decreasePatients() {this.patients--;}

    // RUN THE HOSPITAL
    public void runHospital(){
        int patientCounter = 0;
        boolean start = true;
        boolean run = true;

        while (run){
            /*
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
            */

        }
    }

    private boolean newPatientArrive(){
        int randInt = new Random().nextInt(10) + 1;
        return randInt > 6;
    }

    private void startNewPatientTask(int taskId, Hospital hospital){
        increasePatients();
        Thread task = new Thread(new patientTask(taskId, hospital));
        task.start();
    }

    public void printHospital(){
        System.out.flush();
        System.out.println("-----  HOSPITAL  -----");
        System.out.println("PATIENTS INSIDE: " + this.patients);
        System.out.println("AVAILABLE NURSES: " + this.availableNurses);
        System.out.println("AVAILABLE DOCTORS: " + this.availableDoctors);
        System.out.println("AVAILABLE ROOMS: " + this.availableExaminingRooms);
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

