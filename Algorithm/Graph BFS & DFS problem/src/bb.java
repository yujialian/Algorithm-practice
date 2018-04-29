public class bb {
	public int swapDigit(int num, int i, int j) {
		if(i == j) return num;
		int left = (int) Math.pow(10, i);
		int right = (int) Math.pow(10, j);
		int whole_i = (num / left) % 10 * left;
		int whole_j = (num / right) % 10 * right;
		num = num - whole_i - whole_j;
		int temp = whole_i;
		whole_i = (whole_j / right) * left;
		whole_j = (temp / left) * right;
		return num + whole_i + whole_j;
	}
	public static void main(String[] args) {
		bb test = new bb();
		System.out.println(test.swapDigit(654321, 1, 3));
	}
}
