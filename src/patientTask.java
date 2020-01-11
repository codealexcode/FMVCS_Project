import java.util.Random;

public class patientTask implements Runnable {

    private int taskId;
    private Patient patient;
    private Hospital hospital;

    public patientTask(int taskId, Patient patient,  Hospital hospital){
        this.taskId = taskId;
        this.patient = patient;
        this.hospital = hospital;
    }

    @Override
    public void run() {
        System.out.println("TASK " + this.taskId + " STARTED");
        boolean checkout = false;

        while(!checkout){
            // fill paper
            if(this.hospital.getAvailableNursesNurses().size() > 0){
                fillPaper();
                while(!checkout){
                    // enter room
                    if(this.hospital.getAvailableExaminingRooms().size() >  0){
                        enterRoom();
                        while(!checkout){
                            //treatment
                            if(this.hospital.getAvailableDoctors().size() > 0){
                                treatment();
                                checkout = checkout();
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean test(int proba){
        int randInt = new Random().nextInt(10) + 1;
        return randInt > proba;
    }

    private void fillPaper(){
        this.hospital.getAvailableNursesNurses().remove(0);
        printHospital("FILL PAPER");
        sleep(4000);
        this.hospital.getAvailableNursesNurses().add(new Nurse());
        printHospital("CHECK PAPER");
    }

    private void enterRoom(){
        this.hospital.getAvailableExaminingRooms().remove(0);
        printHospital("ENTER ROOM");
    }

    private void treatment(){
        this.hospital.getAvailableDoctors().remove(0);
        printHospital("TREATMENT");
        sleep(8000);
    }

    private boolean checkout(){
        this.hospital.getAvailableExaminingRooms().add(new ExaminingRoom());
        this.hospital.getAvailableDoctors().add(new Doctor());
        this.hospital.getPatients().remove(0);
        printHospital("CHECKOUT");
        return true;
    }

    private void sleep(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printHospital(String action){
        System.out.flush();
        System.out.println("HOSPITAL - TASK: " + this.taskId + " - ACTION: " + action);
        System.out.println("PATIENTS INSIDE: " + this.hospital.getPatients().size());
        System.out.println("AVAILABLE NURSES: " + this.hospital.getAvailableNursesNurses().size());
        System.out.println("AVAILABLE DOCTORS: " + this.hospital.getAvailableDoctors().size());
        System.out.println("AVAILABLE ROOMS: " + this.hospital.getAvailableExaminingRooms().size());
    }
}
