package GoldMener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static GoldMener.Constant.*;
import static java.awt.Font.BOLD;

public class Run {
    //总分
    static int count = 0;
    //药水数量
    static int waterNum = 3;
    //药水状态
    static boolean waterFlag = false;
    //关卡数
    static int level = 1;
    //开始时间
    static long startTime;
    //结束时间
    static long endTime;

    static int time=60;

    static boolean shengli = false;
    static boolean xingyun = false;
    static boolean shitou = false;
    static boolean zuanshi = false;
    static boolean gutou = false;

    static boolean isStop;


    Claw claw = new Claw(this);
    static List<Object> objectList = new ArrayList<>();


    public void ini() {
        objectList.clear();
        int x;
        RockPlus rp;
        Rock r;
        switch (level) {
            case 1:
                objectList.add(new GoldPlus(20, 350));
                objectList.add(new GoldPlus(850, 400));

                objectList.add(new Gold(350, 420));
                objectList.add(new Gold(600, 370));

                objectList.add(new GoldMini(200, 250));
                objectList.add(new GoldMini(340, 300));
                objectList.add(new GoldMini(650, 290));
                objectList.add(new GoldMini(750, 270));

                rp = new RockPlus(430, 550);
                objectList.add(rp);
                new Thread(rp).start();
                rp = new RockPlus(700, 400);
                objectList.add(rp);
                new Thread(rp).start();

                r = new Rock(200, 370);
                objectList.add(r);
                new Thread(r).start();
                r = new Rock(800, 300);
                objectList.add(r);
                new Thread(r).start();

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(350, 600, x));

                break;
            case 2:
                objectList.add(new GoldPlus(20, 470));
                objectList.add(new GoldPlus(600, 550));

                objectList.add(new Gold(100, 300));
                objectList.add(new Gold(900, 570));

                objectList.add(new GoldMini(200, 480));
                objectList.add(new GoldMini(370, 350));
                objectList.add(new GoldMini(500, 300));
                objectList.add(new GoldMini(620, 330));
                objectList.add(new GoldMini(650, 500));
                objectList.add(new GoldMini(800, 200));
                objectList.add(new GoldMini(850, 320));

                objectList.add(new RockPlus(170, 320));
                objectList.add(new RockPlus(300, 400));
                objectList.add(new RockPlus(550, 450));
                objectList.add(new RockPlus(770, 600));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(350, 550, x));

                objectList.add(new Rock(430, 490));
                objectList.add(new Rock(730, 330));

                objectList.add(new Diamond(710, 430));
                break;
            case 3:
                objectList.add(new GoldPlus(10, 500));

                objectList.add(new Gold(200, 350));
                objectList.add(new Gold(700, 370));
                objectList.add(new Gold(850, 330));

                objectList.add(new GoldMini(250, 220));
                objectList.add(new GoldMini(240, 280));
                objectList.add(new GoldMini(300, 250));
                objectList.add(new GoldMini(600, 330));

