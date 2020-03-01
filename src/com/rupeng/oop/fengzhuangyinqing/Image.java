package com.rupeng.oop.fengzhuangyinqing;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;
public class Image extends normalmethod
{
	int num=NumberCreater.getCreater().createNumber();
	public void creatImages(String path)
	{			
		GameCore.createImage(num, path);
	}
	@Override
	public void setPosition(int x,int y)
	{
		GameCore.setImagePosition(num, x, y);;
	}
	@Override
	public Point getPosition()
	{
		Point pos=GameCore.getImagePosition(num);
		return pos;
	}
	@Override
	public int getPositionX()
	{
		return GameCore.getImageX(num);
	}
	@Override
	public int getPositionY()
	{
		return GameCore.getImageY(num);
	}
	@Override
	public int getHeight()
	{
		return GameCore.getGameHeight();
	}
	@Override
	public int getWidth()
	{
		return GameCore.getGameWidth();
	}
	@Override
	public void hide()
	{
		GameCore.hideImage(num);
	}
	@Override
	public void show()
	{	
		GameCore.showImage(num);
	}
	public void setSource(String path)      //path re-write
	{	
		GameCore.setImageSource(num, path);
	}
	public Point getPosition2()
	{
		return GameCore.getImagePositionOnScreen(num);
	}
	public int getPositionX2()
	{
		return GameCore.getImagePositionOnScreen(num).x;
	}
	public int getPositionY2()
	{
		return GameCore.getImagePositionOnScreen(num).y;
	}

	public  void move(int speed)//move the image
	{	
		int kc=GameCore.getPressedKeyCode();
		Point pos=GameCore.getImagePosition(num);
			if(kc==KeyEvent.VK_LEFT&&pos.x>0)
			{
			GameCore.getImagePosition(num);
			pos.x=pos.x-speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}
			if(kc==KeyEvent.VK_RIGHT&&pos.x<GameCore.getGameWidth()-GameCore.getImageWidth(num))
			{
			GameCore.getImagePosition(num);
			pos.x=pos.x+speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}if(kc==KeyEvent.VK_UP&&pos.y>0)
			{
			GameCore.getImagePosition(num);
			pos.y=pos.y-speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}if(kc==KeyEvent.VK_DOWN&&pos.y<GameCore.getGameHeight()-GameCore.getImageHeight(num))
			{
			GameCore.getImagePosition(num);
			pos.y=pos.y+speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}
//		System.out.println(kc);
//		System.out.println(pos.x);
		

	
	
	}//public move	
	public  void move()
	{
		 move(1);
	}
	public  void move2(int speed)//move the image only left and right
	{	
		int kc=GameCore.getPressedKeyCode();
		Point pos=GameCore.getImagePosition(num);
			if(kc==KeyEvent.VK_LEFT&&pos.x>0)
			{
			GameCore.getImagePosition(num);
			pos.x=pos.x-speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}
			if(kc==KeyEvent.VK_RIGHT&&pos.x<GameCore.getGameWidth()-GameCore.getImageWidth(num))
			{
			GameCore.getImagePosition(num);
			pos.x=pos.x+speed;
			GameCore.setImagePosition(num,pos.x,pos.y);
			GameCore.pause(5);
			}	
	}//public move	
	
	/**
	 * �ж����������Ƿ��㽶
	 * @param name1����һ��ͼƬ������
	 * @param name2�ڶ���ͼƬ������
	 * @return true�����㽶��false�����뽻
	 * �Ҳ�����is̫��������
	 */
	public static boolean  xiangjiao(Sprite name1,Image name2)	//����ʹ��	
	{	
		Point pos=GameCore.getImagePosition(name2.num);
		int x=name1.getPositionX();
		int y=name1.getPositionY();
		int x1=pos.x;
		int y1=pos.y;
		int width=GameCore.getImageWidth(name2.num);
		int height=GameCore.getImageHeight(name2.num);
		
		boolean a=x+name1.getWidth()<x1;//�Ҳ��㽶
		boolean b=x>x1+width;//������
		boolean c=y>y1+height;//up
		boolean d=y+name1.getHeight()<y1;//down
		if(a||b||c||d)
		{//	System.out.println(a+"1"+b+"2"+c+"3"+d+"x"+x+"y"+y+"x1."+x1+"y1."+y1);
		//	System.out.println(width+"||"+height+"||"+name1.getHeight()+"||"+name1.getWidth());
			return false;	
		}
		else
		{//	System.out.println(a+"1"+b+"2"+c+"3"+d+"x"+x+"y"+y+"x1."+x1+"y1."+y1);
		//	System.out.println(width+"||"+height+"||"+name1.getHeight()+"||"+name1.getWidth());
			return true;
		}
	}//�����˺ö��δ֪ԭ�� ֻ��ʹ�����ַ�ʽ������� �����Ƕ���ָ�����
	
	
}
	