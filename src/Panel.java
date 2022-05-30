import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.util.Arrays;

public class Panel extends JPanel{
    private BufferedImage cube = ImageIO.read(new File("isocube.png"));

    private Wait wait = new Wait();

    private CubeLoc cubeArray[][] = new CubeLoc[40][10];

    private int animationState[] = new int[40];

    private boolean direction[] = new boolean[40];

    public Panel(int sizeX, int sizeY) throws Exception{
        super();
        
        this.setBounds(0,0,sizeX, sizeY);
        this.setVisible(true);

        for(int i=0;i<40;i++){
            for(int j=0;j<10;j++){
                cubeArray[i][j] =  new CubeLoc(j, i);
            }
        }

        int i=0;
        int state=0;
        while(animationState[40-1]==0){
            animationState[i]= state;
            i++;
            state++;
            if(state==8){
                state =0;
            }
        }

        Arrays.fill(direction,true);
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
                g.drawImage(cube, cubeArray[i][j].x, cubeArray[i][j].y, 50, 50, null);
            }
        }

        try {
            animation();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    private void animation() throws Exception{

        for(int i=0;i<40;i++){
            if(animationState[i]==7){
                animationState[i]=0;
            }else{
                animationState[i]++;
            }
            for(int j=0;j<10;j++){
                try{
                    cubeArray[i][j].update(animationState[i]);
                }catch(Exception e){
                    System.out.println(e);
                }
            }repaint();
        }
        wait.sleep();
    }

}
