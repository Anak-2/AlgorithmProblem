package gold;

import java.util.*;
import java.io.*;

// �ù�
public class No8980 {
    class Stuff implements Comparable<Stuff>{
        int weight;
        int arrive;
        Stuff(int arrive, int weight){
            this.arrive = arrive;
            this.weight = weight;
        }
        @Override
        public int compareTo(Stuff s){
            if(this.arrive < s.arrive){
                return 1;
            }else{
                return -1;
            }
        }
    }
    
    public static TreeMap<Integer, Integer> truck = new TreeMap<>();
    
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int villeageNum = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] info = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(info, (int[] a, int[] b) -> a[0] - b[0]);
        int answer = 0;
        int totalWeight = 0;
        int nextVilleage = 2;
        for(int i = 0; i < n; i++){
            Map.Entry<Integer, Integer> entry;
            // �� �������
            while(nextVilleage <= info[i][0]){
//            	System.out.println(nextVilleage+"���� �� ������");
                while(!truck.isEmpty()){
                    entry = truck.firstEntry();
                    if(entry.getKey() == nextVilleage){
                        entry = truck.pollFirstEntry();
//                        System.out.print("arrive: "+entry.getKey());
//                        System.out.println(" weight: "+entry.getValue());
                        answer += entry.getValue();
                        totalWeight -= entry.getValue();
                    }else{
                        break;
                    }
                }
                nextVilleage++;
            }
            // �� �Ʊ�
            // Ʈ���� ������� ��
            if(truck.isEmpty()){
                if(info[i][2] > maxWeight){
                    truck.put(info[i][1], maxWeight);
                    totalWeight = maxWeight;
                }else{
                    truck.put(info[i][1], info[i][2]);
                    totalWeight = info[i][2];
                }
            // Ʈ�� �� ������� ��
            }else{
            //   Ʈ���� ������ �������� �ù谡 ���� ����
                if(truck.containsKey(info[i][1])){
                    truck.replace(info[i][1], truck.get(info[i][1])+info[i][2]);
                    totalWeight += info[i][2];
                    // Ʈ���� ������ �������� ���� ����
                }else{
                    truck.put(info[i][1], info[i][2]);
                    totalWeight += info[i][2];
                }
            }
			// Ʈ���� ���� �ѵ��� ���� ���� ��������
			while (totalWeight > maxWeight) {
				entry = truck.lastEntry();
//				System.out.println(info[i][0]+"���� �� ������");
//				System.out.println("���� �ʰ�: "+(totalWeight-maxWeight));
//				 System.out.print("arrive: "+entry.getKey());
//                 System.out.println(" weight: "+entry.getValue());
				// ���� �ѵ����� �� �ָ� ����ϴ� �ù��� ���԰� �� Ŭ ��
				if (totalWeight - entry.getValue() >= maxWeight) {
					truck.pollLastEntry();
					totalWeight -= entry.getValue();
				} else {
					if (entry.getValue() - (totalWeight - maxWeight) > 0) {
						truck.replace(entry.getKey(), entry.getValue() - (totalWeight - maxWeight));
					} else {
						truck.pollLastEntry();
					}
					totalWeight = maxWeight;
				}
			}
        }
        System.out.println(answer+totalWeight);
    }
    
}