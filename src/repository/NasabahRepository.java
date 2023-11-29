/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import model.NasabahModel;

/**
 *
 * @author HP
 */
public class NasabahRepository {

    private Connection connection;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query;
    NasabahModel NM = new NasabahModel();

    public NasabahRepository() {
        try {
            MySQLConnection mySQLConnection = new MySQLConnection();
            connection = mySQLConnection.getConnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean getNamaLengkap(String noRek) {
        try {
            query = "SELECT ID_nasabah from rekening WHERE no_rekening = ?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, noRek);
            rs = psmt.executeQuery();
            if (rs.next()) {
                String idNasabah = rs.getString("ID_nasabah");
                query = "SELECT nama_lengkap from user_bank WHERE ID_nasabah = ? AND role_id = 2";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, idNasabah);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    NM.setNamaLengkap(rs.getString("nama_lengkap"));
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
