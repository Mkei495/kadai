package kadai04;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.StringTokenizer;

import javax.imageio.stream.FileImageInputStream;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		
		try{
		//読み込むcsv
		String csv = args.length>0 ? args[0] : "hunabashi.csv";
		//テーブル名
		String table = args.length>0 ? args[1] : "exam004";
		
		connection = DriverManager.getConnection("jdbc:sqlite:exam004.db");
		java.sql.Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		
		//テーブルがなかったら作成する
		statement.executeUpdate("create table if not exists " + table + " (day text, max real, min real");
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(csv))));
			//一行ずつ読み込む
			String line = "";
			//インサートする文
			String insert = "";
			//ヘッダーフラグ
			boolean header = true;
			
			while((line = br.readLine()) != null){
				StringTokenizer token = new StringTokenizer(line,",");
				int column_queue = 0;
				
				while(token.hasMoreTokens()){
					String tmpString = token.nextToken();
					System.out.println(tmpString);//後で消す
					if(column_queue == 0){
						insert += "/'" + tmpString + "/',";
					}else{
						insert += tmpString + ",";
					}
					column_queue++;
				}
			}
		}
		}
	}

	
}
