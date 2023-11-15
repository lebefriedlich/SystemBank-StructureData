/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.text.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class StructureData {

    public static void bubbleSortByAccountNumber(ArrayList<String[]> arr) {
        try {
            int n = arr.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    long accountNumber1 = Long.parseLong(arr.get(j)[0]);
                    long accountNumber2 = Long.parseLong(arr.get(j + 1)[0]);

                    if (accountNumber1 > accountNumber2) {
                        String[] temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void bubbleSortByName(ArrayList<String[]> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String name1 = arr.get(j)[1];
                String name2 = arr.get(j + 1)[1];

                if (name1.compareTo(name2) > 0) {
                    String[] temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static void bubbleSortTransactionByDate(ArrayList<String[]> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Parsing the dates for comparison
                String date1String = arr.get(j)[0];
                String date2String = arr.get(j + 1)[0];

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date1 = dateFormat.parse(date1String);
                    Date date2 = dateFormat.parse(date2String);

                    // Swap if the current date is greater than the next date
                    if (date1.compareTo(date2) > 0) {
                        String[] temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String[] binarySearchByAccountNumber(ArrayList<String[]> list, String target) {
        bubbleSortByAccountNumber(list);
        
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Bandingkan target dengan elemen pada indeks tengah
            String comparisonResult = list.get(mid)[0]; // Mengasumsikan indeks 0 adalah yang ingin dibandingkan

            int compareResult = target.compareTo(comparisonResult);

            if (compareResult == 0) {
                return list.get(mid); // Mengembalikan array yang sesuai dengan target
            } else if (compareResult < 0) {
                right = mid - 1; // Cari di sebelah kiri
            } else {
                left = mid + 1; // Cari di sebelah kanan
            }
        }

        return null; // Element tidak ditemukan
    }
    
    public static String[] binarySearchByName(ArrayList<String[]> list, String target) {
        bubbleSortByName(list);
        
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Bandingkan target dengan elemen pada indeks tengah
            String comparisonResult = list.get(mid)[1]; // Mengasumsikan indeks 0 adalah yang ingin dibandingkan

            int compareResult = target.compareTo(comparisonResult);

            if (compareResult == 0) {
                return list.get(mid); // Mengembalikan array yang sesuai dengan target
            } else if (compareResult < 0) {
                right = mid - 1; // Cari di sebelah kiri
            } else {
                left = mid + 1; // Cari di sebelah kanan
            }
        }

        return null; // Element tidak ditemukan
    }
}
