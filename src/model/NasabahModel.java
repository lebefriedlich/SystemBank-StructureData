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
public class NasabahModel {
   private static String namaLengkap, namaBank;
    public static String getNamaBank() {
        return namaBank;
    }

    public static void setNamaBank(String namaBank) {
        NasabahModel.namaBank = namaBank;
    }
    private static LinkedList<String[]> dataTransaction = new LinkedList<>();

    public static LinkedList<String[]> getDataTransaction() {
        return dataTransaction;
    }

    public static void setDataTransaction(LinkedList<String[]> dataTransaction) {
        NasabahModel.dataTransaction = dataTransaction;
    }

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static void setNamaLengkap(String namaLengkap) {
        NasabahModel.namaLengkap = namaLengkap;
    }
}
