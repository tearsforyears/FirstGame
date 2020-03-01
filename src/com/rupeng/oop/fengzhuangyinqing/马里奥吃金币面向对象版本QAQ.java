package com.rupeng.oop.fengzhuangyinqing;
import java.awt.Color;

//import java.awt.Color;
import com.rupeng.game.GameCore;
import com.rupeng.oop.fengzhuangyinqing.gameWindows;//看GameCore心烦了
public class 马里奥吃金币面向对象版本QAQ implements Runnable
{
    public static void main(String[] args)
    {
    	GameCore.start(new 马里奥吃金币面向对象版本QAQ());
    }
    public void run()
    {	gameWindows game=gameWindows.getWindows();
    	Sprite mario=new Sprite();
    	Sprite girl=new Sprite();
    	Sprite[] coin=new Sprite[12];//关于COIN的一个数组储存数据
    	game.title("面向对象测试窗口");
    	game.windowSize(800,800);
//    	game.BGM("musicforBg.mp3");
    	game.backGround("p1.png");
    	
    	/**产生随机金币
    	 * 利用随机数
    	 */
    	int[][] coinData=new int[12][2];                 
    	for(int i=0;i<coinData.length;i++)
    	{
    	int randHeight=NumberCreater.getCreater().randomNum(0, game.getGameHeight());
    	int randWidth=NumberCreater.getCreater().randomNum(0, game.getGameWidth());
    	coinData[i][0]=randHeight;
    	coinData[i][1]=randWidth; //能成功产生数组,虽然我觉得可以把这玩意不放在数组里面 但是为了以后方便检查也就放在数组里了
    	coin[i]=new Sprite();
    	coin[i].creatSprite("coin");
    	coin[i].setPosition(coinData[i][0], coinData[i][1]);
    	coin[i].playSpriteAnimate("rotate");
    	}//会少那么一两颗的原因应该是出游戏界面之外了
    	
    	Text text1=new Text();
    	text1.creatText(" ");
    	text1.setFontSize(50);
    	text1.setPosition(400,0);
    	text1.setFontColor(Color.RED);
//    	game.pause(1000);
//    	
//    	text1.xiugaitext("封装真累人");
//    	text1.setFontSize(30);
//    	text1.setFontColor(Color.RED);
//    	game.pause(1000);
//    	text1.hide();
    	  	
    	
    	mario.creatSprite("mario");
    	mario.setPosition(200, 200);
    	mario.playSpriteAnimate("walk");
    	
    	girl.creatSprite("girl");
    	girl.playSpriteAnimate("walk");
    	girl.setPosition(0, 600);
    	
    	
    	for(;;)
    	{
    		mario.move(10);//执行这句话一定在最后因为方法内部有个死循环,后来把死循环移到了外部
    		Sprite.coinEatIsOK(mario, coin);//马里奥 程序员告诉你你可以吃金币了，莫名卡顿,返回值是吃掉金币的个数int
    		text1.xiugaitext("X"+Integer.toString( Sprite.coinEatIsOK(mario, coin)));
    		
    	//	girl.automove(1,10,750);   //开启下面两行代码注释掉马里奥开启加载模式
   		//	girl.automove(3,10,750);
    		
    		
//    		for(int i=0;i<12;i++)
//    		if(Sprite.xiangjiao(mario, coin[i]))
//    		{
//    			coin[i].hide();
//    		}
    	}

    }
}