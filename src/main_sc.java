/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;

/**
 *
 * @author HP
 */
public class main_sc extends BankAccount implements BankingSystemInterface {

    private Connection koneksi;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query, notif;

    public main_sc() {
        try {
            koneksi conn = new koneksi();
            koneksi = conn.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ResultSet showDataNasabah() {
        query = "SELECT user_bank.*, rekening.no_rekening, rekening.Saldo "
                + "FROM user_bank "
                + "JOIN rekening ON user_bank.ID_Nasabah = rekening.ID_Nasabah ";
        try {
            stat = koneksi.createStatement();
            rs = stat.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }

    @Override
    public ResultSet showActivityNasabah(String no_rekening) {
        query = "SELECT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                + "FROM transfer WHERE no_rekening = ? "
                + "UNION "
                + "SELECT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                + "FROM setor_tunai WHERE no_rekening = ? "
                + "UNION "
                + "SELECT Tanggal_Transaksi, Jenis_Transaksi, Jumlah_Transaksi, keterangan "
                + "FROM tarik_tunai WHERE no_rekening  = ? "
                + "ORDER BY Tanggal_Transaksi ASC";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, no_rekening);
            psmt.setString(2, no_rekening);
            psmt.setString(3, no_rekening);
            rs = psmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    @Override
    public String checkLogin(String username, String password) {
        try {
            query = "SELECT user_bank.nama_lengkap, rekening.no_rekening, rekening.Saldo "
                    + "FROM user_bank "
                    + "JOIN rekening ON user_bank.ID_Nasabah = rekening.ID_Nasabah "
                    + "WHERE user_bank.Username =? AND user_bank.Password =?";
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                Session.setNama_lengkap(rs.getString("user_bank.nama_lengkap"));
                Session.setNo_rek(rs.getString("rekening.no_rekening"));
                Session.setJumlah_Transaksi(rs.getDouble("rekening.Saldo"));
                Session.setStatusLogin("AKTIF");
                notif = "Data Berhasil Ditemukan";
            } else {
                notif = "Username atau password yang anda \nmasukkan salah. Silahkan coba kembali";
            }
        } catch (SQLException e) {
            notif = "Gagal Login, Query Error " + e;
        }
        return notif;
    }

    @Override
    public String registrasiNasabah(String nama_lengkap, String username, String password, String no_hp, String email, String nominal, String keterangan) {
        query = "INSERT INTO user_bank (nama_lengkap, username, password, no_hp, email) VALUES (?,?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, nama_lengkap);
            psmt.setString(2, username);
            psmt.setString(3, password);
            psmt.setString(4, no_hp);
            psmt.setString(5, email);
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
                psmt = koneksi.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                psmt.setString(1, idnasabah);
                psmt.setString(2, nominal);
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
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, noRek);
                    psmt.setString(2, "Setor Tunai");
                    psmt.setString(3, nominal);
                    psmt.setString(4, keterangan);
                    psmt.executeUpdate();
                    psmt.close();
                } catch (SQLException e) {
                    notif = "Data Gagal disimpan di Tabel setor_tunai" + e;
                }
            } catch (SQLException e) {
                notif = "Data Gagal disimpan di Tabel rekening" + e;
            }
        } catch (SQLException e) {
            notif = "Data Gagal Disimpan di Tabel user_bank" + e;
        }
        return notif;
    }

    @Override
    public String editData(String username, String password, String no_hp, String email, String ID_Nasabah) {
        query = "UPDATE user_bank SET username =?, password =?, no_hp =?, email =? WHERE ID_Nasabah =?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            psmt.setString(3, no_hp);
            psmt.setString(4, email);
            psmt.setString(5, ID_Nasabah);
            psmt.executeUpdate();
            psmt.close();
            notif = "Data Berhasil Diubah";
        } catch (SQLException e) {
            notif = "Data Gagal Diubah" + e;
        }
        return notif;
    }

    @Override
    public String deleteNasabah(String ID_nasabah) {
        query = "DELETE FROM user_bank WHERE user_bank.ID_nasabah = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, ID_nasabah);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            notif = "Gagal Login, Query Error Tabel " + e;
        }
        return notif;
    }

    @Override
    public String minusSaldo(String no_rek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        query = "UPDATE rekening SET saldo = saldo -? WHERE no_rekening = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, jumlahTransaksi);
            psmt.setString(2, no_rek);
            psmt.executeUpdate();
            psmt.close();
            if (jenisTransaksi.equals("Tarik Tunai")) {
                query = "INSERT INTO tarik_tunai (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = koneksi.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
            } else {
                query = "INSERT INTO transfer (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = koneksi.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
            }
        } catch (SQLException e) {
            notif = "Terjadi kesalahan saat menjalankan query update: " + e.getMessage();
        }
        return notif;
    }

    @Override
    public String plusSaldo(String no_rek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        query = "UPDATE rekening SET saldo = saldo + ? WHERE no_rekening = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, jumlahTransaksi);
            psmt.setString(2, no_rek);
            psmt.executeUpdate();
            psmt.close();
            if (jenisTransaksi.equals("Setor Tunai")) {
                query = "INSERT INTO setor_tunai (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = koneksi.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
            } else {
                query = "INSERT INTO transfer (no_rekening, Jenis_Transaksi, Jumlah_Transaksi, keterangan) VALUES (?,?,?,?)";
                psmt = koneksi.prepareStatement(query);
                psmt.setString(1, no_rek);
                psmt.setString(2, jenisTransaksi);
                psmt.setString(3, jumlahTransaksi);
                psmt.setString(4, keterangan);
                psmt.executeUpdate();
                psmt.close();
            }
        } catch (SQLException e) {
            notif = "Terjadi kesalahan saat menjalankan query update: " + e.getMessage();
        }
        return notif;
    }

    @Override
    public String searchData(String cari) {
        query = "SELECT user_bank.*, rekening.no_rekening, rekening.Saldo "
                + "FROM user_bank "
                + "JOIN rekening ON user_bank.ID_Nasabah = rekening.ID_Nasabah "
                + "WHERE rekening.no_rekening LIKE ? OR user_bank.nama_lengkap LIKE ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, "%" + cari + "%");
            psmt.setString(2, "%" + cari + "%");
            rs = psmt.executeQuery();
            if (rs.next()) {
                setID_nasabah(rs.getString("user_bank.ID_nasabah"));
                setNo_rek(rs.getString("rekening.no_rekening"));
                setNama_lengkap(rs.getString("user_bank.nama_lengkap"));
                setUsername(rs.getString("user_bank.username"));
                setPassword(rs.getString("user_bank.password"));
                setNo_hp(rs.getString("user_bank.no_hp"));
                setEmail(rs.getString("user_bank.email"));
                setJumlah_Transaksi(rs.getDouble("rekening.saldo"));
                notif = "Data berhasil ditemukan";
            } else {
                notif = "Data tidak ditemukan";
            }
        } catch (SQLException e) {
            notif = "Data gagal ditemukan";
        }
        return notif;
    }

    @Override
    public String setSaldoNew(String no_rek) {
        query = "SELECT Saldo FROM rekening WHERE no_rekening=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, no_rek);
            rs = psmt.executeQuery();
            if (rs.next()) {
                Session.setJumlah_Transaksi(rs.getDouble("Saldo"));
                notif = "Saldo berhasil diset";
            }
        } catch (SQLException e) {
            notif = "Saldo berhasil diset" + e;
        }
        return notif;
    }

    @Override
    public String cekData(String username) {
        query = "SELECT COUNT(*) FROM user_bank WHERE username = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            rs = psmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    notif = "Maaf, username ini sudah terdaftar";
                } else {
                    notif = null;
                }
            }
        } catch (SQLException e) {
            notif = "Query error " + e;
        }
        return notif;
    }

}
