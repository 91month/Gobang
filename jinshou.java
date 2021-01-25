package C6;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
public class jinshou extends MouseAdapter implements  BordOK {
	private int x, y;
	static int OKkk=2;
    public jinshou(int x, int y) {
		this.x = x;
		this.y = y;
	}
    public jinshou() {
    }
    
	public  int checkChess3344(){//三三禁手和四四禁手(不包括特殊情况的四四！！！)
		
        int count1=1;
        int count2=1;
        int count3=1;
        int count4=1;
        int b1=0,b2=0,b3=0,b4=0;//跳空白棋参数
        int a1=0,a2=0,a3=0,a4=0;//空白棋个数、
        int sansan=0;//满足三三的线数
        int sisi=0;//满足四四的线数（总共有四条线）
        
        //垂直方向上的检测
        for(int j=y+1;j+1<15;j++)
        {                                //行坐标不变 列坐标递增 检测ch上边的落子情况
            if(array1[x][y]==array1[x][j] && array1[x][y]!=0)
            { //如果ch右边的棋子和ch颜色一样 计数加一
                count1++;
            }
            else if(array1[x][j]==0 && array1[x][y]!=array1[x][j+1])
            {
            	a1+=1;
            	break;
            }
            else if(array1[x][j]==0 && array1[x][y]==array1[x][j+1] && b1==0)
            {
            	b1+=1;
            	continue;
            }
            else
            {
                break;
            }
        }
        for(int j=y-1;j-1>=0;j--){         //行坐标不变 列坐标递减 检测ch下边的落子情况
            if(array1[x][y]==array1[x][j] && array1[x][y]!=0){
                count1++;
            }
            else if(array1[x][j]==0 && array1[x][y]!=array1[x][j-1])
            {
            	a1+=1;
            	break;
            }
            else if(array1[x][j]==0 && array1[x][y]==array1[x][j-1] && b1==0)
            {
            	b1+=1;
            	continue;
            }
            else
            {
                break;
            }
        }
        //垂直方上的落子情况检测完
        if(count1==3 && a1==2){                                  
            sansan+=1;
        }
        if(count1==4 && a1==2){                                  
            sisi+=1;
        }
        
        // 水平方向上的检测
        for(int i=x-1;i-1>=0;i--){                                //列坐标不变 行坐标递减 检测ch左面的落子情况       
            if(array1[x][y]==array1[i][y] && array1[x][y]!=0){
                count2++;
            }
            else if(array1[i][y]==0 && array1[x][y]!=array1[i-1][y])
            {
            	a2+=1;
            	break;
            }
            else if(array1[i][y]==0 && array1[x][y]==array1[i-1][y] && b2==0)
            {
            	b2+=1;
            	continue;
            }
            else
            {
                break;
            }
        }                                                       //列坐标不变 行坐标递加  检测ch右面的落子情况  
        for(int i=x+1;i+1<15;i++){                                
            if(array1[x][y]==array1[i][y] && array1[x][y]!=0){
                count2++;
            }
            else if(array1[i][y]==0 && array1[x][y]!=array1[i+1][y])
            {
            	a2+=1;
            	break;
            }
            else if(array1[i][y]==0 && array1[x][y]==array1[i+1][y] && b2==0)
            {
            	b2+=1;
            	continue;
            }
            else
            {
                break;
            }
        }
        // 水平方向上的棋子情况检测完
        if(count2==3 && a2==2){                                  
        	sansan+=1;
        }
        if(count2==4 && a2==2){                                  
        	sisi+=1;
        }
        /*
         * 正对角线上面的检测
         */
        for(int i=x-1,j=y+1;i-1>=0 && j+1<15;i--,j++){                // 行递减 列递加
            if(array1[x][y]==array1[i][j] && array1[x][y]!=0){
                count3++;
            }
            else if(array1[i][j]==0 && array1[x][y]!=array1[i-1][j+1])
            {
            	a3+=1;
            	break;
            }
            else if(array1[i][j]==0 && array1[x][y]==array1[i-1][j+1] && b3==0)
            {
            	b3+=1;
            	continue;
            }
            else
            {
            	break;
            }
        }
        for(int i=x+1,j=y-1;j-1>=0&&i+1<15;j--,i++){                //行递加 列递减
            if(array1[x][y]==array1[i][j] && array1[x][y]!=0){
                count3++;
            }
            else if(array1[i][j]==0 && array1[x][y]!=array1[i+1][j-1])
            {
            	a3+=1;
            	break;
            }
            else if(array1[i][j]==0 && array1[x][y]==array1[i+1][j-1] && b3==0)
            {
            	b3+=1;
            	continue;
            }
            else
            {
            	break;
            }
        }
        //正对角线上检测完毕
        if(count3==3 && a3==2){                                  
        	sansan+=1;
        }
        if(count3==4 && a3==2){                                  
        	sisi+=1;
        }
        /*
         * 反对角线上的检测     
         */
        for(int i=x+1,j=y+1;i+1<15&&j+1<15;i++,j++){                //行递加列递加
            if(array1[x][y]==array1[i][j] && array1[x][y]!=0){
                count4++;
            }
            else if(array1[i][j]==0 && array1[x][y]!=array1[i+1][j+1])
            {
            	a4+=1;
            	break;
            }
            else if(array1[i][j]==0 && array1[x][y]==array1[i+1][j+1] && b4==0)
            {
            	b4+=1;
            	continue;
            }
            else
            {
            	break;
            }
        }
        for(int i=x-1,j=y-1;j-1>=0&&i-1>=0;j--,i--){
            if(array1[x][y]==array1[i][j] && array1[x][y]!=0){
                count4++;
            }
            else if(array1[i][j]==0 && array1[x][y]!=array1[i-1][j-1])
            {
            	a4+=1;
            	break;
            }
            else if(array1[i][j]==0 && array1[x][y]==array1[i-1][j-1] && b4==0)
            {
            	b4+=1;
            	continue;
            }
            else 
            {
            	break;
            }
        }
        //反对角线上检测完毕
        if(count4==3 && a4==2){                                  
        	sansan+=1;
        }
        if(count4==4 && a4==2){                                  
        	sisi+=1;
        }
        if(sansan>=2 || sisi>=2) 
        {   OKkk=1;
        	return OKkk;
        } OKkk=0;
        return OKkk;
    }
	
