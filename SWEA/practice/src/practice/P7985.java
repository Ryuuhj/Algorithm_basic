package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7985 {
	static int K, max;
	static int[] tree;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			K = sc.nextInt();
			max = (int) Math.pow(2, K) - 1;
			tree = new int[max + 1];
			queue = new LinkedList<Integer>();
			for (int i = 0; i < max; i++) {
				queue.add(sc.nextInt());
			}
			
			fillTree(1);
			int l = 1;
			for (int i = 1; i < tree.length; i++) {
				if(i == (int) Math.pow(2, l)) {
					sb.append("\n");
					l++;
				}
				sb.append(tree[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void fillTree(int idx) {
		if (idx > max)
			return;
		fillTree(idx * 2);
		tree[idx] = queue.poll();
		fillTree(idx * 2 + 1);
	}

}
