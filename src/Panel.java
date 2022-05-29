import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.util.Arrays;

public class Panel extends JPanel{
    private BufferedImage cube = ImageIO.read(new File("isocube.png"));

    private CubeLoc cubeArray[][] = new CubeLoc[40][10];

    private int Wavetiming=0;
    private boolean StopWaveTiming = false;

    private int Reversetiming[] = new int[40];
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

        Arrays.fill(Reversetiming,0);
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
                g.drawImage(cube, cubeArray[i][j].x, (int)cubeArray[i][j].y, 50, 50, null);
            }
        }
        animation();
    }

    private void animation(){
        if(StopWaveTiming == false){
            do{
                for(int i=0;i<Wavetiming;i++){
                    for(int j=0;j<10;j++){
                        if(Reversetiming[i] != 100){
                            Reversetiming[i]++;
                        }else{
                            Reversetiming[i]=0;
                            direction[i] = !direction[i];
                        }

                        cubeArray[i][j].update(direction[i]);
                        System.out.println(i+" "+j);
                    }
                    repaint();
                }
                Wavetiming++;
            }while(Wavetiming!=40);
        }

        StopWaveTiming = true;

        for(int i=0;i<40;i++){
            for(int j=0;j<10;j++){
                
                cubeArray[i][j].update(direction[i]);

                if(Reversetiming[i] != 100){
                    Reversetiming[i]++;
                }else{
                    Reversetiming[i]=0;
                    direction[i] = !direction[i];
                }
            }
        }repaint();
    }

}
