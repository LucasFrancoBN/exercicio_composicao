package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {
  private String name;
  private WorkerLevel level;
  private Double baseSalary;
  private List<HourContract> contracts = new ArrayList<>();
  private Department department;

  public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public void addContract(HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public Double income(Integer year, Integer month) {
    LocalDate date = LocalDate.of(year, month, 1).withDayOfMonth(LocalDate.of(year, month, 1).lengthOfMonth());
    double incomeValue = baseSalary;

    for(HourContract contract : contracts) {
      if(date.getMonthValue() == contract.getDate().getMonthValue() && date.getYear() == contract.getDate().getYear()) {
        incomeValue += contract.totalValue();
      }
    }

    return incomeValue;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public String toString() {
    return String.format("Name: %s%n", name) + String.format("Department: %s%n", department.getName());
  }

}
