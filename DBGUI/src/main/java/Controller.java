import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    Database database = new Database();
    @FXML
    TextFlow textFlow;
    @FXML
    Button button;
    @FXML
    TextField textField;


    public void buttonClicked() throws SQLException {
        String query = textField.getText();


        ResultSet resultSet = database.sendQuery(query);
        textFlow.getChildren().clear();
        textFlow.setLineSpacing(2);
        textFlow.getChildren().add(new Text("isbn  title  author  year\n"));
        while (resultSet.next()){

            textFlow.getChildren().add(new Text(resultSet.getString(1)+" "+resultSet.getString(2)
            +" "+resultSet.getString(3)+" "+resultSet.getString(4)+"\n"));
        }
    }

}