	/*********************************/
	
	public int checkChessCL(){ //长连禁手
		int count1=1;
        int count2=1;
        int count3=1;
        int count4=1;

        //判断一列是否有长连
 	   for(int i=y+1;i<15;i++)
 	   {
 		   if(array1[x][i]==array1[x][y])
 		   {
 			  count1+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	   for(int i=y-1;i>=0;i--)
 	   {
 		   if(array1[x][i]==array1[x][y])
 		   {
 			  count1+=1;
 		   }
 		   else
 		   {
 			   break;
 		   }
 	   }
 	 //判断一行是否有长连
 	   for(int i=x+1;i<15;i++)
 	   {
 		   if(array1[i][y]==array1[x][y])
 		   {
 			  count2+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	   for(int i=x-1;i>=0;i--)
 	   {
 		   if(array1[i][y]==array1[x][y])
 		   {
 			  count2+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	 //判断对角线是否有长连
 	   for(int i=x+1,j=y+1;i<15&&j<15;i++,j++) 
 	   {
 		   if(array1[i][j]==array1[x][y])
 		   {
 			  count3+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	   for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--) 
 	   {
 		   if(array1[i][j]==array1[x][y])
 		   {
 			  count3+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	 //判断反对角线是否有长连
 	   for(int i=x+1,j=y-1;i<15 && j>=0;i++,j--) 
 	   {
 		   if(array1[i][j]==array1[x][y])
 		   {
 			  count4+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	   for(int i=x-1,j=y+1;i>=0 && j<15;i--,j++) 
 	   {
 		   if(array1[i][j]==array1[x][y])
 		   {
 			  count4+=1;
 		   }
 		   else 
 		   {
 			   break;
 		   }
 	   }
 	  if(count1>5||count2>5||count3>5||count4>5) {
 		 OKkk=1;
 		  return OKkk;
 	  }
 	  OKkk=0;
 	  return OKkk;
	}
}
