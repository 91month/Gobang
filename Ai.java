package C6;
 
import java.util.HashMap;
 
public class Ai implements BordOK {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static {
 


		// //活1连
		 map.put("010",10);
		 map.put("0-10",20);
		// //眠1连
		 map.put("-110",1);
		 map.put("01-1",1);
		map.put("1-10",1);
		map.put("0-11",1);
		// //活2连
		 map.put("0110", 100);
		map.put("0-1-10",200);
		// //眠2连
		map.put("-1110",10);
		map.put("011-1",10);
		map.put("1-1-10",5);
		map.put("0-1-11",5);
		// //活3连
		 map.put("01110", 5000);
		 map.put("0-1-1-10",7000);
		// //眠3连
		map.put("-11110",30);
		map.put("0111-1",30);
		 map.put("1-1-1-10",50);
		 map.put("0-1-1-11",50);
		// //活4连
		 map.put("011110", 10000);
	 map.put("0-1-1-1-10",20000);
		// //眠4连
		 map.put("-111110",10000);
		 map.put("01111-1",10000);
		 map.put("1-1-1-1-10",10500);
		 map.put("0-1-1-1-11",10500);
		// //碰壁眠4连
		 map.put("11110", 10000);
		 map.put("01111", 10000);
		map.put("-1-1-1-10", 15000);
		map.put("0-1-1-1-1", 15000);
	}
 
	static String code;
	static Integer weight;
 
