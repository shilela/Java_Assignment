package raiseFlag;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class RaiseFlagJFrame extends JFrame implements ChangeListener{

	private FlagCanvas canvas; //画布
	private JSpinner spinner; //微调
	
	public RaiseFlagJFrame()
	{
		super("RaiseFlag");
		this.setBounds(100, 100, 600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.canvas = new FlagCanvas(100);
		canvas.setBackground(new Color(240, 255, 255));
		this.add(this.canvas);
		JPanel panel = new JPanel();
		this.add(panel,"South");
		panel.add(new JLabel("Delay"));
		SpinnerNumberModel model = new SpinnerNumberModel(50, 10, 300, 10); //初始值，最小值，最大值，步长
		this.spinner = new JSpinner(model);
		this.spinner.addChangeListener(this); //添加ChangeListener监听器
		panel.add(this.spinner);
		this.setVisible(true);
	}
	public void stateChanged(ChangeEvent ev) //ChangeListener监听器
	{
		this.canvas.setDelay(Integer.parseInt(""+this.spinner.getValue()));
	}
	public static void main(String args[])
	{
		new RaiseFlagJFrame();
	}
	
	class FlagCanvas extends Canvas implements ActionListener
	{
		private ObjectInfo flagInfo, sunInfo;
		private Timer timer;
		private class ObjectInfo //私有内部类
		{
			int x, y;
			Color color;
			ObjectInfo(int x, int y, Color color)
			{
				this.x = x;
				this.y = y;
				this.color = color;
			}
		}
		public FlagCanvas(int delay)
		{
			this.flagInfo = new ObjectInfo(150, 330, Color.RED);
			this.sunInfo = new ObjectInfo(420, 0, Color.ORANGE);
			timer = new Timer(delay, this);
			timer.start();
		}
		public void setDelay(int delay) //timer私有，所以使用公有的setDelay函数，来让外部调整Delay值
		{
			timer.setDelay(delay);
		}
		public void paint(Graphics g)
		{
			g.setColor(new Color(47, 79, 79));
			g.fillRect(100, 400, 100, 10);
			g.fillRect(120, 380, 60, 20);
			g.setColor(new Color(192, 192, 192));
			g.fillRect(145, 130, 10, 250);
			g.setColor(flagInfo.color);
			g.fillRect(flagInfo.x, flagInfo.y, 80, 50);
			g.setColor(sunInfo.color);
			g.fillOval(sunInfo.x, sunInfo.y, 80, 80);
			if(flagInfo.y > 130 && sunInfo.x > 0 && sunInfo.x <= 420)
				flagInfo.y -= 5;
			else if(flagInfo.y <= 130 && sunInfo.x > -80)
				sunInfo.x -= 10;
			else if(flagInfo.y < 330 && sunInfo.x <= -80)
				flagInfo.y += 5;
			else
			{
				if(sunInfo.x < 0)
				{
					canvas.setBackground(new Color(25, 25, 112));
					sunInfo.x = 900;
				}
				else
				{
					sunInfo.x -= 10;
					if(sunInfo.x == 650)
						canvas.setBackground(new Color(240, 255, 255));
				}
			}
		}
		public void actionPerformed(ActionEvent ev) //repaint()函数重画
		{
			repaint();
		}
	}
}
