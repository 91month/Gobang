package C6;

import java.awt.event.ActionEvent;

public class Judge implements BordOK {
	private int x, y;
	private int count;
    ActionEvent e = null;
    public  int qqq=0;
    public  int www=0;
    public  int eee=0;
    public  int rrr=0;
    public  int ttt=0;
    public  static int tongshi=0;
	public  int jishu=-1;
	public  int jiayi=0;
	public  int heqi=0;
 
	public Judge(){
		
	}
	public Judge(int x, int y) {
		this.x = x;
		this.y = y;
	}
 
	boolean  judge() {
		if (judge1(x, y) >=5)
			return true;
		return false;
	}
 
	public int judge1(int x1, int y2) {
 
		// 横向检查
		count = 1;
		for (int i = x1 + 1; i < coloum; i++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][y2]) {
					count++;
				} else
					break;
			} else
				break;
		}
		for (int i = x1 - 1; i >= 0; i--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][y2]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		if (count >= 5)
			return count;
 
		// 纵向检查
		count = 1;
		for (int i = y2 + 1; i < row; i++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[x1][i]) {
					count++;
				} else
					break;
			} else
				break;
		}
		for (int i = y2 - 1; i >= 0; i--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[x1][i]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		if (count >= 5)
			return count;
 
		// 斜向检查
		count = 1;
		// 左上到右下
		for (int i = x1 + 1, j = y2 + 1; i < coloum && j < row; i++, j++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
		// 右下到左上
		for (int i = x1 - 1, j = y2 - 1; i >= 0 && j >= 0; i--, j--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
		if (count >= 5)
			return count;
 
		count = 1;
		// 左下到右上
		for (int i = x1 + 1, j = y2 - 1; i < coloum && j >= 0; i++, j--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
		// 右上到左下
		for (int i = x1 - 1, j = y2 + 1; i >= 0 && j < row; i--, j++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		return count;
 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("我想指定禁手"))
		{
			rrr=1;
		}
		if(e.getActionCommand().equals("我想放弃行棋权"))
		{
			ttt=1;
		}
		else
			ttt=0;
		    rrr=0;
	 }

    public void Check()
    {
    	jishu=jishu+1;
    	if(count>5&&array1[x][y]==-1)   //是白棋
    	{
    		qqq=1;
    	}
    	if(count>5&&array1[x][y]==1)  //是黑棋
    	{
    		if(rrr==1)
    		{
    			www=1;
    		}
    		else
    		{
    			qqq=1;
    		}
    	}
    	if(count==5)
    	{
    		if(array1[x][y]==-1)
    		{
    			qqq=1;
    		}
    		else
    		{
    			www=1;
    		}
    	}
    	if(count<5)
    	{
    		for(int i=0;i<15;i++)
    		{
    			for(int j=0;j<15;j++)
    			{
    				if(array1[i][j]!=0)
    				{
    					jishu++;
    				}
    			}
    		}
    		tongshi=jishu;
    		if(ttt==1&&array1[x][y]==1)
    		{
    			jiayi=jishu;
    			heqi++;
    		}
    		if(jishu-1==jiayi&&array1[x][y]==-1&&heqi==1)
    		{
    			if(ttt==1)
    			{
    				eee=1;
    			}
    			else
    			{
    				heqi--;
    			}
    		}
    		if(jishu==225)
    		{
    			eee=1;
    		}
    		//禁手
    		//if(checkChess3344()==1)
    		//{
    			//if(rrr==1)
    			//{
    			//	qqq=1;
    			//}
    		//}
    	}
    }
}
