/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : activity_manage

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2019-06-29 22:44:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseinfo` varchar(64) DEFAULT NULL,
  `planinfo` varchar(255) DEFAULT NULL,
  `dateinfo` varchar(64) DEFAULT NULL,
  `school` varchar(255) DEFAULT '',
  `college` varchar(255) DEFAULT '',
  `name` varchar(64) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  `classcount` int(11) NOT NULL DEFAULT '0',
  `source_operator_id` int(11) DEFAULT NULL,
  `options` varchar(32) NOT NULL DEFAULT '111',
  `attention` varchar(255) DEFAULT '',
  `type` int(11) NOT NULL,
  `Instructor_user_id` int(11) DEFAULT '0',
  `createdate` date NOT NULL,
  `operator_id` int(11) NOT NULL,
  `charge_operator_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(255) DEFAULT '',
  `user_ids` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '课程信息1', '活动计划安排信息', '日期安排信息', '理学与信息科学院', '理信学院', '宣讲会', '3', '0', '1', '011', '活动注意事项', '1', '1', '2018-09-28', '1', '1', '0', '', '8,7,9');
INSERT INTO `activity` VALUES ('2', '课程信息2', '活动计划安排信息', '每学期第二周', '理学与信息科学学院', '数软学院', '校内实训', '2', '0', '1', '101', '必修有学分', '0', '0', '2018-09-28', '3', '1', '0', '', '8,7');
INSERT INTO `activity` VALUES ('3', 'Java', '每天晚上7点到9点', '每天晚上', '生命科学学院', '', 'IT培训', '1', '0', '3', '100', '确保每个人都参加', '0', '0', '2018-12-25', '1', '0', '0', '', '7');
INSERT INTO `activity` VALUES ('4', '阿斯蒂芬', '计划安排', '每周六', '动物医学院', '', '动医实训', '1', '0', '5', '100', '注意事项', '0', '0', '2019-05-23', '4', '0', '0', '组织备注', '8');
INSERT INTO `activity` VALUES ('8', '', 'ddd', '', '植物医学院', '', '测试', '1', '0', null, '010', '', '2', '0', '2019-05-23', '7', '0', '0', '', '8');
INSERT INTO `activity` VALUES ('9', '跑步', '', '周六', '动物医学院', '', '快乐慢跑', '2', '0', null, '000', '', '2', '0', '2019-05-24', '1', '0', '0', '', '7,8');

-- ----------------------------
-- Table structure for activity_checkwork
-- ----------------------------
DROP TABLE IF EXISTS `activity_checkwork`;
CREATE TABLE `activity_checkwork` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `check1` int(11) NOT NULL,
  `check2` int(11) NOT NULL,
  `check3` int(11) NOT NULL,
  `lastdate` varchar(255) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `comments` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_checkwork
