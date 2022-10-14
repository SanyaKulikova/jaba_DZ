package ru.aleksandraKulikova.homeWorks.dz6.task2.products;
//Свойства: название продукта / белки / жиры / углеводы / калории
//Минимум 4 конструктора
//Реализовать необходимые проверки входящих данных
//Создать не менее 4 экземпляров данного класса (объектов)
public class Product {
    private String title;
    private double proteins;
    private double fats;
    private double carbs;
    private double calories;

    public Product(String title, double proteins) {
        if (title.length() < 4) {
            throw new IllegalArgumentException("Название продукта не может быть короче 4 символов");
        }
        this.title = title;
        if (proteins < 0) {
            throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        }
        this.proteins = proteins;
    }

    public Product(String title, double proteins, double fats) {
        if (title.length() < 4) {
            throw new IllegalArgumentException("Название продукта не может быть короче 4 символов");
        }
        this.title = title;
        if (proteins < 0) {
            throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        }
        this.proteins = proteins;
        if (fats < 0) {
            throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        }
        this.fats = fats;
    }

    public Product (String title, double proteins, double fats, double carbs) {
        if (title.length() < 4) {
            throw new IllegalArgumentException("Название продукта не может быть короче 4 символов");
        }
        this.title = title;
        if (proteins < 0) {
            throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        }
        this.proteins = proteins;
        if (fats < 0) {
            throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        }
        this.fats = fats;
        if (carbs < 0) {
            throw new IllegalArgumentException("Количество углеводов не может быть отрицательным");
        }
        this.carbs = carbs;
    }

    public Product (String title, double proteins, double fats, double carbs, double calories) {
        if (title.length() < 4) {
            throw new IllegalArgumentException("Название продукта не может быть короче 4 символов");
        }
        this.title = title;
        if (proteins < 0) {
            throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        }
        this.proteins = proteins;
        if (fats < 0) {
            throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        }
        this.fats = fats;
        if (carbs < 0) {
            throw new IllegalArgumentException("Количество углеводов не может быть отрицательным");
        }
        this.carbs = carbs;
        if (calories < 10) {
            throw new IllegalArgumentException("Количество колорий не может быть меньше 10");
        }
        this.calories = calories;
    }

    public void setFats(double fats){
        if (fats < 0) {
            throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        }
        this.fats = fats;
    }
    public void setCarbs(double carbs){
        if (carbs < 0) {
            throw new IllegalArgumentException("Количество углеводов не может быть отрицательным");
        }
        this.carbs = carbs;
    }
    public void setCalories(double calories) {
        if (calories < 10) {
            throw new IllegalArgumentException("Количество колорий не может быть меньше 10");
        }
        this.calories = calories;
    }




}
