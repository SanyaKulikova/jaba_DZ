package dz1;
/*Задачи на арифметические операторы
Даны длина, ширина и высота прямоугольного параллелепипеда. Найти и вывести в консоль его площадь.

Дано целое число. Найти и вывести в консоль данное число в кубе.

Даны две переменные типа double: время (в часах) и расстояние (в километрах). Найти и вывести в консоль скорость, выраженную в метрах в секунду.*/
public class Task1 {
    public static void main(String[] args) {
        int length = 10, width = 5, height = 7;
        System.out.println(2*length*width+2*width*height+2*length*height);

        int chislo = 5;
        int cub = chislo*chislo*chislo;
        System.out.println(cub);

        double time = 7.5;
        double space = 1000.7;
        double velocity = (space/time)/3.6;
        System.out.println(velocity);

    }
}
