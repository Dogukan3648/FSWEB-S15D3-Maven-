package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Doğukan", "Bozkır"));
        employees.add(new Employee(1, "Doğukan", "Bozkır"));

        employees.add(new Employee(2, "Ahmet", "Yılmaz"));
        employees.add(new Employee(2, "Ahmet", "Yılmaz"));

        employees.add(new Employee(3, "Mehmet", "Demir"));
        employees.add(new Employee(4, "Fatma", "Bakır"));
        employees.add(new Employee(5, "Nuri", "Kartal"));
        employees.add(new Employee(4, "Yavuz", "Yavuzel"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();

        Map<Integer, Employee> seen = new HashMap<>();
        Set<Integer> duplicateIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (seen.containsKey(employee.getId())) {
                if (!duplicateIds.contains(employee.getId())) {
                    duplicates.add(employee);
                    duplicateIds.add(employee.getId());
                }
            } else {
                seen.put(employee.getId(), employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                uniques.putIfAbsent(employee.getId(), employee);
            }
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Employee> result = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                counts.put(
                        employee.getId(),
                        counts.getOrDefault(employee.getId(), 0) + 1
                );
            }
        }

        for (Employee employee : employees) {
            if (employee != null && counts.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }
}