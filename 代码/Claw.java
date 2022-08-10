package GoldMener;


import static GoldMener.Constant.*;
import java.awt.*;

public class Claw {
    int x1=525,y1=149,x2=1000,y2=1000;//坐标
    double length=50,n=0.05;//线长
    int dir=1;//方向
    //线长最小值
    double MIN_length=50;
    //线长最大值
    double MAX_length=550;
    int state=0;//状态0摇摆1抓取2收回3抓取返回
    Boolean boom=false;
    Run frame;
    int u=0;
    int rise=(int)(Math.random()*300+100);
    static int Count;
    static boolean plus=false;
    static boolean shi=false;

    static boolean isStop;

    Claw(Run frame){
        this.frame=frame;
    }
    void reGame(){
        x1=525;
        y1=149;
        x2=1000;
        y2=1000;//坐标
        n=0.05;
        length=50;
        state=0;
        plus=false;
    }
    void logic(){
        for(Object obj:this.frame.objectList){
            if(x2>obj.x&&x2<obj.x+obj.width&&y2>obj.y&&y2<obj.y+obj.height) {
                state = 3;
                obj.flag=true;
            }
        }
    }

    void lines(Graphics2D g){
        x2=(int)(x1+length*Math.cos(n*Math.PI));
        y2=(int)(y1+length*Math.sin(n*Math.PI));//尚学堂
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(5));
        g.drawLine(x1,y1,x2,y2);
        g.drawImage(HOOK,x2-50,y2-43,null);
    }

    public void paint(Graphics g){
        if(n<0.25){
            MAX_length=500/Math.cos(n*Math.PI);
        }
        else if(n<0.5){
            MAX_length=500/Math.sin(n*Math.PI);
        }
        else if(n<0.75){
            MAX_length=500/Math.cos((n-0.5)*Math.PI);
        }
        else{
            MAX_length=500/Math.sin((n-0.5)*Math.PI);
        }
        Graphics2D g1=(Graphics2D)g;
        switch(state){
            case 0:
                if(n<0.03)
                    dir=1;
                else if(n>0.97)
                    dir=-1;
                n+=0.003*dir;
                lines(g1);
                break;
            case 1:
                logic();
                if(length<MAX_length) {
                    length = length + 3;
                    lines(g1);
                }
                else {
                    state = 2;
                }
                plus=false;
                break;
            case 2:
                if(length>MIN_length){
                    length-=3;
                    lines(g1);
                }
                else {
                    if(boom){
                        this.frame.objectList.get(u).x=-300;
                        this.frame.objectList.get(u).y=-300;
                        boom=false;
                    }
                    shi=false;
                    state = 0;
                }
                break;
            case 3:
                int m=1;
                if(length>MIN_length) {
                    length -= 5;
                    lines(g1);
                    Object obj;
                    for (int i=0;i<this.frame.objectList.size();i++) {
                        obj=this.frame.objectList.get(i);
                        if (obj.flag) {
                            m = obj.m;
                            if(Run.shengli) {
                                if(m>100){
                                    m-=100;
                                }
                                else{
                                    m=1;
                                }
                            }
                            obj.x = x2 - obj.getWidth()/2;
                            obj.y = y2;
                            if (length <= MIN_length) {
                                plus=true;
                                obj.x = -300;
                                obj.y = -300;
                                obj.flag=false;
                                Run.waterFlag=false;
                                //加分
                                if(Run.xingyun){
                                    obj.count+=rise;
                                }
                                Run.count+=obj.count;
                                Count=obj.count;
                                state = 0;
                            }
                            if(Run.waterFlag&&obj.type==0&&Run.waterNum>0){
                                    u = i;
                                    obj.boom = true;
                                    boom = true;
                                    obj.setimg(BOOM);
                                    obj.m = 1;
                                    obj.flag = false;
                                    Run.waterFlag = false;
                                    Run.waterNum--;
                                    state = 2;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
    }
}
