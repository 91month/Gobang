package C6;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;

import C6.BordRobit;
 
public class Listener extends MouseAdapter implements ActionListener,BordOK{
 
	int second1;
    int second2;
	int minute1;
	int minute2;
	private BordRobit gm;   	// ����������
	private Graphics g;     	// ���ʶ���
	boolean cco=true;      	//��¼�º��廹�ǰ���
	boolean fff=true;     		//��¼�Ƿ��ܻ���
	boolean	 ggg=true;    		//��¼�Ƿ�������
	boolean yyy=true;          //�Ƿ�ʱ
	private MyArrayList<Chess> array;
	int coloum1,row1;
	int xx,yy,max;
	int jisu=0;//������
	int d=1;//������
	int jishu2=0;//�������
	int sanshou=0;//���ֽ�������
	int sanshou2=0;
	int panduantongshi=0;
	boolean uuu=true;
	boolean iii=true;
	boolean ooo=true;
	
	
	
	public Listener(BordRobit gm,MyArrayList<Chess> array) {  //��BordRobit���������ͼ�¼���ӵ�����
		this.gm = gm;
		this.array=array;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("��ʼ/�ؿ�")) {
    		for(int i=0;i<array1.length;i++) {
    			Arrays.fill(array1[i], 0);jinshou.OKkk=2;
    		}
    		
    		
    		jinshou.OKkk=2;
    		cco=true;
    		fff=true;
    		yyy=true;
    		ggg=true;
    		ooo=true;
    		
    		sanshou=0;
    		sanshou2=0;
    		jisu=0;
    		jishu2=0;
    		d=1;
    		gm.addMouseListener(this);
    		array.Reset();
    		gm.repaint();
    		Calendar ca=Calendar.getInstance();
			second1=ca.get(Calendar.SECOND);
			minute1=ca.get(Calendar.MINUTE);
		}
    	if (e.getActionCommand().equals("����ָ������"))
    	{
    		ooo=false;
		}
    	if (e.getActionCommand().equals("�����������Ȩ")&&iii) {
    		
    		if(cco)
    		{
    		Judge a=new Judge();
    		panduantongshi=a.tongshi;
    		uuu=false;
    		gm.addMouseListener(this);
    		gm.repaint();
    		cco=!cco;
    		Calendar ca=Calendar.getInstance();
			second1=ca.get(Calendar.SECOND);
			minute1=ca.get(Calendar.MINUTE);
    		}
    		else
    		{
    			Judge a=new Judge();
    			if(uuu==false&&panduantongshi==a.tongshi)
    			{
    				JOptionPane.showMessageDialog(gm, "���壡");
    				gm.removeMouseListener(this);
        			fff=false;
        			ggg=false;
    			}
    			else 
    			{
        		    gm.addMouseListener(this);
        		    gm.repaint();
        		    cco=!cco;
        		    Calendar ca=Calendar.getInstance();
    			    second1=ca.get(Calendar.SECOND);
    			    minute1=ca.get(Calendar.MINUTE);
    			    uuu=true;
    			}
    		}
    		
    	}
    	if (e.getActionCommand().equals("�������")) {
    		
    		if(flag[0]) {           //���˶�ս����
    			if(fff) {
    				if(jisu>=6) {
    				if(array.getSize()>1) {
    					array1[coloum1][row1]=0;
    					Chess aaa=array.get(array.getSize()-2);
    					coloum1=aaa.coloum;
    					row1=aaa.row;
    					array.Delete();
    					cco=!cco;
    					gm.repaint();
    					Calendar ca=Calendar.getInstance();
    					second1=ca.get(Calendar.SECOND);
    					minute1=ca.get(Calendar.MINUTE);
    					
    				}
    				}
    				else {
    	    			JOptionPane.showMessageDialog(gm, "����֮�ڣ���ֹ����");
    	    		}
    			
    		    }
    		}
    	
    		
    	}
    		
    		
    		if (e.getActionCommand().equals("�������")) {
    		if(flag[1]) {      //�˻���ս����
    			if(fff) {
    				if(cco) {
    					if(array.getSize()>2) {
    						array1[xx][yy]=0;
    						Chess aaa=array.get(array.getSize()-2);
    						coloum1=aaa.coloum;
        					row1=aaa.row;
    						array.Delete();
    						array1[coloum1][row1]=0;
    						Chess bbb=array.get(array.getSize()-2);
    						xx=bbb.coloum;
        					yy=bbb.row;
        					array.Delete();
    						gm.repaint();
    					}
    				}
    			}
    		}
    		
    		}
    	if (e.getActionCommand().equals("��������")) {
    		if(ggg) {
    			if(cco) {
    				JOptionPane.showMessageDialog(gm, "�����ʤ");
    			}else {
    				JOptionPane.showMessageDialog(gm, "�����ʤ");
    			}
    			gm.removeMouseListener(this);
    			fff=false;
    			ggg=false;
    		}
    	}
    	if (e.getActionCommand().equals("���ֽ��������������")) {
    		if(sanshou2==3){
    			JOptionPane.showMessageDialog(gm, "�ѽ�����");
    		}
    		else if(sanshou2!=3) {
    		    JOptionPane.showMessageDialog(gm, "���ǵ����֣�");
    		}
    	}
    	if (e.getActionCommand().equals("PVP")) {  //ѡ�����˶�սģʽ flag[0]Ϊtrue,flag[1]Ϊfalse
    		flag[0]=true;
    		flag[1]=false;
    		for(int i=0;i<array1.length;i++) {
    			Arrays.fill(array1[i], 0);
    		}
    		cco=true;
    		fff=true;
    		ggg=true;
    		array.Reset();
    		gm.repaint();
    	}
    	if (e.getActionCommand().equals("PVE")) {  //ѡ���˻���սģʽ flag[0]Ϊfalse,flag[1]Ϊtrue
    		flag[0]=false;
    		flag[1]=true;
    		for(int i=0;i<array1.length;i++) {
    			Arrays.fill(array1[i], 0);
    		}
    		cco=true;
    		fff=true;
    		ggg=true;
    		iii=false;
    		array.Reset();
    		gm.repaint();
    	}
    }
 
	public void mouseReleased(MouseEvent e) {     //����ɿ���ʱ����еĲ���
		if(flag[0]) {  //ѡ�����˶�սģʽ���еĲ���
			if (g == null)
				g = gm.getGraphics();
			int x = e.getX();
			int y = e.getY();
			
			coloum1 = (x-X+size/2)/size; 
			row1 = (y-Y+size/2)/size;
			    if(coloum1<coloum&&row1<row) {
				    if(array1[coloum1][row1]==0) {
					    if(cco) {
						    g.setColor(Color.BLACK);
						    g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						    array1[coloum1][row1]=1;
						    Chess sh=new Chess(coloum1,row1,Color.BLACK);
						    array.add(sh);		    
						    BordRobit.timegoby=15;//��������ʱ��
						    jisu+=1;
						    jishu2+=1;
						    sanshou2++;
						    Calendar ca=Calendar.getInstance();
							second2=ca.get(Calendar.SECOND);
							minute2=ca.get(Calendar.MINUTE);
							if((minute2*60+second2)-(minute1*60+second1)>15)
							{
										JOptionPane.showMessageDialog(gm, "���峬ʱ�������ʤ");
										gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
										fff=false;         //���ò��ܽ��л���
										ggg=false;         //���ò��ܽ�������
										yyy=false;
										sanshou2=0;
							    		jisu=0;
							    		jishu2=0;
							    		d=1;
							}
					    }
					    else {
						    jinshou js=new jinshou(coloum1,row1);
					        if(js.checkChess3344()==1||js.checkChessCL()==1) {
					        	if(ooo==false)
					        	{
					        	JOptionPane.showMessageDialog(gm, "�������,�����ʤ!");
					    	    gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
							    fff=false;         //���ò��ܽ��л���
							    ggg=false;         //���ò��ܽ�������
					        	}
					        	ooo=true;
					        } 
						    g.setColor(Color.WHITE);
						    g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						    array1[coloum1][row1]=-1;
						    Chess sh=new Chess(coloum1,row1,Color.WHITE);
						    array.add(sh);
						    
						    BordRobit.timegoby=15;//��������ʱ��
						    jisu+=1;
						    jishu2+=1;
						    sanshou2++;
						    Calendar ca=Calendar.getInstance();
							second2=ca.get(Calendar.SECOND);
							minute2=ca.get(Calendar.MINUTE);
							if((minute2*60+second2)-(minute1*60+second1)>15)
							{
										JOptionPane.showMessageDialog(gm, "���峬ʱ�������ʤ");
										gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
										fff=false;         //���ò��ܽ��л���
										ggg=false;         //���ò��ܽ������䡢
										yyy=false;
										
										sanshou2=0;
							    		jisu=0;
							    		jishu2=0;
							    		d=1;
										
							}
					    }
					    /*if(jishu2==6) {
					    	JOptionPane.showMessageDialog(gm, "�׷��Ƴ�һ���壬��һ����");
					    	if(array.getSize()>1) {
		    					array1[coloum1][row1]=0;
		    					Chess aaa=array.get(array.getSize()-2);
		    					coloum1=aaa.coloum;
		    					row1=aaa.row;
		    					array.Delete();
		    					gm.repaint();
		    				}
					    	JOptionPane.showMessageDialog(gm, "ϵͳ���Զ�Ϊ�׷�����");
					    }*/
					    Judge jd=new Judge(coloum1,row1);
					    	    
					    if(yyy==true) {
					    	if(jd.judge())
						    {
							    jd.Check();
							    if(jd.www==1) 
							    {
								    JOptionPane.showMessageDialog(gm, "�����ʤ");
							    }else if(jd.qqq==1)
							    {
								    JOptionPane.showMessageDialog(gm, "�����ʤ");
							    }
							    gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
							    fff=false;         //���ò��ܽ��л���
							    ggg=false;         //���ò��ܽ�������
						    }
						    else 
						    {
							    jd.Check();
							    if(jd.eee==1)
							    {
							         JOptionPane.showMessageDialog(gm, "����");
							         gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
							         fff=false;         //���ò��ܽ��л���
							         ggg=false;         //���ò��ܽ�������
							    }
							    else if(jd.qqq==1)
							    {
								    JOptionPane.showMessageDialog(gm, "�����ʤ");
								    gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
								    fff=false;         //���ò��ܽ��л���
								    ggg=false;         //���ò��ܽ�������
							    }
						    }
					    }
					    Calendar ca=Calendar.getInstance();
						second1=ca.get(Calendar.SECOND);
						minute1=ca.get(Calendar.MINUTE);
					    //if(jisu!=4) {
					        cco=!cco;
					    //}
					   /* else {
					    	d++;
					    	if(d<3) {
					    		JOptionPane.showMessageDialog(gm, "����N��,�ڷ���������");
					    		cco=!cco;
					    		jisu--;
					        }
				        }*/
			       }
			  }
			
		}
		
		if(flag[1]) { //ѡ���˻���ս���еĲ���
			if (g == null)
				g = gm.getGraphics();
			if(cco) { //��cooΪtrue����������
				int x = e.getX();
				int y = e.getY();
				coloum1 = (x-X+size/2)/size; 
				row1 = (y-Y+size/2)/size;
				if(coloum1<coloum&&row1<row) {
					if(array1[coloum1][row1]==0) {
						g.setColor(Color.BLACK);
						g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						array1[coloum1][row1]=1;
						Chess sh=new Chess(coloum1,row1,Color.BLACK);
						array.add(sh);
						BordRobit.timegoby=15;//��������ʱ��
						sanshou++;
						Calendar ca=Calendar.getInstance();
						second2=ca.get(Calendar.SECOND);
						minute2=ca.get(Calendar.MINUTE);
						if((minute2*60+second2)-(minute1*60+second1)>15)
						{
									JOptionPane.showMessageDialog(gm, "���峬ʱ�������ʤ");
									gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
									fff=false;         //���ò��ܽ��л���
									ggg=false;         //���ò��ܽ�������
									yyy=false;
									sanshou=0;
						    		jisu=0;
						    		jishu2=0;
						    		d=1;
						}
						
						Judge jd=new Judge(coloum1,row1);
						if(yyy==true) {
						if(jd.judge()) {
							jd.Check();
							if(jd.www==1) {
								JOptionPane.showMessageDialog(gm, "�����ʤ");
							}else if(jd.qqq==1){
								JOptionPane.showMessageDialog(gm, "�����ʤ,��Ҳ˼���");
							}
							gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
							fff=false;         //���ò��ܽ��л���
							ggg=false;         //���ò��ܽ�������
						}
						else {
							jd.Check();
							if(jd.eee==1)
							{
							JOptionPane.showMessageDialog(gm, "����");
							gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
							fff=false;         //���ò��ܽ��л���
							ggg=false;         //���ò��ܽ�������
							}
							else if(jd.qqq==1)
							{
								JOptionPane.showMessageDialog(gm, "�����ʤ");
								gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
								fff=false;         //���ò��ܽ��л���
								ggg=false;         //���ò��ܽ�������
							}
						}
						}
						Calendar ac=Calendar.getInstance();
						second1=ac.get(Calendar.SECOND);
						minute1=ac.get(Calendar.MINUTE);
						if(sanshou==2) {
							Random rand = new Random();
							JOptionPane.showMessageDialog(gm, "���Ծ������������ֽ���");
						}
						
						cco=!cco;
					
					}
					
				}
			}
			if(!cco) {  //��cooΪfalse�����������
				AIX();
			}
		}
	}
	
	public void AIX() {
		for(int i=0;i<weightArray.length;i++) {
			for(int j=0;j<weightArray[i].length;j++) {
				weightArray[i][j]=0;
			}
		}
		max=-1;
		Ai.Quan();  
		for(int i=0;i<weightArray.length;i++) {
			for(int j=0;j<weightArray[i].length;j++) {
				if(i<5&&j<5) {
					if(max<=weightArray[i][j]&&array1[i][j]==0) {
						max=weightArray[i][j];
						xx=i;yy=j;
					}
				}else {
					if(max<weightArray[i][j]&&array1[i][j]==0) {
						max=weightArray[i][j];
						xx=i;yy=j;
					}
				}
			}
		}
		if(array1[xx][yy]==0) {
			g.setColor(Color.WHITE);
			g.fillOval(X+xx*size-size/2, Y+yy*size-size/2, size, size);
			array1[xx][yy]=-1;
			Chess sh=new Chess(xx,yy,Color.WHITE);
			array.add(sh);
		
			Judge jd=new Judge(xx,yy);
			if(jd.judge())
			{
				jd.Check();
				if(jd.www==1) 
				{
					JOptionPane.showMessageDialog(gm, "�����ʤ");
				}else if(jd.qqq==1)
				{
					JOptionPane.showMessageDialog(gm, "�����ʤ");
				}
				gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
				fff=false;         //���ò��ܽ��л���
				ggg=false;         //���ò��ܽ�������
			}
			else 
			{
				jd.Check();
				if(jd.eee==1)
				{
				JOptionPane.showMessageDialog(gm, "����");
				gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
				fff=false;         //���ò��ܽ��л���
				ggg=false;         //���ò��ܽ�������
				}
				else if(jd.qqq==1)
				{
					JOptionPane.showMessageDialog(gm, "�����ʤ");
					gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
					fff=false;         //���ò��ܽ��л���
					ggg=false;         //���ò��ܽ�������
				}
			}
			Calendar ca=Calendar.getInstance();
			second1=ca.get(Calendar.SECOND);
			minute1=ca.get(Calendar.MINUTE);
			cco=!cco;
		}
	}
}


	

