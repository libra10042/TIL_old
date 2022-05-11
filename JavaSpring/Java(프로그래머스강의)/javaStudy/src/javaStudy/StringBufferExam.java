package javaStudy;

public class StringBufferExam {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("world");
		
		String str = sb.toString();
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = sb2.append("hello"); 
		if(sb2 == sb3) 
			//@dec sb2�� �ڱ� �ڽ��� ��ȯ�ϹǷ� sb2 == sb3�� ��ȯ�Ѵ�.
			//�޼ҵ� ü�̴��̶�� �Ѵ�.(�ڱ��ڽ��� �����ϰ� ����ؼ� �ڽ��� �޼ҵ带 ȣ���ϴ� ���.)
			System.out.println("sb2 == sb3");
		
		
		String str2 = new StringBuffer().append("hello").append(" ").append("world").toString(); 
		System.out.println(str2);
		
	}
}
