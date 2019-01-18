
package sqlandjava;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement;
public class Assignment3 {
public static Connection getConnection() throws Exception {
	try {
		String url = "jdbc:mysql://localhost:3306/sqlandjava";
		String username = "user";
		String password = "password";

		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected to Database!");
		return conn;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
}

public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	Connection conn = getConnection();

	Statement statement = conn.createStatement();
	Statement statement1 = conn.createStatement();
	Statement statement2 = conn.createStatement();

	ResultSet resOwners = statement.executeQuery("Select * from owners");

	while (resOwners.next()) {

		String personId = resOwners.getString("person_id");
		String carId = resOwners.getString("car_id");
		String personName = null, carBrand = null, carColor = null;

		ResultSet resPeople = statement1.executeQuery("Select * from people where person_id=" + personId);

		while (resPeople.next()) {
			personName = resPeople.getString("firstname");
			// System.out.println(personName);
		}

		ResultSet resCar = statement2.executeQuery("Select * from cars where car_id=" + carId);

		while (resCar.next()) {
			carColor = resCar.getString("color");
			carBrand = resCar.getString("Brand");

			// System.out.println(carColor);
			// System.out.println(carBrand);
		}

		System.out.println(personName + " owns " + carColor + " " + carBrand);
	}
}
}
Connected to Database!
Carl owns Red Audi
Anna owns Green Ford
Erik owns Blue Saab
Gina owns Black Volvo
