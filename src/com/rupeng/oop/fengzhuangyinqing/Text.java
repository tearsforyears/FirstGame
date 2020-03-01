package com.rupeng.oop.fengzhuangyinqing;
import java.awt.Color;
import java.awt.Point;

import com.rupeng.game.GameCore;
public class Text extends normalmethod
{
	int num=NumberCreater.getCreater().createNumber();
	public void creatText(String wenbenneirong)
	{			
		GameCore.createText(num, wenbenneirong);
	}
	@Override
	public void setPosition(int x,int y)
	{
		GameCore.setTextPosition(num, x, y);
	}
	@Override
	public Point getPosition()
	{
		Point pos=GameCore.getTextPosition(num);
		return pos;
	}
	public void setFontSize(int x)				//size
	{
		GameCore.setTextFontSize(num, x);
	}
	public void setFontSize()						//size
	{
		GameCore.setTextFontSize(num, 18);
	}
	public void setFontColor(Color s)				//color
	{
		GameCore.setTextColor(num, s);
	}
	@Override
	public int getPositionX()
	{
		return GameCore.getTextX(num);
	}
	@Override
	public int getPositionY()
	{
		return GameCore.getTextY(num);
	}
	@Override
	public int getHeight()
	{
		return GameCore.getTextHeight(num);
	}
	@Override
	public int getWidth()
	{	
		return GameCore.getTextWidth(num);
	}
	@Override
	public void show()
	{
		GameCore.showText(num);
	}
	@Override
	public void hide()
	{
		GameCore.hideText(num);
	}
	public void xiugaitext(String wenbenneirong)					//ÐÞ¸ÄÎÄ±¾
	{
		GameCore.setText(num, wenbenneirong);
	}
	public Point getPosition2()
	{
		return GameCore.getTextPositionOnScreen(num);
	}
	public int getPositionX2()
	{
		return GameCore.getTextPositionOnScreen(num).x;
	}
	public int getPositionY2()
	{
		return GameCore.getTextPositionOnScreen(num).y;
	}
}

