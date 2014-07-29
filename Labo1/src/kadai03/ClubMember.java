package kadai03;

public class ClubMember extends Student{
	String club;

	ClubMember(String name,int age,String address,String clazz,String club) {
		super(name, age, address, clazz);
		this.club = club;
	}

	void print(){
		super.print();
		System.out.println("部活動:" + club);
	}
}
