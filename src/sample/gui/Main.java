package sample.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.IPersonaCampesina;
import sample.PersonaCampesina;
import sample.PersonaException;
import sample.logic.entities.Persona;
//import sample.sample.logic.PersonaException;
//import sample.sample.logic.sample.logic.entities.Persona;
//import sample.sample.logic.services.IPersonaServices;
//import sample.sample.logic.services.impl.PersonaService;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    // Visual Properties
    private Scene scene;
    private TableView<Persona> personasTable;
    private TextField nameInput;
    private TextField lastNameInput;
    private TextField deathDateInput;
    private TextField municipalityInput;
    private TextField departmentInput;
    private Button addPersona;
    private Button deletePersona;

    // Menu
    private MenuBar menuBar;
    private Map<String, MenuItem> fileMenuItems;

    // Logic Properties
    private IPersonaCampesina personaCampesina;

    //CRUD -
    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp();
        behavior();

        primaryStage.setTitle("Final Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void behavior() {
        this.personaCampesina = new PersonaCampesina();
        try {
            this.personaCampesina.insert(new Persona("Edwin", "Antonio Indaburo", "Nechí","07/01/2021","Antoquia"));
            this.personaCampesina.insert(new Persona("Alfredo", "García", "Ituango","10/01/2021","Antoquia"));
            this.personaCampesina.insert(new Persona("Yordan Eduardo", "Guetio", "Corinto","02/02/2021","Cauca"));
            this.personaCampesina.insert(new Persona("Albeiro", "Hoyos", "Anorí","05/04/2021","Antoquia"));
            this.personaCampesina.insert(new Persona("Wilson", "Lopez", "Aguadas","28/04/2021","Caldas"));
            this.personaCampesina.insert(new Persona("Aldinever", "Cruz Guaraca", "Aipe","09/05/2021","Huila"));
        } catch (PersonaException e) {
            e.printStackTrace();
        }

        personasTable.setItems((ObservableList<Persona>)this.personaCampesina.getAll());

        addPersona.setOnAction(e -> {
            try {
                Persona p = new Persona(nameInput.getText(), lastNameInput.getText(), deathDateInput.getText(),municipalityInput.getText(),departmentInput.getText());
                this.personaCampesina.insert(p);
                nameInput.clear();
                lastNameInput.clear();
                deathDateInput.clear();
                municipalityInput.clear();
                departmentInput.clear();
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
        });

        deletePersona.setOnAction(e -> {
            this.personaCampesina.delete(personasTable.getSelectionModel().getSelectedItems());
        });

        fileMenuItems.get("Export").setOnAction(e -> {
            try {
                this.personaCampesina.export();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }



    private void setUp() {
        setupTable();
        setupInputs();
        setupMenu();
        setUpCrud();

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, lastNameInput, deathDateInput, municipalityInput, departmentInput, addPersona, deletePersona);

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(personasTable, hBox);

        BorderPane layout2 = new BorderPane();
        layout2.setTop(menuBar);

        //Scene
        scene = new Scene(layout2, 400, 400);
    }

    private void setUpCrud() {
        addPersona = new Button("Add");
        addPersona.setMinWidth(30);

        deletePersona = new Button("Delete");
        deletePersona.setMinWidth(30);
    }

    private void setupInputs() {
        nameInput = new TextField();
        nameInput.setPromptText("name");
        nameInput.setMinWidth(30);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("last name");
        lastNameInput.setMinWidth(30);

        deathDateInput = new TextField();
        deathDateInput.setPromptText("death date");
        deathDateInput.setMinWidth(30);

        municipalityInput = new TextField();
        municipalityInput.setPromptText("municipality");
        municipalityInput.setMinWidth(30);

        departmentInput = new TextField();
        departmentInput.setPromptText("department");
        departmentInput.setMinWidth(30);
    }

    private void setupTable() {
        //Name column
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Name column
        TableColumn<Persona, String> lastNameColumn = new TableColumn<>("LastName");
        lastNameColumn.setMaxWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Name column
        TableColumn<Persona, Integer> deathDateColumn = new TableColumn<>("Death Date");
        deathDateColumn.setMaxWidth(200);
        deathDateColumn.setCellValueFactory(new PropertyValueFactory<>("deathDate"));

        //Name column
        TableColumn<Persona, Integer> municipalityColumn = new TableColumn<>("Municipality");
        municipalityColumn.setMaxWidth(200);
        municipalityColumn.setCellValueFactory(new PropertyValueFactory<>("municipality"));

        //Name column
        TableColumn<Persona, Integer> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setMaxWidth(200);
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        //Table
        personasTable = new TableView<>();
        personasTable.getColumns().addAll(nameColumn, lastNameColumn, deathDateColumn, municipalityColumn, departmentColumn);
    }

    private void setupMenu() {

        Menu fileMenu = new Menu("File");

        fileMenuItems = new HashMap<>();
        fileMenuItems.put("Import", new MenuItem("Import"));
        fileMenuItems.put("Export", new MenuItem("Export"));

        fileMenu.getItems().add(fileMenuItems.get("Import"));
        fileMenu.getItems().add(fileMenuItems.get("Export"));

        menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);


    }

    public static void main(String[] args) {
        launch(args);
    }


}
