package GoldMener;

import java.awt.*;

import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Fail {
    static int failIndex;
    static boolean isStop;
    Music m3=new Music("music/失败.wav",isStop,false);
    public void paint(Graphics g){
        g.drawImage(GAME_FAIL,0,30,null);

        final int STR_WIDTH=140;
        int x=(FRAME_WIDTH-STR_WIDTH)/2;
        int y=(int)(FRAME_HEIGHT/1.4);
        final int DIS=50;
        for(int i=0;i<FAIL.length;i++){
            if(i==failIndex)
                drawWord(g,30,Color.red,FAIL[i],x,y+DIS*i);
            else
                drawWord(g,30,Color.black,FAIL[i],x,y+DIS*i);
        }
    }
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("宋体",BOLD,size));
        g.drawString(str,x,y);
    }

    public Fail(){
        m3.start();
        m3.setStop(true);
    }
}
