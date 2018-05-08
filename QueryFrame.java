package unicode;

import java.awt.*;
import java.awt.event.*;
public class QueryFrame extends Frame implements ActionListener
{
	private TextField text_char, text_uni;
	private Button button_char, button_uni;
	public QueryFrame()
	{
		super("Unicode 字符查询");
		this.setBounds(500, 240, 280, 90); //参数分别为，x轴坐标，y轴坐标，x长度，y长度
		this.setBackground(Color.lightGray); //设置背景色
		this.setLayout(new GridLayout(2, 3, 2, 2)); //网格布局 2行 3列 组件水平间距为2 组件纵向间距为2
		this.add(new Label("字符", Label.RIGHT));
		text_char = new TextField("汉字",10);
		this.add(text_char);
		button_char = new Button("查询Unicode码");
		this.add(button_char);
		button_char.addActionListener(this); //为按钮注册监听器
		this.add(new Label("Unicode编码",Label.RIGHT));
		text_uni = new TextField(10);
		this.add(text_uni);
		button_uni = new Button("查询字符");
		this.add(button_uni);
		button_uni.addActionListener(this);
		this.addWindowListener(new WinClose());
		
		this.setVisible(true); //设置为可见
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
class WinClose implements WindowListener //awt特有
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