                objectList.add(new RockPlus(230, 520));
                objectList.add(new RockPlus(570, 450));
                objectList.add(new RockPlus(800, 400));
                objectList.add(new RockPlus(800, 500));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(500, 400, x));

                objectList.add(new Rock(370, 330));
                objectList.add(new Rock(450, 370));
                objectList.add(new Rock(620, 550));

                objectList.add(new Diamond(710, 550));
                break;
            case 4:
                objectList.add(new GoldPlus(270, 480));
                objectList.add(new GoldPlus(550, 520));

                objectList.add(new Gold(580, 350));

                objectList.add(new GoldMini(150, 200));
                objectList.add(new GoldMini(600, 250));
                objectList.add(new GoldMini(640, 280));
                objectList.add(new GoldMini(670, 320));

                objectList.add(new RockPlus(130, 550));
                objectList.add(new RockPlus(170, 250));
                objectList.add(new RockPlus(800, 340));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(300, 330, x));
                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(450, 500, x));
                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(660, 370, x));
                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(750, 250, x));

                objectList.add(new Rock(540, 300));

                Pig pig = new Pig(220, 445);
                objectList.add(pig);
                pig.setminmax(900, 100);
                new Thread(pig).start();
                break;
            case 5:
                objectList.add(new GoldPlus(200, 480));
                objectList.add(new GoldPlus(550, 450));

                objectList.add(new Gold(70, 400));
                objectList.add(new Gold(640, 400));
                objectList.add(new Gold(880, 350));

                objectList.add(new GoldMini(20, 280));
                objectList.add(new GoldMini(300, 440));
                objectList.add(new GoldMini(680, 350));

                objectList.add(new RockPlus(150, 400));
                objectList.add(new RockPlus(320, 470));
                objectList.add(new RockPlus(800, 380));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(400, 530, x));
                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(750, 470, x));

                objectList.add(new Rock(480, 500));

                Pig pig1 = new Pig(220, 270);
                Pig pig2 = new Pig(350, 230);
                Pig pig3 = new Pig(700, 310);
                objectList.add(pig1);
                objectList.add(pig2);
                objectList.add(pig3);
                pig1.setminmax(900, 100);
                pig2.setminmax(900, 100);
                pig3.setminmax(900, 100);
                new Thread(pig1).start();
                new Thread(pig2).start();
                new Thread(pig3).start();
                break;
            case 6:
                objectList.add(new GoldPlus(450, 530));
                objectList.add(new GoldPlus(750, 550));

                objectList.add(new Gold(20, 480));
                objectList.add(new Gold(200, 550));
                objectList.add(new Gold(670, 590));

                objectList.add(new GoldMini(250, 450));
                objectList.add(new GoldMini(400, 550));
                objectList.add(new GoldMini(550, 440));
                objectList.add(new GoldMini(780, 490));
                objectList.add(new GoldMini(800, 380));
                objectList.add(new GoldMini(740, 420));
                objectList.add(new GoldMini(860, 460));

                objectList.add(new RockPlus(50, 220));
                objectList.add(new RockPlus(500, 370));
                objectList.add(new RockPlus(900, 370));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(780, 420, x));

                objectList.add(new Rock(300, 220));
                objectList.add(new Rock(600, 230));
                objectList.add(new Rock(200, 400));

                DiamondPig pigd1 = new DiamondPig(220, 290);
                DiamondPig pigd2 = new DiamondPig(720, 290);
                DiamondPig pigd3 = new DiamondPig(400, 330);
                DiamondPig pigd4 = new DiamondPig(500, 490);
                objectList.add(pigd1);
                objectList.add(pigd2);
                objectList.add(pigd3);
                objectList.add(pigd4);
                pigd1.setminmax(500, 100);
                pigd2.setminmax(900, 550);
                pigd3.setminmax(900, 100);
                pigd4.setminmax(650, 200);
                new Thread(pigd1).start();
                new Thread(pigd2).start();
                new Thread(pigd3).start();
                new Thread(pigd4).start();
                break;
            case 7:
                objectList.add(new GoldPlus(10, 500));
                objectList.add(new GoldPlus(400, 540));
                objectList.add(new GoldPlus(550, 480));
                objectList.add(new GoldPlus(750, 550));

                objectList.add(new Gold(350, 400));
                objectList.add(new Gold(850, 280));

                objectList.add(new GoldMini(20, 350));
                objectList.add(new GoldMini(520, 450));

                x = (int) (Math.random() * 800 + 10);
                objectList.add(new Bag(170, 300, x));

                DiamondPig pigd11 = new DiamondPig(50, 400);
                DiamondPig pigd21 = new DiamondPig(720, 380);
                DiamondPig pigd31 = new DiamondPig(400, 490);
                objectList.add(pigd11);
                objectList.add(pigd21);
                objectList.add(pigd31);
                pigd11.setminmax(300, 30);
                pigd21.setminmax(900, 550);
                pigd31.setminmax(500, 200);
                new Thread(pigd11).start();
                new Thread(pigd21).start();
                new Thread(pigd31).start();

                Pig pig11 = new Pig(220, 230);
                Pig pig21 = new Pig(500, 300);
                Pig pig31 = new Pig(800, 420);
                objectList.add(pig11);
                objectList.add(pig21);
                objectList.add(pig31);
                pig11.setminmax(900, 600);
                pig21.setminmax(620, 250);
                pig31.setminmax(900, 600);
                new Thread(pig11).start();
                new Thread(pig21).start();
                new Thread(pig31).start();

                objectList.add(new Bone(100, 300));
                objectList.add(new Bone(400, 350));

                objectList.add(new Skull(140, 500));
                objectList.add(new Skull(700, 300));

                break;
            case 8:
                objectList.add(new GoldPlus(10, 530));
                objectList.add(new GoldPlus(150, 450));
                objectList.add(new GoldPlus(350, 470));
                objectList.add(new GoldPlus(550, 500));
                objectList.add(new GoldPlus(730, 520));
                objectList.add(new GoldPlus(850, 480));

                objectList.add(new Diamond(200, 600));
                objectList.add(new Diamond(150, 580));
                objectList.add(new Diamond(980, 550));

                objectList.add(new RockPlus(50, 220));
                objectList.add(new RockPlus(500, 370));
                objectList.add(new RockPlus(900, 330));
                objectList.add(new RockPlus(400, 270));
                objectList.add(new RockPlus(650, 320));
                objectList.add(new RockPlus(850, 400));
                objectList.add(new RockPlus(150, 370));
                objectList.add(new RockPlus(260, 290));


                objectList.add(new Rock(300, 220));
                objectList.add(new Rock(760, 400));
                objectList.add(new Rock(230, 400));
                objectList.add(new Rock(150, 220));
                objectList.add(new Rock(480, 300));
                objectList.add(new Rock(350, 400));
                objectList.add(new Rock(700, 380));

                DiamondPig pigd111 = new DiamondPig(700, 230);
                DiamondPig pigd211 = new DiamondPig(550, 470);
                DiamondPig pigd311 = new DiamondPig(100, 300);
                objectList.add(pigd111);
                objectList.add(pigd211);
                objectList.add(pigd311);
                pigd111.setminmax(900, 500);
                pigd211.setminmax(800, 450);
                pigd311.setminmax(200, 30);
                new Thread(pigd111).start();
                new Thread(pigd211).start();
                new Thread(pigd311).start();
                break;
        }
    }

    public Run(){
        ini();
    }


    public void paint(Graphics g){
        g.drawImage(BG,0,30,null);
        g.drawImage(PE,470,40,null);
        drawWord(g,30,Color.black,"现有钱数:￥"+count,30,80);
        //药水
        g.drawImage(TOOL3,700,40,null);
        drawWord(g,30,Color.black,"炸药数量:"+waterNum,850,80);
        //关卡数和目标积分
        drawWord(g,30,Color.black,"第"+level+"关",850,130);
        drawWord(g,30,Color.black,"目标钱数:￥"+Goal[level-1],25,130);

        if(claw.plus) {
            drawWord(g, 30, Color.red, "+" + claw.Count, 330, 130);
        }

        //
        endTime=System.currentTimeMillis();
        long tim=(endTime-startTime)/1000;
        drawWord(g,30,Color.black,"倒计时:"+time,300,80);

        claw.paint(g);

        for(int i=0;i<objectList.size();i++){
            objectList.get(i).paint(g);
        }
    }




    static boolean gameTime(){
        long tim=(endTime-startTime)/1000;
        time= (int) (60-tim);
        if(time<0){
            return true;
        }
        return false;
    }

    void reGame(){

        count=0;
        //药水数量
        waterNum=3;
        //药水状态
        waterFlag=false;
        //关卡数
        level=1;
        ini();
        claw.reGame();
        shengli=false;
        xingyun=false;
        shitou=false;
        zuanshi=false;
        gutou=false;
    }

    //绘制字符串
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",BOLD,size));
        g.drawString(str,x,y);
    }
}
