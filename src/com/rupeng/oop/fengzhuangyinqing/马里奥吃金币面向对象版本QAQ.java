package com.rupeng.oop.fengzhuangyinqing;
import java.awt.Color;

//import java.awt.Color;
import com.rupeng.game.GameCore;
import com.rupeng.oop.fengzhuangyinqing.gameWindows;//��GameCore�ķ���
public class ����³Խ���������汾QAQ implements Runnable
{
    public static void main(String[] args)
    {
    	GameCore.start(new ����³Խ���������汾QAQ());
    }
    public void run()
    {	gameWindows game=gameWindows.getWindows();
    	Sprite mario=new Sprite();
    	Sprite girl=new Sprite();
    	Sprite[] coin=new Sprite[12];//����COIN��һ�����鴢������
    	game.title("���������Դ���");
    	game.windowSize(800,800);
//    	game.BGM("musicforBg.mp3");
    	game.backGround("p1.png");
    	
    	/**����������
    	 * ���������
    	 */
    	int[][] coinData=new int[12][2];                 
    	for(int i=0;i<coinData.length;i++)
    	{
    	int randHeight=NumberCreater.getCreater().randomNum(0, game.getGameHeight());
    	int randWidth=NumberCreater.getCreater().randomNum(0, game.getGameWidth());
    	coinData[i][0]=randHeight;
    	coinData[i][1]=randWidth; //�ܳɹ���������,��Ȼ�Ҿ��ÿ��԰������ⲻ������������ ����Ϊ���Ժ󷽱���Ҳ�ͷ�����������
    	coin[i]=new Sprite();
    	coin[i].creatSprite("coin");
    	coin[i].setPosition(coinData[i][0], coinData[i][1]);
    	coin[i].playSpriteAnimate("rotate");
    	}//������ôһ���ŵ�ԭ��Ӧ���ǳ���Ϸ����֮����
    	
    	Text text1=new Text();
    	text1.creatText(" ");
    	text1.setFontSize(50);
    	text1.setPosition(400,0);
    	text1.setFontColor(Color.RED);
//    	game.pause(1000);
//    	
//    	text1.xiugaitext("��װ������");
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
    		mario.move(10);//ִ����仰һ���������Ϊ�����ڲ��и���ѭ��,��������ѭ���Ƶ����ⲿ
    		Sprite.coinEatIsOK(mario, coin);//����� ����Ա����������ԳԽ���ˣ�Ī������,����ֵ�ǳԵ���ҵĸ���int
    		text1.xiugaitext("X"+Integer.toString( Sprite.coinEatIsOK(mario, coin)));
    		
    	//	girl.automove(1,10,750);   //�����������д���ע�͵�����¿�������ģʽ
   		//	girl.automove(3,10,750);
    		
    		
//    		for(int i=0;i<12;i++)
//    		if(Sprite.xiangjiao(mario, coin[i]))
//    		{
//    			coin[i].hide();
//    		}
    	}

    }
}