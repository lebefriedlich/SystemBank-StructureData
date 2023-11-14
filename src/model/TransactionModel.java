/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class TransactionModel {
    private static ArrayList<String[]> dataTransaction = new ArrayList<>();
    private static String namaLengkap, noRek, role, statusLogin, username, password, email, noTelpon;
    private static double saldo;

    public static ArrayList<String[]> getDataTransaction() {
        return dataTransaction;
    }

    public static void setDataTransaction(ArrayList<String[]> dataTransaction) {
        TransactionModel.dataTransaction = dataTransaction;
    }

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static void setNamaLengkap(String namaLengkap) {
        TransactionModel.namaLengkap = namaLengkap;
    }

    public static String getNoRek() {
        return noRek;
    }

    public static void setNoRek(String noRek) {
        TransactionModel.noRek = noRek;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        TransactionModel.role = role;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }

    public static void setStatusLogin(String statusLogin) {
        TransactionModel.statusLogin = statusLogin;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        TransactionModel.saldo = saldo;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        TransactionModel.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        TransactionModel.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TransactionModel.email = email;
    }

    public static String getNoTelpon() {
        return noTelpon;
    }

    public static void setNoTelpon(String noTelpon) {
        TransactionModel.noTelpon = noTelpon;
    }
}
