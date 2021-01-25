package C6;
import java.awt.*;
import javax.swing.*;

public class BordRobit extends JPanel implements BordOK {
	static int timegoby=0;       //计时器功能
	
	public void UI() {
		JFrame frame = new JFrame("五子棋");
		frame.setSize(750, 590);       //窗口大小
		frame.setLocation(500,500);     //距离的坐标
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);           //窗口大小调整1/0
		frame.setLayout(new BorderLayout());   //BorderLayout布局
		frame.add(this, BorderLayout.CENTER);// 棋盘置于布局中间	
		this.setBackground(Color.PINK);   // frame棋盘背景颜色
		
		JPanel westPanel = new JPanel();//实例化JPanel对象
		westPanel.setLayout(new FlowLayout());//设置面板的布局方式
		westPanel.setPreferredSize(new Dimension(200, 200));// 设置面板容器组件的规格
		
		Listener gl = new Listener(this, array);// 创建监听类对象
		
		          
		            JButton button1 = new JButton("开始/重开");
					JButton button2 = new JButton("三手交换，逆天改命！");
					JButton button3 = new JButton("我想悔棋");
					JButton button4 = new JButton("我想认输");
					JButton button5 = new JButton("我想放弃行棋权");
					JButton button6 = new JButton("我想指定禁手");
					JRadioButton buttonPVP = new JRadioButton("PVP");
					JRadioButton buttonPVE = new JRadioButton("PVE");
					
					
					button1.setPreferredSize(new Dimension(200, 68));
					button2.setPreferredSize(new Dimension(200, 68));
					button3.setPreferredSize(new Dimension(200, 68));
					button4.setPreferredSize(new Dimension(200, 68));
					button5.setPreferredSize(new Dimension(200, 68));
					button6.setPreferredSize(new Dimension(200, 68));
					
					westPanel.add(buttonPVP);
					westPanel.add(buttonPVE);
					westPanel.add(button1);
					westPanel.add(button2);
					westPanel.add(button3);
					westPanel.add(button4);
					westPanel.add(button5);
					westPanel.add(button6);

					
					ButtonGroup b = new ButtonGroup();   //
					b.add(buttonPVE);b.add(buttonPVP);  //  单选
					
					button1.addActionListener(gl);
					button2.addActionListener(gl);
					button3.addActionListener(gl);
					button4.addActionListener(gl);
					button5.addActionListener(gl);   //按钮监听  buttonX.addActionListener(XX)
					button6.addActionListener(gl);
					buttonPVP.addActionListener(gl);
					buttonPVE.addActionListener(gl);
					
					frame.add(westPanel, BorderLayout.WEST);// WEST的布局
					frame.setVisible(true);
		
				   
					//面板计时器（类变量）
					  JLabel please = new JLabel(""+timegoby);
					  please.setFont(new Font("宋体",Font.BOLD, 46));
					  westPanel.add(please);
				      while(true){	                 
					    try {
						   Thread.sleep(1001);
						   timegoby--;
						   if(timegoby>=0) {
						   please.setText(""+timegoby); 
						   }
						   else {
								please.setText("0");
						   }	
						   
					    }
					     catch(InterruptedException e) {}
					}
				
	}

	
	private MyArrayList<Chess> array = new MyArrayList<Chess>();

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 15; i++) {
			g.drawLine(X, Y + size * i,  X + size * (coloum - 1), Y + size * i);// 横线 //格子36
			g.drawLine(X + size * i, Y,  X + size * i,  Y + size * (coloum - 1));// 竖线 //格子36
		}

		for (int i = 0; i < array.getSize(); i++) {
			Chess e = array.get(i);
			g.setColor(e.color);
			g.fillOval(X + e.coloum * size - size / 2, 
					   Y + e.row    * size - size / 2,
					   size, size);
		}
	}
	
	
			
		

	
public static void main(String[] args) {
	BordRobit gm = new BordRobit();
	gm.UI();
	
	
}
	}
