package kadai03;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Person a = new Person("船橋太郎",20,"千葉県船橋市");
		Teacher b = new Teacher("船橋花子",22,"千葉県千葉市中央区","3G1");
		Student c = new Student("朝賀先生",99,"千葉県xxx市","ネットワーク科");
		ClubMember d = new ClubMember("松元ぶちょー",20,"ワシントンD.C","2G1","技術部");

		ArrayList<Person> arr = new ArrayList<Person>();
		
		arr.add(a);
		arr.add(b);
		arr.add(c);
		arr.add(d);
		
		for(int i=0 ; i < arr.size() ; i++){
		
		arr.get(i).print();
		}
	}

}
