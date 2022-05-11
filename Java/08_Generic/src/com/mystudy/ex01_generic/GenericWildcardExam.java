package com.mystudy.ex01_generic;

//제너릭 적용된 클래스
class BoxT<T> {
	T obj;
	void setObj(T obj) { this.obj = obj; }
	T getObj() { return obj; }
}

public class GenericWildcardExam  extends Object {

	public static void main(String[] args) {
		// 제너릭(Generic) : 와일드카드(Wildcard - 대표문자)
		// 1. <?> : 모든 타입(객체) 자료형에 대한 대표문자를 의미
		// 2. <? extends 자료형> : 자료형을 상속받은 하위(sub) 클래스 타입 사용(자료형 포함)
		// 3. <? super 자료형> : 자료형의 상위(super) 타입 사용
		BoxT<String> box1 = new BoxT<>();
		box1.setObj("문자열");
		
		BoxT<Integer> box2 = new BoxT<>();
		//box2.setObj("문자열"); //컴파일오류
		box2.setObj(100);
		box2.setObj(new Integer(999));
		
		System.out.println("----- <?> : 모든 데이터 타입 ---------");
		//<?> : 모든 데이터 타입을 담을 수 있는 형태(Object와 동일한 효과)
		BoxT<?> box3 = new BoxT<String>();
		box3 = new BoxT<Integer>();
		box3 = new BoxT<StringBuilder>();
		
		// 2. <? extends 자료형> : 자료형을 상속받은 하위(sub) 클래스 타입 사용(자료형 포함)
		BoxT<? extends Number> box10 = null;
		box10 = new BoxT<Number>();
		box10 = new BoxT<Integer>();
		box10 = new BoxT<Double>();
		
		//컴파일오류 : Type mismatch: cannot convert from BoxT<String> to BoxT<? extends Number>
		//box10 = new BoxT<String>(); //컴파일오류
		//box10 = new BoxT<Object>(); //컴파일오류
		
		//------------------------
		// 3. <? super 자료형> : 자료형의 상위(super) 타입 사용
		BoxT<? super Number> box20 = null;
		box20 = new BoxT<Number>();
		box20 = new BoxT<Object>();
		
		//컴파일 오류 : Type mismatch: cannot convert from BoxT<Integer> to BoxT<? super Number>
		//box20 = new BoxT<Integer>(); //컴파일오류
	}

}





















