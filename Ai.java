package C6;
 
import java.util.HashMap;
 
public class Ai implements BordOK {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static {
 


		// //��1��
		 map.put("010",10);
		 map.put("0-10",20);
		// //��1��
		 map.put("-110",1);
		 map.put("01-1",1);
		map.put("1-10",1);
		map.put("0-11",1);
		// //��2��
		 map.put("0110", 100);
		map.put("0-1-10",200);
		// //��2��
		map.put("-1110",10);
		map.put("011-1",10);
		map.put("1-1-10",5);
		map.put("0-1-11",5);
		// //��3��
		 map.put("01110", 5000);
		 map.put("0-1-1-10",7000);
		// //��3��
		map.put("-11110",30);
		map.put("0111-1",30);
		 map.put("1-1-1-10",50);
		 map.put("0-1-1-11",50);
		// //��4��
		 map.put("011110", 10000);
	 map.put("0-1-1-1-10",20000);
		// //��4��
		 map.put("-111110",10000);
		 map.put("01111-1",10000);
		 map.put("1-1-1-1-10",10500);
		 map.put("0-1-1-1-11",10500);
		// //������4��
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
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = shang(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = xia(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = zuoshang(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = youshang(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = zuoxia(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					code = youxia(r, c);
					weight = map.get(code);// �����������������ȡ��Ӧ��Ȩֵ
					if (weight != null) {// �ж��Ƿ��и����������������
						weightArray[r][c] += weight;// �ۼ�Ȩֵ
					}
 
					// �ж�����2����һ��ֱ�ߵ��м���һ����λ�����
					
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
 
					// �ж�һ����2����һ����1����һ��ֱ���ϵ��м���һ����λ�����
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
					
 
					// ��3�������˱�����
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
		
	
 
	// ˮƽ����ͳ�Ƶķ���
	public static String zuo(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r - 1; r1 >= 0; r1--) {
			if (array1[r1][c] == 0) {// ��ʾ��λ�]������
				if (r1 + 1 == r) {// ����
					break;
				} 
				else {
					code = array1[r1][c] + code;// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c];// ��¼����
					code = array1[r1][c] + code;// ��¼�����������
				} else if (chess == array1[r1][c]) {
					code = array1[r1][c] + code;// ��¼�����������
				} else {
					code = array1[r1][c] + code;// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ˮƽ����ͳ�Ƶķ���
	public static String you(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r + 1; r1 < coloum; r1++) {
			if (array1[r1][c] == 0) {// ��ʾ��λ�]������
				if (r1 - 1 == r) {// ����
					break;
				} else {
					code =code+array1[r1][c];// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c];// ��¼����
					code =code+array1[r1][c];// ��¼�����������
				} else if (chess == array1[r1][c]) {
					code = code+array1[r1][c];// ��¼�����������
				} else {
					code = code+array1[r1][c];// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��ֱ����ͳ�Ƶķ���
	public static String shang(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int c1 = c - 1; c1 >= 0; c1--) {
			if (array1[r][c1] == 0) {// ��ʾ��λ�]������
				if (c1 + 1 == r) {// ����
					break;
				} else {
					code = array1[r][c1] + code;// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r][c1];// ��¼����
					code = array1[r][c1] + code;// ��¼�����������
				} else if (chess == array1[r][c1]) {
					code = array1[r][c1] + code;// ��¼�����������
				} else {
					code = array1[r][c1] + code;// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��ֱ����ͳ�Ƶķ���
	public static String xia(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int c1 = c + 1; c1 < row; c1++) {
			if (array1[r][c1] == 0) {// ��ʾ��λ�]û������
				if (c1 - 1 == c) {// ����
					break;
				} else {
					code = code+array1[r][c1];// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r][c1];// ��¼����
					code = code+array1[r][c1];// ��¼�����������
				} else if (chess == array1[r][c1]) {
					code = code+array1[r][c1];// ��¼�����������
				} else {
					code = code+array1[r][c1];// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��б����ͳ�Ƶķ���
	public static String zuoshang(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r - 1, c1 = c - 1; r1 >= 0 && c1 >= 0; r1--, c1--) {
			if (array1[r1][c1] == 0) {// ��ʾ��λ�]������
				if (c1 + 1 == c && r1 + 1 == r) {// ����
					break;
				} else {
					code = array1[r1][c1] + code;// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c1];// ��¼����
					code = array1[r1][c1] + code;// ��¼�����������
				} else if (chess == array1[r1][c1]) {
					code = array1[r1][c1] + code;// ��¼�����������
				} else {
					code = array1[r1][c1] + code;// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��б����ͳ�Ƶķ���
	public static String youshang(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r + 1, c1 = c - 1; c1 >= 0 && r1 < coloum; r1++, c1--) {
			if (array1[r1][c1] == 0) {// ��ʾ��λ�]������
				if (r1 - 1 == r && c1 + 1 == c) {// ����
					break;
				} else {
					code = code+array1[r1][c1];// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c1];// ��¼����
					code =code+array1[r1][c1];// ��¼�����������
				} else if (chess == array1[r1][c1]) {
					code =code+array1[r1][c1];// ��¼�����������
				} else {
					code = code+array1[r1][c1];// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��б����ͳ�Ƶķ���
	public static String zuoxia(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r - 1, c1 = c + 1; c1 < row && r1 >= 0; c1++, r1--) {
			if (array1[r1][c1] == 0) {// ��ʾ��λ�]������
				if (c1 - 1 == c && r1 + 1 == r) {// ����
					break;
				} else {
					code = array1[r1][c1] + code;// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c1];// ��¼����
					code = array1[r1][c1] + code;// ��¼�����������
				} else if (chess == array1[r1][c1]) {
					code = array1[r1][c1] + code;// ��¼�����������
				} else {
					code = array1[r1][c1] + code;// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
 
	// ��б����ͳ�Ƶķ���
	public static String youxia(int r, int c) {
		String code = "0";
		int chess = 0;// �洢��һ�ų��ֵ�����
		// ѭ������
		for (int r1 = r + 1, c1 = c + 1; r1 < coloum && c1 < row; r1++, c1++) {
			if (array1[r1][c1] == 0) {// ��ʾ��λ�]������
				if (c1 - 1 == c && r1 - 1 == r) {// ����
					break;
				} else {
					code = code+array1[r1][c1];// ��¼�����������
					break;
				}
			} else {// ��ʾ��λ��������
				if (chess == 0) {// ��һ�γ�������
					chess = array1[r1][c1];// ��¼����
					code = code+array1[r1][c1];// ��¼�����������
				} else if (chess == array1[r1][c1]) {
					code = code+array1[r1][c1];// ��¼�����������
				} else {
					code = code+array1[r1][c1];// ��¼�����������
					break;
				}
			}
		}
		return code;
	}
}
                     