import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestRomanNumerals {

	RomanNumerals n;
	
	@Before
	public void setup() {
		n = new RomanNumerals();
	}
	
	@Test
	public void fourConsecutivesShouldNotBeAllowed() {

		Assert.assertEquals(false, n.isCorrect("MCCXXXX"));
		Assert.assertEquals(false, n.isCorrect("MMMCCCXXXIIII"));
		Assert.assertEquals(false, n.isCorrect("MCXIIIII"));
		Assert.assertEquals(false, n.isCorrect("MMMMI"));
		Assert.assertEquals(false, n.isCorrect("XXXX"));
	}
	
	@Test
	public void symbolsVLDCannotBeRepeated() {
		
		Assert.assertEquals(false, n.isCorrect("XVV"));
		Assert.assertEquals(false, n.isCorrect("XXXLLI"));
		Assert.assertEquals(false, n.isCorrect("CCXVVI"));
		Assert.assertEquals(false, n.isCorrect("CCCCI"));
		Assert.assertEquals(false, n.isCorrect("MMMCLLIII"));
	}
	
	@Test
	public void subtractionsOnlyFromTheTwoNextHighestValues() {
		
		Assert.assertEquals(false, n.isCorrect("LIL"));
		Assert.assertEquals(false, n.isCorrect("XVIIV"));
		Assert.assertEquals(false, n.isCorrect("XVIC"));
		Assert.assertEquals(false, n.isCorrect("XMIII"));
		Assert.assertEquals(false, n.isCorrect("XCXM"));
	}
	
	@Test
	public void onlyOneSubstractionPerNumeral() {
		
		Assert.assertEquals(false, n.isCorrect("IIX"));
		Assert.assertEquals(false, n.isCorrect("XVIIV"));
		Assert.assertEquals(false, n.isCorrect("XVIIC"));
		Assert.assertEquals(false, n.isCorrect("XMIIIV"));
		Assert.assertEquals(false, n.isCorrect("XCCXM"));
	}
	
	@Test
	public void testRomanToIntegerConverter() throws InvalidRomanNumeralException {
		
		Assert.assertEquals(1, n.convertToInteger("I"));
		Assert.assertEquals(5, n.convertToInteger("V"));
		Assert.assertEquals(15, n.convertToInteger("XV"));
		Assert.assertEquals(48, n.convertToInteger("XXXVIII"));
		Assert.assertEquals(49, n.convertToInteger("XXXIX"));
		Assert.assertEquals(99, n.convertToInteger("XCIX"));
		Assert.assertEquals(153, n.convertToInteger("CLIII"));
		Assert.assertEquals(299, n.convertToInteger("CCXCIX"));
		Assert.assertEquals(1000, n.convertToInteger("M"));
		Assert.assertEquals(3589, n.convertToInteger("MMMDLXXXIX"));
	}

}
