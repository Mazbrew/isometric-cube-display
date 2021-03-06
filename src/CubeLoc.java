public class CubeLoc extends Thread{
    public int y;
    public int x;

    private int frameOffset = 25;
    private int cubeSize = 50;
    private int xOffset = cubeSize;
    private int yOffset = xOffset/4;
    private int stepOffset;

    public CubeLoc(int j, int i){
        switch(i%2){
            case 0:
                stepOffset = 0;
                break;
            case 1:
                stepOffset = cubeSize/2;
                break;
        }

        x = 0+(xOffset*j+stepOffset+frameOffset);
        y=  0+(yOffset*i+frameOffset);
    }

    public void update(int state) throws Exception{
        int offset =10 ;
        if(state<=2){
            y+=offset;
        }else if(state>2 && state<=6){
            y-=offset;
        }else if(state == 7){
            y+=offset;
        }
    }
}
