//1.txt encode into 2.txt
//2.txt decode into 3.txt
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class CodeFileJFrame extends JFrame implements ActionListener
{
    private JButton encodeButton, decodeButton;
    private MessageJDialog jdialog;
    public CodeFileJFrame()
    {
        super("Encode/Decode");
        this.setBounds(200, 300, 300, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        encodeButton = new JButton("Encode");
        this.add(encodeButton);
        decodeButton = new JButton("Decode");
        this.add(decodeButton);
        decodeButton.setEnabled(false);
        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);
        jdialog = new MessageJDialog();
        this.setVisible(true);
    }
    private class MessageJDialog extends JDialog
    {
        private JLabel jlabel;
        public MessageJDialog()
        {
            super(CodeFileJFrame.this, "prompt", true);
            //对话框依附于CodeFileJFrame.this，true表示模式窗口
            this.setSize(300, 80);
            jlabel = new JLabel("",JLabel.CENTER);//居中对齐
            this.add(jlabel);
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);//单击关闭按钮，隐藏对话框
        }
        public void show(String message)
        {
            jlabel.setText(message);
            this.setLocation(CodeFileJFrame.this.getX() + 100, CodeFileJFrame.this.getY() + 100);
            this.setVisible(true);
        }
    }
    private void encode() throws IOException
    {
        int ch;
        FileReader fr = new FileReader("1.txt");
        FileWriter fw = new FileWriter("2.txt");
        while((ch = fr.read()) != -1)
        {
            ch = (ch + 1) % 128;
            fw.write(ch);
        }
        fr.close();
        fw.close();
    }
    private void decode() throws IOException
    {
    	int ch;
        FileReader fr = new FileReader("2.txt");
        FileWriter fw = new FileWriter("3.txt");
        while((ch = fr.read()) != -1)
        {
            ch = (ch - 1);
            if(ch == -1)
            	ch = 127;
            fw.write(ch);
        }
        fr.close();
        fw.close();
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource() == encodeButton)
        {
            try {
				encode();
				jdialog.show("1.txt has been encoded into 2.txt");
			} catch (IOException e) {
				jdialog.show("1.txt can't find");
			}
            encodeButton.setEnabled(false);
            decodeButton.setEnabled(true);
        }
        else if(ev.getSource() == decodeButton)
        {
            try {
				decode();
				jdialog.show("2.txt has been decoded into 3.txt");
			} catch (IOException e) {
				jdialog.show("2.txt can't find");
			}
            encodeButton.setEnabled(true);
            decodeButton.setEnabled(false);
        }
    }
    public static void main(String[] args) 
    {
        new CodeFileJFrame();
    }
}