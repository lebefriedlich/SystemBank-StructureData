/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class AdminModel {
    private static LinkedList<String[]> dataNasabah;
    private static LinkedList<String[]> dataAdmin;
    private static LinkedList<String[]> dataTransaction;
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

    public static LinkedList<String[]> getDataAdmin() {
        return dataAdmin;
    }

    public static void setDataAdmin(LinkedList<String[]> dataAdmin) {
        AdminModel.dataAdmin = dataAdmin;
    }

    public static LinkedList<String[]> getDataNasabah() {
        return dataNasabah;
    }

    public static void setDataNasabah(LinkedList<String[]> dataNasabah) {
        AdminModel.dataNasabah = dataNasabah;
    }
    
    public static LinkedList<String[]> getDataTransaction() {
        return dataTransaction;
    }

    public static void setDataTransaction(LinkedList<String[]> dataTransaction) {
        AdminModel.dataTransaction = dataTransaction;
    }
}
