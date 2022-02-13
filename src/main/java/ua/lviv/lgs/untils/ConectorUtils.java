package ua.lviv.lgs.untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConectorUtils {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "namor2004";
	private static String URL ="jdbc:mysql://localhost/My_shop";
	
	@SuppressWarnings("deprecation")
	public static Connection connection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DOMConfigurator.configure("/home/roman/eclipse-workspace/Magazine_Of_Pages_Lesson_04/LogerConfig.xml");
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
	
}
