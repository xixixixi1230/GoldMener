package GoldMener;

import java.awt.*;

import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Help {
    static int helpIndex;
    public void paint(Graphics g){
        g.drawImage(GAME_HELP,0,30,null);
        drawWord(g,20,Color.black,HELP11,248,220);
        drawWord(g,20,Color.black,HELP12,248,250);
        drawWord(g,20,Color.black,HELP13,248,280);
        drawWord(g,20,Color.black,HELP21,248,330);
        drawWord(g,20,Color.black,HELP22,248,360);

        final int STR_WIDTH=140;
        int x=(FRAME_WIDTH-STR_WIDTH)/2;
        int y=(int)(FRAME_HEIGHT/1.4);
        final int DIS=70;
        for(int i=0;i<HELP.length;i++){
            if(i==helpIndex)
                drawWord(g,40,Color.red,HELP[i],x,y+DIS*i);
            else
                drawWord(g,40,Color.black,HELP[i],x,y+DIS*i);
        }
    }
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("宋体",BOLD,size));
        g.drawString(str,x,y);
    }
}
