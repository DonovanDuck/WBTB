package com.TB.analytic;

import java.util.List;
import java.util.Map;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class Test {
public static void main(String[] args) {
	//1.demo
	//System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
	
	//2.标准分词
	//List<Term> termList = StandardTokenizer.segment("商品和服务");
	//System.out.println(termList);
	
	//3.NLP分词
	List<Term> termList = NLPTokenizer.segment("我不是不高兴");
	System.out.println(termList);
	
	//4.索引分词
//	List<Term> termList = IndexTokenizer.segment("主副食品");
//	for (Term term : termList)
//	{
//	    System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
//	}
	
	
	//5. N-最短路径分词
//	Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//	Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//	String[] testCase = new String[]{
//	        "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。",
//	        "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
//	        };
//	for (String sentence : testCase)
//	{
//	    System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
//	}
	
	//6. CRF分词

//	Segment segment = new CRFSegment();
//	segment.enablePartOfSpeechTagging(true);
//	List<Term> termList = segment.seg("你看过穆赫兰道吗");
//	System.out.println(termList);
//	for (Term term : termList)
//	{
//	    if (term.nature == null)
//	    {
//	        System.out.println("识别到新词：" + term.word);
//	    }
//	}
	
	//7. 极速词典分词

	/**
	 * 演示极速分词，基于AhoCorasickDoubleArrayTrie实现的词典分词，适用于“高吞吐量”“精度一般”的场合
	 * @author hankcs
	 */
	
//	        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
//	        System.out.println(SpeedTokenizer.segment(text));
//	        long start = System.currentTimeMillis();
//	        int pressure = 1000000;
//	        for (int i = 0; i < pressure; ++i)
//	        {
//	            SpeedTokenizer.segment(text);
//	        }
//	        double costTime = (System.currentTimeMillis() - start) / (double)1000;
//	        System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);
	   

	/**
	 * 演示用户词典的动态增删
	 *
	 * @author hankcs
	 */
//	        // 动态增加
//	        CustomDictionary.add("攻城狮");
//	        // 强行插入
//	        CustomDictionary.insert("白富美", "nz 1024");
//	        // 删除词语（注释掉试试）
////	        CustomDictionary.remove("攻城狮");
//	        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
//	        System.out.println(CustomDictionary.get("单身狗"));
//
//	        String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰";  // 怎么可能噗哈哈！
//
//	        // AhoCorasickDoubleArrayTrie自动机分词
//	        final char[] charArray = text.toCharArray();
//	        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
//	        {
//	            @Override
//	            public void hit(int begin, int end, CoreDictionary.Attribute value)
//	            {
//	                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
//	            }
//	        });
//	        // trie树分词
//	        BaseSearcher searcher = CustomDictionary.getSearcher(text);
//	        Map.Entry entry;
//	        while ((entry = searcher.next()) != null)
//	        {
//	            System.out.println(entry);
//	        }
//
//	        // 标准分词
//	        System.out.println(HanLP.segment(text));
	
	//9. 中国人名识别

//	String[] testCase = new String[]{
//	        "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
//	        "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
//	        "张浩和胡健康复员回家了",
//	        "王总和小丽结婚了",
//	        "编剧邵钧林和稽道青说",
//	        "这里有关天培的有关事迹",
//	        "龚学平等领导,邓颖超生前",
//	        };
//	Segment segment = HanLP.newSegment().enableNameRecognize(true);
//	for (String sentence : testCase)
//	{
//	    List<Term> termList = segment.seg(sentence);
//	    System.out.println(termList);
//	}

	
	
	
	//10. 音译人名识别

//	String[] testCase = new String[]{
//	                "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。",
//	                "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
//	        };
//	Segment segment = HanLP.newSegment().enableTranslatedNameRecognize(true);
//	for (String sentence : testCase)
//	{
//	    List<Term> termList = segment.seg(sentence);
//	    System.out.println(termList);
//	}


	//11. 日本人名识别

//	String[] testCase = new String[]{
//	        "北川景子参演了林诣彬导演的《速度与激情3》",
//	        "林志玲亮相网友:确定不是波多野结衣？",
//	};
//	Segment segment = HanLP.newSegment().enableJapaneseNameRecognize(true);
//	for (String sentence : testCase)
//	{
//	    List<Term> termList = segment.seg(sentence);
//	    System.out.println(termList);
//	}

	
	//12. 地名识别
//
//	String[] testCase = new String[]{
//	        "鸽子现在去丰台调兵",
//	        "晚上去公主坟上香",
//	};
//	Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
//	for (String sentence : testCase)
//	{
//	    List<Term> termList = segment.seg(sentence);
//	    System.out.println(termList);
//	}
	
	//13. 机构名识别

//	String[] testCase = new String[]{
//	    "我在北大兼职工作，",
//	    "我经常在台川喜宴餐厅吃饭，",
//	    "偶尔去地中海影城看电影。",
//	};
//	Segment segment = HanLP.newSegment().enableOrganizationRecognize(true);
//	for (String sentence : testCase)
//	{
//	    List<Term> termList = segment.seg(sentence);
//	    System.out.println(termList);
//	}

	
	
	//14. 关键词提取

//	String content = "今天我不高兴";
//	List<String> keywordList = HanLP.extractKeyword(content, 10);
//	System.out.println(keywordList);

	//15. 自动摘要

//	String document = "唉～打了十把牌，让我小妹妹全输了，然后她就哭了，哄都哄不好。明天就要走了，唉～心烦……";
//	List<String> sentenceList = HanLP.extractSummary(document, 5);
//	System.out.println(sentenceList);

	//16. 短语提取

//	String text = "算法工程师\n" +
//	                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
//	                "\n" +
//	                "1职位简介\n" +
//	                "算法工程师是一个非常高端的职位；\n" +
//	                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
//	                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
//	                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
//	                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
//	                "\n" +
//	                "2研究方向\n" +
//	                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
//	                "\n" +
//	                "3目前国内外状况\n" +
//	                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
//	                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
//	                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
//	                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
//	                "算法工程师逐渐往人工智能方向发展。";
//	List<String> phraseList = HanLP.extractPhrase(text, 10);
//	System.out.println(phraseList);

	
	//17. 拼音转换

	/**
	 * 汉字转拼音
	 * @author hankcs
	 */
	
//	        String text = "重载不是重任";
//	        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
//	        System.out.print("原文,");
//	        for (char c : text.toCharArray())
//	        {
//	            System.out.printf("%c,", c);
//	        }
//	        System.out.println();
//
//	        System.out.print("拼音（数字音调）,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin);
//	        }
//	        System.out.println();
//
//	        System.out.print("拼音（符号音调）,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
//	        }
//	        System.out.println();
//
//	        System.out.print("拼音（无音调）,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
//	        }
//	        System.out.println();
//
//	        System.out.print("声调,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getTone());
//	        }
//	        System.out.println();
//
//	        System.out.print("声母,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getShengmu());
//	        }
//	        System.out.println();
//
//	        System.out.print("韵母,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getYunmu());
//	        }
//	        System.out.println();
//
//	        System.out.print("输入法头,");
//	        for (Pinyin pinyin : pinyinList)
//	        {
//	            System.out.printf("%s,", pinyin.getHead());
//	        }
//	        System.out.println();
	
	//18. 简繁转换

	/**
	 * 简繁转换
	 * @author hankcs
	 */
	
	       // System.out.println(HanLP.convertToTraditionalChinese("用笔记本电脑写程序"));
	       // System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳當上皇后，就能買士多啤梨慶祝了」"));
	
	//19. 文本推荐

	/**
	 * 文本推荐(句子级别，从一系列句子中挑出与输入句子最相似的那一个)
	 * @author hankcs
	 */
//	        Suggester suggester = new Suggester();
//	        String[] titleArray =
//	        (
//	                "威廉王子发表演说 呼吁保护野生动物\n" +
//	                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
//	                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
//	                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
//	                "英报告说空气污染带来“公共健康危机”"
//	        ).split("\\n");
//	        for (String title : titleArray)
//	        {
//	            suggester.addSentence(title);
//	        }
//
//	        System.out.println(suggester.suggest("发言", 1));       // 语义
//	        System.out.println(suggester.suggest("危机公共", 1));   // 字符
//	        System.out.println(suggester.suggest("mayun", 1));      // 拼音
//	
	        
	      //  20. 语义距离

	        /**
	         * 语义距离
	         * @author hankcs
	         */
	        
//	                String[] wordArray = new String[]
//	                        {
//	                                "香蕉",
//	                                "苹果",
//	                                "白菜",
//	                                "水果",
//	                                "蔬菜",
//	                                "自行车",
//	                                "公交车",
//	                                "飞机",
//	                                "买",
//	                                "卖",
//	                                "购入",
//	                                "新年",
//	                                "春节",
//	                                "丢失",
//	                                "补办",
//	                                "办理",
//	                                "送给",
//	                                "寻找",
//	                                "孩子",
//	                                "教室",
//	                                "教师",
//	                                "会计",
//	                        };
//	                for (String a : wordArray)
//	                {
//	                    for (String b : wordArray)
//	                    {
//	                        System.out.println(a + "\t" + b + "\t之间的距离是\t" + CoreSynonymDictionary.distance(a, b));
//	                    }
//	                }
//	               
}
	
	
	
}

