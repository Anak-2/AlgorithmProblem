package silver;

import java.util.*;
import java.io.*;

class No2108{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // ����
        Arrays.sort(arr);
        // ������
        double mean = 0;
        // �߾Ӱ�
        int middleVal = arr[N/2];
        // �ֺ�
        HashMap<Integer, Integer> map = new HashMap<>();
//        �ֺ� ���� ������ �����ϴ� ��
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        int frequentCnt = 0;
        // �⿬ Ƚ��
        Integer cnt = 0;
        // ����
        int maxMinDiff = arr[N-1] - arr[0];
        for(int i = 0; i < N; i++){
            mean += arr[i];
            cnt = map.get(arr[i]);
            if(cnt != null){
                map.put(arr[i], cnt+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int maxCnt = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
        	if(maxCnt < e.getValue()) {
        		maxCnt = e.getValue();
        		pq.clear();
        		pq.add(e.getKey());
        	}else if(maxCnt == e.getValue()) {
        		pq.add(e.getKey());
        	}
        }
        mean = mean/N;
        if(mean < 0) {   	
        	System.out.println((int)Math.round(Math.abs(mean)) * -1);
        }else {
        	System.out.println((int)Math.round(mean));        	
        }
        System.out.println(middleVal);
        if(pq.size() == 1) {
        	System.out.println(pq.poll());
        }else {
        	pq.poll();
        	System.out.println(pq.poll());
        }
        System.out.println(maxMinDiff);
    }
}
