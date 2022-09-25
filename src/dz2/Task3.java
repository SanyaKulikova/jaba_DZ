package dz2;

public class Task3 {
    public static void main(String[] args) {

        //Дана целочисленная переменная count - количество верных ответов.
        // В зависимости от значения этой переменной вывести в консоль оценку:
        // 100 - 90 правильных ответов - отлично
        // 89 - 60 правильных ответов - хорошо
        // 59 - 40 правильных ответов - удовлетворительно
        // 39 - 0 правильных ответов - попробуйте в следующий раз

        int count = 100;
        if (count >= 90 && count <= 100) {
            System.out.println( "Ваша оценка - отлично" );
        } else if (count >= 60 && count < 90) {
            System.out.println( "Ваша оценка - хорошо" );
        } else if (count >= 40 && count < 60) {
            System.out.println( "Ваша оценка - удовлетворительно" );
        } else if (count >= 0 && count < 40) {
            System.out.println( "Попробуйте в следующий раз" );
        } else System.out.println( "Такое невозможно:)" );

    }
}
