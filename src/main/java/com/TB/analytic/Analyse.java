package com.TB.analytic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;




public class Analyse {
	static DecimalFormat df = new DecimalFormat("0.00"); // 设置double类型小数点后位数格式
	static List<Modle> findMood = new ArrayList<Modle>();
	static List<Modle> findNo = new ArrayList<Modle>();
	static List<Modle> findAdverd = new ArrayList<Modle>();
	static List<Modle> particle = new ArrayList<Modle>();
	Gson gson = new Gson();
	static int flag = 0;// 用来标识进入了哪个List，当成功匹配到时应该从头开始下一次循环
	// 找情感词

	public static void findMood(String word, int i) {
		// List<Modle> modleMood = new ArrayList<Modle>();
		System.out.println("进入情感词查找");
		Modle modle = null;
		modle = Sentiments_Test.selectWord(word, i);
		if (modle != null) {
			findMood.add(modle);
			flag = 1;
		}
	}

	// 找否定词
	public static void findNo(String word, int i) {
		// List<Modle> modleNo = new ArrayList<Modle>();
		System.out.println("进入否定词查找");
		Modle modle = new Modle();
		modle = Sentiments_Test.selectno(word, i);
		if (modle != null) {
			findNo.add(modle);
			flag = 1;
		}
	}

	// 找程度副词
	public static void findAdverd(String word, int i) {
		System.out.println("进入程度副词");
		// List<Modle> adverds = new ArrayList<Modle>();
		Modle modle = new Modle();
		modle = Sentiments_Test.selectadverd(word, i);
		if (modle != null) {
			findAdverd.add(modle);
			flag = 1;
		}

	}

	// 找语气词
	public static void findModalParticle(String word, int i) {
		System.out.println("进入语气词词库");
		// List<Modle> particle = new ArrayList<Modle>();
		Modle modle = new Modle();
		modle = Sentiments_Test.selectparticle(word, i);
		if (modle != null) {
			System.out.println(modle.toString());
			particle.add(modle);
			flag = 1;
		}
	}

	/**
	 * 判断反义疑问句的情况
	 * 
	 * @param str
	 * @param moodList
	 * @return
	 */
	public static Boolean jubgeType(String str) {
		// 判断反义疑问句
		if (str.matches(".*怎么能.*") || str.matches(".*怎能.*") || str.matches(".*怎会.*") || str.matches(".*怎么会.*")
				|| str.matches(".*难道.*")) {
			return true;
		} else {
			// 反问句的情况
			return false;
		}
	}

	/**
	 * 切割句子
	 * 
	 * @param str
	 * @return
	 */
	public static String[] cutSentence(String str) {
		/* 正则表达式：句子结束符 */
		String regEx = "[，。？！；：～]";
		Pattern p = Pattern.compile(regEx);
		/* 按照句子结束符分割句子 */
		Matcher m = p.matcher(str);
		String[] substrs = p.split(str);
		return substrs;
	}

	/**
	 * 切割短语，分析属于那种词
	 * 
	 * @param str
	 */
	public static void cutWord(String str) {
		System.getProperty("java.classpath");
		List<Term> termList = NLPTokenizer.segment(str);
		List<String> words = new ArrayList<>();
		String m = null;
		for(int i =0;i<termList.size();i++){
			int n = termList.get(i).toString().lastIndexOf("/");
			m = termList.get(i).toString().substring(0, n);
			words.add(m);
		}
		int size = termList.size();	
		for (int j = 0; j < size; j++) {
			flag = 0;
			System.out.println(words.get(j));
			findMood(words.get(j), j);
			if (flag == 0) {
				findNo(words.get(j), j);
			}
			if (flag == 0) {
				findAdverd(words.get(j), j);
			}
			if (flag == 0) {
				findModalParticle(words.get(j), j);
			}
		}
	}

