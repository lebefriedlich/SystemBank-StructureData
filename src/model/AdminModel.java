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
public class AdminModel {
    private static ArrayList<String[]> dataNasabah;
    private static ArrayList<String[]> dataAdmin;
    private static ArrayList<String[]> dataTransaction;
    private static String statusLogin, statusNasabah;

    public static String getStatusNasabah() {
        return statusNasabah;
    }

    public static void setStatusNasabah(String statusNasabah) {
        AdminModel.statusNasabah = statusNasabah;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }

    public static void setStatusLogin(String statusLogin) {
        AdminModel.statusLogin = statusLogin;
    }

    public static ArrayList<String[]> getDataAdmin() {
        return dataAdmin;
    }

    public static void setDataAdmin(ArrayList<String[]> dataAdmin) {
        AdminModel.dataAdmin = dataAdmin;
    }

    public static ArrayList<String[]> getDataNasabah() {
        return dataNasabah;
    }

    public static void setDataNasabah(ArrayList<String[]> dataNasabah) {
        AdminModel.dataNasabah = dataNasabah;
    }
    
    public static ArrayList<String[]> getDataTransaction() {
        return dataTransaction;
    }

    public static void setDataTransaction(ArrayList<String[]> dataTransaction) {
        AdminModel.dataTransaction = dataTransaction;
    }
}
