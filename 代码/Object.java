package GoldMener;


import java.awt.*;

import static GoldMener.Constant.*;

public class Object {
    //坐标
    int x,y;
    //宽高
    int width,height;
    //图片
    Image img;
    boolean flag;//标记，是否能移动
    //质量
    int m;
    //积分
    int count;
    //判断物品种类1金块0石块
    int type;
    boolean boom;


    public Object() {
    }

    void paint(Graphics g){
        g.drawImage(img,x,y,null);
    }

    public int getWidth() {
        return width;
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public void setimg(Image a){
        this.img=a;
    }
}

class Rock extends Object implements Runnable{//0
    Rock(int x,int y){
        this.x=x;
        this.y=y;
        this.width=57;
        this.height=52;
        this.flag=false;
        this.m=100;
        this.count=11;
        if(Run.shitou){
            this.count+=100;
        }
        this.type=0;
        this.img= STONE;
        this.boom=false;
    }

    @Override
    public void run() {
        while(true){
            if(boom){
                break;
            }
        }
    }
}

class RockPlus extends Object implements Runnable{
    RockPlus(int x,int y){
        this.x=x;
        this.y=y;
        this.width=70;
        this.height=57;
        this.flag=false;
        this.m=200;
        this.count=20;
        if(Run.shitou){
            this.count+=100;
        }
        this.type=0;
        this.img= STONEPLUS;
        this.boom=false;
    }

    @Override
    public void run() {
        while(true){
            if(boom){
                break;
            }
        }
    }
}

class Gold extends Object {
    Gold(int x,int y){
        this.x=x;
        this.y=y;
        this.width=70;
        this.height=70;
        this.flag=false;
        this.m=100;
        this.count=250;
        this.type=1;
        this.img= GOLD;
    }
}

class GoldMini extends Object {
    GoldMini(int x,int y){
        this.x=x;
        this.y=y;
        this.width=30;
        this.height=30;
        this.flag=false;
        this.m=50;
        this.count=50;
        this.type=1;
        this.img= GOLDMINI;
    }
}

class GoldPlus extends Object {
    GoldPlus(int x,int y){
        this.x=x;
        this.y=y;
        this.width=120;
        this.height=120;
        this.flag=false;
        this.m=200;
        this.type=1;
        this.count=500;
        this.img= GOLDPLUS;
    }
}

class Diamond extends Object{
    Diamond(int x,int y){
        this.x=x;
        this.y=y;
        this.width=20;
        this.height=20;
        this.flag=false;
        this.m=10;
        this.type=1;
        this.count = 600;
        if(Run.zuanshi){
            this.count+=200;
        }
        this.img= DIA;
    }
}

class Pig extends Object implements Runnable{
    int direct=1;
    int max;
    int min;
    Pig(int x,int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 32;
        this.flag = false;
        this.m = 20;
        this.count = 2;
        this.type = 1;
        this.img = PIG1;
    }

    public void setminmax(int a,int b){
        this.max=a;
        this.min=b;
    }

    @Override
    public void run() {
        while(true){
            if(this.x>max) {
               this.direct=-1;
               this.setimg(PIG2);
            }
            else if(this.x<min){
                this.direct=1;
                this.setimg(PIG1);
            }
            this.x=this.x+direct*1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(flag){
                break;
            }
        }
    }
}

class DiamondPig extends Object implements Runnable{
    int direct=1;
    int max;
    int min;
    DiamondPig(int x,int y){
        this.x=x;
        this.y=y;
        this.width = 50;
        this.height = 32;
        this.flag=false;
        this.m=20;
        this.count=602;
        this.type=2;
        this.img= PIGD1;
    }

    public void setminmax(int a,int b){
        this.max=a;
        this.min=b;
    }

    @Override
    public void run() {
        while(true){
            if(this.x>max) {
                this.direct=-1;
                this.setimg(PIGD2);
            }
            else if(this.x<min){
                this.direct=1;
                this.setimg(PIGD1);
            }
            this.x=this.x+direct*1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(flag){
                break;
            }
        }
    }
}

class Bag extends Object{
    Bag(int x,int y,int count){
        this.x=x;
        this.y=y;
        this.width=60;
        this.height=69;
        this.flag=false;
        this.m=(int) Math.random()*100+10;
        this.count=count;
        this.type=1;
        this.img= BAG;
    }
}

class Bone extends Object{
    Bone(int x,int y){
        this.x=x;
        this.y=y;
        this.width = 40;
        this.height = 25;
        this.flag=false;
        this.m=20;
        this.count=7;
        if(Run.gutou){
            this.count+=100;
        }
        this.type=2;
        this.img= BONE;
    }
}

class Skull extends Object{
    Skull(int x,int y){
        this.x=x;
        this.y=y;
        this.width = 40;
        this.height = 35;
        this.flag=false;
        this.m=20;
        this.count=20;
        this.type=2;
        this.img= SKULL;
    }
}