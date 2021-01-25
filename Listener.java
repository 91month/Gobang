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
	private BordRobit gm;   	// 棋盘面板对象
	private Graphics g;     	// 画笔对象
	boolean cco=true;      	//记录下黑棋还是白棋
	boolean fff=true;     		//记录是否能悔棋
	boolean	 ggg=true;    		//记录是否能认输
	boolean yyy=true;          //是否超时
	private MyArrayList<Chess> array;
	int coloum1,row1;
	int xx,yy,max;
	int jisu=0;//下棋数
	int d=1;//个人用
	int jishu2=0;//移棋参数
	int sanshou=0;//三手交换参数
	int sanshou2=0;
	int panduantongshi=0;
	boolean uuu=true;
	boolean iii=true;
	boolean ooo=true;
	
	
	
	public Listener(BordRobit gm,MyArrayList<Chess> array) {  //从BordRobit传窗体对象和记录棋子的数组
		this.gm = gm;
		this.array=array;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("开始/重开")) {
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
    	if (e.getActionCommand().equals("我想指定禁手"))
    	{
    		ooo=false;
		}
    	if (e.getActionCommand().equals("我想放弃行棋权")&&iii) {
    		
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
    				JOptionPane.showMessageDialog(gm, "和棋！");
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
    	if (e.getActionCommand().equals("我想悔棋")) {
    		
    		if(flag[0]) {           //人人对战悔棋
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
    	    			JOptionPane.showMessageDialog(gm, "六手之内，禁止悔棋");
    	    		}
    			
    		    }
    		}
    	
    		
    	}
    		
    		
    		if (e.getActionCommand().equals("我想悔棋")) {
    		if(flag[1]) {      //人机对战悔棋
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
    	if (e.getActionCommand().equals("我想认输")) {
    		if(ggg) {
    			if(cco) {
    				JOptionPane.showMessageDialog(gm, "白棋获胜");
    			}else {
    				JOptionPane.showMessageDialog(gm, "黑棋获胜");
    			}
    			gm.removeMouseListener(this);
    			fff=false;
    			ggg=false;
    		}
    	}
    	if (e.getActionCommand().equals("三手交换，逆天改命！")) {
    		if(sanshou2==3){
    			JOptionPane.showMessageDialog(gm, "已交换！");
    		}
    		else if(sanshou2!=3) {
    		    JOptionPane.showMessageDialog(gm, "不是第三手！");
    		}
    	}
    	if (e.getActionCommand().equals("PVP")) {  //选择人人对战模式 flag[0]为true,flag[1]为false
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
    	if (e.getActionCommand().equals("PVE")) {  //选择人机对战模式 flag[0]为false,flag[1]为true
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
 
	public void mouseReleased(MouseEvent e) {     //鼠标松开的时候进行的操作
		if(flag[0]) {  //选择人人对战模式进行的操作
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
						    BordRobit.timegoby=15;//重置面板计时数
						    jisu+=1;
						    jishu2+=1;
						    sanshou2++;
						    Calendar ca=Calendar.getInstance();
							second2=ca.get(Calendar.SECOND);
							minute2=ca.get(Calendar.MINUTE);
							if((minute2*60+second2)-(minute1*60+second1)>15)
							{
										JOptionPane.showMessageDialog(gm, "黑棋超时，白棋获胜");
										gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
										fff=false;         //设置不能进行悔棋
										ggg=false;         //设置不能进行认输
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
					        	JOptionPane.showMessageDialog(gm, "黑棋禁手,白棋获胜!");
					    	    gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
							    fff=false;         //设置不能进行悔棋
							    ggg=false;         //设置不能进行认输
					        	}
					        	ooo=true;
					        } 
						    g.setColor(Color.WHITE);
						    g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						    array1[coloum1][row1]=-1;
						    Chess sh=new Chess(coloum1,row1,Color.WHITE);
						    array.add(sh);
						    
						    BordRobit.timegoby=15;//重置面板计时数
						    jisu+=1;
						    jishu2+=1;
						    sanshou2++;
						    Calendar ca=Calendar.getInstance();
							second2=ca.get(Calendar.SECOND);
							minute2=ca.get(Calendar.MINUTE);
							if((minute2*60+second2)-(minute1*60+second1)>15)
							{
										JOptionPane.showMessageDialog(gm, "白棋超时，黑棋获胜");
										gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
										fff=false;         //设置不能进行悔棋
										ggg=false;         //设置不能进行认输、
										yyy=false;
										
										sanshou2=0;
							    		jisu=0;
							    		jishu2=0;
							    		d=1;
										
							}
					    }
					    /*if(jishu2==6) {
					    	JOptionPane.showMessageDialog(gm, "白方移除一颗棋，下一颗棋");
					    	if(array.getSize()>1) {
		    					array1[coloum1][row1]=0;
		    					Chess aaa=array.get(array.getSize()-2);
		    					coloum1=aaa.coloum;
		    					row1=aaa.row;
		    					array.Delete();
		    					gm.repaint();
		    				}
					    	JOptionPane.showMessageDialog(gm, "系统已自动为白方移棋");
					    }*/
					    Judge jd=new Judge(coloum1,row1);
					    	    
					    if(yyy==true) {
					    	if(jd.judge())
						    {
							    jd.Check();
							    if(jd.www==1) 
							    {
								    JOptionPane.showMessageDialog(gm, "黑棋获胜");
							    }else if(jd.qqq==1)
							    {
								    JOptionPane.showMessageDialog(gm, "白棋获胜");
							    }
							    gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
							    fff=false;         //设置不能进行悔棋
							    ggg=false;         //设置不能进行认输
						    }
						    else 
						    {
							    jd.Check();
							    if(jd.eee==1)
							    {
							         JOptionPane.showMessageDialog(gm, "和棋");
							         gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
							         fff=false;         //设置不能进行悔棋
							         ggg=false;         //设置不能进行认输
							    }
							    else if(jd.qqq==1)
							    {
								    JOptionPane.showMessageDialog(gm, "白棋获胜");
								    gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
								    fff=false;         //设置不能进行悔棋
								    ggg=false;         //设置不能进行认输
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
					    		JOptionPane.showMessageDialog(gm, "反手N打,黑方下两颗棋");
					    		cco=!cco;
					    		jisu--;
					        }
				        }*/
			       }
			  }
			
		}
		
		if(flag[1]) { //选择人机对战进行的操作
			if (g == null)
				g = gm.getGraphics();
			if(cco) { //若coo为true，则人下棋
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
						BordRobit.timegoby=15;//重置面板计时数
						sanshou++;
						Calendar ca=Calendar.getInstance();
						second2=ca.get(Calendar.SECOND);
						minute2=ca.get(Calendar.MINUTE);
						if((minute2*60+second2)-(minute1*60+second1)>15)
						{
									JOptionPane.showMessageDialog(gm, "黑棋超时，白棋获胜");
									gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
									fff=false;         //设置不能进行悔棋
									ggg=false;         //设置不能进行认输
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
								JOptionPane.showMessageDialog(gm, "黑棋获胜");
							}else if(jd.qqq==1){
								JOptionPane.showMessageDialog(gm, "白棋获胜,玩家菜鸡！");
							}
							gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
							fff=false;         //设置不能进行悔棋
							ggg=false;         //设置不能进行认输
						}
						else {
							jd.Check();
							if(jd.eee==1)
							{
							JOptionPane.showMessageDialog(gm, "和棋");
							gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
							fff=false;         //设置不能进行悔棋
							ggg=false;         //设置不能进行认输
							}
							else if(jd.qqq==1)
							{
								JOptionPane.showMessageDialog(gm, "白棋获胜");
								gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
								fff=false;         //设置不能进行悔棋
								ggg=false;         //设置不能进行认输
							}
						}
						}
						Calendar ac=Calendar.getInstance();
						second1=ac.get(Calendar.SECOND);
						minute1=ac.get(Calendar.MINUTE);
						if(sanshou==2) {
							Random rand = new Random();
							JOptionPane.showMessageDialog(gm, "电脑决定不进行三手交换");
						}
						
						cco=!cco;
					
					}
					
				}
			}
			if(!cco) {  //若coo为false，则机器下棋
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
					JOptionPane.showMessageDialog(gm, "黑棋获胜");
				}else if(jd.qqq==1)
				{
					JOptionPane.showMessageDialog(gm, "白棋获胜");
				}
				gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
				fff=false;         //设置不能进行悔棋
				ggg=false;         //设置不能进行认输
			}
			else 
			{
				jd.Check();
				if(jd.eee==1)
				{
				JOptionPane.showMessageDialog(gm, "和棋");
				gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
				fff=false;         //设置不能进行悔棋
				ggg=false;         //设置不能进行认输
				}
				else if(jd.qqq==1)
				{
					JOptionPane.showMessageDialog(gm, "白棋获胜");
					gm.removeMouseListener(this);  //移除监听，这时将不能对棋盘进行操作
					fff=false;         //设置不能进行悔棋
					ggg=false;         //设置不能进行认输
				}
			}
			Calendar ca=Calendar.getInstance();
			second1=ca.get(Calendar.SECOND);
			minute1=ca.get(Calendar.MINUTE);
			cco=!cco;
		}
	}
}


	

