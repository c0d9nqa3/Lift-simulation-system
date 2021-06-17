package One;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class InLift extends JFrame implements ActionListener{

	public JButton[] btn_in=new JButton[20];
	Lift lift=new Lift();
	//lift.init_liftbutton();
	public InLift() {
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(10,2));
		for(int i=0;i<20;i++) {
			btn_in[i]=new JButton((i+1)+"");
		}
		for(int i=19;i>=0;i--) {
			jp.add(btn_in[i]);
		}
		for(int i=0;i<20;i++) {
			btn_in[i].addActionListener(this);
		}
		this.setTitle("电梯内部按钮");
		this.setSize(300,500);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_in[0]) {
			lift.floor=0;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[1]) {
			lift.floor=1;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[2]) {
			lift.floor=2;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[3]) {
			lift.floor=3;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[4]) {
			lift.floor=4;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[5]) {
			lift.floor=5;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[6]) {
			lift.floor=6;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[7]) {
			lift.floor=7;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[8]) {
			lift.floor=8;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[9]) {
			lift.floor=9;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[10]) {
			lift.floor=10;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[11]) {
			lift.floor=11;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[12]) {
			lift.floor=12;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[13]) {
			lift.floor=13;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[14]) {
			lift.floor=14;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[15]) {
			lift.floor=15;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[16]) {
			lift.floor=16;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[17]) {
			lift.floor=17;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[18]) {
			lift.floor=18;
			lift.changefloor(lift.getlift());
		}
		else if(e.getSource()==btn_in[19]) {
			lift.floor=19;
			lift.changefloor(lift.getlift());
		}
		
	}
	
	
	
}
