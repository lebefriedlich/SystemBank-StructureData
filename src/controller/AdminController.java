/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import service.AdminService;
import service.TransactionService;

/**
 *
 * @author HP
 */
public class AdminController {
    AdminService AS = new AdminService();
    String notif;
    TransactionService TS = new TransactionService();
    final String USERNAME_PATTERN = "^[a-z0-9]{6}$";
    final String PASSWORD_PATTERN = "^\\d{6}$";
    final String NOTELP_PATTERN = "^(\\d{12}|\\d{13})$";
    final String EMAIL_REGEX = "^[a-z0-9]+@gmail\\.com$";
    final Pattern patternUsername = Pattern.compile(USERNAME_PATTERN);
    final Pattern patternPassword = Pattern.compile(PASSWORD_PATTERN);
    final Pattern patternNoTelp = Pattern.compile(NOTELP_PATTERN);
    final Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
   
    
    public String viewAllNasabah(){
        if (AS.viewAllNasabah()) {
            notif = "Data Berhasil Ditampilkan"; 
        } else {
            notif = "Data Gagal Ditampilkan"; 
        }
        return notif;
    }
    
    public String editData(String username, String password, String noTelpon, String email, String namaLengkap){
        Matcher matcherUsername = patternUsername.matcher(username);
        Matcher matcherPassword = patternPassword.matcher(password);
        Matcher matcherNoTelp = patternNoTelp.matcher(noTelpon);
        Matcher matcherEmail = patternEmail.matcher(email);
        
        if (namaLengkap.isEmpty()) {
            notif = "Maaf, Nama lengkap belum diisi !";
        } else if (!matcherUsername.matches()) {
            notif = "Maaf, Username harus memiliki 6 karakter !";
        } else if (!matcherPassword.matches()) {
            notif = "Maaf, Password harus memiliki 6 karakter !";
        } else if (!matcherNoTelp.matches()) {
            notif = "Maaf, No. Telepon harus memiliki 12 atau 13 angka !";
        } else if (username.isEmpty()) {
            notif = "Maaf, Username belum diisi!";
        } else if (password.isEmpty()) {
            notif = "Maaf, Password belum diisi!";
        } else if (noTelpon.isEmpty()) {
            notif = "Maaf, Nomer Telepon belum diisi!";
        } else if (email.isEmpty()) {
            notif = "Maaf, Email belum diisi !";
        } else if (!matcherEmail.matches()) {
            notif = "Maaf, Input email tidak valid!";
        } else if (AS.editData(username, password, noTelpon, email, namaLengkap)) {
            notif = "Data Berhasil Dirubah"; 
        } else if (!TS.checkData(username)) {
            notif = "Maaf, username ini sudah terdaftar";
        } else {
            notif = "Data Gagal Dirubah"; 
        }
        return notif;
    }
    
    public String activeOrNon(String namaLengkap, String status){
        if (namaLengkap.isEmpty()) {
            notif = "Maaf, Nama lengkap belum diisi !";
        }  else if (status.isEmpty()) {
            notif = "Maaf, Username belum diisi!";
        }  else if (AS.activeOrNon(namaLengkap, status)) {
            if ("Active".equals(status)) {
                notif = "Status Nasabah Berhasil Diaktifkan";
            } else {
                notif = "Status Nasabah Berhasil Di Non Aktifkan";
            }
        } else {
            notif = "Data Gagal Dirubah Statusnya"; 
        }
        return notif;
    }
    
    public String viewAllTransactionNasabah() {
        if (AS.viewAllTransactionNasabah()) {
            notif = "Data Berhasil Ditampilkan";
        } else {
            notif = "Data Gagal Ditampilkan";
        }
        return notif;
    }
    
    public String deleteNasabah(String noRekening){
        if (noRekening.isEmpty()) {
            notif = "Nomor Rekening kosong";
        } else if (AS.deleteNasabah(noRekening)) {
            notif = "Data Berhasil Dihapus"; 
        } else {
            notif = "Data Gagal Dihapus"; 
        }
        return notif;
    }
    
    public String viewTransactionNasabah(String noRekening) {
        if (AS.viewTransactionNasabah(noRekening)) {
            notif = "Data Berhasil Ditampilkan";
        } else {
            notif = "Data Gagal Ditampilkan";
        }
        return notif;
    }
    
    public String getStatus(String namaLengkap){
        if (namaLengkap.isEmpty()) {
            notif = "Nama Lengkap Kosong";
        } else if (AS.getStatus(namaLengkap)) {
            notif = "Status Ditemukan";
        } else {
            notif = "Status Tidak ditemukan";
        }
        return notif;
    }
}
