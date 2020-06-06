package sample;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Person {
    private SimpleStringProperty firstName, lastName, statement, salary;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday, String statement, String salary) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.statement = new SimpleStringProperty(statement);
        this.salary = new SimpleStringProperty(salary);
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getStatement() {
        return statement.get();
    }

    public void setStatement(String statement) {
        this.statement.set(statement);
    }

    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }
}
