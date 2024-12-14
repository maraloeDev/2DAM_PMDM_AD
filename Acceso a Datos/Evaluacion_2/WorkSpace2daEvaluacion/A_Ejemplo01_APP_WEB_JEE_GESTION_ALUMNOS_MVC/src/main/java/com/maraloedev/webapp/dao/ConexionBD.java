package com.maraloedev.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
		public static Connection getConnection() throws SQLException {
			
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculas", "root", "");
			}

		}