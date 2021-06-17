package One;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;
import java.util.*;
import java.util.Timer;
import java.awt.Robot;

public class Lift extends JFrame implements ActionListener{
	private JButton[] btn=new JButton[40];
	private JLabel[] lbl=new JLabel[20];
	private static JButton[] lift=new JButton[20];
	//�����յ�label��ǩ��������λ
	private JLabel null1=new JLabel("    ");
	private JLabel null2=new JLabel("    ");
	//����open��close�رյ�����
	private JButton open=new JButton("<|>");    //�������Ŵ��ڿ���״̬���޷�����
	private JButton close=new JButton(">|<"); 
	private JLabel scree_lbl=new JLabel("��ǰ¥��");
	private static JButton screen=new JButton("");
	
	static int floor;	   //Ŀ��¥��
	static int door=1;    //�����ŵ�״̬ ��1Ϊ���ϣ��������У���0Ϊ�������������У�<Ĭ�Ϲر�>
	
	
	public Lift() {
		
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new BorderLayout(41,5));
		for(int i=0;i<40;i++) {
			if(i%2==0)
				btn[i]=new JButton("��");
			else
				btn[i]=new JButton("��");
			
		}
		for(int j=0;j<20;j++) {
			lbl[j]=new JLabel(j+1+"��");
		}
		for(int i=0;i<20;i++) {
			lift[i]=new JButton("      ");
		}
		for(int i=0;i<20;i++) {
			lift[i].setBackground(Color.blue);
		}
		/*
		for(int i=0,j=0;i<30&&j<15;i++,j++) {
			jp.add(lbl[j]);
			jp.add(btn[i]);
		}
		*/
		JPanel jp1=new JPanel();//����ǩ��ʾ��������
		jp1.setLayout(new GridLayout(20,1));
		for(int i=19;i>=0;i--) {
			jp1.add(lbl[i]);
		}
		
		JPanel jp2=new JPanel();  
		jp2.setLayout(new GridLayout(20,2));//ÿ��ĵ��ݰ������֡�����������
		jp2.add(null1);
		for(int i=1;i<39;i++) {
			jp2.add(btn[i]);
		}
		jp2.add(null2);
		JPanel jp3=new JPanel();
		jp3.setLayout(new GridLayout(20,1));   //����
		for(int i=19;i>=0;i--) {
			jp3.add(lift[i]);
		}	
		
		JPanel jp4=new JPanel();
		jp4.setLayout(new GridLayout(1,2));  //�����ſ��ذ�ť
		jp4.add(open);  jp4.add(close);
		
		JPanel jp5=new JPanel();
		jp5.setLayout(new GridLayout(1,2));
		jp5.add(scree_lbl); 
		jp5.add(screen);
		jp.add(jp1,BorderLayout.WEST);
		jp.add(jp2,BorderLayout.CENTER);
		jp.add(jp3,BorderLayout.EAST);
		jp.add(jp4,BorderLayout.SOUTH);
		jp.add(jp5,BorderLayout.NORTH);
		for(int i=0;i<40;i++) {
			btn[i].addActionListener(this);
		}
		open.addActionListener(this);
		close.addActionListener(this);
		
