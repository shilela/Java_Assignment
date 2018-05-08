import java.util.Scanner;
public class Josephus {
	
	private int total;
	private int no, d;
	private char ring[];
	
	public Josephus(int total , int no , int d)
	{
		this.total = total;
		this.d = d - 1;
		this.no = no - 1;
		this.ring = new char[total];
		for(int i = 0;i < this.ring.length;i++)
			this.ring[i] = (char)(i+65);
	}
	public void play()
	{
		while(this.total > 1)
		{
			this.no = (this.no + this.d) % this.total;
			System.out.println(this.ring[this.no]+"±ª…±À¿");
			for(int i = this.no;i < this.total - 1;i++)
				this.ring[i] = this.ring[i+1];
			this.total--;
		}
		System.out.println(this.ring[0]+"¥ÊªÓ");
	}
	public static void main(String[] args) 
	{
		int total, no , d;
		Scanner scan = new Scanner(System.in);
		total = scan.nextInt();
		no = scan.nextInt();
		d = scan.nextInt();
		Josephus jos = new Josephus(total, no, d);
		jos.play();
		scan.close();
	}
}