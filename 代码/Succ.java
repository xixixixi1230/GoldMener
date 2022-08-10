package GoldMener;

import java.awt.*;

import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Succ {
    static int succIndex;
    static boolean isStop;
    Music m4=new Music("music/通关.wav",isStop,false);
    public void paint(Graphics g){
        g.drawImage(GAME_SUCC,0,30,null);

        final int STR_WIDTH=140;
        int x=(FRAME_WIDTH-STR_WIDTH)/2;
        int y=(int)(FRAME_HEIGHT/1.4);
        final int DIS=70;
        for(int i=0;i<SUCC.length;i++){
            if(i==succIndex)
                drawWord(g,40,Color.red,SUCC[i],x,y+DIS*i);
            else
                drawWord(g,40,Color.black,SUCC[i],x,y+DIS*i);
        }
    }
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("宋体",BOLD,size));
        g.drawString(str,x,y);
    }

    public Succ(){
        m4.start();
        m4.setStop(true);
    }
}
