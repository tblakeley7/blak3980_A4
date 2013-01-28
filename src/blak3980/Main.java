package blak3980;

import javax.swing.JFrame;

/**
 * @author Tyler
 *Class to run JavaCalculator
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaCalculator calc = new JavaCalculator();
		calc.pack();
		calc.setLocationRelativeTo(null);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setVisible(true);

	}

}
