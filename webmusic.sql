/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : webmusic

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 29/12/2022 16:20:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `admin` int NOT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin@gmail.com', '123456', 'admin', 0);
INSERT INTO `account` VALUES ('hung@gmail.com', '123456', 'HÃ¹ng', 1);

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `singer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (2, 'Có Tràng Chai Viết Lên Cây', 'https://stream.nixcdn.com/NhacCuaTui993/CoChangTraiVietLenCayMatBiecOst-PhanManhQuynh-6181112.mp3?st=qw8X6Y38USlRERyprY6_RA&e=1672135559', 'https://i.pinimg.com/564x/4c/d2/70/4cd2702e7629bc98d5209a9792b79c54.jpg', 'Son tung');
INSERT INTO `music` VALUES (8, 'Sao Anh Chưa Về Nhà', 'https://laylinkvip.com/acdn/JTJGJTJGbXAzLXMxLXptcDMuem1kY2RuLm1lJTJGOWRhZjBkZGUxZTk5ZjdjN2FlODglMkY2MjE1NTQyNDY4MTg1MzkwODcyJTNGYXV0aGVuJTNEZXhwJTNEMTY3MjI5MzQ1NSU3RWFjbCUzRCUyRjlkYWYwZGRlMWU5OWY3YzdhZTg4JTJGJTJBJTdFaG1hYyUzRDE4NzY3N2NkY2E3NjYxMDJkODg2ZDExOGVkM2ZiZTdmJTI2ZnMlM0RNVFkzTWpFeU1EWTFOVE16Tlh4M1pXSldOSHd4TURNZFVuZ09TNDNPQzQ0TkE=', 'https://i.pinimg.com/564x/15/1f/cc/151fcc2109f349a24daabd510b874d32.jpg', 'AMEE');
INSERT INTO `music` VALUES (9, 'Missing You', 'https://laylinkvip.com/acdn/JTJGJTJGbXAzLXMxLXptcDMuem1kY2RuLm1lJTJGZDA5NTgwM2VlNjc5MGYyNzU2NjglMkYyOTk1MDI4MjExMDY1NTEzMzUzJTNGYXV0aGVuJTNEZXhwJTNEMTY3MjMzMDg1MSU3RWFjbCUzRCUyRmQwOTU4MDNlZTY3OTBmMjc1NjY4JTJGJTJBJTdFaG1hYyUzRDE0ODZjYzg3MTRkYjQ1MTA3Zjc3ODgwYjlhZTZmNDA3JTI2ZnMlM0RNVFkzTWpFMU9EQTFNVFl4TW54M1pXSldOSHd4TWpVZFVuZ01qRXlMakUxTnk0eE5Eaw==', 'https://i.pinimg.com/564x/9d/73/b3/9d73b3b9573ce1504218a0e0d2f68c47.jpg', 'Phương Ly');
INSERT INTO `music` VALUES (10, 'Love Rosie', 'https://laylinkvip.com/acdn/JTJGJTJGbXAzLXMxLXptcDMuem1kY2RuLm1lJTJGOThlY2VjMDhkZDRlMzQxMDZkNWYlMkY2MzIyMjY5Mjc2MjA3MTU2NzI0JTNGYXV0aGVuJTNEZXhwJTNEMTY3MjE4NjY1NyU3RWFjbCUzRCUyRjk4ZWNlYzA4ZGQ0ZTM0MTA2ZDVmJTJGJTJBJTdFaG1hYyUzRGZiMGI4OWI0MjBhZmI3OGYzM2NjMjcwYmIyMjQ1Yjg1JTI2ZnMlM0RNVFkzTWpBeE16ZzFOemsyTjN4M1pXSldOSHd4TURNZFVuZ09TNDNPQzQ0TkE', 'https://i.pinimg.com/564x/64/fc/79/64fc79af34d8f32feb92ffc5d263ecf8.jpg', 'Thiều Bảo Trâm');
INSERT INTO `music` VALUES (11, 'Nơi Này Có Anh', 'https://laylinkvip.com/acdn/JTJGJTJGbXAzLXMxLXptcDMuem1kY2RuLm1lJTJGNmJhNWIzOWM2OWQ4ODA4NmQ5YzklMkY3OTg5OTYzNTU0MDQ4NTUyOTM0JTNGYXV0aGVuJTNEZXhwJTNEMTY3MjMyMjc4MiU3RWFjbCUzRCUyRjZiYTViMzljNjlkODgwODZkOWM5JTJGJTJBJTdFaG1hYyUzRGIxODRlNjVlZmQ0ZTJmODhkZjBiMDk0ZGYwMDc1ODY1JTI2ZnMlM0RNVFkzTWpFME9UazRNamcwTUh4M1pXSldOSHcwTWk0eE1UUWRVbmdNek1kVW5nTVRZMQ==', 'https://i.pinimg.com/564x/51/43/e6/5143e6cc9f4c6a4daba6258d6943ba8d.jpg', 'Sơn Tùng');
INSERT INTO `music` VALUES (12, 'Đom Đóm', 'https://laylinkvip.com/acdn/JTJGJTJGbXAzLXMxLXptcDMuem1kY2RuLm1lJTJGZDMzOGJkYjkyNWZlY2NhMDk1ZWYlMkYyMDI4MTkzMzU2OTg4MTkyMDc2JTNGYXV0aGVuJTNEZXhwJTNEMTY3MjMwNzQ1NiU3RWFjbCUzRCUyRmQzMzhiZGI5MjVmZWNjYTA5NWVmJTJGJTJBJTdFaG1hYyUzRGNiYzI0MThhNThhOTQwNjlmZjI0YmFhYmNhNzhjNDhkJTI2ZnMlM0RNVFkzTWpFek5EWTFOak01Tlh4M1pXSldOSHd4TURNZFVuZ09TNDNPQzQ0TkE=', 'https://i.pinimg.com/564x/08/60/a1/0860a188b69914201e94a3c120e4e292.jpg', 'JACK');

SET FOREIGN_KEY_CHECKS = 1;
