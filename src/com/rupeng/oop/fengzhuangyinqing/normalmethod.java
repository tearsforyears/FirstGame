package com.rupeng.oop.fengzhuangyinqing;
import java.awt.Point;

import com.rupeng.game.GameCore;

//import com.rupeng.game.GameCore;
public  class  normalmethod {
	public void setPosition(int x,int y)
	{		
	}
	public Point getPosition()
	{	
		return null;
	}
	public int getPositionX()
	{
		return -1;
	}
	public int getPositionY()
	{
		return -1;
	}
	public int getHeight()
	{
		return -1;
	}
	public int getWidth()
	{
		return -1;
	}
	public void show()
	{
	}
	public void hide()
	{
	}
	public boolean isRecins()
	{	
		return false;	
	}














}
 class gameWindows {	//类下类的运行测试
	public void title(String title)
	{
		GameCore.setGameTitle(title);	
	}
	public void windowSize(int x,int y)
	{
		GameCore.setGameSize(x, y);	
	}
	public int getGameWidth()
	{
		return GameCore.getGameWidth();
	}
	public int getGameHeight()
	{
		return GameCore.getGameWidth();
	}
	public static  gameWindows getWindows()
	{
		gameWindows s1=new gameWindows();
		return s1;
	}
	public void BGM(String soundName)
	{
		GameCore.playSound(soundName, true);
	}
	public void backGround(String path)
	{
		GameCore.loadBgView(path);
	}
	public void pause(int ms)
	{
		GameCore.pause(ms);
	}
}


