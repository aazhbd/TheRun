import java.awt.*;
import javax.swing.*;

public class TheRun extends JFrame implements Runnable{
	Thread t;
	int x=100, y=100;
	int dir=1, amp=1;
	
	public TheRun(){
		t=new Thread(this);
		t.start();
		setSize(500, 500);
		show();
	}
	
	public void increase(){
		if (dir==1) amp = amp + 1;
		if (dir==0) amp = amp - 1;
		if (amp==10) dir = 0;
		if(amp==1) dir = 1;
		x=amp*5;
		y=y+2;
		repaint();
	}
	
	public void decrease(){
		x=x+10;
		y=y-10;
		repaint();
	}
	
	public void run(){
		while(t!=null){
			increase();
//			decrease();
			try{
				t.sleep(100);
			}
			catch(InterruptedException ie){
				System.out.print("Thread Interrupeted");
			}
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
	
	public static void main(String args[]){
		new TheRun();
	}
}