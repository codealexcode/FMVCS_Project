import java.util.Random;

public class patientTask implements Runnable {

    private int taskId;
    private Hospital hospital;

    public patientTask(int taskId, Hospital hospital){
        this.taskId = taskId;
        this.hospital = hospital;
    }

    @Override
    public void run() {
        System.out.println("TASK " + this.taskId + " STARTED");
        boolean checkout = false;

        while(!checkout){
            // fill paper
            if(this.hospital.getAvailableNursesNurses() > 0){
                fillPaper();
                while(!checkout){
                    // enter room
                    if(this.hospital.getAvailableExaminingRooms() >  0){
                        enterRoom();
                        while(!checkout){
                            //treatment
                            if(this.hospital.getAvailableDoctors() > 0){
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
        this.hospital.decreaseAvailableNurse();
        printHospital("FILL PAPER");
        sleep(4000);
        this.hospital.increaseAvailableNurse();
        printHospital("CHECK PAPER");
    }

    private void enterRoom(){
        this.hospital.decreaseAvailableRooms();
        printHospital("ENTER ROOM");
    }

    private void treatment(){
        this.hospital.decreaseAvailableDoctors();
        printHospital("TREATMENT");
        sleep(8000);
    }

    private boolean checkout(){
        this.hospital.increaseAvailableRooms();
        this.hospital.increaseAvailableDoctors();
        this.hospital.decreasePatients();
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
        System.out.println("PATIENTS INSIDE: " + this.hospital.getPatients());
        System.out.println("AVAILABLE NURSES: " + this.hospital.getAvailableNursesNurses());
        System.out.println("AVAILABLE DOCTORS: " + this.hospital.getAvailableDoctors());
        System.out.println("AVAILABLE ROOMS: " + this.hospital.getAvailableExaminingRooms());
    }
}
