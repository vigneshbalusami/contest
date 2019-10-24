import java.util.Scanner;

public class solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt(), m = sc.nextInt(), max = 0, i, j, value = 0, l = 0, k = 0, count = 0, c = 0;
			int arr[][] = new int[n][m];
			count = n*m*2;
			if (n % 2 == 0)
				l = n / 2 - 1;
			else
				l = n / 2;
			if (m % 2 == 0)
				k = m / 2 - 1;
			else
				k = m / 2;
			for (i = 0; i < n; i++) {
				for (j = 0; j < m; j++) {
					value = sc.nextInt();
					if (value > max) {
						max = value;
						count = n*m*2;
					}
					if (max == value) {
						c = Math.abs(i - l) + Math.abs(j - k);
						if (count > c)
							count = c;
						if (n % 2 == 0 && m % 2 == 0) {
							if (l + 1 < n) {
								c = Math.abs(i - (l + 1)) + Math.abs(j - (k));
								if (count > c)
									count = c;
							}
							if (k + 1 < m) {
								c = Math.abs(i - l) + Math.abs(j - (k + 1));
								if (count > c)
									count = c;
							}
							if (k + 1 < m) {
								c = Math.abs(i - (l + 1)) + Math.abs(j - (k + 1));
								if (count > c)
									count = c;
							}

						} else if (n % 2 == 0) {
							if (l + 1 < n) {
								c = Math.abs(i - (l + 1)) + Math.abs(j - k);
								if (count > c)
									count = c;
							}
						} else if (m % 2 == 0) {
							if (k + 1 < m) {
								c = Math.abs(i - l) + Math.abs(j - (k + 1));
								if (count > c)
									count = c;
							}
						} 
					}
				}
			}
			if (n <= 2 && m <= 2)
				count = 0;
			System.out.println(count);
			t--;

		}
	}
}
