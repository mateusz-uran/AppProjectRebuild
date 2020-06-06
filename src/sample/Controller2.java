package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {



    //TableView konfiguracja
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    @FXML private TableColumn<Person, String> statementColumn;
    @FXML private TableColumn<Person, String> salaryColumn;

    //Zmienne do tworzenia nowego obiektu Person
    @FXML private TextField firtNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;
    @FXML private TextField statementTextField;
    @FXML private TextField salaryTextField;

    @FXML
    private ListView<String> listaPracownikow;

    //ListView wypelnianie pracownikami
    ObservableList<String> items = FXCollections.observableArrayList(
            "pracownik1", "pracownik2", "pracownik3", "pracownik4"
    );


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaPracownikow.setItems(items);

        //TableView
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
        statementColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("statement"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("salary"));

        //laduje dane do metody
        tableView.setItems(getPeople());

        //Zaznaczanie wielu wierszy w tabeli
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * Usuwa zaznaczone elementy z tabeli
     */
    public void deleteButtonPushed() {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        //zaznaczone wiersze
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //petla do zaznaczonych wierszy
        for(Person person: selectedRows) {
            allPeople.remove(person);
        }
    }

    //Zwraca liste obiektu Person
    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Jan", "Kowalski", LocalDate.of(1985, Month.APRIL, 12), "dyrektor", "6549"));
        people.add(new Person("Krzysztof", "Adamczyk", LocalDate.of(1995, Month.AUGUST, 26), "menadżer", "3512"));
        people.add(new Person("Michał", "Kopytko", LocalDate.of(1991, Month.DECEMBER, 5), "zarządca", "833"));

        return people;
    }

    // Tworzy nowy obiekt person w tabeli
    public void newPersonButtonPushed() {
        Person newPerson = new Person(firtNameTextField.getText(),
                                      lastNameTextField.getText(),
                                      birthdayDatePicker.getValue(),
                                      statementTextField.getText(),
                                      salaryTextField.getText());
        //Pobiera dane z tablicy jako lista, dodaje do new Person
        tableView.getItems().add(newPerson);
    }
}
