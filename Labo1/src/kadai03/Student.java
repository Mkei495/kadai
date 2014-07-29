package kadai03;

public class Student extends Person{
	String clazz;

	Student(String name,int age,String address,String clazz) {
		super(name, age, address);
		this.clazz = clazz;
	}

	void print(){
		super.print();
		System.out.println("クラス:" + clazz);
	}
}
