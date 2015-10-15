import java.awt.*;
import javax.swing.*;

public class TheRun extends JFrame implements Runnable{
	Thread t;
	int x=10, y=10;
	
	public TheRun(){
		t=new Thread(this);
		t.start();
		setSize(500, 500);
		show();
	}
	
	public void increase(){
		x=y+5;
		y=x+5;
		repaint();
	}
	
	public void decrease(){
		x=x+10;
		y=y-10;
		repaint();
	}
	
	public void run(){
		while(t!=null){
//			decrease();
			increase();
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
		g.drawOval(x, y, 10, 10);
	}
	
	public static void main(String args[]){
		new TheRun();
	}
}