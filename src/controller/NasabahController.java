/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.NasabahModel;
import service.NasabahService;

/**
 *
 * @author HP
 */
public class NasabahController {
    NasabahService NS = new NasabahService();
    NasabahModel NM = new NasabahModel();
    String notif;
    final String NOREK_PATTERN = "^\\d{14}$";
    final Pattern patternNoRek = Pattern.compile(NOREK_PATTERN);
    
    public String getNamaLengkap(String noRek){
        Matcher matcherNoRek = patternNoRek.matcher(noRek);
        if (!matcherNoRek.matches()) {
            notif = "Nomor Rekening harus memiliki 14 angka";
        } else if (NS.getNamaLengkap(noRek)){
            notif = NM.getNamaLengkap();
        } else {
            notif = null;
        }
        return notif;
    }
    
    public String viewTransactionNasabah(String no_rekening) {
        if (NS.viewTransactionNasabah(no_rekening)) {
            notif = "Data Berhasil Ditampilkan";
        } else {
            notif = "Data Gagal Ditampilkan";
        }
        return notif;
    }
}
