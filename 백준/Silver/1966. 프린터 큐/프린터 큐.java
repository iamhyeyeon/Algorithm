import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(br.readLine());

        for (int i=0; i<n; i++) {
            queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            //우선순위 입력
            for (int j=0; j<N; j++) queue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            if (N==1) {
                sb.append(1).append("\n");
            } else {
                sb.append(result(M)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int result(int m) {

        int findIt = 0; //M이 몇번째로 인쇄되었는지 저장하는 변수

        while(!queue.isEmpty()){ //큐가 비어있을 때까지 반복한다.

            int[] first = queue.poll(); //큐의 맨 앞 요소를 뺀다.
            boolean isMax = true; //해당 요소가 가장 큰지 유효성 검사하는 변수

            //큐에 남아있는 모든 요소들과 반복문을 돌력중요도를 비교한다.
            for(int i = 0; i < queue.size(); i++){

                //지금 뽑은 요소보다 큰 요소다 있을 경우
                if(first[1] < queue.get(i)[1]){

                    queue.offer(first); //뽑은 해당 요소를 맨 뒤에 넣고

                    //반복하면서 마주한 뽑은 요소(first)보다 안 큰 요소들 또한 맨뒤에 넣는다.
                    for(int j = 0; j < i; j++){
                        //queue의 i번째에 first(뽑은 요소)보다 큰 게 있는 것이므로
                        // i까지만 반복한다.
                        queue.offer(queue.poll());
                    }

                    isMax = false; // 해당 뽑은 요소(first)보다 큰 요소가 있다는 뜻이므로 first를 한다.
                    break; // 걸러졌으므로 반복문을 나온다.
                }
            }

            if(!isMax){ //뽑은 요소보다 큰 요소가 있어서 걸러졌다면 다시 반복문을 돌아야한다.(밑은 수행X)
                continue;
            }

            //first가 가장 큰 요소인 거니까
            findIt++; //1씩 증가한다.(큰 요소를 하나씩 누적 개수 더하기 해서)

            if(first[0] == m){ //찾는 요소일 경우 반복문을 빠져나가서
                break;
            }
        }

        return findIt;
    }
}