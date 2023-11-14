/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Util.StructureData;
import model.TransactionModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class TransactionRepository {

    private Connection connection;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query;
    TransactionModel TM = new TransactionModel();
    StructureData SD = new StructureData();
    ArrayList<String[]> dataTransaction = new ArrayList<>();

    public TransactionRepository() {
        try {
            MySQLConnection mySQLConnection = new MySQLConnection();
            connection = mySQLConnection.getConnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean checkLogin(String username, String password) {
        try {
            query = "SELECT u.nama_lengkap, r.no_rekening, r.Saldo, u.role_id, u.status "
                    + "FROM user_bank AS u "
                    + "JOIN rekening AS r ON u.ID_Nasabah = r.ID_Nasabah "
                    + "WHERE u.Username = ? AND u.Password = ?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                TM.setNamaLengkap(rs.getString("u.nama_lengkap"));
                TM.setNoRek(rs.getString("r.no_rekening"));
                TM.setSaldo(rs.getDouble("r.Saldo"));
                TM.setRole(rs.getString("u.role_id"));
                TM.setStatusLogin(rs.getString("u.status"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
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
            TM.setDataTransaction(dataTransaction);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int registrasi(String namaLengkap, String username, String password, String no_hp, String email, Double nominal, String role) {
        query = "INSERT INTO user_bank (nama_lengkap, username, password, no_hp, email, status, role_id) VALUES (?,?,?,?,?,?,?)";
        try {
            psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, namaLengkap);
            psmt.setString(2, username);
            psmt.setString(3, password);
            psmt.setString(4, no_hp);
            psmt.setString(5, email);
            psmt.setString(6, "Active");
            psmt.setString(7, role);
            psmt.executeUpdate();
            rs = psmt.getGeneratedKeys();
            String idnasabah = "";
            if (rs.next()) {
                idnasabah += rs.getString(1);
            }
            rs.close();
            psmt.close();
            query = "INSERT INTO rekening (ID_nasabah, Saldo) VALUES (?,?)";
            try {
                psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                psmt.setString(1, idnasabah);
                psmt.setDouble(2, nominal);
                psmt.executeUpdate();
                rs = psmt.getGeneratedKeys();
                String noRek = "";
                if (rs.next()) {
                    noRek += rs.getString(1);
                }
                rs.close();
                psmt.close();
                query = "INSERT INTO setor_tunai (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                try {
                    psmt = connection.prepareStatement(query);
                    psmt.setString(1, noRek);
                    psmt.setString(2, "Setor Tunai");
                    psmt.setDouble(3, nominal);
                    psmt.setString(4, "Berhasil");
                    psmt.executeUpdate();
                    psmt.close();
                    return 0;
                } catch (SQLException e) {
                    return 1;
                }
            } catch (SQLException e) {
                return 2;
            }
        } catch (SQLException e) {
            return 3;
        }
    }

    public boolean checkData(String username) {
        query = "SELECT COUNT(*) FROM user_bank WHERE username = ?";
        try {
            psmt = connection.prepareStatement(query);
            psmt.setString(1, username);
            rs = psmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Query Error " + e);
            return false;
        }
        return false;
    }

    public int minusSaldo(String noRek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        query = "UPDATE rekening SET saldo = saldo -? WHERE no_rekening = ?";
        try {
            psmt = connection.prepareStatement(query);
            psmt.setString(1, jumlahTransaksi);
            psmt.setString(2, noRek);
            psmt.executeUpdate();
            psmt.close();
            if (jenisTransaksi.equals("Tarik Tunai")) {
                query = "INSERT INTO tarik_tunai (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, noRek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
                return 0;
            } else if (jenisTransaksi.equals("Transfer Keluar")) {
                query = "INSERT INTO transfer (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, noRek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            return 1;
        }
    }

    public int plusSaldo(String no_rek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        query = "UPDATE rekening SET saldo = saldo + ? WHERE no_rekening = ?";
        try {
            psmt = connection.prepareStatement(query);
            psmt.setString(1, jumlahTransaksi);
            psmt.setString(2, no_rek);
            psmt.executeUpdate();
            psmt.close();
            if (jenisTransaksi.equals("Setor Tunai")) {
                query = "INSERT INTO setor_tunai (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
                return 0;
            } else if (jenisTransaksi.equals("Transfer Masuk")) {
                query = "INSERT INTO transfer (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = connection.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            return 1;
        }
    }

    public boolean setSaldoNew(String noRek) {
        try {
            query = "SELECT Saldo FROM rekening WHERE no_rekening=?";
            psmt = connection.prepareStatement(query);
            psmt.setString(1, noRek);
            rs = psmt.executeQuery();
            if (rs.next()) {
                TM.setSaldo(rs.getDouble("Saldo"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
