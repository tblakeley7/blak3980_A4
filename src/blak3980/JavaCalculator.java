package blak3980;

import java.math.BigInteger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

/**
 * @author Tyler Blakeley 090603980 blak3980@mylaurier.ca Class to create Basic
 *         GUI Calculator
 * 
 */
@SuppressWarnings("serial")
public class JavaCalculator extends JFrame {
	private JButton jbtNum1;
	private JButton jbtNum2;
	private JButton jbtNum3;
	private JButton jbtNum4;
	private JButton jbtNum5;
	private JButton jbtNum6;
	private JButton jbtNum7;
	private JButton jbtNum8;
	private JButton jbtNum9;
	private JButton jbtNum0;
	private JButton jbtAdd;
	private JButton jbtSubtract;
	private JButton jbtMultiply;
	private JButton jbtDivide;
	private JButton jbtSolve;
	private JButton jbtClear;
	private JButton jbtFact;
	private JButton jbtPower;
	private JButton jbtRemainder;
	private JButton jbtNegat;

	private BigInteger SolveTEMP = new NewBigInteger("0");
	NewBigInteger results;
	NewBigInteger results2;
	private JTextArea jtfResult;

	Boolean addBool = false;
	Boolean subBool = false;
	Boolean divBool = false;
	Boolean mulBool = false;
	Boolean remainBool = false;
	Boolean factBool = false;
	Boolean powerBool = false;
	Boolean equalBool = false;

	String display = "";

