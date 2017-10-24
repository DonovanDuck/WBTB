/*
Navicat MySQL Data Transfer

Source Server         : yyx
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mood

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-10-24 16:27:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adverd
-- ----------------------------
DROP TABLE IF EXISTS `adverd`;
CREATE TABLE `adverd` (
  `words` varchar(255) NOT NULL,
  `emotionalTendenc` int(11) NOT NULL,
  `emotionalIntensity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adverd
-- ----------------------------
INSERT INTO `adverd` VALUES ('非常', '1', '1.5');
INSERT INTO `adverd` VALUES ('超', '1', '1.5');
INSERT INTO `adverd` VALUES ('超级', '1', '1.3');
INSERT INTO `adverd` VALUES ('很', '1', '1.2');

-- ----------------------------
-- Table structure for interst
-- ----------------------------
DROP TABLE IF EXISTS `interst`;
CREATE TABLE `interst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hobby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interst
-- ----------------------------
INSERT INTO `interst` VALUES ('1', '球馆');
INSERT INTO `interst` VALUES ('2', '练球');
INSERT INTO `interst` VALUES ('3', '打球');

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood` (
  `adverdword` varchar(255) NOT NULL,
  `adverdTendenc` int(11) NOT NULL,
  `adverdIntensity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood
-- ----------------------------
INSERT INTO `mood` VALUES ('伤心', '-1', '5');
INSERT INTO `mood` VALUES ('高兴', '1', '8');
INSERT INTO `mood` VALUES ('开心', '1', '8');
INSERT INTO `mood` VALUES ('郁闷', '1', '6');
INSERT INTO `mood` VALUES ('快乐', '1', '6');
INSERT INTO `mood` VALUES ('赞', '1', '5');
INSERT INTO `mood` VALUES ('超赞', '1', '7');
INSERT INTO `mood` VALUES ('不好', '-1', '5');
INSERT INTO `mood` VALUES ('心烦', '-1', '8');
INSERT INTO `mood` VALUES ('输', '-1', '6');
INSERT INTO `mood` VALUES ('烦', '-1', '5');
INSERT INTO `mood` VALUES ('喜欢', '1', '6');
INSERT INTO `mood` VALUES ('嘿嘿', '1', '3');

-- ----------------------------
-- Table structure for mood_diet
-- ----------------------------
DROP TABLE IF EXISTS `mood_diet`;
CREATE TABLE `mood_diet` (
  `di_id` int(11) NOT NULL AUTO_INCREMENT,
  `mood_diet` text,
  PRIMARY KEY (`di_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_diet
-- ----------------------------
INSERT INTO `mood_diet` VALUES ('1', '牛奶：钙是天然的神经系统稳定剂。在受到某种压力时，通过小便排出体外的钙就会增加。因此，要注意选择含钙高的牛奶、酸奶、虾皮、蛋黄等食物，有安定情绪的效果。');
INSERT INTO `mood_diet` VALUES ('2', '香蕉：香蕉中含有一种物质，能使人的心情变得愉快舒畅。香蕉中富含的钾能保持人体电解质平衡及酸碱代谢平衡，使神经肌肉兴奋性维持常态，协调心肌收缩与舒张功能，使血压处于正常状态。');
INSERT INTO `mood_diet` VALUES ('3', '番茄和柑橘：多吃富含维生素C的食品，具有平衡心理压力的效果。因为人在承受较大心理压力时，身体会消耗比平时多8倍左右的维生素C，维生素C的主要来源为新鲜蔬菜和水果，其中柑橘类水果和番茄是维生素C的最佳来源。');
INSERT INTO `mood_diet` VALUES ('4', '小米粥：小米富含人体所需的氨基酸及其他优质蛋白质，各种矿物质钙、磷、铁以及维生素B1、维生素B2、维生素A原、烟酸、尼克酸、硫胺素、胡萝卜素等，许多营养学家将B族维生素视为减压剂，它可调节内分泌，平衡情绪，松弛神经。');
INSERT INTO `mood_diet` VALUES ('5', '红茶：红茶有降低机体应激激素分泌水平的功效，每天饮用红茶，有利于舒缓神经。');
INSERT INTO `mood_diet` VALUES ('6', '烦躁的人症状：失眠、烦躁、健忘、焦虑不安。sss 措施：应多吃含钙、磷丰富的食物。sss 饮食处方：多食大豆、牛奶、鲜橙、牡蛎、花生（含钙量多）； 多食菠菜、土豆、蛋类（含磷量多）。 ');
INSERT INTO `mood_diet` VALUES ('7', '爱发火的人症状：脾气爆躁情绪反常，嫉妒心强。 sss措施：补钙、补维生素B。sss 饮食处方：多食海产品，如贝、虾、海带、蟹，另外，豆类 及牛奶中含有丰富的钙质；多食各种豆类、桂圆、干核桃仁、蘑 菇（补维生素B1和B2）。 ');
INSERT INTO `mood_diet` VALUES ('8', '爱唠叨的人症状：整日喋喋不休，令旁人生厌。sss 措施：因大脑缺乏复合维生素B，应补给复合维生素B。sss 处方：酵母中混以小麦胚芽，加牛奶、蜂蜜调匀，天天饮用， 每日三次，多食动物瘦肉、粗面粉、麦芽糖、豆类。 ');
INSERT INTO `mood_diet` VALUES ('9', '粗心大意的人症状：做事丢三落四，虎头蛇尾。 sss饮食处方：多吃辣椒、鱼干、笋干、油炸萝卜、牛奶、红枣、 田螺、卷心菜（含维生素C及A丰富）；多食瓜果蔬菜，减少摄 取肉量，少食酸性食物。');

-- ----------------------------
-- Table structure for mood_point
-- ----------------------------
DROP TABLE IF EXISTS `mood_point`;
CREATE TABLE `mood_point` (
  `po_id` int(11) NOT NULL AUTO_INCREMENT,
  `po_content` text,
  PRIMARY KEY (`po_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_point
-- ----------------------------
INSERT INTO `mood_point` VALUES ('1', '自我暗示法：  当你发怒时，暗示自己“不要发怒，发怒有害无益”；当你陷入忧愁时，暗示自己“忧愁没有用，还是振作起来吧。');
INSERT INTO `mood_point` VALUES ('2', '自我激励法：  是用生活中的哲理或思想来鼓励自己。一个人在消极情绪中，通过名言、警句进行自我激励，能够有效地调控情绪。如林则徐写“制怒”条幅悬挂屋中，以此告诫自己。');
INSERT INTO `mood_point` VALUES ('3', '回避法：  在苦闷、烦恼时，集中精力做一件有意义或感兴趣的事，有意识地转移注意力，忘掉或者冲淡烦恼。');
INSERT INTO `mood_point` VALUES ('4', '转视法：  有时候，同一事物，从一个角度看，可能引起消极情绪；从另一个角度看，可以发现其积极意义，从而摆脱消极情绪的困扰。');
INSERT INTO `mood_point` VALUES ('5', '自嘲法：  当生活、学习受到挫折时，当人际交往出现难堪时，自嘲的语言，自嘲的行为，常常能收到出奇制胜的效果，从而使尴尬化为自然，使紧张转为轻松，最终摆脱消极情绪和心里困境。');
INSERT INTO `mood_point` VALUES ('6', '心里换位法：  就是与他人换一个位置，站到对方的角度想问题。通过互换角色，体会别人的情绪与感受，有利于防止不良情绪的产生，或消除已产生的不良情绪。');
INSERT INTO `mood_point` VALUES ('7', '升华法：   困难和挫折，不是人们能够回避的，它会给人们带来心里上的压抑和焦虑。善于调节情绪的人，能把这种情绪引向对自己、对他人、对社会都有利的方向，达到积极的心里平衡。');

-- ----------------------------
-- Table structure for mood_result
-- ----------------------------
DROP TABLE IF EXISTS `mood_result`;
CREATE TABLE `mood_result` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `noteId` int(11) DEFAULT NULL,
  `userNumber` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `specialWord` varchar(255) DEFAULT NULL,
  `keysentence` text,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_result
-- ----------------------------
INSERT INTO `mood_result` VALUES ('2', '57', '9429390675', '-6.1', null, '数据库太难学了', '9.25');
INSERT INTO `mood_result` VALUES ('3', '58', '9429390675', '-5.53', null, '唉～心烦……', '9.26');
INSERT INTO `mood_result` VALUES ('4', '63', '9418912858', '4.5', null, '开放喜欢的荣耀', '10.07');
INSERT INTO `mood_result` VALUES ('5', '84', '9418912858', '0', null, '好皮啊', '10.12');
INSERT INTO `mood_result` VALUES ('6', '85', '9418912858', '-8', null, '我今天特别不高兴', '10.18');
INSERT INTO `mood_result` VALUES ('7', '86', '9418912858', '0', null, '好紧张啊', '10.19');

-- ----------------------------
-- Table structure for no
-- ----------------------------
DROP TABLE IF EXISTS `no`;
CREATE TABLE `no` (
  `noword` varchar(255) NOT NULL,
  `noTendenc` int(11) NOT NULL,
  `noIntensity` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of no
-- ----------------------------
INSERT INTO `no` VALUES ('不', '-1', '0.5');
INSERT INTO `no` VALUES ('不得不', '1', '1');

-- ----------------------------
-- Table structure for particle
-- ----------------------------
DROP TABLE IF EXISTS `particle`;
CREATE TABLE `particle` (
  `particleword` varchar(255) NOT NULL,
  `particleTendenc` int(11) NOT NULL,
  `particleIntensity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of particle
-- ----------------------------
INSERT INTO `particle` VALUES ('唉', '1', '1');
INSERT INTO `particle` VALUES ('哎', '1', '1');
INSERT INTO `particle` VALUES ('吗', '0', '0');
