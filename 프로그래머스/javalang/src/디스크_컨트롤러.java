import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
    // 문제 아이디어: 시작 시간이 빠르고, 작업 시간이 짧은 것 부터 처리해서 더하기
    static class Solution {
        public static int solution(int[][] jobs) {
            int answer = 0;
            // 작업 시간이 빠른 순으로 정렬
            Queue<int[]> controller = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            // 시작 시간이 빠른 순으로 정렬
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            // 현재 작업 대상
            int idx = 0;
            // 현재 작업하는 시간
            int time = jobs[0][0];

            while (idx < jobs.length || !controller.isEmpty()) {
                // 실행 가능한 작업들 controller 에 추가
                while (idx < jobs.length && jobs[idx][0] <= time) {
                    // controller 는 우선순위 큐 이므로 작업 시간이 짧은 순으로 정렬되어 저장된다
                    controller.add(jobs[idx]);
                    idx++;
                }

                // 실행 가능한 작업이 없다면 다음 작업의 시작 시간을 저장하고 controller에 추가
                if (controller.isEmpty()) {
                    time = jobs[idx][0];
                    controller.add(jobs[idx++]);
                }

                // 작업 시간만큼 time에 더하고, (소요 시간) = (종료 시간) - (시작 시간) 만큼 정답에 더하기
                int[] work = controller.poll();
                time += work[1];
                answer += time - work[0];
            }
            return answer / jobs.length;
        }
    }
}
