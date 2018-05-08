package unicode;

import java.awt.*;
import java.awt.event.*;
public class QueryFrame extends Frame implements ActionListener
{
	private TextField text_char, text_uni;
	private Button button_char, button_uni;
	public QueryFrame()
	{
		super("Unicode �ַ���ѯ");
		this.setBounds(500, 240, 280, 90); //�����ֱ�Ϊ��x�����꣬y�����꣬x���ȣ�y����
		this.setBackground(Color.lightGray); //���ñ���ɫ
		this.setLayout(new GridLayout(2, 3, 2, 2)); //���񲼾� 2�� 3�� ���ˮƽ���Ϊ2 ���������Ϊ2
		this.add(new Label("�ַ�", Label.RIGHT));
		text_char = new TextField("����",10);
		this.add(text_char);
		button_char = new Button("��ѯUnicode��");
		this.add(button_char);
		button_char.addActionListener(this); //Ϊ��ťע�������
		this.add(new Label("Unicode����",Label.RIGHT));
		text_uni = new TextField(10);
		this.add(text_uni);
		button_uni = new Button("��ѯ�ַ�");
		this.add(button_uni);
		button_uni.addActionListener(this);
		this.addWindowListener(new WinClose());
		
		this.setVisible(true); //����Ϊ�ɼ�
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource() == button_char)
		{
			String str = text_char.getText();
			if(str.equals(""))
				return;
			char ch = str.charAt(0);
			text_char.setText(""+ch);
			text_uni.setText(""+(int)ch);
		}
		else if(ev.getSource() == button_uni)
		{
			String str = text_uni.getText();
			if(str.equals(""))
				return;
			int uni = Integer.parseInt(str);
			text_char.setText(""+(char)uni);
		}
	}
	public static void main(String arg[])
	{new QueryFrame();}
}
class WinClose implements WindowListener //awt����
{
	public void windowClosing(WindowEvent ev)
	{
		System.exit(0);
	}
	public void windowOpened(WindowEvent ev) {}
	public void windowActivated(WindowEvent ev) {}
	public void windowDeactivated(WindowEvent ev) {}
	public void windowClosed(WindowEvent ev) {}
	public void windowIconified(WindowEvent ev) {}
	public void windowDeiconified(WindowEvent ev) {}
}