-- ----------------------------
INSERT INTO `activity_checkwork` VALUES ('1', '2', '1', '2018-09-28', '1', '1', '1', '2018-09-29 12:37:51', '1', '');
INSERT INTO `activity_checkwork` VALUES ('2', '1', '1', '2018-10-05', '2', '1', '1', '2019-5-23 12:38:59', '1', ' ');
INSERT INTO `activity_checkwork` VALUES ('3', '1', '2', '2018-10-01', '1', '1', '1', '2018-09-29 12:37:51', '1', ' ');
INSERT INTO `activity_checkwork` VALUES ('5', '2', '3', '2018-10-05', '1', '1', '0', '2018-10-04 19:39:55', '1', ' ');
INSERT INTO `activity_checkwork` VALUES ('11', '1', '2', '2018-09-28', '0', '0', '0', '2018-9-29 14:36:43', '1', '');
INSERT INTO `activity_checkwork` VALUES ('12', '1', '1', '2018-09-28', '0', '0', '0', '2018-9-29 14:36:43', '1', '');
INSERT INTO `activity_checkwork` VALUES ('13', '2', '1', '2018-10-05', '1', '1', '0', '2018-10-04 19:39:55', '1', '');
INSERT INTO `activity_checkwork` VALUES ('14', '2', '2', '2018-10-05', '1', '1', '0', '2018-10-04 19:39:55', '1', '');
INSERT INTO `activity_checkwork` VALUES ('15', '2', '6', '2018-10-05', '1', '1', '0', '2018-10-04 19:39:55', '1', '');
INSERT INTO `activity_checkwork` VALUES ('16', '2', '2', '2018-09-28', '0', '0', '0', '2018-9-29 16:38:20', '1', '');
INSERT INTO `activity_checkwork` VALUES ('17', '2', '6', '2018-09-28', '0', '0', '0', '2018-9-29 16:38:20', '1', '');
INSERT INTO `activity_checkwork` VALUES ('18', '2', '3', '2018-09-28', '0', '0', '0', '2018-10-07 9:38:14', '1', '');
INSERT INTO `activity_checkwork` VALUES ('19', '1', '2', '2018-10-05', '0', '0', '0', '2018-10-07 9:38:46', '1', '');
INSERT INTO `activity_checkwork` VALUES ('20', '2', '3', '2018-10-13', '1', '0', '2', '2018-10-17 10:17:08', '1', '');
INSERT INTO `activity_checkwork` VALUES ('21', '2', '6', '2018-10-13', '1', '0', '2', '2018-10-17 10:17:08', '1', '');
INSERT INTO `activity_checkwork` VALUES ('22', '2', '3', '2018-10-24', '1', '0', '0', '2018-10-19 14:08:41', '1', '');
INSERT INTO `activity_checkwork` VALUES ('23', '2', '4', '2018-10-24', '1', '0', '0', '2018-10-19 14:08:41', '1', '');
INSERT INTO `activity_checkwork` VALUES ('24', '2', '6', '2018-10-24', '0', '0', '0', '2018-10-17 10:43:04', '1', '');
INSERT INTO `activity_checkwork` VALUES ('25', '2', '3', '2018-10-28', '2', '1', '1', '2018-12-25 20:30:28', '1', 'sgd');
INSERT INTO `activity_checkwork` VALUES ('26', '2', '4', '2018-10-28', '1', '1', '0', '2018-11-6 14:33:07', '1', 'asdf');
INSERT INTO `activity_checkwork` VALUES ('27', '2', '6', '2018-10-28', '2', '1', '0', '2018-11-6 14:32:59', '1', '');
INSERT INTO `activity_checkwork` VALUES ('28', '2', '3', '2018-10-27', '0', '0', '0', '2018-11-6 14:43:44', '1', '');
INSERT INTO `activity_checkwork` VALUES ('29', '2', '4', '2018-10-27', '0', '0', '0', '2018-11-6 14:43:44', '1', '');
INSERT INTO `activity_checkwork` VALUES ('30', '2', '6', '2018-10-27', '0', '0', '0', '2018-11-6 14:43:44', '1', '');
INSERT INTO `activity_checkwork` VALUES ('31', '2', '3', '2019-05-23', '0', '0', '0', '2019-5-23 18:45:08', '1', '');
INSERT INTO `activity_checkwork` VALUES ('32', '2', '4', '2019-05-23', '0', '0', '0', '2019-5-23 18:45:08', '1', '');
INSERT INTO `activity_checkwork` VALUES ('33', '8', '2', '2019-05-23', '1', '1', '0', '2019-5-23 20:42:57', '1', '');
INSERT INTO `activity_checkwork` VALUES ('34', '8', '2', '2019-05-25', '1', '3', '0', '2019-5-24 23:02:13', '1', '');
INSERT INTO `activity_checkwork` VALUES ('35', '9', '2', '2019-06-03', '0', '0', '0', '2019-6-6 17:15:14', '1', '');
INSERT INTO `activity_checkwork` VALUES ('36', '9', '7', '2019-06-09', '1', '1', '3', '2019-6-10 8:17:28', '1', '');
INSERT INTO `activity_checkwork` VALUES ('37', '8', '8', '2019-05-25', '1', '1', '4', '2019-6-8 22:31:07', '1', '晚上有急事');
INSERT INTO `activity_checkwork` VALUES ('38', '8', '8', '2019-05-23', '0', '0', '0', '2019-6-8 22:07:24', '1', '');
INSERT INTO `activity_checkwork` VALUES ('39', '9', '7', '2019-06-08', '1', '2', '1', '2019-6-9 11:15:21', '1', '');
INSERT INTO `activity_checkwork` VALUES ('40', '9', '8', '2019-06-08', '1', '1', '4', '2019-6-9 11:15:09', '1', '晚上有紧急事情');
INSERT INTO `activity_checkwork` VALUES ('41', '9', '7', '2019-06-10', '1', '3', '0', '2019-6-10 15:36:42', '1', '');
INSERT INTO `activity_checkwork` VALUES ('42', '9', '8', '2019-06-10', '1', '3', '0', '2019-6-10 15:36:42', '1', '');

