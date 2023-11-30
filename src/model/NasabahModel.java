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
public class NasabahModel {
   private static String namaLengkap;
    private static ArrayList<String[]> dataTransaction = new ArrayList<>();

    public static ArrayList<String[]> getDataTransaction() {
        return dataTransaction;
    }

    public static void setDataTransaction(ArrayList<String[]> dataTransaction) {
        NasabahModel.dataTransaction = dataTransaction;
    }

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static void setNamaLengkap(String namaLengkap) {
        NasabahModel.namaLengkap = namaLengkap;
    }
}
