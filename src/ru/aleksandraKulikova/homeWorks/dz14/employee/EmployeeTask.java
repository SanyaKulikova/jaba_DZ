package ru.aleksandraKulikova.homeWorks.dz14.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(50);

        // TODO 1: отсортировать список по имени

        Comparator<Employee> comparator1 = new NameComparator();
        TreeSet<Employee> employeeTreeSet01 = new TreeSet<>(comparator1);
        employeeTreeSet01.addAll(employeeList);
        // TODO 2: отсортировать список по имени и зп
        Comparator<Employee> comparator2 = comparator1.thenComparing(new SalaryComparator());
        TreeSet<Employee> employeeTreeSet02 = new TreeSet<>(comparator2);
        employeeTreeSet02.addAll(employeeList);

        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> comparator3 = comparator1.thenComparing(new SalaryComparator())
                .thenComparing(new AgeComparator()).thenComparing(new CompanyComparator());
        TreeSet<Employee> employeeTreeSet03 = new TreeSet<>(comparator3);
        employeeTreeSet03.addAll(employeeList);

    }
}
