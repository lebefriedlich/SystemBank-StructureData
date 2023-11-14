/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.AdminService;

/**
 *
 * @author HP
 */
public class AdminController {
    AdminService AS;
    String notif;

    public AdminController(AdminService AS) {
        this.AS = AS;
    }
    
    
    public String viewAllNasabah(){
        if (AS.viewAllNasabah()) {
            notif = "Data Berhasil Ditampilkan"; 
        } else {
            notif = "Data Gagal Ditampilkan"; 
        }
        return notif;
    }
    
    public String editData(String username, String password, String noTelpon, String email, String namaLengkap){
        if (namaLengkap.isEmpty()) {
            notif = "Maaf, Nama lengkap belum diisi !";
        }  else if (username.isEmpty()) {
            notif = "Maaf, Username belum diisi!";
        } else if (password.isEmpty()) {
            notif = "Maaf, Password belum diisi!";
        } else if (noTelpon.isEmpty()) {
            notif = "Maaf, Nomer Telepon belum diisi!";
        } else if (email.isEmpty()) {
            notif = "Maaf, Email belum diisi !";
        } else if (AS.editData(username, password, noTelpon, email, namaLengkap)) {
            notif = "Data Berhasil Dirubah"; 
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
    
}
