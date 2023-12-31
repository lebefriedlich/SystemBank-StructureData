/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.AdminRepository;

/**
 *
 * @author HP
 */
public class AdminService {
    AdminRepository AR = new AdminRepository();
    
    public boolean viewAllNasabah(){
        try {
            AR.viewAllNasabah();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean editData(String username, String password, String noTelepon, String email, String namaLengkap){
        try {
            AR.editData(username, password, noTelepon, email, namaLengkap);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean deleteNasabah(String noRekening){
        try {
            AR.deleteNasabah(noRekening);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean activeOrNon(String namaLengkap, String status){
        try {
            AR.activeOrNon(namaLengkap, status);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean viewAllTransactionNasabah(){
        try {
            AR.viewAllTransactionNasabah();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean viewTransactionNasabah(String noRekening){
        try {
            AR.viewTransactionNasabah(noRekening);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean getStatus(String username){
        try {
            AR.getStatus(username);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
