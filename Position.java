public class Position{
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public boolean equals(Position position){
        return (position.getX() == this.x && position.getY() == this.y);
    }

    public String toString(){
        return "(" + this.x + "," + this.y +")";
    }
}