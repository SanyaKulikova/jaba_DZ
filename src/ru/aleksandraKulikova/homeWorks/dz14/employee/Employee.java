package ru.aleksandraKulikova.homeWorks.dz14.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() < o2.getSalary()) return -1;
        if (o1.getSalary() > o2.getSalary()) return 1;
        return 0;
    }
}

class AgeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAge() < o2.getAge()) return -1;
        if (o1.getAge() > o2.getAge()) return 1;
        return 0;
    }
}

class CompanyComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee (String name,String company, int age, int salary) {
        this.name = name;
        this.company = company;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) { // по коду и приоритету вместе
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != employee.name) return false;
        return age == employee.age;
    }

    //  дописать реализацию метода для создания списка из объектов класса Employee.
    //  Объекты Employee создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп.
    //  num - количество объектов в списке
    public static List<Employee> employeeGenerator(int num) {
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        Random random = new Random();
        ArrayList<Employee> employees = new ArrayList<>();

        // создание объектов, наполнение списка
        for (int i = 0; i < num; i++) {
            int age = random.nextInt(60 - 21) + 21;
            employees.add(new Employee(names[random.nextInt(names.length)],
                    companies[random.nextInt(companies.length)], age,
                    (random.nextInt(4) +1) * age * 10_000)); // рандомный коэфициаент умноженный на возраст

        }

        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
