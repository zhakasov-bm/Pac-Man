import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

import java.util.*;
import java.io.*;

public class Game extends Application{
	//Pane
	private Pane pane;

  //Scene
  private Scene scene;

	//Map
	private Map map;
	private int size;
  private int unit;
	private ArrayList<Position> list = new ArrayList<>();
	private static String file; //txt file

	//Player
  private Circle ball;
  private Position position;
  private Player player;
  private int radius;
  private boolean move = false;

  //Food
  private Food food;

  //Main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		file = input.next();

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException{
		  pane = new Pane();

		  //Create a map
		  map = new Map("maps/" +file);
    	unit = map.getUnit();				//size of one cell
    	size = map.getSize();				//size of map
    	System.out.println("Map size: " + size);

    	list = map.getList();				//list of walls
    	radius = unit / 2;					//radius of ball

    	position = map.getStartPosition();  //player start position

    	//Create player
    	ball = new Circle(position.getX() + unit/2, position.getY() + unit/2, radius);
   		ball.setFill(Color.RED);

   		player = new MyPlayer(map, ball);

      food = new Food(map, player);

   		pane.getChildren().addAll(map, ball);

   		//Controls key events;
   		ball.setOnKeyPressed(e ->{

      		switch(e.getCode()){
        		case LEFT:  checkMove("Left");
                    		if(move == false){
                      			player.moveLeft();
                    		} move = false; break;

        		case RIGHT: checkMove("Right");
                    		if(move == false){
                      			player.moveRight();
                    		} move = false; break;

        		case UP:  	checkMove("Up");
                  			if(move == false){
                    			player.moveUp();
                  			} move = false; break;

        		case DOWN: 	checkMove("Down");
                  			if(move == false){
                    			player.moveDown();
                  			} move = false; break;
      		}
    	});

    	scene = new Scene(pane, unit*size, unit*size);

      stage.setTitle("Eater");
    	stage.setScene(scene);
    	stage.show();
      // stage.setResizable(false);
    	ball.setFocusTraversable(true);
	}

	//Thhis method makes sure it does not go out of bounds or through the walls.
	public void checkMove(String direction){

 		 System.out.println(direction);

    	switch(direction){
      		case "Left": position = new Position((int)ball.getCenterX() - (unit + radius) , (int)ball.getCenterY() - radius); break;
      		case "Right": position = new Position((int)ball.getCenterX() + radius, (int)ball.getCenterY() - radius); break;
      		case "Up": position = new Position((int)ball.getCenterX() - radius, (int)ball.getCenterY() - (unit + radius)); break;
      		case "Down": position = new Position((int)ball.getCenterX()- radius, (int)ball.getCenterY() + radius); break;
		  }

    	for (Position p : list) {
			if( position.equals(p)){
        		move = true; System.out.println("Invalid position!"); break;
      		}
      }
  }
}
