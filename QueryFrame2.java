package unicode_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;

public class QueryFrame2 extends JFrame implements ActionListener
{
	private JTextField text;
	private DefaultTableModel tablemodel;
	
	public QueryFrame2()
	{
		super("unicode×Ö·û´®²éÑ¯Æ÷");
		this.setBounds(300, 240, 280, 200);
		this.setBackground(Color.lightGray);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		this.add(panel,"North");
		panel.add(new JLabel("×Ö·û´®"));
		text = new JTextField("²éÑ¯ºº×Ö±àÂë",15);
		panel.add(text);
		text.addActionListener(this);
		String titles[] = {"×Ö·û", "unicodeÖµ"};
		this.tablemodel = new DefaultTableModel(titles, 0); //µÚ0ÐÐ¹Ì¶¨Îªtitles
		JTable jtable =new JTable(this.tablemodel);
		this.add(new JScrollPane(jtable));
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ev) {
		char ch;
		String str = text.getText();
		if(str.equals(""))
			return;
		this.tablemodel.setRowCount(str.length());
		for(int i = 0; i < str.length(); i++) //Ñ­»·°Ñ×Ö·û´®×ª»»³ÉunicodeÖµ
		{
			ch = str.charAt(i);
			this.tablemodel.setValueAt(ch+"", i, 0);
			this.tablemodel.setValueAt(""+(int)ch, i, 1);
		}
		
	}
	public static void main(String arg[])
	{
		new QueryFrame2();
	}
}
