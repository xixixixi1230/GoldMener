package GoldMener;

import java.awt.*;

import static GoldMener.Constant.*;

public class Menu{
    Music m1=new Music("music/开始界面.wav",isStop,true);
    static boolean isStop;
    static int menuIndex;
    public void paint(Graphics g){
        g.drawImage(BEGIN,0,30,null);

        final int STR_WIDTH=650;
        int x=(FRAME_WIDTH-STR_WIDTH)/2;
        int y=(int)(FRAME_HEIGHT/1.4);
        final int DIS=50;
        for(int i=0;i<MENUS.length;i++){
            if(i==menuIndex)
                g.setColor(Color.red);
            else
                g.setColor(Color.white);
            g.drawString(MENUS[i],x,y+DIS*i);
        }
    }
    public Menu(){
        m1.start();
    }
}
