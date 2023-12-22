package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter fmtCompletedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fmtMonthAndYear = DateTimeFormatter.ofPattern("MM/yyyy");

    Worker worker;

    worker = registerWorker(sc);

    registerContracts(sc, fmtCompletedDate, worker);

    System.out.println();
    String income = calculateIncome(sc, fmtMonthAndYear, worker);

    System.out.println(worker.toString());
    System.out.println(income);

  }

  public static Worker registerWorker(Scanner sc) {
    System.out.print("Enter department's name: ");
    String departmentName = sc.nextLine();
    System.out.println("Enter worker data:");
    System.out.print("Name: ");
    String workerName = sc.nextLine();
    System.out.print("Level: ");
    String workerLevel = sc.nextLine();
    System.out.print("Base salary: ");
    double workerBaseSalary = sc.nextDouble();

    Department department = new Department(departmentName);

    return new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, department);
  }

  public static void registerContracts( Scanner sc, DateTimeFormatter fmt, Worker worker) {
    System.out.print("How many contracts to this worker? ");
    int numbersOfContracts = sc.nextInt();

    for(int i = 0; i < numbersOfContracts; i++) {
      System.out.printf("Enter contract #%d data: %n", i + 1);
      System.out.print("Date(DD/MM/YYYY): ");
      sc.nextLine();
      String dateUnparsed = sc.nextLine();
      LocalDate date = LocalDate.parse(dateUnparsed, fmt);
      System.out.print("Value per hour: ");
      double valuePerHour = sc.nextDouble();
      System.out.print("Duration (hours): ");
      int duration = sc.nextInt();
      HourContract contract = new HourContract(date, valuePerHour, duration);
      worker.addContract(contract);
    }
  }

  public static String calculateIncome(Scanner sc, DateTimeFormatter fmt, Worker worker) {
    System.out.println("Enter month and year to calculate income (MM/YYYY): ");
    sc.nextLine();
    String dateUnparsed = sc.nextLine();
    YearMonth yearMonth = YearMonth.parse(dateUnparsed, fmt);
    return "Income for " + dateUnparsed + ": " + worker.income(yearMonth.getYear(), yearMonth.getMonthValue());
  }

}
