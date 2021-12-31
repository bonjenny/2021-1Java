import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex10_05MouseAdapterEx extends JFrame {
	private JLabel la = new JLabel("Hello");
	
	public Ex10_05MouseAdapterEx() {
		setTitle("Mouse �̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
		c.setLayout(null);
		
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(250, 250);
		setVisible(true);
	}
	
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}
	
	public static void main(String [] args) {
		new Ex10_05MouseAdapterEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� 10-5");
	}
}