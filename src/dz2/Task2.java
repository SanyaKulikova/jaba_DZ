package dz2;

public class Task2 {
    public static void main(String[] args) {

        //Дана переменная sum - сумма покупки и переменна saleCode - номер купона.
        //Если номер купона равен 4525 - вывести сумму с учетом скидки 30%
        //Если номер купона равен 6424 или 7012 - вывести сумму с учетом скидки 20%
        //Если номер купона равен 7647 или 9011 или 6612 - вывести сумму с учетом скидки 10%
        //В остальных случаях скидка не предусмотрена, вывесть полную стоимость покупки.

        float sum = 10000f;
        int saleCode = 5677;

        switch (saleCode) {
            case 4525:
                System.out.println( sum * 0.7);
                break;
            case 6424:
            case 7012:
                System.out.println( sum * 0.8);
                break;
            case 7647:
            case 9011:
            case 6612:
                System.out.println( sum * 0.9);
                break;
            default:
                System.out.println( sum );
        }
    }
}
