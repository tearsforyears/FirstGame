package com.rupeng.oop.fengzhuangyinqing;
import com.rupeng.game.GameCore;
public class NumberCreater //����һ������ģʽ�ļ�����
//2.0�汾 ��������Բ���һ�������
{
	private static final NumberCreater instance/*����*/=new NumberCreater();//Ψһ����������˷���private
                                                                      //finalֻ����Ψһû��������ֵ
                                                                     //static��̬������ʼ��֮�󷽷���������д
	private NumberCreater(){
		
	};//���캯��
	public static NumberCreater getCreater()
	{
		return instance;
	}
	private int number=0;//�������������������е�number
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
//NumberCreater n1=NumberCreater.getCreater//�õ�����
//n1.createrNumber();//�Զ���ʹ�����ڲ�����