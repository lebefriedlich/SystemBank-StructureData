/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.AdminModel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class AdminRepository {

    AdminModel AM = new AdminModel();
    private Connection connection;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query;
    ArrayList<String[]> dataNasabah = new ArrayList<>();
    ArrayList<String[]> dataAdmin = new ArrayList<>();

    public AdminRepository() {
        try {
            MySQLConnection mySQLConnection = new MySQLConnection();
            connection = mySQLConnection.getConnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean viewAllNasabah() {
        try {
            query = "SELECT u.nama_lengkap, u.username, u.password, u.no_hp, u.email, r.no_rekening, r.Saldo, u.status "
                    + "FROM user_bank AS u JOIN rekening AS r ON u.ID_nasabah = r.ID_nasabah "
                    + "JOIN roles AS ro ON ro.role_id = u.role_id "
                    + "WHERE ro.role_name = 'User'";
            stat = connection.createStatement();
            rs = stat.executeQuery(query);
            dataNasabah.clear();
            while (rs.next()) {
                String[] row = new String[8];
                row[0] = rs.getString("r.no_rekening");
                row[1] = rs.getString("u.nama_lengkap");
                row[2] = rs.getString("u.username");
                row[3] = rs.getString("u.password");
                row[4] = rs.getString("u.no_hp");
                row[5] = rs.getString("u.email");
                row[6] = rs.getString("r.Saldo");
                row[7] = rs.getString("u.status");

                dataNasabah.add(row);
            }
            AM.setDataNasabah(dataNasabah);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean viewAllAdmin() {
        try {
            query = "SELECT u.nama_lengkap, u.username, u.password, u.no_hp, u.email, r.no_rekening, r.Saldo, u.status "
                    + "FROM user_bank AS u JOIN rekening AS r ON u.ID_nasabah "
                    + "JOIN roles AS ro ON ro.role_id = u.role_id "
                    + "WHERE ro.role_name = 'Admin'";
            stat = connection.createStatement();
            rs = stat.executeQuery(query);
            while (rs.next()) {
                String[] row = new String[8];
                row[0] = rs.getString("r.no_rekening");
                row[1] = rs.getString("u.nama_lengkap");
                row[2] = rs.getString("u.username");
                row[3] = rs.getString("u.password");
                row[4] = rs.getString("u.no_hp");
                row[5] = rs.getString("u.email");
                row[6] = rs.getString("r.Saldo");
                row[7] = rs.getString("u.status");

                dataAdmin.add(row);
            }
            AM.setDataAdmin(dataAdmin);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean editData(String username, String password, String noTelepon, String email, String namaLengkap) {
        query = "UPDATE user_bank SET username =?, password =?, no_hp =?, email =? WHERE nama_lengkap =?";
        try {
            psmt = connection.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            psmt.setString(3, noTelepon);
            psmt.setString(4, email);
            psmt.setString(5, namaLengkap);
            psmt.executeUpdate();
            psmt.close();
            viewAllNasabah();
            return true;
        } catch (SQLException e) {
            System.out.println("Data Gagal Diubah" + e);
            return false;
        }
    }

    public boolean activeOrNon(String namaLengkap, String status) {
        query = "UPDATE user_bank SET status = ? WHERE username = ?";
        try {
            psmt = connection.prepareStatement(query);
            psmt.setString(1, status);
            psmt.setString(2, namaLengkap);
            psmt.executeUpdate();
            psmt.close();
            viewAllNasabah();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
