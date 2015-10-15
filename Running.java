import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class Running extends Applet implements Runnable{
	Thread t;
	int x=50, y=50;
	
	public Running(){
		t=new Thread(this);
		t.start();
	}
	
	public void increase(){
		x=x+2;
		y=2*x+1;
		repaint();
	}
	
	public void run(){
		while(t!=null){
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
		g.fillOval(x, y, 10, 10);
	}
	
	public void init(){
		new Running();
	}
}