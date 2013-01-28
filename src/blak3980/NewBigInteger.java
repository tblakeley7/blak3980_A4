package blak3980;

import java.math.BigInteger;

/**
 * @author Tyler
 *Class used to add Factorial method to BigInteger Class
 */
@SuppressWarnings("serial")
public class NewBigInteger extends BigInteger{

	String x;
	public NewBigInteger(String val) {
		super(val);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return 
	 * NewBigInteger as factorial of this NewBigInteger
	 */
	public NewBigInteger factorial(){
		this.x = this.toString();
	    BigInteger fact = new BigInteger("1");
		for(int i = 1; i<=Integer.parseInt(x); i++){
			BigInteger y = new BigInteger(String.valueOf(i));
			fact = fact.multiply(y);
			
		}return new NewBigInteger(fact.toString());
		
	}

	/**
	 * @param args
	 */
	

}
