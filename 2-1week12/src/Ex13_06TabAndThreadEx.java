import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
	int barSize = 0; //���� ũ��
	int maxBarSize;
	
	MyLabel(int maxBarSize) { this.maxBarSize = maxBarSize; }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)(this.getWidth()))
				/maxBarSize*barSize); //(this����/100) * barSize
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {
		if(barSize == maxBarSize) {
			try { wait(); } catch (InterruptedException e) { return; }
		}
		barSize++;
		repaint(); //�� �ٽ� �׸���
		notify();
	}
	
	synchronized void consume() {
		if(barSize == 0) {
			try { wait(); } catch (InterruptedException e) { return; }	
		}
		barSize--;
		repaint(); //�� �ٽ� �׸���
		notify();
	}	
}

class ConsumerThread extends Thread {
	MyLabel bar;
	ConsumerThread(MyLabel bar) { this.bar = bar; }
	
	public void run() {
		while(true) {
			try { sleep(200); bar.consume(); } //0.2�ʸ��� �پ��
			catch (InterruptedException e) { return; }
		}
	} //end-run()
}

public class Ex13_06TabAndThreadEx extends JFrame {
	MyLabel bar = new MyLabel(100); //maxBarSize 100���� ����, MyLabel �θ�
	
	Ex13_06TabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { bar.fill(); }
		}); //Ű ������ bar ä����
		
		setSize(350,200);
		setVisible(true);
		c.requestFocus();
		ConsumerThread th = new ConsumerThread(bar); //th �ҷ���
		th.start(); //������ ����
	}
	
	public static void main(String[] args) {
		new Ex13_06TabAndThreadEx("�ƹ�Ű�� ���� ���� �� ä���");
	}
}