-- ----------------------------
-- Table structure for activity_college
-- ----------------------------
DROP TABLE IF EXISTS `activity_college`;
CREATE TABLE `activity_college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_college
-- ----------------------------
INSERT INTO `activity_college` VALUES ('1', '-', '1');
INSERT INTO `activity_college` VALUES ('10', '人工智能', '2');
INSERT INTO `activity_college` VALUES ('11', '大数据', '2');
INSERT INTO `activity_college` VALUES ('12', '信计', '2');
INSERT INTO `activity_college` VALUES ('13', '动物药理', '3');
INSERT INTO `activity_college` VALUES ('14', '信工', '2');
INSERT INTO `activity_college` VALUES ('15', '计算机科学与技术（软件外包Java方向）', '2');
INSERT INTO `activity_college` VALUES ('16', '互联网', '2');
INSERT INTO `activity_college` VALUES ('20', '植物药理', '4');
INSERT INTO `activity_college` VALUES ('21', '物联网', '2');
INSERT INTO `activity_college` VALUES ('22', '韩语', '6');
INSERT INTO `activity_college` VALUES ('23', '英语', '6');
INSERT INTO `activity_college` VALUES ('24', '俄语', '6');
INSERT INTO `activity_college` VALUES ('25', '生命护理', '5');
INSERT INTO `activity_college` VALUES ('26', '农作物病理', '4');
INSERT INTO `activity_college` VALUES ('27', '动物病理', '3');

-- ----------------------------
-- Table structure for activity_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `activity_evaluation`;
CREATE TABLE `activity_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `point` double(11,2) NOT NULL DEFAULT '0.00',
  `status` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(255) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_evaluation
-- ----------------------------
INSERT INTO `activity_evaluation` VALUES ('18', '4', '8', '100.00', '0', '', '非常棒');
INSERT INTO `activity_evaluation` VALUES ('19', '3', '7', '90.00', '0', '', '值得培养');
INSERT INTO `activity_evaluation` VALUES ('20', '2', '8', '99.00', '0', '', '几乎完美');
INSERT INTO `activity_evaluation` VALUES ('21', '2', '7', '60.00', '0', '', '一般般');
INSERT INTO `activity_evaluation` VALUES ('22', '1', '8', '100.00', '0', '', '666');
INSERT INTO `activity_evaluation` VALUES ('23', '8', '8', '98.00', '0', '', '非常棒');
INSERT INTO `activity_evaluation` VALUES ('24', '9', '7', '0.00', '0', '', '');
INSERT INTO `activity_evaluation` VALUES ('25', '1', '7', '0.00', '0', '', '');
INSERT INTO `activity_evaluation` VALUES ('26', '1', '9', '0.00', '0', '', '');

