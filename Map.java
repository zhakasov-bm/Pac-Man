import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.*;
import java.io.*;

public class Map extends Pane {
  private int[][] map;
  private int size;
  private int unit = 40;
  private Position start;
  private ArrayList<Position> list = new ArrayList<>();
  

  public Map(String fileName) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(fileName));
    this.size = scan.nextInt();

    while(scan.hasNext()){
      for (int i = 0; i<unit*size; i += unit) {
          for (int j = 0; j < unit*size; j += unit) {
            Rectangle wall = new Rectangle(j, i, unit, unit);
            wall.setStyle("-fx-fill: white; -fx-stroke: black; ");

            switch(scan.nextInt()){
              case 1: wall.setStyle("-fx-fill: black; "); list.add(new Position(j, i));break;
              case 2: start = new Position(j, i);
            }
            getChildren().add(wall);
          }
      }
    }

    draw(fileName);
  }

  public void draw(String fileName) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(fileName));
    scan.nextInt();
    this.map = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        map[i][j] = scan.nextInt();
      }
    }
  }

  public int getSize(){
    return size;
  }

  public int getUnit(){
    return unit;
  }

  public Position getStartPosition(){
    return start;
  }

  public int getValue(int x, int y){
    return map[x][y];
  }

  public ArrayList<Position> getList(){
    return this.list;
  }
}