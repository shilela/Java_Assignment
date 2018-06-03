public class Trans {

	static final String[] a = {"0","1","2","3","4","5","6","7","8","9"};
	static final String[] b = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	static final String[] c = {"","圆","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};
	public static String trans(String num)
	{
		String trans = "";
		if(num.length() > 12)
			return "太大了";
		else
		{
			for(int i = 1;num.length() - i >= 0;i++)
			{
				trans = b[(int)(num.charAt(num.length() - i))-48] + c[i] + trans;
			}
		}
			return trans;
	}
	public static void main(String[] args) {
		String number = "123456789";
		System.out.println(trans(number));
	}
}