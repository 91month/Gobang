package C6;
import java.awt.Color;
public class Chess extends Object implements BordOK{
	int coloum,row;
	Color color;
	public Chess(int coloum,int row,Color color) {
		this.coloum=coloum;
		this.row=row;
		this.color=color;
	}
}
