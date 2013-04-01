package nl.hightech.dojo.coinchangekata;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

public class CoinchangerTest {

	Coinchanger coinchanger;
	Multiset<Integer> change;

	Set<Integer> euroCoinSet = Sets.newHashSet(1, 2, 5, 10, 20, 50, 100, 200);

	@Test
	public void testConstructor() {
		new Coinchanger(new HashSet<Integer>());
	}

	@Test
	public void testSingleCoin() {
		coinchanger = new Coinchanger(euroCoinSet);

		change = coinchanger.getChangeForAmount(1);

		assertEquals(1, change.size());
		assertEquals(1, change.count(1));
	}

	@Test
	public void testEightCents() {
		coinchanger = new Coinchanger(euroCoinSet);

		change = coinchanger.getChangeForAmount(8);

		assertEquals(3, change.size());
		assertEquals(1, change.count(1));
		assertEquals(1, change.count(2));
		assertEquals(1, change.count(5));
	}

	@Test
	public void testFourteenCents() {
		coinchanger = new Coinchanger(Sets.newHashSet(1, 10, 7));

		change = coinchanger.getChangeForAmount(14);

		assertEquals(2, change.size());
		assertEquals(2, change.count(7));
	}

	@Test
	public void testFourhundredTwoCentCoins() {
		coinchanger = new Coinchanger(Sets.newHashSet(1, 2));

		change = coinchanger.getChangeForAmount(800);

		assertEquals(400, change.size());
		assertEquals(400, change.count(2));
	}
}
