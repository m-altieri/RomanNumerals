
public class RomanNumerals {
	
	public int convertToInteger(String romanNum) throws InvalidRomanNumeralException {
		
		if (!this.isCorrect(romanNum))
			throw new InvalidRomanNumeralException();
		
		int tot = 0;
		String s = romanNum;
		s = s.trim();
		s = s.toUpperCase();
		
		return calculate(s, tot);
	}
	
	/**
	@TODO renderlo privato
	*/
	public boolean isCorrect(String s)
	{
		boolean correct = true;
		s = s.trim();
		s = s.toUpperCase();
		
		// The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row.
		for (int i = 0; i <= s.length() - 4; i++)
			if (s.substring(i, i + 4).equals("IIII") || s.substring(i, i + 4).equals("XXXX") || s.substring(i, i + 4).equals("CCCC") || s.substring(i, i + 4).equals("MMMM"))
				correct = false;
		
		// The symbols 'V', 'L', and 'D' can never be repeated.
		int countV = 0, countL = 0, countD = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'V': countV++; break;
				case 'L': countL++; break;
				case 'D': countD++; break;
			}
		}
		if (countV > 1 || countL > 1 || countD > 1)
			correct = false;
		
		// The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values 
		// ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM').
		for (int i = 0; i < s.length() - 1; i++) {
			switch (s.substring(i,i+2)) {
			case "IL":
			case "IC":
			case "ID":
			case "IM":
			case "XD":
			case "XM":
				correct = false; break;
			}
		}

		// Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not).
		for (int i = 0; i < s.length() - 2; i++) {
			switch (s.substring(i,i+3)) {
			case "IIV":
			case "IIX":
			case "IIL":
			case "IIC":
			case "IID":
			case "IIM":
			case "XXL":
			case "XXC":
			case "XXD":
			case "XXM":
			case "CCD":
			case "CCM":
				correct = false; break;
			}
		}
		
		// The '5' symbols ('V', 'L', and 'D') can never be subtracted.
		for (int i = 0; i < s.length() - 1; i++) {
			switch (s.substring(i,i+2)) {
			case "VX":
			case "VL":
			case "VC":
			case "VD":
			case "VM":
			case "LC":
			case "LD":
			case "LM":
			case "DM":
				correct = false; break;
			}
		}
		
		return correct;
	}
	
	private static int calculate(String s, int tot) {
		
		if (s.length() == 1)
			switch (s.charAt(0)) {
			case 'I': return tot + 1;
			case 'V': return tot + 5;
			case 'X': return tot + 10;
			case 'L': return tot + 50;
			case 'C': return tot + 100;
			case 'D': return tot + 500;
			case 'M': return tot + 1000;
			}
			
		String t = s.substring(0,2);
		if (t.equals("IV"))
			calculate(s.substring(2), tot + 4);
		else if (t.equals("IX"))
			calculate(s.substring(2), tot + 9);
		else if (t.equals("XL"))
			calculate(s.substring(2), tot + 40);
		else if (t.equals("XC"))
			calculate(s.substring(2), tot + 90);
		else if (t.equals("CD"))
			calculate(s.substring(2), tot + 400);
		else if (t.equals("CM"))
			calculate(s.substring(2), tot + 900);
		else
			;
		
		String u = s.substring(0,1);
		if (u.equals("I"))
			calculate(s.substring(1), tot + 1);
		else if (u.equals("V"))
			calculate(s.substring(1), tot + 5);
		else if (u.equals("X"))
			calculate(s.substring(1), tot + 10);
		else if (u.equals("L"))
			calculate(s.substring(1), tot + 50);
		else if (u.equals("C"))
			calculate(s.substring(1), tot + 100);
		else if (u.equals("D"))
			calculate(s.substring(1), tot + 500);
		else if (u.equals("M"))
			calculate(s.substring(1), tot + 1000);
		else
			;
		
		return 0;
	}
}
