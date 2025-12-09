import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    public void onAddStudent() {
        Main.loadScene("add_student.fxml");
    }

    @FXML
    public void onViewStudents() {
        Main.loadScene("view_students.fxml");
    }

    @FXML
    public void onExit() {
        System.exit(0);
    }
}
