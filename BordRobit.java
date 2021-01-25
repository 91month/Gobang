package C6;
import java.awt.*;
import javax.swing.*;

public class BordRobit extends JPanel implements BordOK {
	static int timegoby=0;       //��ʱ������
	
	public void UI() {
		JFrame frame = new JFrame("������");
		frame.setSize(750, 590);       //���ڴ�С
		frame.setLocation(500,500);     //���������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);           //���ڴ�С����1/0
		frame.setLayout(new BorderLayout());   //BorderLayout����
		frame.add(this, BorderLayout.CENTER);// �������ڲ����м�	
		this.setBackground(Color.PINK);   // frame���̱�����ɫ
		
		JPanel westPanel = new JPanel();//ʵ����JPanel����
		westPanel.setLayout(new FlowLayout());//�������Ĳ��ַ�ʽ
		westPanel.setPreferredSize(new Dimension(200, 200));// ���������������Ĺ��
		
		Listener gl = new Listener(this, array);// �������������
		
		          
		            JButton button1 = new JButton("��ʼ/�ؿ�");
					JButton button2 = new JButton("���ֽ��������������");
					JButton button3 = new JButton("�������");
					JButton button4 = new JButton("��������");
					JButton button5 = new JButton("�����������Ȩ");
					JButton button6 = new JButton("����ָ������");
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
					b.add(buttonPVE);b.add(buttonPVP);  //  ��ѡ
					
					button1.addActionListener(gl);
					button2.addActionListener(gl);
					button3.addActionListener(gl);
					button4.addActionListener(gl);
					button5.addActionListener(gl);   //��ť����  buttonX.addActionListener(XX)
					button6.addActionListener(gl);
					buttonPVP.addActionListener(gl);
					buttonPVE.addActionListener(gl);
					
					frame.add(westPanel, BorderLayout.WEST);// WEST�Ĳ���
					frame.setVisible(true);
		
				   
					//����ʱ�����������
					  JLabel please = new JLabel(""+timegoby);
					  please.setFont(new Font("����",Font.BOLD, 46));
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
			g.drawLine(X, Y + size * i,  X + size * (coloum - 1), Y + size * i);// ���� //����36
			g.drawLine(X + size * i, Y,  X + size * i,  Y + size * (coloum - 1));// ���� //����36
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
