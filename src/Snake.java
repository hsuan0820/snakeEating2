import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends Component {

    private ArrayList<Node> snakeBody;
    private ImageIcon img;

    public Snake() {
        snakeBody = new ArrayList<>();
        snakeBody.add(new Node(80, 0));
        snakeBody.add(new Node(60, 0));
        snakeBody.add(new Node(40, 0));
        snakeBody.add(new Node(20, 0));
    }

    public ArrayList<Node> getSnakeBody() {
        return snakeBody;
    }

    public void drawSnake(Graphics g) {
        g.setColor(Color.GREEN);
        for(int i=0;i<snakeBody.size();i++) {
            if (i==0){
                g.setColor(Color.ORANGE);
               // img=new ImageIcon("strawberry.png");
                //img.paintIcon(this,g,80,0);
                // g.setColor(Color.ORANGE);

            }else {
                int red=(int)(Math.random()*255);
                int green=(int)(Math.random()*255);
                int blue=(int)(Math.random()*255);
                g.setColor(new Color(red,green,blue));

            }
            Node n=snakeBody.get(i);
            if (n.x>=Main.width){
                n.x=0;
            }
            if (n.y>=Main.height){
                n.y=0;
            }
            if (n.x<0){
                n.x=Main.width-Main.CELL_SIZE;
            }
            if (n.y<0){
                n.y=Main.height-Main.CELL_SIZE;
            }
            g.fillOval(n.x, n.y, Main.CELL_SIZE, Main.CELL_SIZE);
        }
    }
}