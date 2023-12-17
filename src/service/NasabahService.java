/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.NasabahRepository;

/**
 *
 * @author HP
 */
public class NasabahService {
    NasabahRepository NR = new NasabahRepository();
    
    public boolean getDataNasabah(String noRek){
        try {
            NR.getDataNasabah(noRek);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean viewTransactionNasabah(String no_rekening){
        try {
            NR.viewTransactionNasabah(no_rekening);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
