/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public interface BankingSystemInterface {
    
    public ResultSet showDataNasabah();

    public ResultSet showActivityNasabah(String ID_rekening);

    public String checkLogin(String username, String password);

    public String registrasiNasabah(String nama_lengkap, String username, String password, String no_hp, String email, String saldo, String keterangan);

    public String editData(String username, String password, String no_hp, String email, String no_rek);

    public String deleteNasabah(String no_rek);

    public String minusSaldo(String no_rek, String saldo, String aktifitas, String keterangan);

    public String plusSaldo(String no_rek, String saldo, String aktifitas, String keterangan);

    public String searchData(String cari);

    public String setSaldoNew(String no_rek);

    public String cekData(String username);

}
