# Panduan Penggunaan System Bank Java Netbeans

Proyek ini memerlukan langkah-langkah tertentu agar dapat dijalankan dengan benar. Berikut adalah langkah-langkah yang perlu Anda ikuti:

## Langkah 1: Unduh Database

Unduh file database dari https://github.com/lebefriedlich/SystemBank-StructureData/blob/main/database/db_bankadvance.sql dan simpan di lokasi yang mudah diakses pada komputer Anda.

## Langkah 2: Impor Database

Gunakan manajer database favorit Anda (seperti MySQL Workbench atau phpMyAdmin) untuk mengimpor database yang telah diunduh. Ikuti langkah-langkah berikut:

1. Buka manajer database.
2. Buat database baru (jika belum ada).
3. Pilih opsi impor dan pilih file database yang diunduh.
4. Klik "OK" untuk mengimpor struktur dan data ke database Anda.

## Langkah 3: Konfigurasi Koneksi Database

Buka berkas `MySQLConnection.java` pada proyek ini dan ubah bagian berikut:

Perhatikan pada baris 18: String url = "jdbc:mysql://localhost/db_bankadvance"; rubah nama **db_bankadvance** menjadi nama database yang kalian impor tadi