		this.setTitle("����ģ��ϵͳ��");
		this.setSize(400,800);
		this.setVisible(true);
	}
	
	public static int getlift() { //��ȡ��ǰ����¥����
		int now_f = 0;    //��ǰ¥����
		for(int i=0;i<20;i++) {
			if(!lift[i].isContentAreaFilled()) {
				now_f=i;
			}
		}
		return now_f;
	}
	public static void init_liftbutton() {  //��ʼ������λ��
		Thread thread=new Thread() {
			public void run() {
				lift[0].setContentAreaFilled(false);
			}
		};
		thread.start();
		
	}
	
	public void Lift_up(int i) {   //ʵ�ֵ�������
		for(int j=i;j<floor;j++) {
			//Judge_door(door);
			if(door!=1) {
				JOptionPane.showMessageDialog(null, "�������ѿ�!!!!��ر�", "WARNING!!!",JOptionPane.PLAIN_MESSAGE);
				break;
				}
				try{
					 Thread.sleep(1000); 
					} 
				catch (InterruptedException e1) 
				{
					         
					e1.printStackTrace();
				}
				
				lift[j].setContentAreaFilled(true);
				
				lift[j+1].setContentAreaFilled(false);
				screen.setText(""+(j+2));
			}
		}
		
	public static void Lift_down(int i) {    //�����½�
		
		for(int j=i;j>floor;j--) {
				if(door!=1) {
					JOptionPane.showMessageDialog(null, "�������ѿ�!!!!��ر�", "WARNING!!!",JOptionPane.PLAIN_MESSAGE);
					break;
					}
				try{
					 Thread.sleep(1000); 
					} 
				catch (InterruptedException e2) 
					{     
					e2.printStackTrace();
					}
				
				lift[j].setContentAreaFilled(true);
				lift[j-1].setContentAreaFilled(false);
				screen.setText(""+j);
				}
			}
	
	//�жϵ������Ƿ���
	/*public void Judge_door(int j) {
		if(j!=1) {
			JOptionPane.showMessageDialog(null, "�������ѿ�!!!!", "WARNING!!!",JOptionPane.PLAIN_MESSAGE);
			
		}
		
	}
	*/
	//�ı��������¥��ĺ���
	public void changefloor(int x) {   //xΪ��ǰ¥�㣡��
		Thread thread=new Thread() {
			public void run() {
					//Judge_door(door);
					if(x>floor) {
						
						Lift_down(x);
					}
					else if(x<floor) {
						Lift_up(x);
						
					}
				
				//lift[x].setContentAreaFilled(false);
			}
		};
		thread.start();
	}
	
	public static void returninit() {    //���ݵȴ�8��󷵻�1¥�ĺ���
		Thread thread=new Thread();
		if(!thread.isAlive()) {
			
			try {
				thread.sleep(8000);
				floor=0;
				lift[getlift()].setContentAreaFilled(true);
				Lift_down(getlift());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn[1]) {
			floor=19;
			changefloor(getlift());
			
			
		}
		else if(e.getSource()==btn[2]||e.getSource()==btn[3]) {
			floor=18;
			changefloor(getlift());
		}
		
		else if(e.getSource()==btn[4]||e.getSource()==btn[5]) {
			floor=17;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[6]||e.getSource()==btn[7]) {
			floor=16;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[8]||e.getSource()==btn[9]) {
			floor=15;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[10]||e.getSource()==btn[11]) {
			floor=14;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[12]||e.getSource()==btn[13]) {
			floor=13;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[14]||e.getSource()==btn[15]) {
			floor=12;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[16]||e.getSource()==btn[17]) {
			floor=11;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[18]||e.getSource()==btn[19]) {
			floor=10;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[20]||e.getSource()==btn[21]) {
			floor=9;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[22]||e.getSource()==btn[23]) {
			floor=8;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[24]||e.getSource()==btn[25]) {
			floor=7;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[26]||e.getSource()==btn[27]) {
			floor=6;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[28]||e.getSource()==btn[29]) {
			floor=5;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[30]||e.getSource()==btn[31]) {
			floor=4;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[32]||e.getSource()==btn[33]) {
			floor=3;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[34]||e.getSource()==btn[35]) {
			floor=2;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[36]||e.getSource()==btn[37]) {
			floor=1;
			changefloor(getlift());
		}
		else if(e.getSource()==btn[38]) {
			floor=0;
			changefloor(getlift());
		}
		else if(e.getSource()==open) {
			JOptionPane.showMessageDialog(null, "�������ѿ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
			door=0;

		}
		else if(e.getSource()==close) {
			JOptionPane.showMessageDialog(null, "�������ѹأ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
			door=1;
		}
		
	}
	public static void main(String args[]) {
		InLift in=new InLift();
		init_liftbutton();
		
		//returninit();
		
		
	}
}
