/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class NasabahModel {
   private static String namaLengkap, username, password, noTelpon, email; 
   private static double saldo;

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static void setNamaLengkap(String namaLengkap) {
        NasabahModel.namaLengkap = namaLengkap;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        NasabahModel.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        NasabahModel.password = password;
    }

    public static String getNoTelpon() {
        return noTelpon;
    }

    public static void setNoTelpon(String noTelpon) {
        NasabahModel.noTelpon = noTelpon;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        NasabahModel.email = email;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        NasabahModel.saldo = saldo;
    }
}
