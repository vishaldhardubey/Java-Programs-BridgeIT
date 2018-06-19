package com.bridgelabz.structuraldesignpattern;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FacadeDesignPattern {
	public static void main(String[] args) {
		FacadeDesignMysql mysql=new FacadeDesignMysql();
		FacadeDesignOracle oracle=new FacadeDesignOracle();
		mysql.mySqlDBConnection();
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
		oracle.getOracleDBConnection();
	}
}
