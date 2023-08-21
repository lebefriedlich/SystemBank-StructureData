/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Session {
    private static String no_rek, nama_lengkap, statusLogin;
    private static double Jumlah_Transaksi;

    public static String getNo_rek() {
        return no_rek;
    }

    public static void setNo_rek(String no_rek) {
        Session.no_rek = no_rek;
    }

    public static String getNama_lengkap() {
        return nama_lengkap;
    }

    public static void setNama_lengkap(String nama_lengkap) {
        Session.nama_lengkap = nama_lengkap;
    }
    
    public static double getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }

    public static void setJumlah_Transaksi(double Jumlah_Transaksi) {
        Session.Jumlah_Transaksi = Jumlah_Transaksi;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }

    public static void setStatusLogin(String statusLogin) {
        Session.statusLogin = statusLogin;
    }
}
