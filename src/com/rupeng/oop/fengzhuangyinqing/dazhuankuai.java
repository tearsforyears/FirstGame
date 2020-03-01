package com.rupeng.oop.fengzhuangyinqing;

import java.awt.Point;

import com.rupeng.game.GameCore;
import com.rupeng.oop.fengzhuangyinqing.gameWindows;

public class dazhuankuai implements Runnable {

	public static void main1(String[] args) {
		GameCore.start(new dazhuankuai());
	}

	public void run()// 黑暗打砖块 去掉背景图1秒死系列
	{	
		int ballVX=NumberCreater.getCreater().randomNum(0, 2);//x方向的分速度
		int ballVY =-5;//y方向的分速度	
		
		gameWindows game = new gameWindows();
		game.windowSize(900, 600);
		game.backGround("p1.png");

		Image ban = new Image();
		ban.creatImages("ban.png");
		ban.setPosition(250, 550);

		Sprite ball = new Sprite();
		ball.creatSprite("ball1");
		ball.setPosition(200, 400);
		ball.playSpriteAnimate("rotate");

		int brickData1[][] = new int[5][9];
		boolean brickData[][] = new boolean[5][9];
		Image[] brick = new Image[45];
			for (int i = 0; i < 45; i++)
			{
				brick[i] = new Image();
			}
		for (int i = 0; (i < 5); i++) {
			for (int j = 0; (j < 9); j++) {
				brickData1[i][j] = NumberCreater.getCreater().randomNum(0, 1);
				// System.out.println(brickData1[i][j]);
				if (brickData1[i][j] == 1) {
					brickData[i][j] = true;
				}
				// System.out.println(brickData[i][j]);
			}
		}
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 9; j++) {
				if (brickData[i][j] == true)
				{	
					brick[i * j] = new Image();
					brick[i * j].creatImages("7.png");
					brick[i * j].setPosition(j * 100, i * 20 + 20);
				}
				if (brickData[i][j] == false)
				{
//					brick[i * j] = new Image();
//					brick[i * j].creatImages("6.png");
//					brick[i * j].setPosition(j * 100, i * 20 + 20);
				}
			}
		} // 在进行各种调试之前检查文件修改是否生效 上面三个for循环  摆砖块

		for (;;) 
		{	
		Point posball = ball.getPosition();		
		
		int xball = posball.x;
		int yball = posball.y;
		xball+=ballVX*1;
		yball +=ballVY*1;
		
		ball.setPosition(xball, yball);
		if(xball==0)
		{
			ballVX=-ballVX;
		}
		if(xball==game.getGameWidth())//x=width
		{
			ballVX=-ballVX;
		}
		if(yball==0)//y=0
		{
			ballVY=-ballVY;
		}
		if(yball==game.getGameHeight())//如果碰到下面游戏结束
		{
			GameCore.alert("gameover");
		}
		if(Image.xiangjiao(ball, ban))//球和板反弹
		{	
			ballVY=-ballVY;
		}
		for(int i=1;i<45;i++)
		{
		if(Image.xiangjiao(ball, brick[i]))brick[i].hide();
		}
			
			
			 ban.move(10);

			
			game.pause(10);
		}
	}
}
