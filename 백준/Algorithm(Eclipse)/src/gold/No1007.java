package gold;

import java.util.*;
import java.io.*;

// ���� ��Ī (���ͳ� ������ ����)
public class No1007 {
	
	private static double result;
//	���������� ���õ� ���� ����
	private static boolean[] isChecked;
//	��ǥ�� ����
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���̽� ��
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			// ���� ����
			int n = Integer.parseInt(br.readLine());
			result = Double.MAX_VALUE;

			isChecked = new boolean[n];

			arr = new int[n][2];

			for (int j = 0; j < n; j++) {
				String[] temp = br.readLine().split(" ");

				arr[j][0] = Integer.parseInt(temp[0]);
				arr[j][1] = Integer.parseInt(temp[1]);
			}

//			n���� ��ǥ �� n/2���� ��� ���������� ����� ���� ���� �Լ�
			combination(0, n / 2);

			System.out.println(result);
		}

	}
	
	private static void combination(int index, int count) {
		if(count == 0) {
			result = Math.min(result, getVector());
		}
		else {
			for(int i = index; i < isChecked.length; i++) {
				isChecked[i] = true;
				combination(i+1, count-1);
				isChecked[i] = false;
			}
		}
	}
	
//	���ʹ� "���� - ������" �ε�, ���͵��� ���� x,y ��ǥ�� �����̹Ƿ� "(���� ��� ���� ��) - (������ ��� ���� ��)"�� �ϸ�
//	���͵��� ������ ���� ���� �� �ִ�!
	private static double getVector()
    {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            // ����� ���õ� ���� ���
            if (isChecked[i])
            {
                x += arr[i][0];
                y += arr[i][1];
            }
            
            // ������ ���õ� ���� ���
            else
            {
                x -= arr[i][0];
                y -= arr[i][1];
            }
        }
        
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
