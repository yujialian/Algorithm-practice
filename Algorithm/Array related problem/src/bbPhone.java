import java.util.ArrayList;
import java.util.HashMap;
public class bbPhone {
	public void print3() {
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		for(int i = 1; i <= 999; i++) {
			int sum = getSum(i);
			ArrayList<String> arr = map.get(sum);
			if(arr == null) {
				map.put(sum, new ArrayList<String>());
				arr = map.get(sum);
			}
			String cur = i + "";
			while(cur.length() < 3) {
				cur = '0' + cur;
			}
			arr.add(cur);
		}
		int m = 0;
		for(int i = 100; i <= 999; i++) {
			int sum = getSum(i);
			ArrayList<String> list = map.get(sum);
			for(String str: list) {
				String temp = i + str;
				m++;
				System.out.println(m + " " + temp);
			}
		}
	}

	private int getSum(int i) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}
	public static void main(String[] args) {
		bbPhone test = new bbPhone();
		test.print3();
	}
}

