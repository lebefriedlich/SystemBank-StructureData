-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2023 at 09:33 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_bankadvance`
--

-- --------------------------------------------------------

--
-- Table structure for table `rekening`
--

CREATE TABLE `rekening` (
  `no_rekening` bigint(14) NOT NULL,
  `ID_nasabah` int(13) NOT NULL,
  `Saldo` int(11) NOT NULL,
  `Tanggal_Daftar` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rekening`
--

INSERT INTO `rekening` (`no_rekening`, `ID_nasabah`, `Saldo`, `Tanggal_Daftar`) VALUES
(19210204000001, 1, 0, '2023-11-12 08:31:15'),
(19210204000002, 2, 49500000, '2023-11-29 16:38:11'),
(19210204000003, 3, 0, '2023-11-12 08:09:18'),
(19210204000004, 4, 35000000, '2023-11-15 23:09:22'),
(19210204000005, 5, 69500000, '2023-11-29 16:38:11'),
(19210204000006, 6, 96000000, '2023-11-29 08:41:14'),
(19210204000007, 7, 65000000, '2023-11-12 14:09:26'),
(19210204000008, 8, 45000000, '2023-11-13 14:00:05'),
(19210204000009, 9, 90000000, '2023-11-15 23:09:22'),
(19210204000010, 10, 109000000, '2023-11-29 03:53:05'),
(19210204000011, 11, 50000000, '2023-11-15 01:56:42'),
(19210204000012, 12, 60000000, '2023-11-15 01:59:33'),
(19210204000013, 13, 80000000, '2023-11-15 02:18:33');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `setor_tunai`
--

