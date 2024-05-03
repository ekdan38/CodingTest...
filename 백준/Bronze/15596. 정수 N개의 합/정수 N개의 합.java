public class Test {

	long sum(int[] a) {
		long hap = 0;
		for (int i = 0; i < a.length; i++) {
			hap += a[i];
		} 
		return hap;
	}
}