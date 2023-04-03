package level2.kakao;

import java.util.*;
import java.io.*;

// ���� �ִ�ȭ
public class No1 {

//  ������ ������ ������ �迭
	static Character[] operatorKind;
//  ������ �켱���� ����� ���� ������ ����Ʈ
	static ArrayList<Character[]> operatorPrio = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(solution("50*6-3*2"));
	}

	public static long solution(String expression) {
		long answer = 0;
//	     ���Ŀ��� �ǿ����� ����
		ArrayList<Long> operand = new ArrayList<>();
//	     ���Ŀ��� ������ ����
		ArrayList<Character> operator = new ArrayList<>();
//	     �Է¹��� ���ڿ��� ���� �迭�� ��ȯ
		char[] expressionArr = expression.toCharArray();
		operatorKind = new Character[] { '+', '-', '*' };
		boolean[] visited = new boolean[3];
		int operatorSize = 0;
//	         �ǿ����� 1,0,0 ������ ���� �����ؼ� 100���� list�� �־��ֱ� ���� StringBuilder �̿�
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < expression.length(); i++) {
			int j = 0;
			for (j = 0; j < operatorKind.length; j++) {
				if (operatorKind[j] == expressionArr[i])
					break;
			}
			if (j != operatorKind.length) {
				if (!visited[j]) {
					operatorSize++;
					visited[j] = true;
				}
				operand.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				operator.add(expressionArr[i]);
				continue;
			}
			sb.append(expressionArr[i]);
		}
		operand.add(Long.parseLong(sb.toString()));

//	     ������ ������ŭ visited�迭 ����
		visited = new boolean[operatorSize];
		Character[] retArr = new Character[operatorSize];
		getOperatorPrio(visited, retArr, 0);

		for (Character[] i : operatorPrio) {
			// System.out.println(Arrays.deepToString(i));
			long temp = calc(new ArrayList<Long>(operand), new ArrayList<Character>(operator), i);
			if (answer < temp)
				answer = temp;
		}

		return answer;
	}

	// ���Ŀ� ���Ե� �������� ������ �Ѱ��ָ�, �������� �켱 ���� ����� ���� list�� ��Ƽ� ��ȯ
	private static void getOperatorPrio(boolean[] visited, Character[] retArr, int idx) {
//	     ���� �湮�� ������� üũ
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				retArr[idx] = operatorKind[i];
				if (idx == visited.length - 1) {
//						���������� ���� �������� ���� �迭�� �ٲ� �� ������ �� �����Ƿ� cheap deep copy
					Character[] insertArr = Arrays.copyOf(retArr, retArr.length);
//						deep copy (Object.clone())
					Character[] insertArr2 = retArr.clone();
					operatorPrio.add(insertArr2);
				} else {
					getOperatorPrio(visited, retArr, idx + 1);
				}
				visited[i] = false;
			}
		}
	}

	public static long calc(ArrayList<Long> operand, ArrayList<Character> operator, Character[] operatorPrio) {
		System.out.println(Arrays.deepToString(operatorPrio));
		for (Character op : operatorPrio) {
			while (operator.size() != 0) {
				int idx = operator.indexOf(op);
				if (idx == -1)
					break;

				if (op == '*') {
					long result = operand.get(idx) * operand.get(idx + 1);
					operand.set(idx, result);
				} else if (op == '+') {
					long result = operand.get(idx) + operand.get(idx + 1);
					operand.set(idx, result);
				} else {
					long result = operand.get(idx) - operand.get(idx + 1);
					operand.set(idx, result);
				}
//	                 ����� operator operand ����
				operand.remove(idx + 1);
				operator.remove(idx);
			}
		}
		System.out.println(operand.get(0));
		return Math.abs(operand.get(0));
	}
}