CREATE TABLE `setor_tunai` (
  `ID_transaksi` int(13) NOT NULL,
  `no_rekening` bigint(14) NOT NULL,
  `Tanggal_Transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Jenis_Transaksi` varchar(50) NOT NULL,
  `Jumlah_Transaksi` varchar(14) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `setor_tunai`
--

INSERT INTO `setor_tunai` (`ID_transaksi`, `no_rekening`, `Tanggal_Transaksi`, `Jenis_Transaksi`, `Jumlah_Transaksi`, `keterangan`) VALUES
(1, 19210204000002, '2023-11-04 09:52:22', 'Setor Tunai', '100000000', 'Berhasil'),
(2, 19210204000004, '2023-11-12 14:09:26', 'Setor Tunai', '50000000', 'Berhasil'),
(3, 19210204000005, '2023-11-12 14:09:26', 'Setor Tunai', '60000000', 'Berhasil'),
(4, 19210204000006, '2023-11-12 14:09:26', 'Setor Tunai', '75000000', 'Berhasil'),
(5, 19210204000007, '2023-11-12 14:09:26', 'Setor Tunai', '65000000', 'Berhasil'),
(6, 19210204000008, '2023-11-12 14:09:26', 'Setor Tunai', '45000000', 'Berhasil'),
(7, 19210204000009, '2023-11-12 14:09:26', 'Setor Tunai', '80000000', 'Berhasil'),
(8, 19210204000005, '2023-11-13 13:16:21', 'Setor Tunai', '10000000', 'Berhasil'),
(9, 19210204000004, '2023-11-14 09:16:51', 'Setor Tunai', '2500000', 'Berhasil'),
(10, 19210204000010, '2023-11-15 01:52:18', 'Setor Tunai', '100000000', 'Berhasil'),
(11, 19210204000011, '2023-11-15 01:56:42', 'Setor Tunai', '50000000', 'Berhasil'),
(12, 19210204000012, '2023-11-15 01:59:33', 'Setor Tunai', '60000000', 'Berhasil'),
(13, 19210204000013, '2023-11-15 02:18:33', 'Setor Tunai', '80000000', 'Berhasil'),
(14, 19210204000002, '2023-11-15 08:08:20', 'Setor Tunai', '5000000', 'Berhasil');

-- --------------------------------------------------------

--
-- Table structure for table `tarik_tunai`
--

CREATE TABLE `tarik_tunai` (
  `ID_transaksi` int(13) NOT NULL,
  `no_rekening` bigint(14) NOT NULL,
  `Tanggal_Transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Jenis_Transaksi` varchar(50) NOT NULL,
  `Jumlah_Transaksi` varchar(14) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tarik_tunai`
--

INSERT INTO `tarik_tunai` (`ID_transaksi`, `no_rekening`, `Tanggal_Transaksi`, `Jenis_Transaksi`, `Jumlah_Transaksi`, `keterangan`) VALUES
(1, 19210204000002, '2023-11-13 13:02:20', 'Tarik Tunai', '5000000', 'Berhasil'),
(2, 19210204000002, '2023-11-13 13:03:34', 'Tarik Tunai', '5000000', 'Berhasil'),
(3, 19210204000002, '2023-11-13 13:06:08', 'Tarik Tunai', '5000000', 'Berhasil'),
(4, 19210204000002, '2023-11-13 13:07:23', 'Tarik Tunai', '5000000', 'Berhasil'),
(5, 19210204000004, '2023-11-14 09:17:06', 'Tarik Tunai', '2500000', 'Berhasil'),
(6, 19210204000002, '2023-11-15 08:06:34', 'Tarik Tunai', '5000000', 'Berhasil'),
(7, 19210204000002, '2023-11-29 03:23:17', 'Tarik Tunai', '1000000', 'Berhasil');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `ID_transaksi` int(13) NOT NULL,
  `no_rekening` bigint(14) NOT NULL,
  `Tanggal_Transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Jenis_Transaksi` varchar(50) NOT NULL,
  `Jumlah_Transaksi` varchar(14) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`ID_transaksi`, `no_rekening`, `Tanggal_Transaksi`, `Jenis_Transaksi`, `Jumlah_Transaksi`, `keterangan`) VALUES
(1, 19210204000004, '2023-11-13 14:00:05', 'Transfer Keluar', '5000000', 'ke 19210204000008'),
(2, 19210204000008, '2023-11-13 14:00:05', 'Transfer Masuk', '5000000', 'dari 19210204000004'),
(3, 19210204000002, '2023-11-14 08:45:12', 'Transfer Keluar', '10000000', 'ke 19210204000006'),
(4, 19210204000006, '2023-11-14 08:45:12', 'Transfer Masuk', '10000000', 'dari 19210204000002'),
(5, 19210204000005, '2023-11-15 23:05:12', 'Transfer Keluar', '1000000', 'ke 19210204000006'),
(6, 19210204000006, '2023-11-15 23:05:12', 'Transfer Masuk', '1000000', 'dari 19210204000005'),
(7, 19210204000004, '2023-11-15 23:09:22', 'Transfer Keluar', '10000000', 'ke 19210204000009'),
(8, 19210204000009, '2023-11-15 23:09:22', 'Transfer Masuk', '10000000', 'dari 19210204000004'),
(9, 19210204000002, '2023-11-29 03:53:05', 'Transfer Keluar', '9000000', 'ke 19210204000010'),
(10, 19210204000010, '2023-11-29 03:53:05', 'Transfer Masuk', '9000000', 'dari 19210204000002'),
(11, 19210204000002, '2023-11-29 08:41:14', 'Transfer Keluar', '10000000', 'ke 19210204000006'),
(12, 19210204000006, '2023-11-29 08:41:14', 'Transfer Masuk', '10000000', 'dari 19210204000002'),
(13, 19210204000002, '2023-11-29 16:38:11', 'Transfer Keluar', '500000', 'ke 19210204000005'),
(14, 19210204000005, '2023-11-29 16:38:11', 'Transfer Masuk', '500000', 'dari 19210204000002');

-- --------------------------------------------------------

--
-- Table structure for table `user_bank`
--

CREATE TABLE `user_bank` (
  `ID_nasabah` int(13) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(6) NOT NULL,
  `password` varchar(6) NOT NULL,
  `no_hp` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_bank`
--

INSERT INTO `user_bank` (`ID_nasabah`, `nama_lengkap`, `username`, `password`, `no_hp`, `email`, `status`, `role_id`) VALUES
(1, 'Maulana Haekal Noval Akbar', 'hae192', '190204', '081359654483', 'noval.akbar.906@gmail.com', 'Active', 1),
(2, 'Maulana Haekal Noval Akbar', 'val192', '190204', '081359654483', 'maulanahaekal906@gmail.com', 'Active', 2),
(3, 'Wafiy Anwarul Hikam', 'fiy211', '210104', '081111111111', 'wafiyanwarul@gmail.com', 'Active', 1),
(4, 'John Doe', 'u01a01', '123456', '123456789012', 'johndoe99@gmail.com', 'Active', 2),
(5, 'Jane Doe', 'u02a02', '234567', '987654321098', 'janedoe64@gmail.com', 'Active', 2),
(6, 'Alice Smith', 'u03a03', '345678', '555555555555', 'alice.smith@example.com', 'Active', 2),
(7, 'Bob Johnson', 'u04a04', '456789', '333333333333', 'bob.johnson@example.com', 'Active', 2),
(8, 'Eva Brown', 'u05a05', '567890', '999999999999', 'eva.brown@example.com', 'Active', 2),
(9, 'Charlie White', 'u06a06', '678901', '777777777777', 'charlie.white@example.com', 'Active', 2),
(10, 'Almira Tasya Nabila', 'sya212', '210204', '081355556666', 'tasyuu78@gmail.com', 'Active', 2),
(11, 'Wafiy Anwarul Hikam', 'waf555', '555666', '085244446666', 'wafiy@gmail.com', 'Active', 2),
(12, 'Alsy Amalia Jasmine Muin', 'als789', '789456', '085744449999', 'alsy@gmail.com', 'Active', 2),
(13, 'Rifdan Acmal Faza', 'mil987', '987456', '085978945612', 'kom_il99@gmail.com', 'Active', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`no_rekening`),
  ADD KEY `ID_nasabah` (`ID_nasabah`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `setor_tunai`
--
ALTER TABLE `setor_tunai`
  ADD PRIMARY KEY (`ID_transaksi`),
  ADD KEY `no_rekening` (`no_rekening`);

--
-- Indexes for table `tarik_tunai`
--
ALTER TABLE `tarik_tunai`
  ADD PRIMARY KEY (`ID_transaksi`),
  ADD KEY `no_rekening` (`no_rekening`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`ID_transaksi`),
  ADD KEY `no_rekening` (`no_rekening`);

--
-- Indexes for table `user_bank`
--
ALTER TABLE `user_bank`
  ADD PRIMARY KEY (`ID_nasabah`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rekening`
--
ALTER TABLE `rekening`
  MODIFY `no_rekening` bigint(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19210204000014;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `setor_tunai`
--
ALTER TABLE `setor_tunai`
  MODIFY `ID_transaksi` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tarik_tunai`
--
ALTER TABLE `tarik_tunai`
  MODIFY `ID_transaksi` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `ID_transaksi` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `user_bank`
--
ALTER TABLE `user_bank`
  MODIFY `ID_nasabah` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rekening`
--
ALTER TABLE `rekening`
  ADD CONSTRAINT `rekening_ibfk_1` FOREIGN KEY (`ID_nasabah`) REFERENCES `user_bank` (`ID_nasabah`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `setor_tunai`
--
ALTER TABLE `setor_tunai`
  ADD CONSTRAINT `setor_tunai_ibfk_1` FOREIGN KEY (`no_rekening`) REFERENCES `rekening` (`no_rekening`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tarik_tunai`
--
ALTER TABLE `tarik_tunai`
  ADD CONSTRAINT `tarik_tunai_ibfk_1` FOREIGN KEY (`no_rekening`) REFERENCES `rekening` (`no_rekening`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transfer`
--
ALTER TABLE `transfer`
  ADD CONSTRAINT `transfer_ibfk_1` FOREIGN KEY (`no_rekening`) REFERENCES `rekening` (`no_rekening`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_bank`
--
ALTER TABLE `user_bank`
  ADD CONSTRAINT `user_bank_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
