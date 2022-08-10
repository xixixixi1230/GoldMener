package GoldMener;

import java.awt.*;

import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Pass {
    static int passIndex;
    public void paint(Graphics g){
        g.drawImage(GAME_PASS,0,30,null);

        final int STR_WIDTH=140;
        int x=(FRAME_WIDTH-STR_WIDTH)/2;
        int y=(int)(FRAME_HEIGHT/1.4);
        final int DIS=70;
        for(int i=0;i<PASS.length;i++){
            if(i==passIndex)
                drawWord(g,40,Color.red,PASS[i],x,y+DIS*i);
            else
                drawWord(g,40,Color.black,PASS[i],x,y+DIS*i);
        }
    }
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("宋体",BOLD,size));
        g.drawString(str,x,y);
    }
}
