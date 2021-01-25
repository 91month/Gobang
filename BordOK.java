package C6;
    public interface BordOK  {
    	 static final int X = 20, Y = 20; // 棋盘的边距
	     static final int size = 36; // 格子大小6*6
	     static final int coloum = 15;    //行数
	     static final int row = 15;     //列数
	     static final int[][] array1 = new int[coloum][row];   //棋子位置数组
	     static final int[][] weightArray = new int[coloum][row];  //记录棋盘每个位置的算法权值
	     static final boolean flag[] = new boolean[2];   //PVP与PVE模式选择
	     
}

