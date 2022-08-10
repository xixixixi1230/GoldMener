package GoldMener;

import java.awt.*;
import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Shop {
    static int shopIndex;
    int price0=(int)(Math.random()*400)+10;
    int price1=(int)(Math.random()*400)+10;
    int price2=(int)(Math.random()*400)+10;
    int price3=(int)(Math.random()*400)+10;
    int price4=(int)(Math.random()*400)+10;
    int price5=(int)(Math.random()*400)+10;
    public void paint(Graphics g){
        g.drawImage(SHOP1,0,30,null);
        g.drawImage(TIP,180,160,null);
        final int DIS=40;
        g.drawImage(TOOL0,10,450,null);
        g.drawImage(TOOL1,130,450,null);
        g.drawImage(TOOL2,210,430,null);
        g.drawImage(TOOL3,360,460,null);
        g.drawImage(TOOL4,420,430,null);
        g.drawImage(TOOL5,570,430,null);
        for(int i=0;i<SHOP.length;i++) {
            if (i == shopIndex) {
                drawWord(g, 20, Color.red, SHOP[i], 20, 180 + DIS * i);
                switch (i){
                    case 0:
                        drawWord(g, 20, Color.black, SHOPP01, 200, 200);
                        drawWord(g, 20, Color.black, SHOPP02, 200, 230);
                        break;
                    case 3:
                        drawWord(g, 20, Color.black, SHOPP31, 200, 200);
                        drawWord(g, 20, Color.black, SHOPP32, 200, 230);
                        break;
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                        drawWord(g, 20, Color.black, SHOPP[i], 200, 200);
                        break;
                }
            }
            else {
                drawWord(g, 20, Color.white, SHOP[i], 20, 180 + DIS * i);
            }
        }
        drawWord(g, 30, Color.white, "现有金钱："+Run.count, 20, 100);
        drawWord(g, 20, Color.white, "$："+price0, 35, 590);
        drawWord(g, 20, Color.white, "$："+price1, 130, 590);
        drawWord(g, 20, Color.white, "$："+price2, 250, 590);
        drawWord(g, 20, Color.white, "$："+price3, 350, 590);
        drawWord(g, 20, Color.white, "$："+price4, 460, 590);
        drawWord(g, 20, Color.white, "$："+price5, 620, 590);
    }
    //绘制字符串
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("宋体",BOLD,size));
        g.drawString(str,x,y);
    }
}
