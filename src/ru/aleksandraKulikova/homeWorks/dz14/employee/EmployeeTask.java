package ru.aleksandraKulikova.homeWorks.dz14.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList01 = Employee.employeeGenerator(50);

        // TODO 1: отсортировать список по имени
        Comparator<Employee> comparator1 = new NameComparator();
        TreeSet<Employee> employeeTreeSet01 = new TreeSet<>(comparator1);
        employeeTreeSet01.addAll(employeeList01);

        // TODO 2: отсортировать список по имени и зп
        Comparator<Employee> comparator2 = comparator1.thenComparing(new SalaryComparator());
        TreeSet<Employee> employeeTreeSet02 = new TreeSet<>(comparator2);
        employeeTreeSet02.addAll(employeeList01);

        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> comparator3 = comparator1.thenComparing(new SalaryComparator())
                .thenComparing(new AgeComparator()).thenComparing(new CompanyComparator());
        TreeSet<Employee> employeeTreeSet03 = new TreeSet<>(comparator3);
        employeeTreeSet03.addAll(employeeList01);

        // или с применением метода sort:

        List<Employee> employeeList02 = Employee.employeeGenerator(50);

        Comparator<Employee> byName = new NameComparator();
        Comparator<Employee> byAge = new AgeComparator();
        Comparator<Employee> bySalary = new SalaryComparator();
        Comparator<Employee> byCompany = new CompanyComparator();

        employeeList02.sort(byName); // sort принимает на вох компаратор
        employeeList02.forEach(employee -> System.out.println(employee.getName()));

        employeeList02.sort(byName.thenComparing(bySalary));
        employeeList02.forEach(employee -> System.out.println(employee.getName() + " " + employee.getSalary()));

        // имени, зарплате, возрасту и компании
        employeeList02.sort(byName.thenComparing(bySalary).thenComparing(byAge).thenComparing(byCompany));
        employeeList02.forEach(System.out::println);

        // можно создать отдельный класс, где будут хранится статик методы - компораторы
        // employeeList02.sort(AppComparators.BY_NAME.thenComparing(AppComparators.BY_AGE));

    }
}
