/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Util.StructureData;
import java.sql.*;
import java.util.ArrayList;
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
    StructureData SD = new StructureData();
    ArrayList<String[]> dataTransaction = new ArrayList<>();

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
    
    public boolean viewTransactionNasabah(String no_rekening) {
        try {
            query = "SELECT DISTINCT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                    + "FROM transfer WHERE no_rekening = ? "
                    + "UNION "
                    + "SELECT DISTINCT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                    + "FROM setor_tunai WHERE no_rekening = ? "
                    + "UNION "
                    + "SELECT DISTINCT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                    + "FROM tarik_tunai WHERE no_rekening  = ? ";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, no_rekening);
            psmt.setString(2, no_rekening);
            psmt.setString(3, no_rekening);
            rs = psmt.executeQuery();
            dataTransaction.clear();
            while (rs.next()) {
                String[] row = new String[4];
                row[0] = rs.getString("Tanggal_Transaksi");
                row[1] = rs.getString("Jenis_Transaksi");
                row[2] = rs.getString("Jumlah_Transaksi");
                row[3] = rs.getString("keterangan");

                dataTransaction.add(row);
            }
            SD.bubbleSortTransactionByDate(dataTransaction);
            NM.setDataTransaction(dataTransaction);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
