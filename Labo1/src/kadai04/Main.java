package kadai04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	Main() throws SQLException{
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:exam004.db");
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}

		sakusei();
		pirintOut();
		max();
		min();
		avg();
		
		rs.close();
		stmt.close();
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new Main();
	}

	void sakusei(){
		try{
			//読み込むcsv
			String csv ="hunabashi.csv";
			//テーブル名
			String table = "exam004";

			//テーブルがなかったら作成する
			stmt.executeUpdate("create table if not exists " + table + " (day text, maxa real, mina real, avga real");

			try{
				BufferedReader br = new BufferedReader((new FileReader(csv)));

				//一行ずつ読み込む
				String line;
				rs = stmt.executeQuery("select * from exam004");

				while((line = br.readLine()) != null){
					String x[] = line.split(",");
					stmt.execute("insert into exam004 values('" + x[0] + "'," + x[1]+ "," + x[2] + "," + x[3] + ")");
				}

				br.close();
			}catch(Exception e){
				e.printStackTrace();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	void pirintOut(){
		try{
			while (rs.next()) {
				String day = rs.getString("day");
				String max = rs.getString("maxa");
				String min = rs.getString("mina");
				String avg = rs.getString("avga");
				System.out.println(day + "|" + max + "|" + min + "|" + avg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void max() {
		try {
			rs = stmt.executeQuery("select day from exam004 where maxa = (select max(maxa) from exam004)");
			SimpleDateFormat si = new SimpleDateFormat("yyyy/mm/dd");
			Date mad = si.parse(rs.getString("day"));
			System.out.println("最高気温日:"+mad);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void min() {
		try {
			rs = stmt.executeQuery("select day from exam004 where mina = (select min(mina) from exam004)");

			SimpleDateFormat si = new SimpleDateFormat("yyyy/mm/dd");
			Date mid = si.parse(rs.getString("day"));
			System.out.println("最低気温日:" + mid);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void avg() {
		try {
			rs = stmt.executeQuery("select avg(avga) from exam004");
			System.out.println("平均気温:"+rs.getFloat(1));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
