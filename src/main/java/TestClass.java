import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class TestClass {

	static Map<String, Map<Integer, Integer>> subscribers_monthly_free = new HashMap<String, Map<Integer, Integer>>();
	static Map<String, Map<Integer, BigDecimal>> subscribers_monthly_total = new HashMap<String, Map<Integer, BigDecimal>>();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static final BigDecimal ONEHUNDRED = new BigDecimal(100);
	public static final BigDecimal ONE = new BigDecimal(1);
	public static final BigDecimal ONE_PT_FIVE = new BigDecimal(1.5);
	public static final BigDecimal TWO = new BigDecimal(2);
	public static final BigDecimal ZERO_PT_FIVE = new BigDecimal(0.5);
	public static final BigDecimal ZERO = new BigDecimal(0);
	private static final BigDecimal FIFTY_K = new BigDecimal(50000);
	private static final BigDecimal FIVE_K = new BigDecimal(5000);
	private static final BigDecimal NINE_K_99 = new BigDecimal(9999.99);
	private static final MathContext mc = new MathContext(2);

	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			String[] split = line.split(",");
			
			Date date = sdf.parse(split[0]);
			int month = date.getMonth();
			String subscriber = split[1];
			BigDecimal amt = new BigDecimal(split[2]);
			
			Map<Integer, BigDecimal> monthlyTotal = subscribers_monthly_total.get(subscriber);
			if(monthlyTotal == null) {
				monthlyTotal = new HashMap<Integer, BigDecimal>();
				subscribers_monthly_total.put(subscriber, monthlyTotal);
			}
			
			BigDecimal monthTotal = monthlyTotal.get(month);
			if(monthTotal == null) {
				monthTotal = ZERO;
				monthlyTotal.put(month, monthTotal);
			}
			
			if(monthTotal.compareTo(FIFTY_K) == 1) {
				//apply rule4
				BigDecimal charge = percentage(amt, ZERO_PT_FIVE);
				charge = charge.round(mc);
				charge = charge.setScale(2, RoundingMode.CEILING);
				System.out.println(charge);
			} else {
				//update the monthly total
				monthlyTotal.put(month, monthTotal.add(amt));
				
				if(amt.compareTo(FIVE_K) <= 0) {
					Map<Integer, Integer> monthlyFree = subscribers_monthly_free.get(subscriber);
					if(monthlyFree == null) {
						monthlyFree = new HashMap<Integer, Integer>();
						subscribers_monthly_free.put(subscriber, monthlyFree);
					}
					Integer freeApplied = monthlyFree.get(month);
					if(freeApplied == null) {
						freeApplied = 0;
						monthlyFree.put(month, freeApplied);
					}
					
					if(freeApplied < 2) {
						//apply rule5
						System.out.println("0.00");
						//Increment the counter
						freeApplied++;
						monthlyFree.put(month, freeApplied);
					} else if(amt.compareTo(FIVE_K) == -1) {
						//apply rule1
						BigDecimal charge = percentage(amt, TWO);
						charge = charge.round(mc);
						charge = charge.setScale(2, RoundingMode.CEILING);
						System.out.println(charge);
					} else {
						//apply rule2
						BigDecimal charge = percentage(amt, ONE_PT_FIVE);
						charge = charge.round(mc);
						charge = charge.setScale(2, RoundingMode.CEILING);
						System.out.println(charge);
					}
				} else if(amt.compareTo(NINE_K_99) <= 0) {
					//apply rule2
					BigDecimal charge = percentage(amt, ONE_PT_FIVE);
					charge = charge.round(mc);
					charge = charge.setScale(2, RoundingMode.CEILING);
					System.out.println(charge);
				} else {
					//apply rule3
					BigDecimal charge = percentage(amt, ONE);
					charge = charge.round(mc);
					charge = charge.setScale(2, RoundingMode.CEILING);
					System.out.println(charge);
				}
			}
		}
	}
	
	public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
	    return base.multiply(pct).divide(ONEHUNDRED);
	}
}