package GoldMener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static GoldMener.Constant.*;

//游戏的主窗口类
public class GameFrame extends JFrame implements Runnable {
    //游戏状态
    public static int gameState;
    //菜单当前选中
    Image offScreenImage;


    Menu menu=new Menu();
    Run run=new Run();
    Help help=new Help();
    Pass pass=new Pass();
    Fail fail=new Fail();
    Succ succ=new Succ();
    Shop shop=new Shop();
    //对窗口进行初始化
    //每个方法不要超过50行
    public GameFrame(){
        initFrame();
        initEventListener();
        //用于刷新窗口
        new Thread(this).start();
    }
    public void initFrame(){
        setTitle(GAME_TITLE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //对游戏进行初始化
    private void initGame(){
        gameState=STATE_MENU;
    }


    @Override
    public void paint(Graphics g) {
        offScreenImage=this.createImage(1024,680);
        Graphics gImage=offScreenImage.getGraphics();
        gImage.setFont(GAME_FONT);
        switch(gameState){
            case STATE_MENU:
                menu.paint(gImage);
                break;
            case STATE_HELP:
                help.paint(gImage);
                break;
            case STATE_OVER:
                break;
            case STATE_RUN:
                run.paint(gImage);
                break;
            case STATE_PASS:
                pass.paint(gImage);
                break;
            case STATE_FAIL:
                fail.paint(gImage);
                break;
            case STATE_SUCC:
                succ.paint(gImage);
                break;
            case STATE_SHOP:
                shop.paint(gImage);
                break;
            default:
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    private void initEventListener(){
        //添加按键监听事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //获得被按下的键值
                int keyCode=e.getKeyCode();
                //不同的游戏状态不同的处理方法
                switch(gameState){
                    case STATE_MENU:
                        KeyEventMenu(keyCode);
                        break;
                    case STATE_HELP:
                        KeyEventHelp(keyCode);
                        break;
                    case STATE_RUN:
                        KeyEventRun(keyCode);
                        break;
                    case STATE_PASS:
                        KeyEventPass(keyCode);
                        break;
                    case STATE_FAIL:
                        KeyEventFail(keyCode);
                        break;
                    case STATE_SUCC:
                        KeyEventSucc(keyCode);
                        break;
                    case STATE_SHOP:
                        KeyEventShop(keyCode);
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    private void KeyEventShop(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Shop.shopIndex<0){
                    Shop.shopIndex=SHOP.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Shop.shopIndex>SHOP.length-1){
                    Shop.shopIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Shop.shopIndex){
                    case 0://生力水
                        Run.shengli=true;
                        gameState=STATE_RUN;
                        break;
                    case 1://幸运草
                        Run.xingyun=true;
                        gameState=STATE_RUN;
                        break;
                    case 2://石头收藏书
                        Run.shitou=true;
                        gameState=STATE_RUN;
                        break;
                    case 3://炸药
                        Run.waterNum++;
                        gameState=STATE_RUN;
                        break;
                    case 4://钻石收藏书
                        Run.zuanshi=true;
                        gameState=STATE_RUN;
                        break;
                    case 5://骨头收藏书
                        Run.gutou=true;
                        gameState=STATE_RUN;
                        break;
                    case 6:
                        gameState=STATE_RUN;
                        break;
                }
                newGame();
                break;
        }
    }

    private void KeyEventSucc(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Succ.succIndex<0){
                    Succ.succIndex=SUCC.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Succ.succIndex>SUCC.length-1){
                    Succ.succIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Succ.succIndex){
                    case 0:
                        gameState=STATE_MENU;
                        break;
                    case 1:
                        gameState=STATE_REGAME;
                        break;
                    case 2:
                        gameState=STATE_OVER;
                        break;
                }
                newGame();
                break;
        }
    }

    private void KeyEventFail(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Fail.failIndex<0){
                    Fail.failIndex=FAIL.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Fail.failIndex>FAIL.length-1){
                    Fail.failIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Fail.failIndex){
                    case 0:
                        gameState=STATE_MENU;
                        run.reGame();
                        break;
                    case 1:
                        gameState=STATE_REGAME;
                        break;
                    case 2:
                        gameState=STATE_SHOP;
                        break;
                    case 3:
                        gameState=STATE_OVER;
                        break;
                }
                newGame();
                break;
        }
    }

    private void KeyEventPass(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Pass.passIndex<0){
                    Pass.passIndex=PASS.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Pass.passIndex>PASS.length-1){
                    Pass.passIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Pass.passIndex){
                    case 0:
                        gameState=STATE_MENU;
                        break;
                    case 1:
                        gameState=STATE_RUN;
                        break;
                    case 2:
                        gameState=STATE_SHOP;
                        break;
                }
                newGame();
                break;
        }
    }

    private void KeyEventRun(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_DOWN:
                if(run.claw.state==0)
                    run.claw.state=1;
                break;
            case KeyEvent.VK_UP:
                if(run.claw.state==3 && Run.waterNum>0) {
                    Run.waterFlag = true;
                }
                break;
        }
    }

    private void KeyEventHelp(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Help.helpIndex<0){
                    Help.helpIndex=HELP.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Help.helpIndex>HELP.length-1){
                    Help.helpIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Help.helpIndex){
                    case 0:
                        gameState=STATE_MENU;
                        break;
                    case 1:
                        gameState=STATE_RUN;
                        break;
                    case 2:
                        gameState=STATE_OVER;
                        break;
                }
                newGame();
                break;
        }
    }
    //菜单状态下的按键
    private void KeyEventMenu(int keyCode) {
        switch(keyCode){
            case KeyEvent.VK_UP:
                if(--Menu.menuIndex<0){
                    Menu.menuIndex=MENUS.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(++Menu.menuIndex>MENUS.length-1){
                    Menu.menuIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (Menu.menuIndex){
                    case 0://游戏中
                        gameState=STATE_RUN;
                        break;
                    case 1://帮助
                        gameState=STATE_HELP;
                        break;
                    case 2://退出
                        gameState=STATE_OVER;
                        break;
                }
                newGame();
                break;
        }
    }

    //开始新游戏
    private void newGame(){
        switch(gameState){
            case STATE_MENU:
                break;
            case STATE_HELP://帮助
                gameState=STATE_HELP;
                break;
            case STATE_RUN://菜单
                Run.startTime=System.currentTimeMillis();
                break;
            case STATE_OVER://退出
                System.exit(0);//退出程序
                break;
            case STATE_PASS:
                break;
            case STATE_FAIL:
                break;
            case STATE_REGAME:
                run.reGame();
                gameState=STATE_RUN;
                Run.startTime=System.currentTimeMillis();
                break;
        }

    }

    public void nextlevel(){
        if(run.gameTime()&&gameState==STATE_RUN){
            if(Run.count>=Goal[Run.level-1]){
                if(Run.level==8){
                    //游戏成功通关界面
                    gameState=STATE_SUCC;
                    menu.m1.setStop(true);
                    succ.m4.setStop(false);
                }
                else{
                    gameState=STATE_PASS;
                    Run.shengli=false;
                    Run.xingyun=false;
                    Run.shitou=false;
                    Run.zuanshi=false;
                    Run.gutou=false;
                    Run.level++;
                    run.ini();
                    Claw.plus=false;
                    run.claw.reGame();
                }
            }
            else{
                gameState=STATE_FAIL;
                menu.m1.setStop(true);
                fail.m3.setStop(false);
            }
            newGame();
        }
    }


    @Override
    public void run() {
        while(true){
            repaint();
            nextlevel();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
