package com.mystudy.ex01_generic;

//�Ϲ�Ŭ����
class Box extends Object {
	Object obj; //�ʵ� ������ Ÿ�� Object
	void setObj(Object obj) { this.obj = obj; }
	Object getObj() { return obj; }
}
//���ʸ� ����� Ŭ����
class BoxG<T> {
	T obj;
	void setObj(T obj) { this.obj = obj; }
	T getObj() { return obj; }
}


public class GenericExam {

	public static void main(String[] args) {
		/* ���ʸ�(Generic) : �÷����� � ��ü��� �̷�������� ǥ���ϴ� ��üŸ���� �ǹ�
		���ʸ��� ���� : <��ü�ڷ���>, <> - �����빮�� �ѱ��ڸ� ����ؼ� ǥ��
		API -> <T> : ��ü�ڷ���(Type), <E> : �ϳ��� ���(��ü �ϳ����ǹ� Element)
		       Map���� : <K, V> K�� Key, V�� Value(��, ������)
		-----------
		�÷���(Collection) �����ӿ�ũ : ��ü�� ��Ƽ� ó���� �� ������ 
			�������̽��� Ŭ������ ����ؼ� �۾�
		    Set<E>, List<E>, Queue<E>, Map<K, V>, Stack<E>
		******************************** */
		Box box = new Box();
		box.setObj("���ڿ�String");
		box.setObj(100);
		box.setObj(new Box());
		box.setObj(new Integer(1000));
		
		System.out.println(box.getObj());
		Integer integer = (Integer) box.getObj(); //Integer <--- Object
		System.out.println(integer.MAX_VALUE);
		
		System.out.println("----- ���ʸ� ��� ----");
		BoxG<Integer> boxg = new BoxG<>();
		boxg.setObj(1000);
		//boxg.setObj("���ڿ�String"); // ������ Ÿ������ Ȯ���ǹǷ� �ٸ� ������ Ÿ�� ���ȵ�
		Integer intNum = boxg.getObj();
		System.out.println(intNum.MAX_VALUE);
	}

}











