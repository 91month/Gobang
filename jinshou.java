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
    
	public  int checkChess3344(){//�������ֺ����Ľ���(������������������ģ�����)
		
        int count1=1;
        int count2=1;
        int count3=1;
        int count4=1;
        int b1=0,b2=0,b3=0,b4=0;//���հ������
        int a1=0,a2=0,a3=0,a4=0;//�հ��������
        int sansan=0;//��������������
        int sisi=0;//�������ĵ��������ܹ��������ߣ�
        
        //��ֱ�����ϵļ��
        for(int j=y+1;j+1<15;j++)
        {                                //�����겻�� ��������� ���ch�ϱߵ��������
            if(array1[x][y]==array1[x][j] && array1[x][y]!=0)
            { //���ch�ұߵ����Ӻ�ch��ɫһ�� ������һ
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
        for(int j=y-1;j-1>=0;j--){         //�����겻�� ������ݼ� ���ch�±ߵ��������
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
        //��ֱ���ϵ�������������
        if(count1==3 && a1==2){                                  
            sansan+=1;
        }
        if(count1==4 && a1==2){                                  
            sisi+=1;
        }
        
        // ˮƽ�����ϵļ��
        for(int i=x-1;i-1>=0;i--){                                //�����겻�� ������ݼ� ���ch������������       
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
        }                                                       //�����겻�� ������ݼ�  ���ch������������  
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
        // ˮƽ�����ϵ�������������
        if(count2==3 && a2==2){                                  
        	sansan+=1;
        }
        if(count2==4 && a2==2){                                  
        	sisi+=1;
        }
        /*
         * ���Խ�������ļ��
         */
        for(int i=x-1,j=y+1;i-1>=0 && j+1<15;i--,j++){                // �еݼ� �еݼ�
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
        for(int i=x+1,j=y-1;j-1>=0&&i+1<15;j--,i++){                //�еݼ� �еݼ�
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
        //���Խ����ϼ�����
        if(count3==3 && a3==2){                                  
        	sansan+=1;
        }
        if(count3==4 && a3==2){                                  
        	sisi+=1;
        }
        /*
         * ���Խ����ϵļ��     
         */
        for(int i=x+1,j=y+1;i+1<15&&j+1<15;i++,j++){                //�еݼ��еݼ�
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
        //���Խ����ϼ�����
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
	
	public int checkChessCL(){ //��������
		int count1=1;
        int count2=1;
        int count3=1;
        int count4=1;

        //�ж�һ���Ƿ��г���
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
 	 //�ж�һ���Ƿ��г���
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
 	 //�ж϶Խ����Ƿ��г���
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
 	 //�жϷ��Խ����Ƿ��г���
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
