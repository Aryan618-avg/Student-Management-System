import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewStudentsController {
    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, Integer> colId;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, Integer> colAge;
    @FXML private TableColumn<Student, String> colGender;
    @FXML private TableColumn<Student, String> colCourse;
    @FXML private TableColumn<Student, String> colEmail;
    @FXML private TableColumn<Student, String> colPhone;

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<String> genderBox;
    @FXML private TextField courseField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;

    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;
    @FXML private Button backBtn;
    @FXML private Label statusLabel;

    private StudentDAO dao = new StudentDAO();
    private ObservableList<Student> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        genderBox.setItems(FXCollections.observableArrayList("Male", "Female", "Other"));

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        refreshTable();

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                populateFields(newSel);
            }
        });
    }

    private void populateFields(Student s) {
        idField.setText(String.valueOf(s.getId()));
        nameField.setText(s.getName());
        ageField.setText(String.valueOf(s.getAge()));
        genderBox.setValue(s.getGender());
        courseField.setText(s.getCourse());
        emailField.setText(s.getEmail());
        phoneField.setText(s.getPhone());
    }

    @FXML
    public void onUpdate() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String gender = genderBox.getValue();
            String course = courseField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            Student s = new Student(id, name, age, gender, course, email, phone);
            boolean ok = dao.updateStudent(s);
            if (ok) {
                statusLabel.setText("Updated successfully.");
                refreshTable();
            } else {
                statusLabel.setText("Update failed.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input.");
        }
    }

    @FXML
    public void onDelete() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            boolean ok = dao.deleteStudent(id);
            if (ok) {
                statusLabel.setText("Deleted successfully.");
                refreshTable();
                clearFields();
            } else {
                statusLabel.setText("Delete failed.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Select a record to delete.");
        }
    }

    private void refreshTable() {
        list.clear();
        list.addAll(dao.getAllStudents());
        table.setItems(list);
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        ageField.clear();
        genderBox.getSelectionModel().clearSelection();
        courseField.clear();
        emailField.clear();
        phoneField.clear();
    }

    @FXML
    public void onBack() {
        Main.loadScene("dashboard.fxml");
    }
}
