package com.rupeng.oop.fengzhuangyinqing;
//import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import com.rupeng.game.GameCore;
public class Sprite extends normalmethod
	{ 
	int num=NumberCreater.getCreater().createNumber();
	public void creatSprite(String s1)
	{			
		GameCore.createSprite(num, s1);
	}
	@Override
	public void setPosition(int x,int y)
	{
		GameCore.setSpritePosition(num, x, y);
	}
	@Override
	public Point getPosition()
	{
		Point pos=GameCore.getSpritePosition(num);
		return pos;
	}
	@Override
	public int getPositionX()
	{
		return GameCore.getSpriteX(num);
	}
	@Override
	public int getPositionY()
	{
		return GameCore.getSpriteY(num);
	}
	@Override
	public int getHeight()
	{
		return GameCore.getSpriteHeight(num);
	}
	@Override
	public int getWidth()
	{	
		return GameCore.getSpriteWidth(num);
	}
	@Override
	public void show()
	{
		GameCore.showSprite(num);
	}
	@Override
	public void hide()
	{
		GameCore.hideSprite(num);
	}
	public void playSpriteAnimate(String animatename,boolean a)
	{
		GameCore.playSpriteAnimate(num, animatename, a);
	}
	public void playSpriteAnimate(String animatename)
	{
		GameCore.playSpriteAnimate(num, animatename, true);
	}
	public void setSpriteFlipX(boolean a)
	{
		GameCore.setSpriteFlipX(num, a);
		
	}
	public void setSpriteFlipY(boolean a)
	{
		GameCore.setSpriteFlipY(num, a);
		
	} 
	public void setSpriteFlipX()
	{
		setSpriteFlipX(true);
	}
	public void setSpriteFlipY()
	{
		setSpriteFlipY(true);
	}
	public Point getPosition2()
	{
		return GameCore.getSpritePositionOnScreen(num);
	}
	public int getPositionX2()
	{
		return GameCore.getSpritePositionOnScreen(num).x;
	}
	public int getPositionY2()
	{
		return GameCore.getSpritePositionOnScreen(num).y;
	}
	
	public  void move(int speed)//move the sprite
	{	
		int kc=GameCore.getPressedKeyCode();
		Point pos=GameCore.getSpritePosition(num);
			if(kc==KeyEvent.VK_LEFT&&pos.x>0)
			{
			GameCore.getSpritePosition(num);
			pos.x=pos.x-speed;
			GameCore.setSpritePosition(num,pos.x,pos.y);
			GameCore.setSpriteFlipX(num, false);
			GameCore.pause(5);
			}
			if(kc==KeyEvent.VK_RIGHT&&pos.x<GameCore.getGameWidth()-GameCore.getSpriteWidth(num))
			{
			GameCore.getSpritePosition(num);
			pos.x=pos.x+speed;
			GameCore.setSpritePosition(num,pos.x,pos.y);
			GameCore.setSpriteFlipX(num, true);
			GameCore.pause(5);
			}if(kc==KeyEvent.VK_UP&&pos.y>0)
			{
			GameCore.getSpritePosition(num);
			pos.y=pos.y-speed;
			GameCore.setSpritePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}if(kc==KeyEvent.VK_DOWN&&pos.y<GameCore.getGameHeight()-GameCore.getSpriteHeight(num))
			{
			GameCore.getSpritePosition(num);
			pos.y=pos.y+speed;
			GameCore.setSpritePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}
//		System.out.println(kc);
//		System.out.println(pos.x);
		

	
	
	}//public move	
	public  void move()
	{
		 move(1);
	}

	/**
	 * 判断两个矩形是否香蕉
	 * @param name1其中一个精灵的名字
	 * @param name2第二个精灵的名字
	 * @return true代表香蕉，false代表不想交
	 * 我不会用is太容易乱套
	 */
	public static boolean xiangjiao(Sprite name1,Sprite name2)
	{
		int x=name1.getPositionX();
		int y=name1.getPositionY();
		int x1=name2.getPositionX();
		int y1=name2.getPositionY();
		boolean a=x+name1.getWidth()<x1;//右不香蕉
		boolean b=x>x1+name2.getWidth();//做不橡胶
		boolean c=y>y1+name2.getHeight();//up
		boolean d=y+name1.getHeight()<y1;//down
		if(a||b||c||d)
		{//	System.out.println(a+"1"+b+"2"+c+"3"+d+"x"+x+"y"+y+"x1."+x1+"y1."+y1);
			return false;	
		}
		else
		{	//System.out.println(a+"1"+b+"2"+c+"3"+d+"x"+x+"y"+y+"x1."+x1+"y1."+y1);
			return true;
		}
	}
	
	
	static boolean isCoinDeadData[]=new boolean[12];	
	static int coins=0;
	public static int coinEatIsOK(Sprite name,Sprite[] name2)
	{	
		for(int i=0;i<12;i++)
		{
		if(Sprite.xiangjiao(name,name2[i])&&(!isCoinDeadData[i]))
		{
			GameCore.hideSprite(name2[i].num);
			isCoinDeadData[i]=true;
			coins++;
		}
		}
		return coins;
	}
	public void automove(int diretion,int speed,int lengh)//auto move function//be out of the function run
	{
		Point pos= GameCore.getSpritePosition(num);
		int x=pos.x;
		int y=pos.y; //get the(x,y) of the sprite
		int a=x,b=y;
		for(;;)
		{
		if((((x-a)<lengh)&&(y==b))||(((y-b)<lengh)&&(x==a)))//is this ok?		
		{
			if(diretion==1)	//right
			{
			x=x+speed;
			GameCore.setSpritePosition(num, x, y);
			GameCore.setSpriteFlipX(num, false);
			GameCore.pause(10);
    			if((x-a)>=lengh)
    			{
    				break;
    			}
			}
			if(diretion==2)	//down
			{
			y=y+speed;
			GameCore.setSpritePosition(num, x, y);
			GameCore.pause(10);
    			if((y-b)>=lengh)
    			{
    				break;
    			}
			}
			if(diretion==3)	//left
			{
			x=x-speed;
			GameCore.setSpritePosition(num, x, y);
			GameCore.setSpriteFlipX(num, true);
			GameCore.pause(10);
    			if((a-x)>=lengh)
    			{
    				break;
    			}
			}
			if(diretion==4)	//up
			{
			y=y-speed;
			GameCore.setSpritePosition(num, x, y);
			GameCore.pause(10);
    			if((b-y)>=lengh)
    			{
    				break;
    			}
			}
		}	
		}
}
//	static boolean isBricksDeadData[]=new boolean[45];	
//	static int bricks=0;
//	public int BricksEatIsOK(Sprite name,Image[] name2)
//	{	
//		for(int i=0;i<45;i++)
//		{
//		if(Image.xiangjiao(name,name2[i])&&(!isBricksDeadData[i]))
//		{
//			GameCore.hideSprite(name2[i].num);
//			isBricksDeadData[i]=true;
//			bricks++;
//		}
//		}
//		return bricks;
//	}	
//	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}//first kuohao





