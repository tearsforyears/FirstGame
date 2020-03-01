package com.rupeng.oop.fengzhuangyinqing;
import com.rupeng.game.GameCore;
public class NumberCreater //这是一个单例模式的计数器
//2.0版本 这玩意可以产生一个随机数
{
	private static final NumberCreater instance/*例子*/=new NumberCreater();//唯一对象不允许别人访问private
                                                                      //final只能是唯一没有其他赋值
                                                                     //static静态方法初始化之后方法不允许被重写
	private NumberCreater(){
		
	};//构造函数
	public static NumberCreater getCreater()
	{
		return instance;
	}
	private int number=0;//不允许别的类访问这个类中的number
	public  int  createNumber()
	{
		number++;
		return number;
	}
	public int randomNum(int a, int b)
	{
		return GameCore.rand(a, b+1);
	}
	
}
//NumberCreater n1=NumberCreater.getCreater//得到对象
//n1.createrNumber();//对对象使用类内部方法