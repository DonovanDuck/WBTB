/*
Navicat MySQL Data Transfer

Source Server         : yyx
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : tbox

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-10-24 16:30:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for moob_noteabout
-- ----------------------------
DROP TABLE IF EXISTS `moob_noteabout`;
CREATE TABLE `moob_noteabout` (
  `aboutId` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `aboutName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aboutId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moob_noteabout
-- ----------------------------

-- ----------------------------
-- Table structure for mood_aftertime
-- ----------------------------
DROP TABLE IF EXISTS `mood_aftertime`;
CREATE TABLE `mood_aftertime` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `afterAcontent` text,
  `afrom` int(11) DEFAULT NULL,
  `astatus` int(11) DEFAULT NULL,
  `abegin` varchar(255) DEFAULT NULL,
  `aend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_aftertime
-- ----------------------------

-- ----------------------------
-- Table structure for mood_authority
-- ----------------------------
DROP TABLE IF EXISTS `mood_authority`;
CREATE TABLE `mood_authority` (
  `noteId` int(11) NOT NULL,
  `friendNumber` varchar(11) DEFAULT NULL,
  `obvious` int(11) DEFAULT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_authority
-- ----------------------------
INSERT INTO `mood_authority` VALUES ('42', '9429390675', '0');
INSERT INTO `mood_authority` VALUES ('44', '9429390675', '1');
INSERT INTO `mood_authority` VALUES ('52', null, '1');
INSERT INTO `mood_authority` VALUES ('53', null, '1');
INSERT INTO `mood_authority` VALUES ('54', null, '1');
INSERT INTO `mood_authority` VALUES ('55', null, '1');
INSERT INTO `mood_authority` VALUES ('56', null, '1');
INSERT INTO `mood_authority` VALUES ('57', null, '1');
INSERT INTO `mood_authority` VALUES ('58', null, '1');
INSERT INTO `mood_authority` VALUES ('59', null, '1');
INSERT INTO `mood_authority` VALUES ('97', '9429390675', '1');

-- ----------------------------
-- Table structure for mood_category
-- ----------------------------
DROP TABLE IF EXISTS `mood_category`;
CREATE TABLE `mood_category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_category
-- ----------------------------
INSERT INTO `mood_category` VALUES ('1', '亲人');
INSERT INTO `mood_category` VALUES ('2', '爱人');
INSERT INTO `mood_category` VALUES ('3', '长辈');
INSERT INTO `mood_category` VALUES ('4', '同事/学');
INSERT INTO `mood_category` VALUES ('5', '朋友');

-- ----------------------------
-- Table structure for mood_color
-- ----------------------------
DROP TABLE IF EXISTS `mood_color`;
CREATE TABLE `mood_color` (
  `uid` int(11) NOT NULL,
  `happy` varchar(255) DEFAULT NULL,
  `angry` varchar(255) DEFAULT NULL,
  `sad` varchar(255) DEFAULT NULL,
  `scard` varchar(255) DEFAULT NULL,
  `commen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_color
-- ----------------------------
INSERT INTO `mood_color` VALUES ('1', 'happy', 'angry', 'sad', 'scard', 'commen');

-- ----------------------------
-- Table structure for mood_drift
-- ----------------------------
DROP TABLE IF EXISTS `mood_drift`;
CREATE TABLE `mood_drift` (
  `driftId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `driftContent` text,
  `sendId` int(11) DEFAULT NULL,
  `identifier` int(11) DEFAULT NULL,
  `driftTime` varchar(255) DEFAULT NULL,
  `checkTheQuantity` int(11) DEFAULT NULL,
  `hate` int(11) DEFAULT NULL,
  PRIMARY KEY (`driftId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_drift
-- ----------------------------
INSERT INTO `mood_drift` VALUES ('5', '前台没提供这个梗，以后再说', '写了一些奇怪的东西哈哈哈哈哈哈哈哈', '33', '1', '2017-10-09 19:34:10', '2', '1');
INSERT INTO `mood_drift` VALUES ('6', '前台没提供这个梗，以后再说', '不卡不啊明明就是那个是谁啊？，的', '33', '1', '2017-10-09 19:36:03', '25', '0');
INSERT INTO `mood_drift` VALUES ('7', '前台没提供这个梗，以后再说', '。。。。。。', '33', '1', '2017-10-09 19:37:42', '13', '0');
INSERT INTO `mood_drift` VALUES ('8', '前台没提供这个梗，以后再说', '你要是', '36', '1', '2017-10-10 16:20:11', '0', '0');
INSERT INTO `mood_drift` VALUES ('9', '前台没提供这个梗，以后再说', '。。。', '36', '1', '2017-10-11 19:02:25', '0', '0');
INSERT INTO `mood_drift` VALUES ('10', '前台没提供这个梗，以后再说', '尼玛币', '36', '1', '2017-10-16 18:56:26', '0', '0');

-- ----------------------------
-- Table structure for mood_drift_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `mood_drift_evaluate`;
CREATE TABLE `mood_drift_evaluate` (
  `drif_evaluateId` int(11) NOT NULL AUTO_INCREMENT,
  `drifCommentId` int(11) DEFAULT NULL,
  `driftId` int(11) DEFAULT NULL,
  `drifIfObv` int(11) DEFAULT NULL,
  `dirfCommentTime` varchar(255) DEFAULT NULL,
  `drifContent` varchar(255) DEFAULT NULL,
  `driftUserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`drif_evaluateId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_drift_evaluate
-- ----------------------------
INSERT INTO `mood_drift_evaluate` VALUES ('1', '36', '7', '0', '2017-10-10 17:28:22', '。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('2', '36', '7', '0', '2017-10-10 19:30:24', '评论2', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('3', '36', '7', '0', '2017-10-10 19:49:42', '。。。评论这个梗', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('4', '36', '6', '0', '2017-10-10 19:53:50', '。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('5', '36', '7', '0', '2017-10-10 19:54:09', '。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('6', '36', '7', '0', '2017-10-10 19:54:27', '。。。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('7', '36', '6', '0', '2017-10-10 20:02:02', '匿名', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('8', '36', '6', '0', '2017-10-10 20:02:02', '匿名', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('9', '36', '6', '0', '2017-10-10 20:16:21', '评论这个东西', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('10', '36', '6', '0', '2017-10-10 20:16:43', '是的，评论', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('11', '36', '6', '0', '2017-10-10 21:09:47', '。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('12', '36', '6', '0', '2017-10-10 21:09:47', '。。。', '忘川呐');
INSERT INTO `mood_drift_evaluate` VALUES ('13', '36', '6', '0', '2017-10-12 19:22:10', '评论N', null);
INSERT INTO `mood_drift_evaluate` VALUES ('14', '36', '6', '0', '2017-10-12 19:22:10', '评论N', null);
INSERT INTO `mood_drift_evaluate` VALUES ('15', '36', '8', '0', '2017-10-10 19:40', '123', '忘川呐');

-- ----------------------------
-- Table structure for mood_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `mood_evaluate`;
CREATE TABLE `mood_evaluate` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `replyId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `commentTime` varchar(255) DEFAULT NULL,
  `ifObv` int(11) DEFAULT NULL,
  `econtent` text,
  `noteId` int(11) DEFAULT NULL,
  `eflag` int(11) DEFAULT NULL,
  `commentNum` varchar(255) DEFAULT NULL,
  `replyNum` varchar(255) DEFAULT NULL,
  `replyEid` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_evaluate
-- ----------------------------
INSERT INTO `mood_evaluate` VALUES ('17', '0', '36', '2017-09-21 21:37:43', '0', '这是第六个纸条的评论', '46', '1', null, null, '0');
INSERT INTO `mood_evaluate` VALUES ('18', '36', '36', '2017-09-21 21:37:51', '1', '是嘛', '46', '2', '9418912858', '9418912858', '17');
INSERT INTO `mood_evaluate` VALUES ('19', '36', '36', '2017-09-21 21:38:16', '1', '哎呀', '46', '3', '9418912858', '9418912858', '18');
INSERT INTO `mood_evaluate` VALUES ('20', '0', '36', '2017-09-22 10:50:56', '1', '还没', '46', '1', '9418912858', null, '0');
INSERT INTO `mood_evaluate` VALUES ('21', '0', '36', '2017-09-22 22:04:20', '1', '评论了这个条儿', '56', '1', '9418912858', null, '0');
INSERT INTO `mood_evaluate` VALUES ('22', '36', '36', '2017-09-22 22:06:05', '1', '回复了刚才的评论', '56', '2', '9418912858', '9418912858', '21');
INSERT INTO `mood_evaluate` VALUES ('23', '0', '36', '2017-09-22 22:07:47', '0', '[爱你]匿名评论', '56', '1', null, null, '0');
INSERT INTO `mood_evaluate` VALUES ('24', '0', '36', '2017-09-22 22:06:05', '1', '回复了刚才的评论', '57', '1', '9418912858', '9418912858', '0');
INSERT INTO `mood_evaluate` VALUES ('25', '0', '33', '2017-10-07 17:42:53', '0', '这是[害羞]匿名评论', '64', '1', null, null, '0');
INSERT INTO `mood_evaluate` VALUES ('26', '33', '33', '2017-10-07 17:43:07', '0', '[鄙视]回复这条匿名评论', '64', '2', '9429390675', null, '25');
INSERT INTO `mood_evaluate` VALUES ('27', '33', '33', '2017-10-07 17:43:18', '1', '都弱爆了！', '64', '3', '9429390675', '9429390675', '26');
INSERT INTO `mood_evaluate` VALUES ('28', '0', '36', '2017-10-22 08:17:25', '1', '这是？', '59', '1', '9418912858', null, '0');

-- ----------------------------
-- Table structure for mood_feedback
-- ----------------------------
DROP TABLE IF EXISTS `mood_feedback`;
CREATE TABLE `mood_feedback` (
  `fe_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fe_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mood_feedback
-- ----------------------------
INSERT INTO `mood_feedback` VALUES ('1', '33', '2323434', '2017-10-7 09:48');
INSERT INTO `mood_feedback` VALUES ('2', '33', '界面有点丑！', '2017-10-7 09:48');
INSERT INTO `mood_feedback` VALUES ('3', '33', '啦啦啦', '2017-10-07 10:56:41');

-- ----------------------------
-- Table structure for mood_friend
-- ----------------------------
DROP TABLE IF EXISTS `mood_friend`;
CREATE TABLE `mood_friend` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `friendNumber` varchar(255) DEFAULT NULL,
  `friendUsername` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `friendTime` varchar(255) DEFAULT NULL,
  `friendNickname` varchar(255) DEFAULT NULL,
  `facing` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `recoverFriend` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_friend
-- ----------------------------
INSERT INTO `mood_friend` VALUES ('32', '9429390675', '小号', '1', '2017-09-21 18:52:25', '莫忘川', '9429390675_-1_0.png', '36', '0');
INSERT INTO `mood_friend` VALUES ('33', '9418912858', '大号', '1', '2017-09-21 21:46:02', '忘川呐', '9418912858_-1_0.png', '33', '1');
INSERT INTO `mood_friend` VALUES ('34', '9418912858', '大号', '1', '2017-09-21 21:46:02', '忘川呐', '9418912858_-1_0.png', '41', '0');

-- ----------------------------
-- Table structure for mood_good
-- ----------------------------
DROP TABLE IF EXISTS `mood_good`;
CREATE TABLE `mood_good` (
  `goodId` int(11) NOT NULL AUTO_INCREMENT,
  `noteId` int(11) DEFAULT NULL,
  `userNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_good
-- ----------------------------

-- ----------------------------
-- Table structure for mood_imageresp
-- ----------------------------
DROP TABLE IF EXISTS `mood_imageresp`;
CREATE TABLE `mood_imageresp` (
  `noteId` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_imageresp
-- ----------------------------
INSERT INTO `mood_imageresp` VALUES ('0', 'tit.png');
INSERT INTO `mood_imageresp` VALUES ('40', '9418912858_40_0.png');
INSERT INTO `mood_imageresp` VALUES ('40', '9418912858_40_1.png');
INSERT INTO `mood_imageresp` VALUES ('42', '9418912858_42_0.png');
INSERT INTO `mood_imageresp` VALUES ('42', '9418912858_42_1.png');
INSERT INTO `mood_imageresp` VALUES ('43', '9418912858_43_0.png');
INSERT INTO `mood_imageresp` VALUES ('43', '9418912858_43_1.png');
INSERT INTO `mood_imageresp` VALUES ('43', '9418912858_43_2.png');
INSERT INTO `mood_imageresp` VALUES ('44', '9418912858_44_0.png');
INSERT INTO `mood_imageresp` VALUES ('44', '9418912858_44_1.png');
INSERT INTO `mood_imageresp` VALUES ('44', '9418912858_44_2.png');
INSERT INTO `mood_imageresp` VALUES ('44', '9418912858_44_3.png');
INSERT INTO `mood_imageresp` VALUES ('50', '9418912858_50_0.png');
INSERT INTO `mood_imageresp` VALUES ('56', '9418912858_56_0.png');
INSERT INTO `mood_imageresp` VALUES ('56', '9418912858_56_1.png');
INSERT INTO `mood_imageresp` VALUES ('57', '9429390675_57_0.png');
INSERT INTO `mood_imageresp` VALUES ('57', '9429390675_57_1.png');
INSERT INTO `mood_imageresp` VALUES ('57', '9429390675_57_2.png');
INSERT INTO `mood_imageresp` VALUES ('59', '9429390675_59_0.png');
INSERT INTO `mood_imageresp` VALUES ('72', '9418912858_72_0.png');
INSERT INTO `mood_imageresp` VALUES ('85', '9418912858_85_0.png');
INSERT INTO `mood_imageresp` VALUES ('86', '9418912858_86_0.png');

-- ----------------------------
-- Table structure for mood_memo
-- ----------------------------
DROP TABLE IF EXISTS `mood_memo`;
CREATE TABLE `mood_memo` (
  `memoId` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `memoName` varchar(255) DEFAULT NULL,
  `friendContent` text,
  PRIMARY KEY (`memoId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_memo
-- ----------------------------
INSERT INTO `mood_memo` VALUES ('20', '33', '33', '你好', '便签');
INSERT INTO `mood_memo` VALUES ('21', '33', '33', '得得', '嘿嘿嘿');
INSERT INTO `mood_memo` VALUES ('24', '36', '32', '喜欢吃', '西瓜');

-- ----------------------------
-- Table structure for mood_note
-- ----------------------------
DROP TABLE IF EXISTS `mood_note`;
CREATE TABLE `mood_note` (
  `noteId` int(11) NOT NULL AUTO_INCREMENT,
  `mood` varchar(255) DEFAULT NULL,
  `noteAdout` varchar(255) DEFAULT NULL,
  `noteContent` text,
  `time` varchar(255) DEFAULT NULL,
  `goodNum` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `egg` int(11) DEFAULT NULL,
  `highOpinion` int(11) DEFAULT NULL,
  `lowOpinion` int(11) DEFAULT NULL,
  `opinionNumber` int(11) DEFAULT NULL,
  `locate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_note
-- ----------------------------
INSERT INTO `mood_note` VALUES ('40', '5', '[\"9429390675\"]', '这是第一个纸条', '2017-09-21 19:03:00', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('41', '4', '[\"9429390675\"]', '这是第二个纸条', '2017-09-21 19:21:57', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('42', '4', '[]', '这是第三个纸条', '2017-09-21 19:37:34', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('43', '1', '[]', '这是第四个纸条', '2017-09-21 20:39:58', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('44', '4', '[\"9429390675\"]', '第五个纸条', '2017-09-21 21:14:39', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('46', '5', '[]', '这是第六个纸条', '2017-09-21 21:34:29', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('47', '2', '[\"9429390675\"]', '这是第七个', '2017-09-22 17:40:53', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('48', '3', '[\"9429390675\"]', '这是155第一', '2017-09-22 17:46:05', null, '33', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('49', '5', '[\"9429390675\"]', '这是第八个纸条，用来调试用', '2017-09-22 17:48:02', null, '36', null, null, null, null, '');
INSERT INTO `mood_note` VALUES ('50', '5', '[\"9429390675\"]', '这是第八个纸条，用来调试用', '2017-09-22 17:51:31', null, '36', null, null, null, null, '');
INSERT INTO `mood_note` VALUES ('51', '5', '[\"9418912858\"]', '第九个纸条，用来调试用', '2017-09-22 18:12:50', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('52', '5', '[\"9418912858\"]', '第九个纸条，用来调试用', '2017-09-22 18:23:45', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('53', '5', '[\"9429390675\"]', '第十个纸条！！！！！！', '2017-09-22 18:45:59', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('54', '3', '[]', '。。。。。。十一', '2017-09-22 19:58:08', null, '36', null, null, null, null, '');
INSERT INTO `mood_note` VALUES ('55', '3', '[\"9418912858\"]', '。。十二', '2017-09-22 19:58:32', null, '36', null, null, null, null, '');
INSERT INTO `mood_note` VALUES ('56', '5', '[]', '写了个条儿', '2017-09-22 22:04:04', null, '36', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('57', '3', '[\"9418912858\"]', '今天很不开心，代码怎么弄也弄不对。唉，数据库太难学了！', '2017-09-25 12:26:09', null, '33', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('58', '2', '[]', '唉～打了十把牌，让我小妹妹全输了，然后她就哭了，哄都哄不好。明天就要走了，唉～心烦……', '2017-09-26 20:33:07', null, '33', null, null, null, null, '山西省-太原市-尖草坪区');
INSERT INTO `mood_note` VALUES ('59', '5', '[]', '唔哇塞。。。笑死我了！', '2017-09-26 20:35:48', null, '33', null, null, null, null, '');
INSERT INTO `mood_note` VALUES ('63', '4', '[\"9418912858\"]', '开放喜欢的荣耀，嘿嘿', '2017-10-07 17:14:26', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('64', '5', '[]', '今天是比赛的最后一天，有点小激动', '2017-10-07 17:39:48', null, '33', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('65', '1', '[]', '咯摸摸', '2017-10-09 21:19:50', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('66', '1', '[]', '咯摸摸', '2017-10-09 21:19:53', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('67', '1', '[]', '咯摸摸', '2017-10-09 21:19:54', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('68', '1', '[]', '咯摸摸', '2017-10-09 21:19:56', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('69', '1', '[]', '咯摸摸', '2017-10-09 21:19:58', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('70', '3', '[]', '。。。', '2017-10-10 10:42:09', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('71', '3', '[]', '。。。。。。', '2017-10-10 10:48:46', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('72', '5', '[\"9429390675\"]', '今天把APP的进度条写出来了，开心', '2017-10-10 21:51:29', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('73', '4', '[\"9429390675\"]', '今天中午吃小火锅，嘿嘿', '2017-10-11 10:41:33', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('74', '4', '[\"9429390675\"]', '今天中午吃小火锅，嘿嘿', '2017-10-11 10:49:57', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('75', '1', '[]', '今天中午吃火锅，第三次说了', '2017-10-11 10:52:04', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('76', '2', '[]', '今天没吃成小火锅，唉', '2017-10-11 19:02:04', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('77', '3', '[]', '今天睡眠时间，16小时。', '2017-10-11 19:22:18', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('78', '3', '[]', '今天睡眠时间，16小时。', '2017-10-11 19:22:45', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('79', '5', '[\"9429390675\"]', '啦卡啦卡精明哦呵呵呵哈哈哈。', '2017-10-11 19:27:48', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('80', '3', '[]', '又写了一个纸条', '2017-10-11 19:29:43', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('81', '3', '[]', '再写个纸条', '2017-10-11 21:45:05', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('82', '4', '[]', '听说有个大数据讲座，哈哈，不屑一顾', '2017-10-12 16:34:07', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('83', '3', '[]', '这个美女好漂亮', '2017-10-12 16:43:53', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('84', '3', '[]', '杜意权貌似不是个帅哥啊，好皮啊！', '2017-10-12 16:56:44', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('85', '1', '[]', '我今天特别不高兴。。。', '2017-10-18 16:40:41', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('86', '4', '[]', '今天跟指导老师进行了最后的讨论，准备参加即将到来的比赛答辩，好紧张啊。。。', '2017-10-19 18:41:19', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('87', '3', '[]', '啦啦啦', '2017-10-21 17:43:10', null, '41', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('88', '3', '[]', '啦啦啦', '2017-10-21 17:43:00', null, '41', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('89', '3', '[]', '今天嗝', '2017-10-21 18:41:16', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('90', '3', '[]', '今天嗝', '2017-10-21 18:41:18', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('91', '3', '[\"9429390675\",\"9429390675\"]', '今天嗝', '2017-10-21 18:41:38', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('92', '3', '[\"9429390675\",\"9429390675\"]', '今天嗝', '2017-10-21 18:41:40', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('93', '3', '[\"9429390675\",\"9429390675\"]', '今天嗝', '2017-10-21 18:41:43', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('94', '3', '[\"9429390675\"]', '明天就要比赛了，好紧张啊。。。', '2017-10-21 18:42:26', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('95', '4', '[]', '今天真的很紧张', '2017-10-21 19:57:34', null, '33', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('96', '4', '[\"9429390675\"]', '今天该比赛了，加油！', '2017-10-22 08:14:15', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('97', '4', '[]', '第一组答辩开始。。。希望春风和你，依旧安好。', '2017-10-22 08:15:57', null, '36', null, null, null, null, null);
INSERT INTO `mood_note` VALUES ('98', '5', '[]', '今天要比赛了，对长帅爆了！！', '2017-10-22 08:16:58', null, '33', null, null, null, null, null);

-- ----------------------------
-- Table structure for mood_noteabout
-- ----------------------------
DROP TABLE IF EXISTS `mood_noteabout`;
CREATE TABLE `mood_noteabout` (
  `aboutId` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `aboutName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aboutId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_noteabout
-- ----------------------------

-- ----------------------------
-- Table structure for mood_push
-- ----------------------------
DROP TABLE IF EXISTS `mood_push`;
CREATE TABLE `mood_push` (
  `uid` int(11) DEFAULT NULL,
  `channelId` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_push
-- ----------------------------
INSERT INTO `mood_push` VALUES ('21', '');
INSERT INTO `mood_push` VALUES ('22', '');
INSERT INTO `mood_push` VALUES ('23', '');
INSERT INTO `mood_push` VALUES ('24', '');
INSERT INTO `mood_push` VALUES ('25', '');
INSERT INTO `mood_push` VALUES ('26', '');
INSERT INTO `mood_push` VALUES ('27', '');
INSERT INTO `mood_push` VALUES ('28', '');
INSERT INTO `mood_push` VALUES ('29', '');
INSERT INTO `mood_push` VALUES ('30', '');
INSERT INTO `mood_push` VALUES ('31', '');
INSERT INTO `mood_push` VALUES ('32', '');
INSERT INTO `mood_push` VALUES ('33', '');
INSERT INTO `mood_push` VALUES ('34', '4129273269619862291');
INSERT INTO `mood_push` VALUES ('35', '');
INSERT INTO `mood_push` VALUES ('36', '');
INSERT INTO `mood_push` VALUES ('37', '4516889113908580579');
INSERT INTO `mood_push` VALUES ('38', '4516889113908580579');
INSERT INTO `mood_push` VALUES ('39', null);
INSERT INTO `mood_push` VALUES ('40', null);
INSERT INTO `mood_push` VALUES ('41', '');
INSERT INTO `mood_push` VALUES ('42', '4516889113908580579');
INSERT INTO `mood_push` VALUES ('43', '4516889113908580579');
INSERT INTO `mood_push` VALUES ('44', '4516889113908580579');

-- ----------------------------
-- Table structure for mood_topic
-- ----------------------------
DROP TABLE IF EXISTS `mood_topic`;
CREATE TABLE `mood_topic` (
  `topicId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `topicContent` text,
  `time` varchar(255) DEFAULT NULL,
  `goodNum` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `opinionNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_topic
-- ----------------------------
INSERT INTO `mood_topic` VALUES ('10', '改变人生轨迹的一次经历', '？。。。。。', '2017-10-18 22:16:21', null, '36', null);
INSERT INTO `mood_topic` VALUES ('11', '改变人生轨迹的一次经历', '。。。。我发了个朋友圈', '2017-10-18 22:17:16', null, '36', null);
INSERT INTO `mood_topic` VALUES ('12', '改变人生轨迹的一次经历', '。。。', '2017-10-18 22:19:17', null, '36', null);
INSERT INTO `mood_topic` VALUES ('13', '改变人生轨迹的一次经历', '。。。', '2017-10-18 22:20:39', null, '36', null);
INSERT INTO `mood_topic` VALUES ('14', '改变人生轨迹的一次经历', '。。。', '2017-10-18 22:21:07', null, '36', null);
INSERT INTO `mood_topic` VALUES ('15', '改变人生轨迹的一次经历', '。。。', '2017-10-18 22:20:57', null, '36', null);
INSERT INTO `mood_topic` VALUES ('16', '改变人生轨迹的一次经历', '。。？', '2017-10-18 22:21:59', null, '36', null);
INSERT INTO `mood_topic` VALUES ('17', '改变人生轨迹的一次经历', '发表意见', '2017-10-19 00:25:52', null, '36', null);
INSERT INTO `mood_topic` VALUES ('18', '改变人生轨迹的一次经历', '发表意见', '2017-10-19 00:36:03', null, '36', null);
INSERT INTO `mood_topic` VALUES ('19', '改变人生轨迹的一次经历', '。。。，这是最新消息！', '2017-10-19 00:44:04', null, '36', null);
INSERT INTO `mood_topic` VALUES ('20', '改变人生轨迹的一次经历', '最新消息', '2017-10-19 00:50:55', null, '36', null);
INSERT INTO `mood_topic` VALUES ('21', '改变人生轨迹的一次经历', '。。。', '2017-10-19 00:54:48', null, '36', null);
INSERT INTO `mood_topic` VALUES ('22', '改变人生轨迹的一次经历', '？？？', '2017-10-19 12:02:37', null, '36', null);
INSERT INTO `mood_topic` VALUES ('23', '改变人生轨迹的一次经历', '。。？', '2017-10-19 16:14:26', null, '36', null);

-- ----------------------------
-- Table structure for mood_topicimage
-- ----------------------------
DROP TABLE IF EXISTS `mood_topicimage`;
CREATE TABLE `mood_topicimage` (
  `topicId` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_topicimage
-- ----------------------------
INSERT INTO `mood_topicimage` VALUES ('0', 'C:\\image\\tit.png');

-- ----------------------------
-- Table structure for mood_topic_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `mood_topic_evaluate`;
CREATE TABLE `mood_topic_evaluate` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `replyId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `commentTime` varchar(255) DEFAULT NULL,
  `tcontent` text,
  `topicId` int(11) DEFAULT NULL,
  `tflag` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_topic_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for mood_user
-- ----------------------------
DROP TABLE IF EXISTS `mood_user`;
CREATE TABLE `mood_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `constellation` varchar(255) DEFAULT NULL,
  `blood` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `ufacing` varchar(255) DEFAULT '',
  `hobby` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `personalPassword` varchar(255) DEFAULT NULL,
  `fingerprint` varchar(255) DEFAULT '',
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_user
-- ----------------------------
INSERT INTO `mood_user` VALUES ('33', '9429390675', '这是小号', 'wzdasnl6', '15536985303', '山西省-太原市-尖草坪区', '天秤座', 'O型', '我穷的只剩帅啦', '2017-10-19', '9429390675_-1_0.png', '打豆豆', '学生', '先生', '', '', '21');
INSERT INTO `mood_user` VALUES ('36', '9418912858', '忘川呐', 'wzdasnl6', '18103410307', '山西省-太原市-尖草坪区', '处女座', 'O型', '我真的穷的只剩帅', '2017-9-21', '9418912858_-1_0.png', '打豆豆', '学生', '先生', '', '', '21');
INSERT INTO `mood_user` VALUES ('39', '1467107487', null, '1208790701', '15364938285', null, null, null, null, null, 'tit.png', null, null, null, null, '', null);
INSERT INTO `mood_user` VALUES ('40', '3393114657', null, '123456789', '15364943679', null, null, null, null, null, 'tit.png', null, null, null, null, '', null);
INSERT INTO `mood_user` VALUES ('41', '3320101389', '傻子一号', '123456789', '15735185214', '山西省-太原市-尖草坪区', '天秤座', 'O型', '有些日子着实不好过', '2017-10-21', '3320101389_-1_0.png', '打狗', '学生', '先生', '', '', '0');
INSERT INTO `mood_user` VALUES ('44', '2012626175', null, '12345678', '15388516317', null, null, null, null, null, 'tit.png', null, null, null, null, '', null);

-- ----------------------------
-- Table structure for mood_vent
-- ----------------------------
DROP TABLE IF EXISTS `mood_vent`;
CREATE TABLE `mood_vent` (
  `uid` int(11) NOT NULL,
  `ventName` varchar(255) DEFAULT NULL,
  `ventNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_vent
-- ----------------------------

-- ----------------------------
-- Table structure for mood_warn
-- ----------------------------
DROP TABLE IF EXISTS `mood_warn`;
CREATE TABLE `mood_warn` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `wcintent` text,
  `wtime` varchar(255) DEFAULT NULL,
  `wto` varchar(255) DEFAULT NULL,
  `wfrom` int(11) DEFAULT NULL,
  `wphone` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_warn
-- ----------------------------
INSERT INTO `mood_warn` VALUES ('20', '今天该吃药了', '2017-10-09', 'me', '36', '', '20');
INSERT INTO `mood_warn` VALUES ('21', '明天该吃药了', '2017-11-09', 'me', '36', '', '21');
INSERT INTO `mood_warn` VALUES ('22', '大后天天该吃药了', '2017-12-09', 'me', '36', '', '22');
INSERT INTO `mood_warn` VALUES ('23', '下个星期该吃药了', '2017-10-20', 'me', '36', '', '23');
INSERT INTO `mood_warn` VALUES ('24', '下个月该吃药了', '2017-10-09', 'me', '36', '', '2');
INSERT INTO `mood_warn` VALUES ('25', '明年该吃药了', '2017-10-09', 'me', '36', '', '2');
INSERT INTO `mood_warn` VALUES ('27', '打豆豆啦', '2018-10-07', '大号', '33', '18103410307', '0');
INSERT INTO `mood_warn` VALUES ('28', '该打豆豆了', '2018-10-07', '大号', '33', '18103410307', '0');
INSERT INTO `mood_warn` VALUES ('29', '打豆豆啦', '2018-10-07', '。。。', '33', '18103410307', '0');
INSERT INTO `mood_warn` VALUES ('30', '我老婆要生日了', '2027-01-11', '老婆', '36', '18103410370', '0');

-- ----------------------------
-- Table structure for mood_warn_obj
-- ----------------------------
DROP TABLE IF EXISTS `mood_warn_obj`;
CREATE TABLE `mood_warn_obj` (
  `wid` int(11) NOT NULL,
  `wto` varchar(255) DEFAULT NULL,
  `wphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_warn_obj
-- ----------------------------