-- ----------------------------
-- Table structure for activity_feedback
-- ----------------------------
DROP TABLE IF EXISTS `activity_feedback`;
CREATE TABLE `activity_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_time_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `opt1` varchar(32) NOT NULL DEFAULT '',
  `opt2` varchar(32) NOT NULL DEFAULT '',
  `opt3` varchar(32) NOT NULL DEFAULT '',
  `opt4` varchar(32) NOT NULL DEFAULT '',
  `opt5` varchar(32) NOT NULL DEFAULT '',
  `opt6` varchar(32) NOT NULL DEFAULT '',
  `text1` varchar(64) NOT NULL DEFAULT '',
  `text2` varchar(64) NOT NULL DEFAULT '',
  `text3` varchar(64) NOT NULL DEFAULT '',
  `text4` varchar(64) NOT NULL DEFAULT '',
  `text5` varchar(64) NOT NULL DEFAULT '',
  `text6` varchar(64) NOT NULL DEFAULT '',
  `result` varchar(64) NOT NULL DEFAULT '',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_feedback
-- ----------------------------
INSERT INTO `activity_feedback` VALUES ('1', '18', '3', '', '', '', '', '', '', '', '', '', '', '', '', '嗷嗷111', '0');
INSERT INTO `activity_feedback` VALUES ('2', '18', '6', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('3', '19', '3', '', '', '', '', '', '', '', '', '', '', '', '', '还阔以', '0');
INSERT INTO `activity_feedback` VALUES ('4', '19', '6', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('5', '20', '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('6', '20', '6', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('7', '20', '2', '', '', '', '', '', '', '', '', '', '', '', '', 'ssaasadsdff', '1');
INSERT INTO `activity_feedback` VALUES ('8', '21', '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('9', '21', '4', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('10', '21', '6', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('11', '21', '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('12', '21', '4', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('13', '21', '6', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('14', '22', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('15', '23', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('16', '23', '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('17', '24', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('18', '24', '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('19', '25', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('20', '26', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('21', '27', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('22', '28', '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('23', '29', '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('24', '30', '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `activity_feedback` VALUES ('25', '30', '8', '', '', '', '', '', '', '', '', '', '', '', '', '', '0');

-- ----------------------------
-- Table structure for activity_market
-- ----------------------------
DROP TABLE IF EXISTS `activity_market`;
CREATE TABLE `activity_market` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `info` varchar(255) NOT NULL,
  `json` text NOT NULL,
  `comments` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_market
-- ----------------------------
INSERT INTO `activity_market` VALUES ('1', '1', '1', '2018-09-24', '有3个想要报名', '[{\"name\":\"张三丰\",\"id\":\"1\",\"level\":\"B\",\"info\":\"想要报名\"}]', '还可以');
INSERT INTO `activity_market` VALUES ('5', '2', '1', '2018-10-13', '有几个有意向报名', '[{\"name\":\"杨过\",\"id\":\"3\",\"level\":\"B\",\"info\":\"有意向\"}]', '整体情况一般');
INSERT INTO `activity_market` VALUES ('6', '2', '1', '2018-10-24', '有3个想要报名', '[{\"name\":\"周伯通\",\"id\":\"4\",\"level\":\"B\",\"info\":\"想要报名\"},{\"name\":\"杨过\",\"id\":\"3\",\"level\":\"A\",\"info\":\"想要报名\"}]', '还可以');
INSERT INTO `activity_market` VALUES ('7', '2', '1', '2018-10-28', '', '[{\"name\":\"周伯通\",\"id\":\"4\",\"level\":\"A\",\"info\":\"个\"}]', '');
INSERT INTO `activity_market` VALUES ('8', '1', '1', '2019-05-23', '', '[]', '');
INSERT INTO `activity_market` VALUES ('9', '8', '5', '2019-05-23', '', '[]', '');

-- ----------------------------
-- Table structure for activity_notice
-- ----------------------------
DROP TABLE IF EXISTS `activity_notice`;
CREATE TABLE `activity_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL DEFAULT '',
  `operator_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL DEFAULT '',
  `info` varchar(255) NOT NULL DEFAULT '',
  `status` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_notice
-- ----------------------------
INSERT INTO `activity_notice` VALUES ('5', '1', '20180919', '1', '1111111111', '让他好过特然后他还特好', '0', '1');
INSERT INTO `activity_notice` VALUES ('6', '1', '20180890', '1', '合同和儿童特瑞特', '合同合同人体呵呵因为个人个人痛苦【hetahjetrahae--ghjertaphetjmhoetahethet而如果i哦我还我如果我如果i 个人为个人感悟人嘎我恶化认为各位如果配哦然后个他回家饿啊让他【合同和配套和个人【ohg如何啊客人哈儿挺好i哦而他【平衡可让他会更热破锅；而更为人和副攻i问问然后给我如果和你哦', '1', '0');

-- ----------------------------
-- Table structure for activity_operator
-- ----------------------------
DROP TABLE IF EXISTS `activity_operator`;
CREATE TABLE `activity_operator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(255) NOT NULL DEFAULT '',
  `pass` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` int(11) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `power` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `comments` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_operator
-- ----------------------------
INSERT INTO `activity_operator` VALUES ('1', '17863933965', '3032B963A259075B964B07153D3C4B70', '张三', '0', '17863933965', '0', '0', '');
INSERT INTO `activity_operator` VALUES ('3', '13546897456', '3032B963A259075B964B07153D3C4B70', '李四', '0', '13546897456', '0', '0', '');
INSERT INTO `activity_operator` VALUES ('4', '13569856324', '3032B963A259075B964B07153D3C4B70', '王五', '0', '13569856324', '1', '0', '');
INSERT INTO `activity_operator` VALUES ('5', '13127033965', '3032B963A259075B964B07153D3C4B70', '张家祥', '1', '15465987896', '1', '0', '');
INSERT INTO `activity_operator` VALUES ('6', '13586954565', '3032B963A259075B964B07153D3C4B70', '赵六', '1', '13586954565', '0', '0', '');
INSERT INTO `activity_operator` VALUES ('7', '123456789', '3032B963A259075B964B07153D3C4B70', '老七七', '0', '12312312356', '0', '0', '');

-- ----------------------------
-- Table structure for activity_report
-- ----------------------------
DROP TABLE IF EXISTS `activity_report`;
CREATE TABLE `activity_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '5',
  `date` varchar(255) NOT NULL,
  `tprogress` varchar(255) NOT NULL DEFAULT '',
  `sprogress` varchar(255) NOT NULL DEFAULT '',
  `cprogress` varchar(255) NOT NULL DEFAULT '',
  `json` text NOT NULL,
  `comments` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_report
