package com.example.hotel_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HotelManagementApplication.class, args);

		// Retrieve the DataSource bean
		DataSource dataSource = context.getBean(DataSource.class);

		try (Connection connection = dataSource.getConnection()) {
			if (connection != null) {
				System.out.println("Successfully connected to the database.");
			} else {
				System.err.println("Failed to connect to the database.");
			}
		} catch (SQLException e) {
			System.err.println("Error connecting to the database: " + e.getMessage());
		}
	}
}