	/**
	 * 进入分析
	 * 
	 * @param specile
	 */
	public static List<ResultValue> anlyseSentence(Boolean specile) {
		List<ResultValue> values = new ArrayList<>();
		int f = 0;// 用来标识进入了模型，方便跳出循环
		List<TwoSum> listNo = new ArrayList<TwoSum>();
		List<TwoSum> listAdverd = new ArrayList<TwoSum>();
		/**
		 * 处理双从否定的情况
		 */
		if (findNo.size() >= 2) {
			for (int m1 = 0; m1 < findNo.size(); m1++) {
				if ((m1 + 1 < findNo.size()) && (findNo.get(m1 + 1).getAddress() - findNo.get(m1).getAddress()) <= 2) {
					TwoSum s = new TwoSum();
					s.setFirdstaddress(findNo.get(m1).getAddress());
					s.setSecondaddress(findNo.get(m1 + 1).getAddress());
					s.setCount(2);
					listNo.add(s);

				}
			}
		}
		/**
		 * 处理多个个程度副词在一起的情况
		 */
		if (findAdverd.size() >= 2) {
			for (int m1 = 0; m1 < findAdverd.size(); m1++) {
				if ((m1 + 1 < findAdverd.size())
						&& (findAdverd.get(m1 + 1).getAddress() - findAdverd.get(m1).getAddress()) == 1) {
					TwoSum s = new TwoSum();
					s.setFirdstaddress(findAdverd.get(m1).getAddress());
					s.setSecondaddress(findAdverd.get(m1 + 1).getAddress());
					s.setCount(2);
					listAdverd.add(s);
				}
			}
		}

		/**
		 * 判断类型计算情感值
		 */

		if (findMood.size() != 0) {// 有情感词
			for (Modle mood : findMood) {// 遍历情感词
				if (findAdverd.size() != 0) {// 有程度副词
					for (Modle adverd : findAdverd) {// 遍历程度副词
						if (f == 1) {
							break;
						} else {
							if ((mood.getAddress() > adverd.getAddress())
									&& (mood.getAddress() - adverd.getAddress()) <= 4) {// 判断情感词与程度副词的位置，
								// 当程度副词与情感词之间的差距小于4时才会进入，否则就因为离得太远而舍弃掉
								if (findNo.size() != 0) {// 有否定词

									for (Modle no : findNo) {// 遍历否定词
										if (f == 1) {
											break;
										} else {
											if ((adverd.getAddress() > no.getAddress())
													&& (adverd.getAddress() - no.getAddress()) <= 2) {
												// 判断程度副词与否定词的位置，当两者的位置在3之内的时候才会算在内，否则会因为里的太远而屏蔽掉
												if (specile) {

													/*
													 * 反义疑问句
													 */
													double emotionalValue = 0;
													ResultValue value = new ResultValue();
													emotionalValue = -1 * 0.5 * no.getEmotionalTendenc()
															* adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													System.out.println(" 反义疑问词 否定词 程度副词 情感词 类型:" + no.toString()
															+ adverd.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("反义疑问词 否定词 程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												} else {
													double emotionalValue = 0;
													ResultValue value = new ResultValue();
													emotionalValue = -0.5 * no.getEmotionalTendenc()
															* adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													System.out.println("否定词 程度副词 情感词 类型:" + no.toString()
															+ adverd.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("否定词 程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
													// 否定词 程度副词 情感词 类型
												}

											} else if ((no.getAddress() > adverd.getAddress())
													&& (no.getAddress() - adverd.getAddress()) <= 3) {
												if (specile) {

													/**
													 * 反义疑问句
													 */
													double emotionalValue = 0;
													emotionalValue = -1 * no.getEmotionalTendenc()
															* adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													// 程度副词 否定词 情感词 类型
													ResultValue value = new ResultValue();
													System.out.println(" 反义疑问词 程度副词 否定词 情感词 类型" + adverd.toString()
															+ no.toString() + mood.toString());
													System.out.println("情感值为：" + emotionalValue);
													value.setType("反义疑问词 程度副词 否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												} else {
													double emotionalValue = 0;
													emotionalValue = no.getEmotionalTendenc()
															* adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													// 程度副词 否定词 情感词 类型
													ResultValue value = new ResultValue();
													System.out.println("程度副词 否定词 情感词 类型" + adverd.toString()
															+ no.toString() + mood.toString());
													System.out.println("情感值为：" + emotionalValue);
													f = 1;
													value.setType("程度副词 否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
												}

											} else {
												if (specile) {
													/**
													 * 反义疑问句
													 */
													// 否定词没有所属
													double emotionalValue = 0;
													ResultValue value = new ResultValue();
													emotionalValue = -1 * adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													System.out.println(
															" 反义疑问词 程度副词 情感词 类型" + adverd.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("反义疑问词 程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												} else {
													// 否定词没有所属
													double emotionalValue = 0;
													ResultValue value = new ResultValue();
													emotionalValue = adverd.getEmotionalIntensity()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													System.out.println(
															"程度副词 情感词 类型" + adverd.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												}
											}
										}

									}
								} else {
									if (specile) {
										// 程度副词 情感词 类型
										double emotionalValue = 0;
										ResultValue value = new ResultValue();
										emotionalValue = -1 * adverd.getEmotionalIntensity()
												* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
										System.out.println("反义疑问词 程度副词 情感词 类型" + adverd.toString() + mood.toString());
										System.out.println("情感值为：" + emotionalValue);
										value.setType("反义疑问词 程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
										value.setValue(emotionalValue);
										values.add(value);
										f = 1;
									} else {
										// 程度副词 情感词 类型
										double emotionalValue = 0;
										ResultValue value = new ResultValue();
										emotionalValue = adverd.getEmotionalIntensity() * mood.getEmotionalIntensity()
												* mood.getEmotionalTendenc();
										System.out.println("程度副词 情感词 类型" + adverd.toString() + mood.toString());
										System.out.println("情感值为：" + emotionalValue);
										value.setType("程度副词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
										value.setValue(emotionalValue);
										values.add(value);
										f = 1;
									}
								}

							} else if (findNo.size() != 0) {// 当程度副词舍弃掉时，应该判断否定词的位置

								for (Modle no : findNo) {// 遍历否定词

									if (f == 1) {
										break;
									} else {
										if ((mood.getAddress() > no.getAddress())
												&& (mood.getAddress() - no.getAddress()) <= 2) {
											/*
											 * 判断双从否定情况
											 */
											if (listNo.size() != 0) {
												for (TwoSum s : listNo) {
													if (f == 1) {
														break;
													} else {
														if ((s.getFirdstaddress() == no.getAddress())
																|| (s.getSecondaddress() == no.getAddress())) {
															if (mood.getAddress() - s.getSecondaddress() == 1) {
																double emotionalValue = 0;
																emotionalValue = mood.getEmotionalIntensity()
																		* mood.getEmotionalTendenc();
																ResultValue value = new ResultValue();
																System.out.println("双从否定表肯定类型：");

																System.out.println("情感值为：" + emotionalValue);
																value.setType("双从否定表肯定类型");// 把情感值加入到list中，为后边的分析做准备
																value.setValue(emotionalValue);
																values.add(value);
																f = 1;
															} else {
																if (specile) {
																	/**
																	 * 反义疑问词
																	 */
																	double emotionalValue = 0;
																	emotionalValue = -1 * no.getEmotionalTendenc()
																			* mood.getEmotionalIntensity()
																			* mood.getEmotionalTendenc();
																	// 否定词
																	// 情感词
																	// 类型
																	ResultValue value = new ResultValue();
																	System.out.println("否定词 情感词 类型" + no.toString()
																			+ mood.toString());
																	System.out.println("情感值为" + emotionalValue);
																	value.setType("否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
																	value.setValue(emotionalValue);
																	values.add(value);
																	f = 1;
																} else {
																	double emotionalValue = 0;
																	emotionalValue = no.getEmotionalTendenc()
																			* mood.getEmotionalIntensity()
																			* mood.getEmotionalTendenc();
																	// 否定词
																	// 情感词
																	// 类型
																	ResultValue value = new ResultValue();
																	System.out.println("否定词 情感词 类型" + no.toString()
																			+ mood.toString());
																	System.out.println("情感值为" + emotionalValue);
																	value.setType("否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
																	value.setValue(emotionalValue);
																	values.add(value);
																	f = 1;
																}
															}
														}
													}
												}
											} else {
												if (specile) {
													/*
													 * 反义疑问词
													 */
													double emotionalValue = 0;
													emotionalValue = -1 * no.getEmotionalTendenc()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													// 否定词 情感词 类型
													ResultValue value = new ResultValue();
													System.out.println(
															"反义疑问词 否定词 情感词 类型" + no.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("反义疑问词 否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												} else {
													double emotionalValue = 0;
													emotionalValue = no.getEmotionalTendenc()
															* mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
													// 否定词 情感词 类型
													ResultValue value = new ResultValue();
													System.out.println("否定词 情感词 类型" + no.toString() + mood.toString());
													System.out.println("情感值为" + emotionalValue);
													value.setType("否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												}
											}

										} else {
											if (specile) {
												// 否定词没有所属
												double emotionalValue = -1 * mood.getEmotionalIntensity()
														* mood.getEmotionalTendenc();
												ResultValue value = new ResultValue();
												System.out.println(" 反义疑问词 情感词 类型" + mood.toString());
												System.out.println("情感值为" + emotionalValue);
												value.setType("反义疑问词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
												value.setValue(emotionalValue);
												values.add(value);
												f = 1;
											} else {
												// 否定词没有所属
												double emotionalValue = mood.getEmotionalIntensity()
														* mood.getEmotionalTendenc();
												ResultValue value = new ResultValue();
												System.out.println("情感词 类型" + mood.toString());
												System.out.println("情感值为" + emotionalValue);
												value.setType("情感词 类型");// 把情感值加入到list中，为后边的分析做准备
												value.setValue(emotionalValue);
												values.add(value);
												f = 1;
											}
										}
									}
								}
							} else {
								if (specile) {
									// 情感词 类型
									/**
									 * 反义疑问句
									 */
									double emotionalValue = -1 * mood.getEmotionalIntensity()
											* mood.getEmotionalTendenc();
									ResultValue value = new ResultValue();
									System.out.println(" 反义疑问词 情感词 类型" + mood.toString());
									System.out.println("情感值为" + emotionalValue);
									value.setType("反义疑问词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
									value.setValue(emotionalValue);
									values.add(value);
									f = 1;
								} else {
									// 情感词 类型
									double emotionalValue = mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
									ResultValue value = new ResultValue();
									System.out.println("情感词 类型" + mood.toString());
									System.out.println("情感值为" + emotionalValue);
									value.setType("情感词 类型");// 把情感值加入到list中，为后边的分析做准备
									value.setValue(emotionalValue);
									values.add(value);
									f = 1;
								}
							}
						}
					}
				} else if (findNo.size() != 0) {// 当没有程度副词的时候应该判断否定词

					for (Modle no : findNo) {// 遍历否定词
						if (f == 1) {
							break;
						} else {
							if ((mood.getAddress() > no.getAddress()) && (mood.getAddress() - no.getAddress()) <= 3) {
								/*
								 * 判断双从否定
								 */

								if (listNo.size() != 0) {
									for (TwoSum s : listNo) {
										if (f == 1) {
											break;
										} else {
											if ((s.getFirdstaddress() == no.getAddress())
													|| (s.getSecondaddress() == no.getAddress())) {
												if (mood.getAddress() - s.getSecondaddress() == 1) {
													double emotionalValue = 0;
													emotionalValue = mood.getEmotionalIntensity()
															* mood.getEmotionalTendenc();
													ResultValue value = new ResultValue();
													System.out.println("双从否定表肯定类型：");
													System.out.println("情感值为：" + emotionalValue);
													value.setType("双从否定表肯定类型");// 把情感值加入到list中，为后边的分析做准备
													value.setValue(emotionalValue);
													values.add(value);
													f = 1;
												} else {
													if (specile) {
														/**
														 * 反义疑问句
														 */
														double emotionalValue = 0;
														emotionalValue = no.getEmotionalTendenc()
																* mood.getEmotionalIntensity()
																* mood.getEmotionalTendenc();
														// 否定词 情感词 类型
														System.out.println(
																"反义疑问词 否定词 情感词 类型" + no.toString() + mood.toString());
														System.out.println("情感值为" + emotionalValue);
														ResultValue value = new ResultValue();
														value.setType("反义疑问词 否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
														value.setValue(emotionalValue);
														values.add(value);
														f = 1;
													} else {
														double emotionalValue = 0;
														emotionalValue = no.getEmotionalTendenc()
																* mood.getEmotionalIntensity()
																* mood.getEmotionalTendenc();
														// 否定词 情感词 类型
														System.out.println(
																"否定词 情感词 类型" + no.toString() + mood.toString());
														System.out.println("情感值为" + emotionalValue);
														ResultValue value = new ResultValue();
														value.setType("否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
														value.setValue(emotionalValue);
														values.add(value);
														f = 1;
													}
												}
											}
										}
									}
								} else {
									if (specile) {
										double emotionalValue = 0;
										emotionalValue = -1 * no.getEmotionalTendenc() * mood.getEmotionalIntensity()
												* mood.getEmotionalTendenc();
										// 否定词 情感词 类型
										System.out.println(" 反义疑问词 否定词 情感词 类型" + no.toString() + mood.toString());
										System.out.println("情感值为" + emotionalValue);
										ResultValue value = new ResultValue();
										value.setType("反义疑问词 否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
										value.setValue(emotionalValue);
										values.add(value);
										f = 1;
									} else {
										double emotionalValue = 0;
										emotionalValue = no.getEmotionalTendenc() * mood.getEmotionalIntensity()
												* mood.getEmotionalTendenc();
										// 否定词 情感词 类型
										ResultValue value = new ResultValue();
										System.out.println("否定词 情感词 类型" + no.toString() + mood.toString());
										System.out.println("情感值为" + emotionalValue);
										value.setType("否定词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
										value.setValue(emotionalValue);
										values.add(value);
										f = 1;
									}
								}
							} else {
								if (specile) {
									/**
									 * 反义疑问词
									 */
									// 情感词 类型
									double emotionalValue = -1 * mood.getEmotionalIntensity()
											* mood.getEmotionalTendenc();
									System.out.println("反义疑问词 情感词 类型" + mood.toString());
									System.out.println("情感值为" + emotionalValue);
									ResultValue value = new ResultValue();
									value.setType("反义疑问词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
									value.setValue(emotionalValue);
									values.add(value);
									f = 1;
								} else {
									// 情感词 类型
									double emotionalValue = mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
									ResultValue value = new ResultValue();
									System.out.println("情感词 类型" + mood.toString());
									System.out.println("情感值为" + emotionalValue);
									value.setType("情感词 类型");// 把情感值加入到list中，为后边的分析做准备
									value.setValue(emotionalValue);
									values.add(value);
									f = 1;
								}
							}
						}
					}

				} else {
					if (specile) {
						/**
						 * 反义疑问句
						 */
						// 情感词 类型
						double emotionalValue = -1 * mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
						ResultValue value = new ResultValue();
						System.out.println("反义疑问词 情感词 类型" + mood.toString());
						System.out.println("情感值为" + emotionalValue);
						value.setType("反义疑问词 情感词 类型");// 把情感值加入到list中，为后边的分析做准备
						value.setValue(emotionalValue);
						values.add(value);
						f = 1;
					} else {
						// 情感词 类型
						double emotionalValue = mood.getEmotionalIntensity() * mood.getEmotionalTendenc();
						ResultValue value = new ResultValue();
						System.out.println("情感词 类型" + mood.toString());
						System.out.println("情感值为" + emotionalValue);
						value.setType("情感词 类型");// 把情感值加入到list中，为后边的分析做准备
						value.setValue(emotionalValue);
						values.add(value);
						f = 1;
					}
				}
			}
		} else {
			// 其他方法进行分析
			ResultValue value = new ResultValue();
			value.setType("无情感词 类型");
			value.setValue(0);
			values.add(value);
			//System.out.println("其他方法进行分析");
		}
		return values;
	}

	/**
	 * 计算一段话的情感值
	 * 
	 * @param values
	 * @return
	 */
	public static double countValue(List<ResultValue> values) {
		double valueNum = 0;
		for (ResultValue value : values) {
			valueNum += value.getValue();
		}
		valueNum = valueNum / values.size();
		if (valueNum < 0) {
			valueNum = valueNum + (-0.1 * particle.size());
		} else if (valueNum > 0) {
			valueNum = valueNum + 0.1 * particle.size();
		}
		if(valueNum!=0){
			valueNum = Double.parseDouble(df.format(valueNum));
		}
		return valueNum;
	}

	/**
	 * 每次分析完一段话以后想应的list应清空，不然会覆盖原来的值，最后都变成了空
	 */
	public static void deleteList() {
		findMood.clear();
		findNo.clear();
		findAdverd.clear();
	}

	/**
	 * 提取关键语句
	 * 
	 * @return
	 */
	public static String document(String document) {
		List<String> sentenceList = HanLP.extractSummary(document, 5);
		System.out.println(sentenceList);
		String str = sentenceList.toString();
		str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
		return str;
	}
	/**
	 * 计算一句话的情感值
	 * 
	 * @param str
	 * @return
	 */
	public static double getValue(String str) {
		List<ResultValue> values = new ArrayList<>();
		String[] subStrings = cutSentence(str);
		for (int i = 0; i < subStrings.length; i++) {
			System.out.println(subStrings[i]);
			cutWord(subStrings[i]);
			/* 给分开的句子进行判断是不是反义疑问句 */
			Boolean specile = jubgeType(subStrings[i]);
			List<ResultValue> value = new ArrayList<>();
			value = anlyseSentence(specile);
			values.addAll(value);
			deleteList();
		}
		for (ResultValue v : values) {
			System.out.println(v.toString());
		}
		System.out.println(particle.size() + "===============================");
		double n = countValue(values);
		return n;
	}
/**
 * 提取兴趣爱好
 * @param str
 * @return
 */
	public static String getHobby(String content){
		//String content = "桌球只比丁俊晖菜一点的哥们硬在周末把我拉出去陪他练球，炎炎夏日心情和禅一样烦躁。但球馆的气氛到是让人很快转移了注意，每日一球";
		List<String> hobby = new ArrayList<>();
		List<String> keywordList = HanLP.extractKeyword(content, 5);
		System.out.println(keywordList);
		for(String key :keywordList){
			String words = com.TB.analytic.Sentiments_Test.selecthobby(key);
			if(words!=null){
				hobby.add(words);
			}
		}
		if(hobby.toString()=="[]")
			return null;
		else
			{
			String str = hobby.toString();
			str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
			return str;
			}
	}
	/**
	 * 最后的提取
	 * @param str
	 * @return
	 */
public static ReturnValue value(String str){
	ReturnValue value = new ReturnValue();
	double n = getValue(str);
	String s = document(str);
	String hobby = getHobby(str);
	value.setValue(n);value.setDocument(s);value.setHobby(hobby);
	return value;
}

	public static void main(String[] args) {
		String str = "开放喜欢的荣耀，嘿嘿";
		ReturnValue value = new ReturnValue();
		value = value(str);
		System.out.println("这段话的情感值为" + value.toString());
	}
}
