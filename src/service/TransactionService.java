/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.TransactionModel;
import repository.TransactionRepository;
/**
 *
 * @author HP
 */
public class TransactionService {
    TransactionRepository TR = new TransactionRepository();
    TransactionModel TM = new TransactionModel();
    
    public boolean checkLogin(String username, String password){
        try {
            return TR.checkLogin(username, password);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean checkData(String username){
        try {
            return TR.checkData(username);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean register(String namaLengkap, String username, String password, String no_hp, String email, Double nominal, String role){
        try {
            int error = TR.registrasi(namaLengkap, username, password, no_hp, email, nominal, role);
            switch (error) {
                case 0:
                    return true;
                case 1:
                    System.out.println("Data Gagal disimpan di Tabel setor_tunai");
                    return false;
                case 2:
                    System.out.println("Data Gagal disimpan di Tabel rekening");
                    return false;
                case 3:
                    System.out.println("Data Gagal Disimpan di Tabel user_bank");
                    return false;
                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean minusSaldo(String noRek, String jumlahTransaksi, String jenisTransaksi, String keterangan){
        try {
            int error = TR.minusSaldo(noRek, jumlahTransaksi, jenisTransaksi, keterangan);
            switch (error) {
                case 0:
                    return true;
                case 1:
                    System.out.println("Terjadi kesalahan saat menjalankan query transaksi");
                    return false;
                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean plusSaldo(String noRek, String jumlahTransaksi, String jenisTransaksi, String keterangan){
        try {
            int error = TR.plusSaldo(noRek, jumlahTransaksi, jenisTransaksi, keterangan);
            switch (error) {
                case 0:
                    return true;
                case 1:
                    System.out.println("Terjadi kesalahan saat menjalankan query transaksi");
                    return false;
                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean setSaldoNew(String noRek){
        try {
            TR.setSaldoNew(noRek);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
