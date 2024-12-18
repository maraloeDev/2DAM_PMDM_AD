package com.maraloedev.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;

@Resource(name = "jdbc/MySQL")
public class ConexionBD {
	
		public static Connection getConnection() throws SQLException, NamingException {
			
			return ((DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQL")).getConnection();
			}

		}