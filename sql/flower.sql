/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : flower

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 17/06/2024 23:03:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '分类代码',
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '分类名称',
  PRIMARY KEY (`category_code`) USING BTREE,
  UNIQUE INDEX `category_code`(`category_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('b', '山茶花');
INSERT INTO `category` VALUES ('cl', '玫瑰');
INSERT INTO `category` VALUES ('jj', '康乃馨');
INSERT INTO `category` VALUES ('ooo', '月季花');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `game_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '游戏编号',
  `category_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游戏分类代码',
  `game_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '游戏名称',
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'ISBN',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '作者',
  `press` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '出版社',
  `pub_date` date NOT NULL COMMENT '出版日期',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '游戏图片',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '游戏描述',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '游戏单价',
  `stock` int(0) UNSIGNED NOT NULL COMMENT '游戏库存',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '上架时间',
  PRIMARY KEY (`game_id`) USING BTREE,
  UNIQUE INDEX `book_id`(`game_id`) USING BTREE,
  INDEX `category_code`(`category_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1044 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1036, 'cl', '红玫瑰', '001', '12', '123', '2024-01-01', '111.jpg', '123', 123.00, 117, '2024-02-20 22:09:04');
INSERT INTO `game` VALUES (1037, 'ooo', '白玫瑰', '0066', '123', '暴雪', '2022-01-22', '111.jpg', '123', 22.00, 65, '2024-02-20 22:14:52');
INSERT INTO `game` VALUES (1038, 'cl', '粉玫瑰', '03', '江西', '美丽鲜花有限公司', '2024-04-01', '1.jpg', '粉色地玫瑰花', 120.00, 7, '2024-04-01 18:29:27');
INSERT INTO `game` VALUES (1040, 'b', '大红花', '3', '江西', '美丽鲜花有限公司', '2024-03-01', '111.jpg', '又大又红', 12.00, 12, '2024-04-01 18:39:05');
INSERT INTO `game` VALUES (1041, 'ooo', '白月季', '3', '江西', '美丽鲜花有限公司', '2024-04-02', '1.jpg', '', 32.00, 1, '2024-04-02 17:57:56');
INSERT INTO `game` VALUES (1042, 'b', '红月季', '4', '江西', '美丽鲜花有限公司', '2024-02-02', '1.jpg', '', 10.00, 20, '2024-04-02 17:59:52');
INSERT INTO `game` VALUES (1043, 'b', '大红', '5', '进行', '美丽鲜花有限公司', '2024-02-03', '1.jpg', '火山红鲜花', 123.00, 10, '2024-04-03 10:53:12');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单子项ID',
  `order_id` int(0) UNSIGNED NOT NULL COMMENT '订单ID',
  `game_id` int(0) UNSIGNED NOT NULL COMMENT '游戏ID',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `quantity` int(0) UNSIGNED NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`order_item_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `book_id`(`game_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 2, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (2, 3, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (3, 4, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (5, 6, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (6, 7, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (7, 8, 1036, 123.00, 1);
INSERT INTO `order_item` VALUES (8, 9, 1038, 120.00, 1);
INSERT INTO `order_item` VALUES (9, 10, 1038, 120.00, 1);
INSERT INTO `order_item` VALUES (10, 11, 1038, 120.00, 1);
INSERT INTO `order_item` VALUES (11, 11, 1041, 32.00, 1);
INSERT INTO `order_item` VALUES (12, 12, 1041, 32.00, 8);
INSERT INTO `order_item` VALUES (13, 13, 1037, 22.00, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(0) UNSIGNED NOT NULL COMMENT '用户ID',
  `consignee_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收货地址',
  `zip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '邮政编号',
  `phone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '联系方式',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '审核状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (2, 1, '123', '123', '271100', '13888888888', b'1', '2024-02-20 22:11:33');
INSERT INTO `orders` VALUES (3, 1, '11', '大苏打', '271100', '13888888888', b'1', '2024-02-20 22:12:45');
INSERT INTO `orders` VALUES (4, 2020001, '1', '213', '271100', '13878888888', b'0', '2024-03-04 15:03:11');
INSERT INTO `orders` VALUES (6, 2020003, 'xiaom', '123', '271100', '13333333333', b'0', '2024-03-22 09:05:09');
INSERT INTO `orders` VALUES (8, 2020003, '123', 'qwe', '271100', '13333333333', b'0', '2024-03-22 09:12:11');
INSERT INTO `orders` VALUES (9, 2020005, '254', '123', '321456', '125', b'0', '2024-04-02 13:35:02');
INSERT INTO `orders` VALUES (10, 2020006, '小龙', '江西省', '321', '18879959845', b'0', '2024-04-02 13:53:10');
INSERT INTO `orders` VALUES (11, 2020005, '1', '321', '123', '12345678936', b'0', '2024-04-03 11:27:11');
INSERT INTO `orders` VALUES (12, 2020005, '小米', '北京', '123', '12345678936', b'0', '2024-04-03 11:37:51');
INSERT INTO `orders` VALUES (13, 2020005, '小米', '北京', '123', '12345678936', b'0', '2024-04-07 14:18:48');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `cart_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `user_id` int(0) UNSIGNED NOT NULL COMMENT '用户ID',
  `game_id` int(0) UNSIGNED NOT NULL COMMENT '游戏ID',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '游戏价格',
  `quantity` int(0) UNSIGNED NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`cart_id`) USING BTREE,
  UNIQUE INDEX `cart_id`(`cart_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`game_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES (1, 2020002, 1036, 123.00, 1);
INSERT INTO `shopping_cart` VALUES (9, 2020005, 1040, 12.00, 1);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户头像',
  `join_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2020008 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '111111', '', '', '2024-02-20 11:20:05');
INSERT INTO `user_info` VALUES (2020001, 'dnld77', '111111', 'aaa@qq.com', '', '2024-02-20 11:25:50');
INSERT INTO `user_info` VALUES (2020002, '999', '999999', '999@qq.com', '', '2024-03-22 09:03:10');
INSERT INTO `user_info` VALUES (2020003, '888', '888888', '888@qq.com', '', '2024-03-22 09:04:26');
INSERT INTO `user_info` VALUES (2020004, '321', '123456', '1234@qq.com', '', '2024-03-27 13:58:48');
INSERT INTO `user_info` VALUES (2020005, '456', '987456', '1@qq.com', '', '2024-04-01 18:03:12');
INSERT INTO `user_info` VALUES (2020006, '123', '456789', '123@qq.com', '', '2024-04-02 13:51:35');
INSERT INTO `user_info` VALUES (2020007, '234', '123456', '123@qq.com', '', '2024-04-06 20:39:23');

SET FOREIGN_KEY_CHECKS = 1;
