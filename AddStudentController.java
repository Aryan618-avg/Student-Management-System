import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class AddStudentController {
    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<String> genderBox;
    @FXML private TextField courseField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private Button addBtn;
    @FXML private Button backBtn;
    @FXML private Label statusLabel;

    private StudentDAO dao = new StudentDAO();

    @FXML
    public void initialize() {
        genderBox.setItems(FXCollections.observableArrayList("Male", "Female", "Other"));
    }

    @FXML
    public void onAdd() {
        try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String gender = genderBox.getValue();
            String course = courseField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (name.isEmpty() || gender == null || course.isEmpty()) {
                statusLabel.setText("Please fill mandatory fields.");
                return;
            }

            Student s = new Student(name, age, gender, course, email, phone);
            boolean ok = dao.addStudent(s);
            if (ok) {
                statusLabel.setText("Student added successfully.");
                clearFields();
            } else {
                statusLabel.setText("Failed to add student.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid age.");
        }
    }

    private void clearFields() {
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
