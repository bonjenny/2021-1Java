import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SwingArraysBtn09 extends JFrame{
   
   Container cp;
   JButton [] btn = new JButton[6];
   String [] btnLabel= {"Red", "Green", "Cyan", "Magenta", "Yellow", "Gray"};
   Color [] btnColors = {Color.RED,Color.GREEN,Color.CYAN,Color.MAGENTA,Color.YELLOW,Color.GRAY};
   protected int i;
   
   
   public SwingArraysBtn09(String title) {
      super(title);
      
      cp=this.getContentPane();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setBounds(200, 300, 400, 500);
      cp.setBackground(new Color(155,255,200));
      setDesign();
      this.setVisible(true);
   }
   
   //������
   public void setDesign() {
      //�ǳ��� �⺻�� Flow ���̾ƿ�
      JPanel panel = new JPanel();
      panel.setBackground(Color.ORANGE);
      //�����ӿ� �ǳ��߰�_��ġ����
      this.add(panel, BorderLayout.NORTH);
      
      //�ݺ������� ��ư����
      for (i = 0; i < btn.length; i++) {
         btn[i] = new JButton(btnLabel[i]);
         //btn[i]��� ���� ���
         btn[i].setBackground(btnColors[i]);         

         //�гο� ��ư�߰�
         panel.add(btn[i]);

      }
      
            
      for (i = 0; i < btn.length; i++) {
         btn[i].addActionListener(new ActionListener() {
			private int k = i;

			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(btnColors[k]);
			}
         });
      }
      
   }
   
   

   public static void main(String[] args) {
      
      new SwingArraysBtn09("���� �迭�� ��ư�����");
   }
}