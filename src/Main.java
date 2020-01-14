

public class Main {

    public static void main(String[] args) {

        RessourceProvider ressourceProvider = new RessourceProvider();

        Hospital hospital1 = new Hospital(ressourceProvider);
        Hospital hospital2 = new Hospital(ressourceProvider);
        hospital1.runHospital();
        hospital2.runHospital();
    }
}