	public static void Quan() {
		for (int r = 0; r < array1.length; r++) {
			for (int c = 0; c < array1[r].length; c++) {
				if (array1[r][c] == 0) {
					code = zuo(r, c);
					weight = map.get(code);
					if (weight != null) {
						weightArray[r][c] += weight;
					}
	
					code = you(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = shang(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = xia(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = zuoshang(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = youshang(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = zuoxia(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					code = youxia(r, c);
					weight = map.get(code);// 根据棋子相连情况获取对应的权值
					if (weight != null) {// 判断是否有该种棋子相连的情况
						weightArray[r][c] += weight;// 累加权值
					}
 
					// 判断两个2连在一条直线但中间有一个空位的情况
					
					if (
							 (zuo(r,c)+you(r,c)).equals("0-1-100-1-10")
							|| (zuo(r,c)+you(r,c)).equals("0-100-1-1-10")
							|| (zuo(r,c)+you(r,c)).equals("0-1-1-100-10")) 
					{
						weightArray[r][c] = weightArray[r][c]+20000;
					}
					 if (
							 (zuo(r,c)+you(r,c)).equals("01100110")
							|| (zuo(r,c)+you(r,c)).equals("01001110")
							|| (zuo(r,c)+you(r,c)).equals("01110010")
							|| (zuo(r,c)+you(r,c)).equals("-11110010")
							|| (zuo(r,c)+you(r,c)).equals("0111001-1")
							|| (zuo(r,c)+you(r,c)).equals("-11100110")
							||(zuo(r,c)+you(r,c)).equals("0111001-1")
							) {
						weightArray[r][c] = weightArray[r][c]+8000;
						
					}
					
 
					 if ((shang(r,c)+xia(r,c)).equals( "0-1-100-1-10")
							|| (shang(r,c)+xia(r,c)).equals( "0-100-1-1-10")
							|| (shang(r,c)+xia(r,c)).equals( "0-1-1-100-10")
							){
						weightArray[r][c] = weightArray[r][c] + 20000;
					}
					
					 if ((shang(r,c)+xia(r,c)).equals( "01100110")
								|| (shang(r,c)+xia(r,c)).equals( "01001110")
								|| (shang(r,c)+xia(r,c)).equals( "01110010")
								||(shang(r,c)+xia(r,c)).equals("-11110010")
								|| (shang(r,c)+xia(r,c)).equals("0111001-1")
								||(shang(r,c)+xia(r,c)).equals("-11100110")
								|| (shang(r,c)+xia(r,c)).equals("0111001-1")){
						weightArray[r][c] = weightArray[r][c] + 8000;
					}
 
					 if ((zuoshang(r,c)+youxia(r,c)).equals( "0-1-100-1-10")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "0-100-1-1-10")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "0-1-1-100-10")
							){
						weightArray[r][c] = weightArray[r][c] + 20000;
					}
 
					if ((zuoshang(r,c)+youxia(r,c)).equals( "01100110")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "01001110")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "01110010")
							|| (zuoshang(r,c)+youxia(r,c)).equals("-11110010")
							|| (zuoshang(r,c)+youxia(r,c)).equals("0111001-1")
							|| (zuoshang(r,c)+youxia(r,c)).equals("-11100110")
							|| (zuoshang(r,c)+youxia(r,c)).equals("0111001-1")){
						weightArray[r][c] = weightArray[r][c] + 8000;
					}
					 if ((zuoxia(r,c)+youshang(r,c)).equals( "0-1-100-1-10")
							|| (zuoxia(r,c)+youshang(r,c)).equals("0-100-1-1-10")
							|| (zuoxia(r,c)+youshang(r,c)).equals("0-1-1-100-10")
							){
						weightArray[r][c] = weightArray[r][c] + 20000;
					}
					 if ((zuoxia(r,c)+youshang(r,c)).equals( "01100110")
								|| (zuoxia(r,c)+youshang(r,c)).equals( "01001110")
								|| (zuoxia(r,c)+youshang(r,c)).equals( "01110010")
								|| (zuoxia(r,c)+youshang(r,c)).equals("-11110010")
								|| (zuoxia(r,c)+youshang(r,c)).equals("0111001-1")
								|| (zuoxia(r,c)+youshang(r,c)).equals("-11100110")
								|| (zuoxia(r,c)+youshang(r,c)).equals("0111001-1")){
						weightArray[r][c] = weightArray[r][c] + 8000;
					}
 
					// 判断一个活2连和一个活1连在一条直线上但中间有一个空位的情况
					 if(( zuo(r,c)+you(r,c)).equals("0-100-1-10")
							|| (zuo(r,c)+you(r,c)).equals("0-1-100-10")) {
						weightArray[r][c] = weightArray[r][c] + 3000;
					}
					 if(( zuo(r,c)+you(r,c)).equals("0100110")
							|| (zuo(r,c)+you(r,c)).equals("0110010")) {
						weightArray[r][c] = weightArray[r][c] + 2800;
					}
 
					if(( (shang(r,c)+xia(r,c)).equals("0-100-1-10")
							|| (shang(r,c)+xia(r,c)).equals( "0-1-100-10"))) {
						weightArray[r][c] = weightArray[r][c] + 3000;
					}
 
					if(( (shang(r,c)+xia(r,c)).equals("0100110")
							|| (shang(r,c)+xia(r,c)).equals( "0110010"))) {
						weightArray[r][c] = weightArray[r][c] + 2800;
					}
 
					if(( zuoshang(r,c)+youxia(r,c)).equals( "0-100-1-10")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "0-1-100-10")) {
						weightArray[r][c] = weightArray[r][c] + 3000;
					}
					if(( zuoshang(r,c)+youxia(r,c)).equals( "0100110")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "0110010")) {
						weightArray[r][c] = weightArray[r][c] + 2800;
					}
					if(( zuoxia(r,c)+youshang(r,c)).equals( "0-100-1-10")
							|| (zuoxia(r,c)+youshang(r,c)).equals( "0-1-100-10")) {
						weightArray[r][c] = weightArray[r][c] + 3000;
					}
					if(( zuoxia(r,c)+youshang(r,c)).equals( "0100110")
							|| (zuoxia(r,c)+youshang(r,c)).equals( "0110010")) {
						weightArray[r][c] = weightArray[r][c] + 2800;
					}
					
 
					// 眠3连的两端被堵了
					// "1-1-1-10"&"010" "0-1-1-10"&"010"
					if ((zuo(r,c)+you(r,c)).equals("1-1-1-10010")
							||  (zuo(r,c)+you(r,c)).equals("-111100-10")
							|| (zuo(r,c)+you(r,c)).equals("1-1-100-110")
							||  (zuo(r,c)+you(r,c)).equals("-111001-10")
							||  (zuo(r,c)+you(r,c)).equals("-110011-1")
							|| (zuo(r,c)+you(r,c)).equals("1-100-1-11")
							) {
						weightArray[r][c] = 1;
					}
 
					if ((shang(r,c)+xia(r,c)).equals( "1-1-1-10010")
							|| (shang(r,c)+xia(r,c)).equals("-111100-10")
							|| (shang(r,c)+xia(r,c)).equals( "1-1-100-110")
							|| (shang(r,c)+xia(r,c)).equals("-111001-10")
							|| (shang(r,c)+xia(r,c)).equals("-110011-1")
							|| (shang(r,c)+xia(r,c)).equals( "1-100-1-11")
							) {
						weightArray[r][c] = 1;
					}
 
					if ((zuoshang(r,c)+youxia(r,c)).equals( "1-1-1-10010")
							|| (zuoshang(r,c)+youxia(r,c)).equals("-111100-10")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "1-1-100-110")
							|| (zuoshang(r,c)+youxia(r,c)).equals("-111001-10")
							|| (zuoshang(r,c)+youxia(r,c)).equals("-110011-1")
							|| (zuoshang(r,c)+youxia(r,c)).equals( "1-100-1-11")
							) {
						weightArray[r][c] = 1;
					}
 
					if ((zuoxia(r,c)+youshang(r,c)).equals( "1-1-1-10010")
							|| (zuoxia(r,c)+youshang(r,c)).equals("-111100-10")
							|| (zuoxia(r,c)+youshang(r,c)).equals( "1-1-100-110")
							|| (zuoxia(r,c)+youshang(r,c)).equals("-111001-10")
							|| (zuoxia(r,c)+youshang(r,c)).equals("-110011-1")
							|| (zuoxia(r,c)+youshang(r,c)).equals( "1-100-1-11")
							) {
						weightArray[r][c] = 1;
					}
					if((zuo(r,c)+zuoshang(r,c)).equals("-11110-11110")
						||(zuo(r,c)+shang(r,c)).equals("-11110-11110")
				        ||(zuo(r,c)+youshang(r,c)).equals("-111100111-1")
				        ||(zuo(r,c)+you(r,c)).equals("-111100111-1")
				        ||(zuo(r,c)+youxia(r,c)).equals("-111100111-1")
				        ||(zuo(r,c)+xia(r,c)).equals("-111100111-1")
				        ||(zuo(r,c)+zuoxia(r,c)).equals("1-11110-11110")
				        ||(zuoshang(r,c)+shang(r,c)).equals("-11110-11110")
				        ||(zuoshang(r,c)+youshang(r,c)).equals("-111100111-1")
				        ||(zuoshang(r,c)+you(r,c)).equals("-111100111-1")
				        ||(zuoshang(r,c)+youxia(r,c)).equals("-111100111-1")
				        ||(zuoshang(r,c)+xia(r,c)).equals("-111100111-1")
				        ||(zuoshang(r,c)+zuoxia(r,c)).equals("-11110-11110")
				        ||(shang(r,c)+youshang(r,c)).equals("0111-10111-1")
				        ||(shang(r,c)+you(r,c)).equals("0111-10111-1")
				        ||(shang(r,c)+youxia(r,c)).equals("0111-10111-1")
				        ||(shang(r,c)+xia(r,c)).equals("0111-10111-1")
				        ||(shang(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(youshang(r,c)+you(r,c)).equals("0111-10111-1")
				        ||(youshang(r,c)+youxia(r,c)).equals("0111-10111-1")
				        ||(youshang(r,c)+xia(r,c)).equals("0111-10111-1")
				        ||(youshang(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(you(r,c)+youxia(r,c)).equals("0111-10111-1")
				        ||(you(r,c)+xia(r,c)).equals("0111-10111-1")
				        ||(you(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(youxia(r,c)+xia(r,c)).equals("0111-10111-1")
				        ||(youxia(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(xia(r,c)+zuoxia(r,c)).equals("0111-1-11110")) {
						weightArray[r][c] = weightArray[r][c] + 4000;
					}

                    if((zuo(r,c)+zuoshang(r,c)).equals("0111-1-11110")
						||(zuo(r,c)+shang(r,c)).equals("0111-1-11110")
				        ||(zuo(r,c)+youshang(r,c)).equals("0111-1-11110")
				        ||(zuo(r,c)+you(r,c)).equals("0111-1-11110")
				        ||(zuo(r,c)+youxia(r,c)).equals("0111-1-11110")
				        ||(zuo(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(zuo(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+shang(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+youshang(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+you(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+youxia(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(zuoshang(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(shang(r,c)+youshang(r,c)).equals("0111-1-11110")
				        ||(shang(r,c)+you(r,c)).equals("0111-1-11110")
				        ||(shang(r,c)+youxia(r,c)).equals("0111-1-11110")
				        ||(shang(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(shang(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(youshang(r,c)+you(r,c)).equals("0111-1-11110")
				        ||(youshang(r,c)+youxia(r,c)).equals("0111-1-11110")
				        ||(youshang(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(youshang(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(you(r,c)+youxia(r,c)).equals("0111-1-11110")
				        ||(you(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(you(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(youxia(r,c)+xia(r,c)).equals("0111-1-11110")
				        ||(youxia(r,c)+zuoxia(r,c)).equals("0111-1-11110")
				        ||(xia(r,c)+zuoxia(r,c)).equals("0111-1-11110")) {
						weightArray[r][c] = weightArray[r][c] + 3400;
					}
				}}}
				
			}
		
	
 
	// 水平向左统计的方法
	public static String zuo(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r - 1; r1 >= 0; r1--) {
			if (array1[r1][c] == 0) {// 表示空位沒有棋子
				if (r1 + 1 == r) {// 相邻
					break;
				} 
				else {
					code = array1[r1][c] + code;// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c];// 记录棋子
					code = array1[r1][c] + code;// 记录棋子相连情况
				} else if (chess == array1[r1][c]) {
					code = array1[r1][c] + code;// 记录棋子相连情况
				} else {
					code = array1[r1][c] + code;// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 水平向右统计的方法
	public static String you(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r + 1; r1 < coloum; r1++) {
			if (array1[r1][c] == 0) {// 表示空位沒有棋子
				if (r1 - 1 == r) {// 相邻
					break;
				} else {
					code =code+array1[r1][c];// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c];// 记录棋子
					code =code+array1[r1][c];// 记录棋子相连情况
				} else if (chess == array1[r1][c]) {
					code = code+array1[r1][c];// 记录棋子相连情况
				} else {
					code = code+array1[r1][c];// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 竖直向上统计的方法
	public static String shang(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int c1 = c - 1; c1 >= 0; c1--) {
			if (array1[r][c1] == 0) {// 表示空位沒有棋子
				if (c1 + 1 == r) {// 相邻
					break;
				} else {
					code = array1[r][c1] + code;// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r][c1];// 记录棋子
					code = array1[r][c1] + code;// 记录棋子相连情况
				} else if (chess == array1[r][c1]) {
					code = array1[r][c1] + code;// 记录棋子相连情况
				} else {
					code = array1[r][c1] + code;// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 竖直向下统计的方法
	public static String xia(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int c1 = c + 1; c1 < row; c1++) {
			if (array1[r][c1] == 0) {// 表示空位沒没有棋子
				if (c1 - 1 == c) {// 相邻
					break;
				} else {
					code = code+array1[r][c1];// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r][c1];// 记录棋子
					code = code+array1[r][c1];// 记录棋子相连情况
				} else if (chess == array1[r][c1]) {
					code = code+array1[r][c1];// 记录棋子相连情况
				} else {
					code = code+array1[r][c1];// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 左斜向上统计的方法
	public static String zuoshang(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r - 1, c1 = c - 1; r1 >= 0 && c1 >= 0; r1--, c1--) {
			if (array1[r1][c1] == 0) {// 表示空位沒有棋子
				if (c1 + 1 == c && r1 + 1 == r) {// 相邻
					break;
				} else {
					code = array1[r1][c1] + code;// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c1];// 记录棋子
					code = array1[r1][c1] + code;// 记录棋子相连情况
				} else if (chess == array1[r1][c1]) {
					code = array1[r1][c1] + code;// 记录棋子相连情况
				} else {
					code = array1[r1][c1] + code;// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 右斜向上统计的方法
	public static String youshang(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r + 1, c1 = c - 1; c1 >= 0 && r1 < coloum; r1++, c1--) {
			if (array1[r1][c1] == 0) {// 表示空位沒有棋子
				if (r1 - 1 == r && c1 + 1 == c) {// 相邻
					break;
				} else {
					code = code+array1[r1][c1];// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c1];// 记录棋子
					code =code+array1[r1][c1];// 记录棋子相连情况
				} else if (chess == array1[r1][c1]) {
					code =code+array1[r1][c1];// 记录棋子相连情况
				} else {
					code = code+array1[r1][c1];// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 左斜向下统计的方法
	public static String zuoxia(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r - 1, c1 = c + 1; c1 < row && r1 >= 0; c1++, r1--) {
			if (array1[r1][c1] == 0) {// 表示空位沒有棋子
				if (c1 - 1 == c && r1 + 1 == r) {// 相邻
					break;
				} else {
					code = array1[r1][c1] + code;// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c1];// 记录棋子
					code = array1[r1][c1] + code;// 记录棋子相连情况
				} else if (chess == array1[r1][c1]) {
					code = array1[r1][c1] + code;// 记录棋子相连情况
				} else {
					code = array1[r1][c1] + code;// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
 
	// 右斜向下统计的方法
	public static String youxia(int r, int c) {
		String code = "0";
		int chess = 0;// 存储第一颗出现的棋子
		// 循环遍历
		for (int r1 = r + 1, c1 = c + 1; r1 < coloum && c1 < row; r1++, c1++) {
			if (array1[r1][c1] == 0) {// 表示空位沒有棋子
				if (c1 - 1 == c && r1 - 1 == r) {// 相邻
					break;
				} else {
					code = code+array1[r1][c1];// 记录棋子相连情况
					break;
				}
			} else {// 表示该位置有棋子
				if (chess == 0) {// 第一次出现棋子
					chess = array1[r1][c1];// 记录棋子
					code = code+array1[r1][c1];// 记录棋子相连情况
				} else if (chess == array1[r1][c1]) {
					code = code+array1[r1][c1];// 记录棋子相连情况
				} else {
					code = code+array1[r1][c1];// 记录棋子相连情况
					break;
				}
			}
		}
		return code;
	}
}
                     