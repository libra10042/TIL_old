package com.mystudy.ex01_generic;

//일반클래스
class Box extends Object {
	Object obj; //필드 변수의 타입 Object
	void setObj(Object obj) { this.obj = obj; }
	Object getObj() { return obj; }
}
//제너릭 적용된 클래스
class BoxG<T> {
	T obj;
	void setObj(T obj) { this.obj = obj; }
	T getObj() { return obj; }
}


public class GenericExam {

	public static void main(String[] args) {
		/* 제너릭(Generic) : 컬렉션이 어떤 객체들로 이루어졌는지 표시하는 객체타입을 의미
		제너릭의 형태 : <객체자료형>, <> - 영문대문자 한글자를 사용해서 표시
		API -> <T> : 객체자료형(Type), <E> : 하나의 요소(객체 하나를의미 Element)
		       Map형식 : <K, V> K는 Key, V는 Value(값, 데이터)
		-----------
		컬렉션(Collection) 프레임워크 : 객체를 모아서 처리할 때 정해진 
			인터페이스와 클래스를 사용해서 작업
		    Set<E>, List<E>, Queue<E>, Map<K, V>, Stack<E>
		******************************** */
		Box box = new Box();
		box.setObj("문자열String");
		box.setObj(100);
		box.setObj(new Box());
		box.setObj(new Integer(1000));
		
		System.out.println(box.getObj());
		Integer integer = (Integer) box.getObj(); //Integer <--- Object
		System.out.println(integer.MAX_VALUE);
		
		System.out.println("----- 제너릭 사용 ----");
		BoxG<Integer> boxg = new BoxG<>();
		boxg.setObj(1000);
		//boxg.setObj("문자열String"); // 지정된 타입으로 확정되므로 다른 데이터 타입 사용안됨
		Integer intNum = boxg.getObj();
		System.out.println(intNum.MAX_VALUE);
	}

}











