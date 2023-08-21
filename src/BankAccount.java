/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public abstract class BankAccount {

    private String no_rek, nama_lengkap, username, password, no_hp, email, Tanggal_Transaksi, Jenis_Transaksi, keterangan, ID_nasabah;
    private double Jumlah_Transaksi;

    public String getID_nasabah() {
        return ID_nasabah;
    }

    public void setID_nasabah(String ID_nasabah) {
        this.ID_nasabah = ID_nasabah;
    }

    public String getTanggal_Transaksi() {
        return Tanggal_Transaksi;
    }

    public void setTanggal_Transaksi(String Tanggal_Transaksi) {
        this.Tanggal_Transaksi = Tanggal_Transaksi;
    }

    public String getJenis_Transaksi() {
        return Jenis_Transaksi;
    }

    public void setJenis_Transaksi(String Jenis_Transaksi) {
        this.Jenis_Transaksi = Jenis_Transaksi;
    }

    public double getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }

    public void setJumlah_Transaksi(double Jumlah_Transaksi) {
        this.Jumlah_Transaksi = Jumlah_Transaksi;
    }

    public String getNo_rek() {
        return no_rek;
    }

    public void setNo_rek(String no_rek) {
        this.no_rek = no_rek;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
