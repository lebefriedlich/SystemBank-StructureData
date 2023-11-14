/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TransactionModel;
import service.TransactionService;
import java.util.regex.*;

/**
 *
 * @author HP
 */
public class TransactionController {

    TransactionService TS = new TransactionService();
    TransactionModel TM = new TransactionModel();
    final String USERNAME_PATTERN = "^[a-z0-9]{6}$";
    final String PASSWORD_PATTERN = "^\\d{6}$";
    final String SALDO_PATTERN = "^\\d+$";
    final String NOTELP_PATTERN = "^(\\d{12}|\\d{13})$";
    final Pattern patternUsername = Pattern.compile(USERNAME_PATTERN);
    final Pattern patternPassword = Pattern.compile(PASSWORD_PATTERN);
    final Pattern patternSaldo = Pattern.compile(SALDO_PATTERN);
    final Pattern patternNoTelp = Pattern.compile(NOTELP_PATTERN);
    String notif;

    public String checkLogin(String username, String password) {
        Matcher matcherUsername = patternUsername.matcher(username);
        Matcher matcherPassword = patternPassword.matcher(password);
        if (username.isEmpty()) {
            notif = "Maaf, Username belum diisi!";
        } else if (password.isEmpty()) {
            notif = "Maaf, Password belum diisi!";
        } else if (matcherUsername.matches() && matcherPassword.matches() && TS.checkLogin(username, password)) {
            notif = null;
        } else {
            notif = "Username atau password yang anda \nmasukkan salah. Silahkan coba kembali";
        }
        return notif;
    }

    public String register(String namaLengkap, String username, String password, String noTelpon, String email, String saldo, String role) {
        Matcher matcherUsername = patternUsername.matcher(username);
        Matcher matcherPassword = patternPassword.matcher(password);
        Matcher matcherSaldo = patternSaldo.matcher(saldo);
        Matcher matcherNoTelp = patternNoTelp.matcher(noTelpon);

        if (namaLengkap.isEmpty()) {
            notif = "Maaf, Nama lengkap belum diisi !";
        } else if (!matcherUsername.matches()) {
            notif = "Maaf, Username harus memiliki 6 karakter !";
        } else if (!TS.checkData(username)) {
            notif = "Maaf, username ini sudah terdaftar";
        } else if (!matcherPassword.matches()) {
            notif = "Maaf, Password harus memiliki 6 karakter !";
        } else if (!matcherNoTelp.matches()) {
            notif = "Maaf, No. Telepon harus memiliki 12 atau 13 angka !";
        } else if (email.isEmpty()) {
            notif = "Maaf, Email belum diisi !";
        } else if (!matcherSaldo.matches()) {
            notif = "Maaf, Input saldo harus angka!";
        } else {
            TM.setNamaLengkap(namaLengkap);
            TM.setUsername(username);
            TM.setPassword(password);
            TM.setNoTelpon(noTelpon);
            TM.setEmail(email);
            TM.setSaldo(Double.parseDouble(saldo));
            TM.setRole(role);
            if (TS.register(namaLengkap, username, password, noTelpon, email, Double.parseDouble(saldo), role)) {
                notif = "Daftar Berhasil";
            } else {
                notif = "Daftar Gagal";
            }
        }
        return notif;
    }

    public String viewTransactionNasabah(String no_rekening) {
        if (TS.viewTransactionNasabah(no_rekening)) {
            notif = "Data Berhasil Ditampilkan";
        } else {
            notif = "Data Gagal Ditampilkan";
        }
        return notif;
    }

    public String minusSaldo(String noRek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        Matcher matcherSaldo = patternSaldo.matcher(jumlahTransaksi);

        if (noRek.isEmpty()) {
            notif = "Maaf, Nomer Rekening belum diisi !";
        } else if (!matcherSaldo.matches()) {
            notif = "Maaf, Input saldo harus angka!";
        } else {
            if (TS.minusSaldo(noRek, jumlahTransaksi, jenisTransaksi, keterangan)) {
                notif = "Anda Berhasil " + jenisTransaksi;
            } else {
                notif = "Anda Gagal " + jenisTransaksi ;
            }
        }
        return notif;
    }

    public String plusSaldo(String noRek, String jumlahTransaksi, String jenisTransaksi, String keterangan) {
        Matcher matcherSaldo = patternSaldo.matcher(jumlahTransaksi);

        if (noRek.isEmpty()) {
            notif = "Maaf, Nomer Rekening belum diisi !";
        } else if (!matcherSaldo.matches()) {
            notif = "Maaf, Input saldo harus angka!";
        } else {
            if (TS.plusSaldo(noRek, jumlahTransaksi, jenisTransaksi, keterangan)) {
                notif = "Anda Berhasil " + jenisTransaksi ;
            } else {
                notif = "Anda Gagal " + jenisTransaksi ;
            }
        }
        return notif;
    }

    public String setSaldoNew(String noRek) {
        if (TS.setSaldoNew(noRek)) {
            notif = "Saldo berhasil diset ulang";
        } else {
            notif = "Saldo gagal diset ulang";
        } 
        return notif;
    }
}
