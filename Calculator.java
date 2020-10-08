package pyf;

public class Calculator {
	int result;
	String formula;
	int[] answers;
	int right;
	int type;
	{   type=0;
		result=-1;
		formula=null;
		answers=new int[4];
		right=-1;
	}
	boolean p(int x)//求s<x概率的方法
	{
		int s=(int)(Math.random()*100);
		return s<x;
	}
	int getResult()//获得结果
	{
		return result;
	}



	String getFormula()//获得题目
	{
		return formula;
	}
	int getAnswers(int index)//获得答案
	{
		return answers[index];
	}
	int getRight()//获得正确答案
	{
		return right;
	}
	void setAnswers()//给出正确答案和错误答案
	{
		int wrong0,wrong1,wrong2;
		if(result==0) wrong0=1;
		else if(result==100) wrong0=99;
		else wrong0=p(50)?(result+1):(result-1);
		if(result<10) wrong1=result+10;
		else if(result>90) wrong1=result-10;
		else wrong1=p(50)?(result+10):(result-10);
		wrong2=(int)(Math.random()*100);
		while(wrong2==result || wrong2==wrong0 || wrong2==wrong1)
		{
			wrong2=(int)(Math.random()*100);
		}
		answers[0]=result;
		answers[1]=wrong0;
		answers[2]=wrong1;
		answers[3]=wrong2;
		right=0;
		for(int i=0;i<15;i++)//打乱正确和错误答案顺序
		{
			int x=(int)(Math.random()*4);
			int y=(int)(Math.random()*4);
			while(x==y)
			{
				x=(int)(Math.random()*4);
				y=(int)(Math.random()*4);
			}
			if(x==right)
				right=y;
			else if(y==right)
				right=x;
			int tp=answers[x];//交换数值
			answers[x]=answers[y];
			answers[y]=tp;
		}
	}
	
	public void selecttype(int zz)
	{ type=zz;
	}
	
	void run()
	{
		int p1,p2,gep1 = 0,gep2 = 0;
		if(type==0){ 
			do {
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				int lengthp1 = Integer.toString(p1).length();
				int lengthp2 = Integer.toString(p2).length();
				if (lengthp1 == 1) {
				gep1= p1;
				};
				if (lengthp1 == 2) {
					gep1= p1%10;
					};
				if (lengthp2 == 1) {
					gep2= p2;
					};
				if (lengthp2 == 2) {
					gep2= p2%10;
					};
			}
			while
			(gep1 + gep2 <= 10);
			formula=p1+"+"+p2;
			result=p1+p2;
		}
		if(type==1){
			do {
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				int lengthp1 = Integer.toString(p1).length();
				int lengthp2 = Integer.toString(p2).length();
				if (lengthp1 == 1) {
				gep1= p1;
				};
				if (lengthp1 == 2) {
					gep1= p1%10;
					};
				if (lengthp2 == 1) {
					gep2= p2;
					};
				if (lengthp2 == 2) {
					gep2= p2%10;
					};
			}
			while
			(gep1 - gep2 > 0 || p1 - p2 < 0);
			formula=p1+"-"+p2;
			result=p1-p2;
		}
		setAnswers();
	}
		
		
		
		
	}