	public JavaCalculator() {
		super("The Calculator");
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 5, 3, 3));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.add(jbtNum7 = new JButton("7"));
		p1.add(jbtNum8 = new JButton("8"));
		p1.add(jbtNum9 = new JButton("9"));
		p1.add(jbtDivide = new JButton("/"));
		p1.add(jbtPower = new JButton("^"));
		p1.add(jbtNum4 = new JButton("4"));
		p1.add(jbtNum5 = new JButton("5"));
		p1.add(jbtNum6 = new JButton("6"));
		p1.add(jbtMultiply = new JButton("*"));
		p1.add(jbtRemainder = new JButton("%"));
		p1.add(jbtNum1 = new JButton("1"));
		p1.add(jbtNum2 = new JButton("2"));
		p1.add(jbtNum3 = new JButton("3"));
		p1.add(jbtAdd = new JButton("+"));
		p1.add(jbtSubtract = new JButton("-"));
		p1.add(jbtNum0 = new JButton("0"));
		p1.add(jbtNegat = new JButton("+/-"));
		p1.add(jbtClear = new JButton("C"));
		p1.add(jbtSolve = new JButton("="));
		p1.add(jbtFact = new JButton("!"));
		jbtClear.setBackground(Color.red);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		jtfResult = new JTextArea(2, 35);
		jtfResult.setLineWrap(true);
		p2.add(jtfResult);
		jtfResult.setEditable(false);
		JScrollPane Scroll = new JScrollPane(jtfResult);
		Scroll.setPreferredSize(new Dimension(2, 35));
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(Scroll, BorderLayout.NORTH);
		p.add(p1, BorderLayout.SOUTH);

		add(p);

		jbtNum1.addActionListener(new ListenToOne());
		jbtNum2.addActionListener(new ListenToTwo());
		jbtNum3.addActionListener(new ListenToThree());
		jbtNum4.addActionListener(new ListenToFour());
		jbtNum5.addActionListener(new ListenToFive());
		jbtNum6.addActionListener(new ListenToSix());
		jbtNum7.addActionListener(new ListenToSeven());
		jbtNum8.addActionListener(new ListenToEight());
		jbtNum9.addActionListener(new ListenToNine());
		jbtNum0.addActionListener(new ListenToZero());

		jbtAdd.addActionListener(new ListenToAdd());
		jbtSubtract.addActionListener(new ListenToSubtract());
		jbtMultiply.addActionListener(new ListenToMultiply());
		jbtDivide.addActionListener(new ListenToDivide());
		jbtSolve.addActionListener(new ListenToSolve());
		jbtClear.addActionListener(new ListenToClear());
		jbtRemainder.addActionListener(new ListentoRemainder());
		jbtFact.addActionListener(new ListentoFact());
		jbtPower.addActionListener(new ListentoPower());
		jbtNegat.addActionListener(new ListentoNeg());

	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the C
	 *         button
	 */
	class ListenToClear implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			jtfResult.setText("");
			addBool = false;
			subBool = false;
			mulBool = false;
			divBool = false;
			remainBool = false;
			factBool = false;
			powerBool = false;
			equalBool = false;

			SolveTEMP = new NewBigInteger("0");
			results = new NewBigInteger("0");
			results2 = new NewBigInteger("0");

		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the +/-
	 *         button
	 */
	class ListentoNeg implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}
				results = new NewBigInteger(display);
				SolveTEMP = results.multiply(new NewBigInteger("-1"));
				jtfResult.setText(SolveTEMP.toString());
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}

		}

	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the "1"
	 *         button
	 */
	class ListenToOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("1");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("1");
					equalBool = false;
				} else {
					jtfResult.setText(display + "1");
				}
			}
		}

	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 2
	 *         button
	 */
	class ListenToTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("2");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("2");
					equalBool = false;
				} else {
					jtfResult.setText(display + "2");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 3
	 *         button
	 */
	class ListenToThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("3");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("3");
					equalBool = false;
				} else {
					jtfResult.setText(display + "3");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 4
	 *         button
	 */
	class ListenToFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("4");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("4");
					equalBool = false;
				} else {
					jtfResult.setText(display + "4");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 5
	 *         button
	 */
	class ListenToFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("5");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("5");
					equalBool = false;
				} else {
					jtfResult.setText(display + "5");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 6
	 *         button
	 */
	class ListenToSix implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("6");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("6");
					equalBool = false;
				} else {
					jtfResult.setText(display + "6");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 7
	 *         button
	 */
	class ListenToSeven implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("7");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("7");
					equalBool = false;
				} else {
					jtfResult.setText(display + "7");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 8
	 *         button
	 */
	class ListenToEight implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("8");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("8");
					equalBool = false;
				} else {
					jtfResult.setText(display + "8");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 9
	 *         button
	 */
	class ListenToNine implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("9");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("9");
					equalBool = false;
				} else {
					jtfResult.setText(display + "9");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the 0
	 *         button
	 */
	class ListenToZero implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			display = jtfResult.getText();
			if (display.contains("Error")) {
				jtfResult.setText("0");
			} else {
				if (equalBool == true) {
					SolveTEMP = new NewBigInteger("0");
					results = new NewBigInteger("0");
					results2 = new NewBigInteger("0");
					jtfResult.setText("0");
					equalBool = false;
				} else {
					jtfResult.setText(display + "0");
				}
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the +
	 *         button
	 */
	class ListenToAdd implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}

				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");
				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}

					jtfResult.setText("");
				}
				addBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the -
	 *         button
	 */
	class ListenToSubtract implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}
				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");
				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}

					jtfResult.setText("");
				}
				subBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the *
	 *         button
	 */
	class ListenToMultiply implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}

				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");
				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}
					jtfResult.setText("");
				}
				mulBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the /
	 *         button
	 */
	class ListenToDivide implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}
				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");
				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}
					jtfResult.setText("");
				}
				divBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the %
	 *         button
	 */
	class ListentoRemainder implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			try {
				equalBool = false;
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}

				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");

				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}
					jtfResult.setText("");
				}
				remainBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}

	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the ^
	 *         button
	 */
	class ListentoPower implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				}

				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");

				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					}
					jtfResult.setText("");
				}
				powerBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}

	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the !
	 *         button
	 */
	class ListentoFact implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			equalBool = false;
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException("Error: Re enter #'s");

				} else if (display.contains("-")) {
					throw new NumberFormatException(
							"Error: Can't take factorial of negative #'s");
				}
				if (addBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.add(results2);
					jtfResult.setText("");
					addBool = false;

				} else if (subBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.subtract(results2);
					subBool = false;
					jtfResult.setText("");
				} else if (mulBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.multiply(results2);
					mulBool = false;
					jtfResult.setText("");
				} else if (divBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.divide(results2);
					divBool = false;
					jtfResult.setText("");

				} else if (remainBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.remainder(results2);
					remainBool = false;
					jtfResult.setText("");

				} else if (powerBool == true) {
					results2 = new NewBigInteger(jtfResult.getText());
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results2
							.toString()));
					powerBool = false;
					jtfResult.setText("");
				} else {
					results = new NewBigInteger(jtfResult.getText());
					if (SolveTEMP.equals(new BigInteger("0"))) {
						SolveTEMP = SolveTEMP.add(results);
						jtfResult.setText("");
					} else {
						SolveTEMP = results;
					}

				}
				NewBigInteger x = new NewBigInteger(SolveTEMP.toString());
				SolveTEMP = x.factorial();
				jtfResult.setText(SolveTEMP.toString());
				factBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	/**
	 * @author Tyler Class to be used as event handler when user presses the =
	 *         button
	 */
	class ListenToSolve implements ActionListener {
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			try {
				display = jtfResult.getText();
				if (display.equals("") || display.contains("Error")) {
					throw new NumberFormatException(
							"Error:Enter a number first");

				}

				results = new NewBigInteger(jtfResult.getText());
				if (addBool == true) {
					SolveTEMP = SolveTEMP.add(results);
					jtfResult.setText(SolveTEMP.toString());

				} else if (subBool == true) {
					SolveTEMP = SolveTEMP.subtract(results);
					jtfResult.setText(SolveTEMP.toString());
				} else if (mulBool == true) {
					SolveTEMP = SolveTEMP.multiply(results);
					jtfResult.setText(SolveTEMP.toString());
				} else if (divBool == true) {
					SolveTEMP = SolveTEMP.divide(results);
					jtfResult.setText(SolveTEMP.toString());
				} else if (remainBool == true) {
					SolveTEMP = SolveTEMP.remainder(results);
					jtfResult.setText(SolveTEMP.toString());
				} else if (factBool == true) {
					SolveTEMP = results;
					jtfResult.setText(SolveTEMP.toString());
				} else if (powerBool == true) {
					SolveTEMP = SolveTEMP.pow(Integer.parseInt(results
							.toString()));
					jtfResult.setText(SolveTEMP.toString());
				} else {
					jtfResult.setText(results.toString());
				}

				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
				equalBool = true;
			} catch (NumberFormatException e1) {
				jtfResult.setText((e1.getMessage()));
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;

			}catch(ArithmeticException e1){
				jtfResult.setText("Error: Division By Zero");
				SolveTEMP = new NewBigInteger("0");
				results = new NewBigInteger("0");
				results = new NewBigInteger("0");
				addBool = false;
				subBool = false;
				mulBool = false;
				divBool = false;
				remainBool = false;
				factBool = false;
				powerBool = false;
			}
		}
	}

	// Runs the JavaCalculator
	

}