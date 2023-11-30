/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Util.StructureData;
import model.AdminModel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class AdminRepository {

    AdminModel AM = new AdminModel();
    StructureData SD = new StructureData();
    private Connection connection;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query;
    ArrayList<String[]> dataNasabah = new ArrayList<>();
    ArrayList<String[]> dataAdmin = new ArrayList<>();
    ArrayList<String[]> dataTransaction = new ArrayList<>();

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
        query = "UPDATE user_bank SET username =?, password =?, no_hp =?, email =? WHERE nama_lengkap = ? AND role_id = 2";
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
            return false;
        }
    }

    public boolean deleteNasabah(String noRekening) {
        try {
            query = "SELECT ID_nasabah from rekening WHERE no_rekening = ?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, noRekening);
            rs = psmt.executeQuery();
            if (rs.next()) {
                String idNasabah = rs.getString("ID_nasabah");
                query = "DELETE FROM user_bank WHERE user_bank.ID_nasabah = ?";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, idNasabah);
                psmt.executeUpdate();
                psmt.close();
                viewAllNasabah();
                viewAllTransactionNasabah();
            }
            return true;
        } catch (SQLException e) {
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

    public boolean viewAllTransactionNasabah() {
        try {
            query = "SELECT tt.Tanggal_Transaksi, r.no_rekening, ub.nama_lengkap, tt.Jenis_Transaksi, tt.Jumlah_Transaksi, tt.keterangan "
                    + "FROM tarik_tunai tt JOIN rekening r ON tt.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah "
                    + "UNION "
                    + "SELECT st.Tanggal_Transaksi, st.no_rekening, ub.nama_lengkap, st.Jenis_Transaksi, st.Jumlah_Transaksi, st.keterangan "
                    + "FROM setor_tunai st JOIN rekening r ON st.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah "
                    + "UNION "
                    + "SELECT tf.Tanggal_Transaksi, tf.no_rekening, ub.nama_lengkap, tf.Jenis_Transaksi, tf.Jumlah_Transaksi, tf.keterangan "
                    + "FROM transfer tf JOIN rekening r ON tf.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah";
            psmt = connection.prepareStatement(query);
            rs = psmt.executeQuery();
            dataTransaction.clear();
            while (rs.next()) {
                String[] row = new String[6];
                row[0] = rs.getString("Tanggal_Transaksi");
                row[1] = rs.getString("no_rekening");
                row[2] = rs.getString("nama_lengkap");
                row[3] = rs.getString("Jenis_Transaksi");
                row[4] = rs.getString("Jumlah_Transaksi");
                row[5] = rs.getString("keterangan");

                dataTransaction.add(row);
            }
            SD.bubbleSortTransactionByDate(dataTransaction);
            AM.setDataTransaction(dataTransaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean viewTransactionNasabah(String noRekening) {
        try {
            query = "SELECT tt.Tanggal_Transaksi, r.no_rekening, ub.nama_lengkap, tt.Jenis_Transaksi, tt.Jumlah_Transaksi, tt.keterangan "
                    + "FROM tarik_tunai tt JOIN rekening r ON tt.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah WHERE tt.no_rekening = ?"
                    + "UNION "
                    + "SELECT st.Tanggal_Transaksi, st.no_rekening, ub.nama_lengkap, st.Jenis_Transaksi, st.Jumlah_Transaksi, st.keterangan "
                    + "FROM setor_tunai st JOIN rekening r ON st.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah WHERE st.no_rekening = ?"
                    + "UNION "
                    + "SELECT tf.Tanggal_Transaksi, tf.no_rekening, ub.nama_lengkap, tf.Jenis_Transaksi, tf.Jumlah_Transaksi, tf.keterangan "
                    + "FROM transfer tf JOIN rekening r ON tf.no_rekening = r.no_rekening "
                    + "JOIN user_bank ub ON r.ID_nasabah = ub.ID_nasabah WHERE tf.no_rekening = ?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, noRekening);
            psmt.setString(2, noRekening);
            psmt.setString(3, noRekening);
            rs = psmt.executeQuery();
            dataTransaction.clear();
            while (rs.next()) {
                String[] row = new String[6];
                row[0] = rs.getString("Tanggal_Transaksi");
                row[1] = rs.getString("no_rekening");
                row[2] = rs.getString("nama_lengkap");
                row[3] = rs.getString("Jenis_Transaksi");
                row[4] = rs.getString("Jumlah_Transaksi");
                row[5] = rs.getString("keterangan");

                dataTransaction.add(row);
            }
            SD.bubbleSortTransactionByDate(dataTransaction);
            AM.setDataTransaction(dataTransaction);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean getStatus(String username) {
        try {
            query = "SELECT status from user_bank WHERE username = ?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, username);
            rs = psmt.executeQuery();
            if (rs.next()) {
                AM.setStatusNasabah(rs.getString("status"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
