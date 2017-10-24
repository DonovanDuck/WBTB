/*
Navicat MySQL Data Transfer

Source Server         : yyx
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : tbox

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-10-24 16:28:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mood_color_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `mood_color_dictionary`;
CREATE TABLE `mood_color_dictionary` (
  `moodId` int(11) NOT NULL AUTO_INCREMENT,
  `colorEnglish` varchar(255) DEFAULT NULL,
  `colorChinese` varchar(255) DEFAULT NULL,
  `radix` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`moodId`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mood_color_dictionary
-- ----------------------------
INSERT INTO `mood_color_dictionary` VALUES ('1', 'white', '白色', '#ffffff');
INSERT INTO `mood_color_dictionary` VALUES ('2', 'ivory', '象牙色', '#fffff0');
INSERT INTO `mood_color_dictionary` VALUES ('3', 'lightyellow', '亮黄色', '#ffffe0');
INSERT INTO `mood_color_dictionary` VALUES ('4', 'yellow', '黄色', '#ffff00');
INSERT INTO `mood_color_dictionary` VALUES ('5', 'snow', '雪白色', '#fffafa');
INSERT INTO `mood_color_dictionary` VALUES ('6', 'floralwhite', '花白色', '#fffaf0');
INSERT INTO `mood_color_dictionary` VALUES ('7', 'lemonchiffon', '柠檬绸色', '#fffacd');
INSERT INTO `mood_color_dictionary` VALUES ('8', 'cornsilk', '米绸色', '#fff8dc');
INSERT INTO `mood_color_dictionary` VALUES ('9', 'seaShell', '海贝色', '#fff5ee');
INSERT INTO `mood_color_dictionary` VALUES ('10', 'lavenderblush', '淡紫红', '#fff0f5');
INSERT INTO `mood_color_dictionary` VALUES ('11', 'papayawhip', '番木色', '#ffefd5');
INSERT INTO `mood_color_dictionary` VALUES ('12', 'blanchedalmond', '白杏色', '#ffebcd');
INSERT INTO `mood_color_dictionary` VALUES ('13', 'mistyrose', '浅玫瑰色', '#ffe4e1');
INSERT INTO `mood_color_dictionary` VALUES ('14', 'bisque', '桔黄色', '#ffe4c4');
INSERT INTO `mood_color_dictionary` VALUES ('15', 'moccasin', '鹿皮色', '#ffe4b5');
INSERT INTO `mood_color_dictionary` VALUES ('16', 'navajowhite', '纳瓦白', '#ffdead');
INSERT INTO `mood_color_dictionary` VALUES ('17', 'peachpuff', '桃色', '#ffdab9');
INSERT INTO `mood_color_dictionary` VALUES ('18', 'gold', '金色', '#ffd700');
INSERT INTO `mood_color_dictionary` VALUES ('19', 'pink', '粉红色', '#ffc0cb');
INSERT INTO `mood_color_dictionary` VALUES ('20', 'lightpink', '亮粉红色', '#ffb6c1');
INSERT INTO `mood_color_dictionary` VALUES ('21', 'orange', '橙色', '#ffa500');
INSERT INTO `mood_color_dictionary` VALUES ('22', 'lightsalmon', '亮肉色', '#ffa07a');
INSERT INTO `mood_color_dictionary` VALUES ('23', 'darkorange', '暗桔黄色', '#ff8c00');
INSERT INTO `mood_color_dictionary` VALUES ('24', 'coral', '珊瑚色', '#ff7f50');
INSERT INTO `mood_color_dictionary` VALUES ('25', 'hotpink', '热粉红色', '#ff69b4');
INSERT INTO `mood_color_dictionary` VALUES ('26', 'tomato', '西红柿色', '#ff6347');
INSERT INTO `mood_color_dictionary` VALUES ('27', 'orangered', '红橙色', '#ff4500');
INSERT INTO `mood_color_dictionary` VALUES ('28', 'deeppink', '深粉红色', '#ff1493');
INSERT INTO `mood_color_dictionary` VALUES ('29', 'fuchsia', '紫红色', '#ff00ff');
INSERT INTO `mood_color_dictionary` VALUES ('30', 'magenta', '红紫色', '#ff00ff');
INSERT INTO `mood_color_dictionary` VALUES ('31', 'red', '红色', '#ff0000');
INSERT INTO `mood_color_dictionary` VALUES ('32', 'oldlace', '老花色', '#fdf5e6');
INSERT INTO `mood_color_dictionary` VALUES ('33', 'lightgoldenrodyellow', '亮金黄色', '#fafad2');
INSERT INTO `mood_color_dictionary` VALUES ('34', 'linen', '亚麻色', '#faf0e6');
INSERT INTO `mood_color_dictionary` VALUES ('35', 'antiquewhite', '古董白', '#faebd7');
INSERT INTO `mood_color_dictionary` VALUES ('36', 'salmon', '鲜肉色', '#fa8072');
INSERT INTO `mood_color_dictionary` VALUES ('37', 'ghostwhite', '幽灵白', '#f8f8ff');
INSERT INTO `mood_color_dictionary` VALUES ('38', 'mintcream', '薄荷色', '#f5fffa');
INSERT INTO `mood_color_dictionary` VALUES ('39', 'whitesmoke', '烟白色', '#f5f5f5');
INSERT INTO `mood_color_dictionary` VALUES ('40', 'beige', '米色', '#f5f5dc');
INSERT INTO `mood_color_dictionary` VALUES ('41', 'wheat', '浅黄色', '#f5deb3');
INSERT INTO `mood_color_dictionary` VALUES ('42', 'sandybrown', '沙褐色', '#f4a460');
INSERT INTO `mood_color_dictionary` VALUES ('43', 'azure', '天蓝色', '#f0ffff');
INSERT INTO `mood_color_dictionary` VALUES ('44', 'honeydew', '蜜色', '#f0fff0');
INSERT INTO `mood_color_dictionary` VALUES ('46', 'khaki', '黄褐色', '#f0e68c');
INSERT INTO `mood_color_dictionary` VALUES ('47', 'lightcoral', '亮珊瑚色', '#f08080');
INSERT INTO `mood_color_dictionary` VALUES ('48', 'palegoldenrod', '苍麒麟色', '#eee8aa');
INSERT INTO `mood_color_dictionary` VALUES ('49', 'violet', '紫罗兰色', '#ee82ee');
INSERT INTO `mood_color_dictionary` VALUES ('50', 'darksalmon', '暗肉色', '#e9967a');
INSERT INTO `mood_color_dictionary` VALUES ('51', 'lavender', '淡紫色', '#e6e6fa');
INSERT INTO `mood_color_dictionary` VALUES ('52', 'lightcyan', '亮青色', '#e0ffff');
INSERT INTO `mood_color_dictionary` VALUES ('53', 'burlywood', '实木色', '#deb887');
INSERT INTO `mood_color_dictionary` VALUES ('54', 'plum', '洋李色', '#dda0dd');
INSERT INTO `mood_color_dictionary` VALUES ('55', 'gainsboro', '淡灰色', '#dcdcdc');
INSERT INTO `mood_color_dictionary` VALUES ('56', 'crimson', '暗深红色', '#dc143c');
INSERT INTO `mood_color_dictionary` VALUES ('57', 'palevioletred', '苍紫罗兰色', '#db7093');
INSERT INTO `mood_color_dictionary` VALUES ('58', 'goldenrod', '金麒麟色', '#daa520');
INSERT INTO `mood_color_dictionary` VALUES ('59', 'orchid', '淡紫色', '#da70d6');
INSERT INTO `mood_color_dictionary` VALUES ('60', 'thistle', '蓟色', '#d8bfd8');
INSERT INTO `mood_color_dictionary` VALUES ('61', 'lightgray', '亮灰色', '#d3d3d3');
INSERT INTO `mood_color_dictionary` VALUES ('62', 'lightgrey', '亮灰色', '#d3d3d3');
INSERT INTO `mood_color_dictionary` VALUES ('63', 'tan', '茶色', '#d2b48c');
INSERT INTO `mood_color_dictionary` VALUES ('64', 'chocolate', '巧可力色', '#d2691e');
INSERT INTO `mood_color_dictionary` VALUES ('65', 'peru', '秘鲁色', '#cd853f');
INSERT INTO `mood_color_dictionary` VALUES ('66', 'indianred', '印第安红', '#cd5c5c');
INSERT INTO `mood_color_dictionary` VALUES ('67', 'mediumvioletred', '中紫罗兰色', '#c71585');
INSERT INTO `mood_color_dictionary` VALUES ('68', 'silver', '银色', '#c0c0c0');
INSERT INTO `mood_color_dictionary` VALUES ('69', 'darkkhaki', '暗黄褐色', '#bdb76b');
INSERT INTO `mood_color_dictionary` VALUES ('70', 'rosybrown', '褐玫瑰红', '#bc8f8f');
INSERT INTO `mood_color_dictionary` VALUES ('71', 'mediumorchid', '中粉紫色', '#ba55d3');
INSERT INTO `mood_color_dictionary` VALUES ('72', 'darkgoldenrod', '暗金黄色', '#b8860b');
INSERT INTO `mood_color_dictionary` VALUES ('73', 'firebrick', '火砖色', '#b22222');
INSERT INTO `mood_color_dictionary` VALUES ('74', 'powderblue', '粉蓝色', '#b0e0e6');
INSERT INTO `mood_color_dictionary` VALUES ('75', 'lightsteelblue', '亮钢兰色', '#b0c4de');
INSERT INTO `mood_color_dictionary` VALUES ('76', 'paleturquoise', '苍宝石绿', '#afeeee');
INSERT INTO `mood_color_dictionary` VALUES ('77', 'greenyellow', '黄绿色', '#adff2f');
INSERT INTO `mood_color_dictionary` VALUES ('78', 'lightblue', '亮蓝色', '#add8e6');
INSERT INTO `mood_color_dictionary` VALUES ('79', 'darkgray', '暗灰色', '#a9a9a9');
INSERT INTO `mood_color_dictionary` VALUES ('80', 'darkgrey', '暗灰色', '#a9a9a9');
INSERT INTO `mood_color_dictionary` VALUES ('81', 'brown', '褐色', '#a52a2a');
INSERT INTO `mood_color_dictionary` VALUES ('82', 'colorPrimary', '番茄红', '#ff6347');
INSERT INTO `mood_color_dictionary` VALUES ('83', 'colorPrimaryDark', '橘红色', '#ff4500');
INSERT INTO `mood_color_dictionary` VALUES ('84', 'colorAccent', '爱丽丝蓝', '#f0f8ff');
INSERT INTO `mood_color_dictionary` VALUES ('85', 'sienna', '赭色', '#a0522d');
INSERT INTO `mood_color_dictionary` VALUES ('86', 'darkorchid', '暗紫色', '#9932cc');
INSERT INTO `mood_color_dictionary` VALUES ('87', 'palegreen', '苍绿色', '#98fb98');
INSERT INTO `mood_color_dictionary` VALUES ('88', 'darkviolet', '暗紫罗兰色', '#9400d3');
INSERT INTO `mood_color_dictionary` VALUES ('89', 'mediumpurple', '中紫色', '#9370db');
INSERT INTO `mood_color_dictionary` VALUES ('90', 'lightgreen', '亮绿色', '#90ee90');
INSERT INTO `mood_color_dictionary` VALUES ('91', 'darkseagreen', '暗海兰色', '#8fbc8f');
INSERT INTO `mood_color_dictionary` VALUES ('92', 'saddlebrown', '重褐色', '#8b4513');
INSERT INTO `mood_color_dictionary` VALUES ('93', 'darkmagenta', '暗洋红', '#8b008b');
INSERT INTO `mood_color_dictionary` VALUES ('94', 'darkred', '暗红色', '#8b0000');
INSERT INTO `mood_color_dictionary` VALUES ('95', 'blueviolet', '紫罗兰蓝色', '#8a2be2');
INSERT INTO `mood_color_dictionary` VALUES ('96', 'lightskyblue', '亮天蓝色', '#87cefa');
INSERT INTO `mood_color_dictionary` VALUES ('97', 'skyblue', '天蓝色', '#87ceeb');
INSERT INTO `mood_color_dictionary` VALUES ('98', 'gray', '灰色', '#808080');
INSERT INTO `mood_color_dictionary` VALUES ('99', 'grey', '灰色', '#808080');
INSERT INTO `mood_color_dictionary` VALUES ('100', 'olive', '橄榄色', '#808000');
INSERT INTO `mood_color_dictionary` VALUES ('101', 'purple', '紫色', '#800080');
INSERT INTO `mood_color_dictionary` VALUES ('102', 'maroon', '粟色', '#800000');
INSERT INTO `mood_color_dictionary` VALUES ('103', 'aquamarine', '碧绿色', '#7fffd4');
INSERT INTO `mood_color_dictionary` VALUES ('104', 'chartreuse', '黄绿色', '#7fff00');
INSERT INTO `mood_color_dictionary` VALUES ('105', 'lawngreen', '草绿色', '#7cfc00');
INSERT INTO `mood_color_dictionary` VALUES ('106', 'mediumslateblue', '中暗蓝色', '#7b68ee');
INSERT INTO `mood_color_dictionary` VALUES ('107', 'lightslategray', '亮蓝灰', '#778899');
INSERT INTO `mood_color_dictionary` VALUES ('108', 'lightslategrey', '亮蓝灰', '#778899');
INSERT INTO `mood_color_dictionary` VALUES ('109', 'slategray', '灰石色', '#708090');
INSERT INTO `mood_color_dictionary` VALUES ('110', 'slategrey', '灰石色', '#708090');
INSERT INTO `mood_color_dictionary` VALUES ('111', 'olivedrab', '深绿褐色', '#6b8e23');
INSERT INTO `mood_color_dictionary` VALUES ('112', 'slateblue', '石蓝色', '#6a5acd');
INSERT INTO `mood_color_dictionary` VALUES ('113', 'dimgray', '暗灰色', '#696969');
INSERT INTO `mood_color_dictionary` VALUES ('114', 'dimgrey', '暗灰色', '#696969');
INSERT INTO `mood_color_dictionary` VALUES ('115', 'mediumaquamarine', '中绿色', '#66cdaa');
INSERT INTO `mood_color_dictionary` VALUES ('116', 'cornflowerblue', '菊兰色', '#6495ed');
INSERT INTO `mood_color_dictionary` VALUES ('117', 'cadetblue', '军兰色', '#5f9ea0');
INSERT INTO `mood_color_dictionary` VALUES ('118', 'darkolivegreen', '暗橄榄绿', '#556b2f');
INSERT INTO `mood_color_dictionary` VALUES ('119', 'indigo', '靛青色', '#4b0082');
INSERT INTO `mood_color_dictionary` VALUES ('120', 'mediumturquoise', '中绿宝石', '#48d1cc');
INSERT INTO `mood_color_dictionary` VALUES ('121', 'darkslateblue', '暗灰蓝色', '#483d8b');
INSERT INTO `mood_color_dictionary` VALUES ('122', 'steelblue', '钢兰色', '#4682b4');
INSERT INTO `mood_color_dictionary` VALUES ('123', 'royalblue', '皇家蓝', '#4169e1');
INSERT INTO `mood_color_dictionary` VALUES ('124', 'turquoise', '青绿色', '#40e0d0');
INSERT INTO `mood_color_dictionary` VALUES ('125', 'mediumseagreen', '中海蓝', '#3cb371');
INSERT INTO `mood_color_dictionary` VALUES ('126', 'limegreen', '橙绿色', '#32cd32');
INSERT INTO `mood_color_dictionary` VALUES ('127', 'darkslategray', '暗瓦灰色', '#2f4f4f');
INSERT INTO `mood_color_dictionary` VALUES ('128', 'darkslategrey', '暗瓦灰色', '#2f4f4f');
INSERT INTO `mood_color_dictionary` VALUES ('129', 'seagreen', '海绿色', '#2e8b57');
INSERT INTO `mood_color_dictionary` VALUES ('130', 'forestgreen', '森林绿', '#228b22');
INSERT INTO `mood_color_dictionary` VALUES ('131', 'lightseagreen', '亮海蓝色', '#20b2aa');
INSERT INTO `mood_color_dictionary` VALUES ('132', 'dodgerblue', '闪兰色', '#1e90ff');
INSERT INTO `mood_color_dictionary` VALUES ('133', 'midnightblue', '中灰兰色', '#191970');
INSERT INTO `mood_color_dictionary` VALUES ('134', 'aqua', '浅绿色', '#00ffff');
INSERT INTO `mood_color_dictionary` VALUES ('135', 'cyan', '青色', '#00ffff');
INSERT INTO `mood_color_dictionary` VALUES ('136', 'springgreen', '春绿色', '#00ff7f');
INSERT INTO `mood_color_dictionary` VALUES ('137', 'lime', '酸橙色', '#00ff00');
INSERT INTO `mood_color_dictionary` VALUES ('138', 'mediumspringgreen', '中春绿色', '#00fa9a');
INSERT INTO `mood_color_dictionary` VALUES ('139', 'darkturquoise', '暗宝石绿', '#00ced1');
INSERT INTO `mood_color_dictionary` VALUES ('140', 'deepskyblue', '深天蓝色', '#00bfff');
INSERT INTO `mood_color_dictionary` VALUES ('141', 'darkcyan', '暗青色', '#008b8b');
INSERT INTO `mood_color_dictionary` VALUES ('142', 'teal', '水鸭色', '#008080');
INSERT INTO `mood_color_dictionary` VALUES ('143', 'green', '绿色', '#008000');
INSERT INTO `mood_color_dictionary` VALUES ('144', 'darkgreen', '暗绿色', '#006400');
INSERT INTO `mood_color_dictionary` VALUES ('145', 'blue', '蓝色', '#0000ff');
INSERT INTO `mood_color_dictionary` VALUES ('146', 'mediumblue', '中兰色', '#0000cd');
INSERT INTO `mood_color_dictionary` VALUES ('147', 'darkblue', '暗蓝色', '#00008b');
INSERT INTO `mood_color_dictionary` VALUES ('148', 'navy', '海军色', '#000080');
INSERT INTO `mood_color_dictionary` VALUES ('149', 'black', '黑色', '#000000');
