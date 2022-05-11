package com.mystudy.bean02;

/* �ڹٺ�(Java Bean) ���� ��Ģ 
- �������(property)�� ���������ڴ� private
- �������(property) ���� get/set �޼ҵ� ����(���������� get�� ����)
- get/set �޼ҵ�� public
- get �޼ҵ�� �Ķ���� ����, set �޼ҵ�� �ϳ� �̻��� �Ķ���� ����
- �������(property)�� boolean Ÿ���̸� get �޼ҵ� ��� is �޼ҵ� ��밡��
- �ܺο��� �������(property) ���ٽÿ��� get/set �޼ҵ带 ���� ����
 */
public class Student extends Object {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int tot;
	private double avg;
	
	//������ ����� ----------------------
	//������1 : �⺻������
	//������2 : name �ʵ尪 �޾� ����
	//������3 : name, kor, eng, math �ʵ尪 �޾� ����
	//--------
	// ���콺������ư > source > Generate ...
	// ctrl + shift + s > Generate ...
	public Student() {
		//super : �θ�Ŭ����(super Ŭ����)�� �ǹ�
		//super() : �θ�Ŭ������ �⺻ ������ ȣ��
		super();
	}
	public Student(String name) {
		super(); //�� ù�ٿ� �ۼ� - �θ�Ŭ������ ������ ȣ��(��������)
		this.name = name;
	}
	public Student(String name, int kor, int eng, int math) {
		//���� ��ü�� ������ ȣ�� : ������ ����
		//this(name); //this ���簴ü�� String Ÿ�� �Ķ���Ͱ� �޴� ������
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}
	
	public Student(String name, int kor, int eng, int math, 
			int tot, double avg) {
		this(name, kor, eng, math); //���簴ü�� ������ ȣ�� ����
		this.tot = tot;
		this.avg = avg;
	}
	//set�޼ҵ�(setter, set property) : ����Ÿ�� void, �Ķ���Ͱ� ����
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		if (kor < 0 || kor > 100) {
			System.out.println("[���ܹ߻�] ��������(0~100) ���� �ƴ�");
			return;
		}
		this.kor = kor;
		computeTotAvg();
	}
	
	//get�޼ҵ�(getter, get property) : ���ϰ� ����, �Ķ���Ͱ� ����
	public String getName() {
		return this.name;
	}
	public int getKor() {
		return this.kor;
		
	}

	//(�ǽ�) eng, math, tot, avg �ʵ��� setter �ۼ�
	//(�ǽ�) eng, math, tot, avg �ʵ��� getter �ۼ�
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg();
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		computeTotAvg();
	}
	public int getTot() {
		return tot;
	}
	
	//�ʿ信 ���� setter, getter�� �������� �ʱ⵵ ��
//	public void setTot(int tot) {
//		this.tot = tot;
//	}

	public double getAvg() {
		return avg;
	}
	//�ʿ信 ���� setter, getter�� �������� �ʱ⵵ ��
//	public void setAvg(double avg) {
//		this.avg = avg;
//	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg + "]";
	}
	
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
}













