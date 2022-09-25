package dz2;

public class Task1 {
    public static void main(String[] args) {

        //Дан номер месяца, например int month = 5. В зависимости от данного значения вывести в консоль время года

        int month = 9;
        if (month == 12 || month <= 2) {
            System.out.println("Winter");
        } else if (month > 2 && month <= 5) {
            System.out.println("Spring");
        } else if (month > 5 && month <= 8) {
            System.out.println("Summer");
        } else System.out.println("Autumn");

    }
}
