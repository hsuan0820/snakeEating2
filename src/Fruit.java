import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;
    private ImageIcon img2;

    public Fruit(){
        img=new ImageIcon("strawberry.png");
        this.x = (int) (Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
        this.y = (int) (Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void drawFruit(Graphics g){
        //g.setColor(Color.ORANGE);
        // g.fillOval(this.x, this.y, Main.CELL_SIZE, Main.CELL_SIZE);
        img.paintIcon(null,g,this.x,this.y);
    }
    public void setNewLocation(Snake s){
        int newX;
        int newY;
        boolean overLap;
        do{
            newX=(int) (Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
            newY=(int) (Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
            overLap=checkOverLap(newX,newY,s);
        }while(overLap);

        this.x=newX;
        this.y=newY;
    }
    private boolean checkOverLap(int x,int y, Snake s) {
        ArrayList<Node> shake_body = s.getSnakeBody();
        for (int j=0;j<s.getSnakeBody().size();j++){
            if (x == shake_body.get(j).x&& y==shake_body.get(j).y){
                return true;
            }
        }
        return false;
    }
}

