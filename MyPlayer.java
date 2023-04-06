import javafx.scene.shape.Circle;


public class MyPlayer implements Player {
    private Circle player;
    private Position playerPosition;
    private Map map;
    private int unit;


    public MyPlayer(Map map, Circle player){
        this.map = map;
        this.player = player;
        this.unit = map.getUnit();
        this.playerPosition = map.getStartPosition();
        playerPosition.setX(playerPosition.getX() / unit);
        playerPosition.setY(playerPosition.getY() / unit);
    }

    @Override
    public void moveUp() {
      if (player.getCenterY() != unit/2){
        player.setCenterY(player.getCenterY() - unit);
        playerPosition.setY(playerPosition.getY() - 1);
      }
    }

    @Override
    public void moveDown() {
      if (player.getCenterY() < (map.getSize()*unit) - unit/2) {
        player.setCenterY(player.getCenterY() + unit);
        playerPosition.setY(playerPosition.getY() + 1);
      }
    }

    @Override
    public void moveLeft() {
        if (player.getCenterX() != unit/2){
          player.setCenterX(player.getCenterX() - unit);
          playerPosition.setX(playerPosition.getX() - 1);
        }
    }

    @Override
    public void moveRight() {
        if (player.getCenterX() < (map.getSize()*unit) - unit/2) {
          player.setCenterX(player.getCenterX() + unit);
          playerPosition.setX(playerPosition.getX() + 1);
        }
    }

    public Position getPosition() {
        return playerPosition;
    }
}