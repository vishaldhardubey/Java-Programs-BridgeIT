package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionPool {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
     static final String JDBC_DB_URL ="jdbc:mysql://localhost:3306/Student_Info";
     // JDBC Database Credentials
     static final String JDBC_USER = "root";
     static final String JDBC_PASS = "root";

     private static GenericObjectPool gPool=null;

     public DataSource setUpPool() throws ClassNotFoundException {
    Class.forName(JDBC_DRIVER);

    gPool=new GenericObjectPool();
    gPool.setMaxActive(5);
    ConnectionFactory cf=new
DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER,JDBC_PASS);

    PoolableConnectionFactory pcf=new PoolableConnectionFactory(cf,
gPool, null, null, false, true);

return new PoolingDataSource(gPool);
     }
     public GenericObjectPool getConnectionPool() {
         return gPool;
     }
     private void printDbStatus() {
         System.out.println("Max.: " +
getConnectionPool().getMaxActive() + "; Active: " +
getConnectionPool().getNumActive() + "; Idle: " +
getConnectionPool().getNumIdle());
     }

     public static void main(String[] args) {
    ResultSet rsObj = null;
    Connection connObj = null;
    PreparedStatement pstmtObj = null;
    ConnectionPool cPool=new ConnectionPool();

    try {
DataSource dataSource=cPool.setUpPool();
System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
            connObj = dataSource.getConnection();
            cPool.printDbStatus();
            pstmtObj = connObj.prepareStatement("SELECT * FROM student_info");
            rsObj = pstmtObj.executeQuery();
            while (rsObj.next()) {
                System.out.println("Username: " +
rsObj.getString("regNo"));
            }
            System.out.println("\n=====Releasing Connection Object To Pool=====\n");
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                // Closing ResultSet Object
                if(rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if(pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if(connObj != null) {
                    connObj.close();
                }
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
        cPool.printDbStatus();
    }

}


