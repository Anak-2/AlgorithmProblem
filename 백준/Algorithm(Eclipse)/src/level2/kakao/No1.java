package level2.kakao;

import java.util.*;
import java.io.*;

// 수식 최대화
public class No1 {

//  연산자 종류를 저장할 배열
	static Character[] operatorKind;
//  연산자 우선순위 경우의 수를 저장할 리스트
	static ArrayList<Character[]> operatorPrio = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(solution("50*6-3*2"));
	}

	public static long solution(String expression) {
		long answer = 0;
//	     수식에서 피연산자 저장
		ArrayList<Long> operand = new ArrayList<>();
//	     수식에서 연산자 저장
		ArrayList<Character> operator = new ArrayList<>();
//	     입력받은 문자열을 문자 배열로 변환
		char[] expressionArr = expression.toCharArray();
		operatorKind = new Character[] { '+', '-', '*' };
		boolean[] visited = new boolean[3];
		int operatorSize = 0;
//	         피연산자 1,0,0 들어오는 것을 저장해서 100으로 list에 넣어주기 위해 StringBuilder 이용
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

//	     연산자 개수만큼 visited배열 생성
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

	// 수식에 포함된 연산자의 종류를 넘겨주면, 연산자의 우선 순위 경우의 수를 list에 담아서 반환
	private static void getOperatorPrio(boolean[] visited, Character[] retArr, int idx) {
//	     전부 방문한 경우인지 체크
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				retArr[idx] = operatorKind[i];
				if (idx == visited.length - 1) {
//						실질적으론 얕은 복사지만 원본 배열이 바뀔 때 영향을 안 받으므로 cheap deep copy
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
//	                 사용한 operator operand 삭제
				operand.remove(idx + 1);
				operator.remove(idx);
			}
		}
		System.out.println(operand.get(0));
		return Math.abs(operand.get(0));
	}
}
