import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;

public class Panel extends JPanel{
    private BufferedImage cube = ImageIO.read(new File("isocube.png"));

    private CubeLoc cubeArray[][] = new CubeLoc[40][10];

    public Panel(int sizeX, int sizeY) throws Exception{
        super();
        
        this.setBounds(0,0,sizeX, sizeY);
        this.setVisible(true);

        for(int i=0;i<40;i++){
            for(int j=0;j<10;j++){
                cubeArray[i][j] =  new CubeLoc(j, i);
            }
        }

    }

    protected void paintComponent(Graphics g){
        //d1 represents the location to draw
        //d2 represents the areas of the location to draw
        g.setColor(new Color(237, 227, 255));
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        
        drawGrid(g);
    }

    protected void drawGrid(Graphics g){

        for(int i=0;i<40;i++){
            for(int j=0;j<10;j++){
                if((i%2==1 && j==9) || i==39){
                    break;
                }
                g.drawImage(cube, cubeArray[i][j].x,  cubeArray[i][j].y, 50, 50, null);
            }
        }
    }

}
