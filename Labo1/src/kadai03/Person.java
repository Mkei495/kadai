package kadai03;

public class Person {
	String name;
	int age;
	String address;

	Person(String name,int age,String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	void print(){
		System.out.println("名前:" + name);
		System.out.println("年齢:" + age);
		System.out.println("住所:" + address);
	}
}
