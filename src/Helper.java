import java.awt.Color;

public class Helper {
//
	public static void main(String[] args) {
		int r, g, b, rgb;
		Color c;
		
		r = 140;
		g = 129;
		b = 124;
		c = new Color (r,g,b);
		rgb = c.hashCode();
		System.out.println(rgb);
	}
	
}