-- ----------------------------
INSERT INTO `activity_report` VALUES ('19', '2', '1', '2018-09-28', '', '', '', '[{\"name\":\"王重阳\",\"id\":\"6\",\"info\":\"上课时候神游泰山\"}]', '');
INSERT INTO `activity_report` VALUES ('20', '2', '1', '2018-10-05', '', '听课认真，回答积极', '', '[{\"name\":\"张三丰\",\"id\":\"1\",\"info\":\"上课打太极\"}]', '');
INSERT INTO `activity_report` VALUES ('21', '1', '1', '2018-09-28', '', '', '', '[{\"name\":\"郭靖\",\"id\":\"2\",\"info\":\"\"}]', '');
INSERT INTO `activity_report` VALUES ('22', '1', '1', '2018-10-05', '', '', '', '[{\"name\":\"郭靖\",\"id\":\"2\",\"info\":\"上课练降龙十八掌\"}]', '');
INSERT INTO `activity_report` VALUES ('23', '1', '5', '2018-10-01', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('24', '2', '5', '2018-10-13', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('25', '2', '5', '2018-10-24', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('26', '2', '1', '2018-10-28', '', '', '', '[{\"name\":\"杨过\",\"id\":\"3\",\"info\":\"asdf\"}]', '');
INSERT INTO `activity_report` VALUES ('27', '2', '5', '2018-10-27', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('28', '2', '5', '2019-05-27', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('30', '8', '1', '2019-05-24', '超额完成', '精神饱满', '略有瑕疵', '[]', '');
INSERT INTO `activity_report` VALUES ('31', '8', '1', '2019-05-25', '全部完成', '精神焕发', '非常完美', '[]', '');
INSERT INTO `activity_report` VALUES ('37', '8', '7', '2019-05-23', '全部完成', '精神饱满', '非常不错', '[]', '');
INSERT INTO `activity_report` VALUES ('38', '9', '5', '2019-06-08', '', '', '', '[]', '');
INSERT INTO `activity_report` VALUES ('39', '9', '5', '2019-06-10', '', '', '', '[]', '');

-- ----------------------------
-- Table structure for activity_school
-- ----------------------------
DROP TABLE IF EXISTS `activity_school`;
CREATE TABLE `activity_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_school
-- ----------------------------
INSERT INTO `activity_school` VALUES ('1', '-');
INSERT INTO `activity_school` VALUES ('2', '理学与信息科学学院');
INSERT INTO `activity_school` VALUES ('3', '动物医学院');
INSERT INTO `activity_school` VALUES ('4', '植物医学院');
INSERT INTO `activity_school` VALUES ('5', '生命科学学院');
INSERT INTO `activity_school` VALUES ('6', '外国语学院');

-- ----------------------------
-- Table structure for activity_summary
-- ----------------------------
DROP TABLE IF EXISTS `activity_summary`;
CREATE TABLE `activity_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `createdate` varchar(255) NOT NULL,
  `options` varchar(255) NOT NULL,
  `sstatus` varchar(255) DEFAULT NULL,
  `tstatus` varchar(255) DEFAULT NULL,
  `cstatus` varchar(255) DEFAULT NULL,
  `xstatus` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `proposal` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_summary
-- ----------------------------
INSERT INTO `activity_summary` VALUES ('1', '1', '1', '2018-09-24', '100', '良好', '良好', '良好', '良好', '都很好', '没啥建议', '很不错');
INSERT INTO `activity_summary` VALUES ('10', '2', '1', '2018-09-23', '021', '很棒', '很棒', '很棒', '很棒', '都很棒', '没啥意见', '都相当棒');
INSERT INTO `activity_summary` VALUES ('14', '8', '7', '2019-05-25', '000', 'asdf', 'asdf', 'adf', 'adsf', 'asdf', 'asf', 'asdf');

-- ----------------------------
-- Table structure for activity_time
-- ----------------------------
DROP TABLE IF EXISTS `activity_time`;
CREATE TABLE `activity_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `date` varchar(64) NOT NULL,
  `time1` varchar(32) NOT NULL DEFAULT '',
  `time2` varchar(32) NOT NULL DEFAULT '',
  `time3` varchar(32) NOT NULL DEFAULT '',
  `time4` varchar(32) NOT NULL DEFAULT '',
  `time5` varchar(32) NOT NULL DEFAULT '',
  `time6` varchar(32) NOT NULL DEFAULT '',
  `roominfo` varchar(64) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_time
-- ----------------------------
INSERT INTO `activity_time` VALUES ('12', '2', '2018-09-28', '', '', '', '', '19:00', '21:00', '软件园', '1', '2', '');
INSERT INTO `activity_time` VALUES ('13', '2', '2018-10-05', '', '', '', '', '19:00', '21:00', '软件园', '1', '2', '');
INSERT INTO `activity_time` VALUES ('14', '1', '2018-09-28', '', '', '', '', '19:00', '21:00', '盈园商务中心', '2', '2', '');
INSERT INTO `activity_time` VALUES ('15', '1', '2018-10-05', '', '', '', '', '19:00', '21:00', '盈园商务中心', '2', '2', '');
INSERT INTO `activity_time` VALUES ('16', '1', '2019-05-23', '08:00', '12:00', '14:00', '15:30', '', '', '大润发', '4', '2', '');
INSERT INTO `activity_time` VALUES ('18', '2', '2018-10-13', '08:00', '08:00', '', '', '', '', 'xxx', '1', '2', '');
INSERT INTO `activity_time` VALUES ('19', '2', '2018-10-24', '08:00', '12:00', '', '', '', '', 'aaaa', '1', '2', '');
INSERT INTO `activity_time` VALUES ('20', '2', '2018-10-27', '08:00', '12:00', '', '', '', '', 'aaaa', '1', '2', '');
INSERT INTO `activity_time` VALUES ('21', '2', '2019-05-23', '13:45', '22:00', '', '', '', '', 'asdf', '1', '2', '');
INSERT INTO `activity_time` VALUES ('22', '8', '2019-05-23', '08:00', '', '', '', '', '21:00', 'hongzi', '7', '2', '');
INSERT INTO `activity_time` VALUES ('23', '4', '2019-05-23', '00:00', '', '', '', '', '21:00', '', '1', '2', '');
INSERT INTO `activity_time` VALUES ('24', '4', '2019-05-24', '00:00', '', '', '', '', '23:00', 'dddd', '7', '2', '');
INSERT INTO `activity_time` VALUES ('25', '8', '2019-05-24', '00:00', '', '', '', '', '21:00', '', '1', '2', '');
INSERT INTO `activity_time` VALUES ('26', '8', '2019-05-25', '08:00', '', '', '', '', '21:00', '', '1', '2', '');
INSERT INTO `activity_time` VALUES ('29', '9', '2019-06-08', '08:00', '11:00', '14:00', '17:00', '19:00', '23:59', '知音广场', '1', '2', '');
INSERT INTO `activity_time` VALUES ('30', '9', '2019-06-10', '08:00', '11:30', '14:00', '17:30', '19:00', '21:00', 'C111', '1', '1', '');

-- ----------------------------
-- Table structure for activity_user
-- ----------------------------
DROP TABLE IF EXISTS `activity_user`;
CREATE TABLE `activity_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nike` varchar(255) NOT NULL DEFAULT '',
  `pass` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` int(11) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `classinfo` varchar(60) DEFAULT NULL,
  `ylevel` int(11) DEFAULT NULL,
  `glevel` varchar(255) DEFAULT '',
  `sex` int(11) NOT NULL DEFAULT '0',
  `qq` varchar(255) DEFAULT NULL,
  `slevel` int(11) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `createdate` varchar(255) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_user
-- ----------------------------
INSERT INTO `activity_user` VALUES ('7', '111111', '123', '王小二', '0', '11111111', '软件外包', '0', '0', '0', '111222333', '0', '2', '21', '0', null, '2019-05-23 13:52', '1', '北湖');
INSERT INTO `activity_user` VALUES ('8', '13127033965', '123', '张家祥', '0', '13127033965', '软件1505', '0', '0', '0', '1010858809', '0', '2', '15', '0', null, '2019-06-08 21:58', '1', '');
INSERT INTO `activity_user` VALUES ('9', '1111', '123', '萌小明', '0', '12345678910', '韩语1501', '0', '0', '1', '9040332', '0', '6', '22', '0', null, '2019-06-08 22:00', '1', '');

-- ----------------------------
-- Table structure for activity_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `activity_usergroup`;
CREATE TABLE `activity_usergroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `ids` varchar(255) NOT NULL,
  `project` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `point1` double(11,2) DEFAULT NULL,
  `point2` double(11,2) DEFAULT NULL,
  `point3` double(11,2) DEFAULT NULL,
  `point4` double(11,2) DEFAULT NULL,
  `point5` double(11,2) DEFAULT NULL,
  `point6` double(11,2) DEFAULT NULL,
  `createdate` varchar(255) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_usergroup
-- ----------------------------
INSERT INTO `activity_usergroup` VALUES ('2', '一手遮天', '1', '5,1', '管理系统', 'c:/project2', '50.00', '10.00', '0.00', '0.00', '0.00', '0.00', '2018-09-16 20:59:50', '2', '完美');
INSERT INTO `activity_usergroup` VALUES ('3', '241', '1', '8', '闲书屋', 'c:/xianshuwu', '100.00', '99.00', '98.00', '89.00', '0.00', '0.00', '2018-9-16 23:31:15', '1', '很有创意');
INSERT INTO `activity_usergroup` VALUES ('16', '多对多', '1', '7', '多对多', 'file:///e:/tmp/logging.properties', '78.00', '98.00', '67.00', '89.00', '56.00', '0.00', '2018-9-25 17:37:21', '1', '');
INSERT INTO `activity_usergroup` VALUES ('18', '方法对付', '1', '9', '多多对多', 'file:///e:/tmp/logging.properties', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2018-9-26 11:00:15', '1', '');
INSERT INTO `activity_usergroup` VALUES ('19', '嗨嗨嗨', '2', '8', '在线商城', 'file:///e:/tmp/logging.properties', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2018-10-17 9:45:26', '1', '');
INSERT INTO `activity_usergroup` VALUES ('20', '飒飒的说法', '2', '7', 'ui设计', 'file:///e:/tmp/logging.properties', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2018-10-17 9:45:54', '1', '');
INSERT INTO `activity_usergroup` VALUES ('22', '吧', '4', '8', '的', '', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2019-5-23 13:59:34', '1', '');
INSERT INTO `activity_usergroup` VALUES ('24', '嗯嗯', '8', '8', '符', '', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2019-5-23 20:56:55', '1', '');
INSERT INTO `activity_usergroup` VALUES ('25', '无敌', '9', '7', '跑得快', '', '100.00', '98.00', '89.00', '96.00', '0.00', '0.00', '2019-6-8 22:08:21', '1', '很棒');
