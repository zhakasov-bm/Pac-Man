import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Main extends Application{
	private static final double WIDTH = 300;

	private Scene s1;
	private Scene s2;
	private Scene s3;

	private Button btn1;
	private Button btn2;
	private Button btn3;

	public void start(Stage stage) {
		intiLayout();
		initEventHandlers(stage);

		stage.setScene(s1);
		stage.show();
	}

	public void intiLayout() {
		StackPane sp1 = new StackPane();
		sp1.setStyle("-fx-background-color : red");

		btn1 = new Button("Scene 1 -> Scene 2");
		sp1.getChildren().add(btn1);

		StackPane sp2 = new StackPane();
		sp2.setStyle("-fx-background-color : green");

		btn2 = new Button("Scene 2 -> Scene 3");
		sp2.getChildren().add(btn2);
		
		StackPane sp3 = new StackPane();
		sp3.setStyle("-fx-background-color : blue");

		btn3 = new Button("Scene 3 -> Scene 1");
		sp3.getChildren().add(btn3);


		s1 = new Scene(sp1,WIDTH,WIDTH);
		s2 = new Scene(sp2,WIDTH,WIDTH);
		s3 = new Scene(sp3,WIDTH,WIDTH);
	}

	public void initEventHandlers(Stage s) {
		btn1.setOnAction(e -> s.setScene(s2));
		btn2.setOnAction(e -> s.setScene(s3));
		btn3.setOnAction(e -> {
			s.setScene(s1);
		});
		
	}
}