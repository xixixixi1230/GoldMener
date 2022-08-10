package GoldMener;

import java.awt.*;

//维护游戏中的常量
public class Constant {
    public static final String GAME_TITLE="黄金矿工";

    public static final int FRAME_WIDTH=1024;
    public static final int FRAME_HEIGHT=680;

    //菜单相关
    public static final int STATE_MENU=0;
    public static final int STATE_HELP=1;
    public static final int STATE_RUN=2;
    public static final int STATE_OVER=3;//退出程序
    public static final int STATE_PASS=4;
    public static final int STATE_FAIL=5;//失败界面
    public static final int STATE_SHOP=6;
    public static final int STATE_REGAME=7;
    public static final int STATE_SUCC=8;

    public static final String[] MENUS={
            "开始游戏",
            "游戏帮助",
            "退出游戏"
    };

    public static final String[] HELP={
            "返回菜单",
            "开始游戏",
            "退出游戏"
    };

    public static final String[] PASS={
            "返回菜单",
            "进入下一关",
            "进入商店"
    };

    public static final String[] FAIL={
            "返回菜单",
            "重新开始",
            "进入商店",
            "退出游戏"
    };

    public static final String[] SUCC={
            "返回菜单",
            "重新开始",
            "退出游戏"
    };

    public static final String[] SHOP={
            "购买生力水",
            "购买幸运草",
            "购买石头收藏书",
            "购买炸药",
            "购买钻石收藏书",
            "购买骨头收藏书",
            "进入下一关"
    };

    //字体
    public static final Font GAME_FONT=new Font("宋体",Font.BOLD,24);

    //图片
    public static final Image BEGIN= Toolkit.getDefaultToolkit().getImage("imgs/开始.jpg");
    public static final Image BG= Toolkit.getDefaultToolkit().getImage("imgs/背景.jpg");
    public static final Image PE= Toolkit.getDefaultToolkit().getImage("imgs/me1.png");
    public static final Image WATER= Toolkit.getDefaultToolkit().getImage("imgs/tool0.png");
    public static final Image HOOK=Toolkit.getDefaultToolkit().getImage("imgs/claw1.png");
    public static final Image STONE=Toolkit.getDefaultToolkit().getImage("imgs/stone.png");
    public static final Image STONEPLUS=Toolkit.getDefaultToolkit().getImage("imgs/stone2.png");
    public static final Image GOLD=Toolkit.getDefaultToolkit().getImage("imgs/gold.png");
    public static final Image GOLDMINI=Toolkit.getDefaultToolkit().getImage("imgs/goldmini.png");
    public static final Image GOLDPLUS=Toolkit.getDefaultToolkit().getImage("imgs/goldPlus.png");
    public static final Image GAME_HELP=Toolkit.getDefaultToolkit().getImage("imgs/passscene.png");
    public static final Image GAME_PASS=Toolkit.getDefaultToolkit().getImage("imgs/passscene1.png");
    public static final Image GAME_FAIL=Toolkit.getDefaultToolkit().getImage("imgs/passscene2.png");
    public static final Image GAME_SUCC=Toolkit.getDefaultToolkit().getImage("imgs/happyend.jpg");
    public static final Image DIA=Toolkit.getDefaultToolkit().getImage("imgs/diamond.png");
    public static final Image PIG1=Toolkit.getDefaultToolkit().getImage("imgs/pig.png");
    public static final Image PIG2=Toolkit.getDefaultToolkit().getImage("imgs/pig2.png");
    public static final Image PIGD1=Toolkit.getDefaultToolkit().getImage("imgs/pigdiamond.png");
    public static final Image PIGD2=Toolkit.getDefaultToolkit().getImage("imgs/pigdiamond2.png");
    public static final Image BAG=Toolkit.getDefaultToolkit().getImage("imgs/bag.png");
    public static final Image BONE=Toolkit.getDefaultToolkit().getImage("imgs/bone.png");
    public static final Image SKULL=Toolkit.getDefaultToolkit().getImage("imgs/skull.png");
    public static final Image SHOP1=Toolkit.getDefaultToolkit().getImage("imgs/shop_unhappy.jpg");
    public static final Image BOOM=Toolkit.getDefaultToolkit().getImage("imgs/boom2.png");
    public static final Image TOOL0=Toolkit.getDefaultToolkit().getImage("imgs/tool0.png");
    public static final Image TOOL1=Toolkit.getDefaultToolkit().getImage("imgs/tool1.png");
    public static final Image TOOL2=Toolkit.getDefaultToolkit().getImage("imgs/tool2.png");
    public static final Image TOOL3=Toolkit.getDefaultToolkit().getImage("imgs/tool3.png");
    public static final Image TOOL4=Toolkit.getDefaultToolkit().getImage("imgs/tool4.png");
    public static final Image TOOL5=Toolkit.getDefaultToolkit().getImage("imgs/tool5.png");
    public static final Image TIP=Toolkit.getDefaultToolkit().getImage("imgs/tip.png");



    public static final String HELP11="游戏规则：玩家在规定的时间内得到规定的金钱即可进入下";
    public static final String HELP12="           一关。当游戏中抓取的物品价值超过当前关的目";
    public static final String HELP13="           标分值时，超出部分可以累计至下一关。";

    public static final String HELP21="操作规则：按下键使钩子变长捞取物品，如有炸弹，按上键" ;
    public static final String HELP22="           放炸弹，买东西按enter键。" ;

    public static final String[] SHOPP={
            "生力水。买了它以后，在下一关中你的力气将会增加，即抓东西的速度会增加。其功效为一关。" ,
            "幸运草。它将增强你在下一关中所有物品的价值。其效用为一关。",
            "石头收藏书。石头将会变成相当有价值的物品。其功效为一关。",
            "炸药。你买了它以后，当你抓到较重而且钱不多的物品时，按下上方向键即可将它炸毁，以便节省时间。",
            "钻石收藏书。在下一关中钻石将变得相当值钱。其效用为一关。" ,
            "骨头收藏书。骨头将会变成相当有价值的物品。其功效为一关。",
            "什么都不购买，直接进入下一关。"
    };


    public static final String SHOPP01="生力水。买了它以后，在下一关中你的力气将会增加，即抓东西的速度" ;
    public static final String SHOPP02="会增加。其功效为一关。" ;
    public static final String SHOPP11="幸运草。它将增强你在下一关中所有物品的价值。其效用为一关。" ;
    public static final String SHOPP12="一关。" ;
    public static final String SHOPP31="炸药。你买了它以后，当你抓到较重而且钱不多的物品时，按下上方向" ;
    public static final String SHOPP32="键即可将它炸毁，以便节省时间。" ;




    public static final int Goal[]={650,1195,2010,3095,4450,6075,7970,10135};

}
