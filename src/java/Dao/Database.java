/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Diana
 */
public interface Database {

    public static Connection getConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/itg_time_module?zeroDateTimeBehavior=convertToNull","root","");
        return con;
        
} catch (Exception ex) {
    System.out.println("Database.getConnection() Error -->" +ex.getMessage());
return null;
        }
            }
        static void close(Connection con) {
            try {
            con.close();
            }catch (Exception ex) {

                }
            }
        }

        
