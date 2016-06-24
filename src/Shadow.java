/////////////////////////////////////////////////////////
// SDS SW Certificate
// Problem : 그림자 (Professional)
// Author  : SW Competency Development TF
// Copyright(c) 2016 Samsung SDS Co. ltd.
// All rights reserved. / Confidential
// 본 문서를 SDS 직원이 아닌 외부인에게 공유하거나
// 외부 사이트 등 공중에 게시하는 행위를 절대 금합니다.
/////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

// SWCERT SHADOW : 그림자

public class Shadow {
	
	static final int MAX_N = 1003;
	static int N;
	static int[] X = new int[MAX_N];
	static int[] Y = new int[MAX_N];
	static int[] Answer = new int[MAX_N];
	static Line[] lines = new Line[MAX_N * (MAX_N - 1) / 2];
	
	public static int gcd(int a, int b) {
		
		if (b == 0) return a;
		return gcd(b, a % b);
		
	}
	
	public static void main(String args[]) throws Exception {
		long startTime = System.currentTimeMillis();
		//System.setIn(new FileInputStream(Shadow.class.getResource("").getPath() + "eval_input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		FileReader fr = new FileReader("eval_input.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		int T = Integer.parseInt(br.readLine());		// 테스트 케이스 수
		String[] split;
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			for(int i=0;i<N;i++){
				split = br.readLine().split(" ");
				X[i] = Integer.parseInt((split[0]));
				Y[i] = Integer.parseInt((split[1]));
			}
			
			int idx = 0, dx, dy, g;
			for(int i=0; i<N; i++){
				for(int j=i+1; j<N; j++){
					// X, Y 좌표차이 구하기
					dx = X[i] - X[j];
					dy = Y[i] - Y[j];
					
					// 기울기의 부호를 통일하기 위한 처리
					if(dx < 0) {
						dx *= -1;
						dy *= -1;
					}
					
					// 수평, 수직에 대한 기울기
					// x축 또는 y축에 대해 평행인 직선의 경우 임의의 값으로 dx, dy를 설정
					if(dx==0) dy = 1;		// 임의의 값
					else if(dy==0) dx = 1;	// 임의의 값
					else { // 기울기 비교를 위한 GCD로 약분
						g = gcd(dx, dy); // GCD는 유클리드 호제법 활용
						dx /= g;
						dy /= g;
					}					
					lines[idx++] = new Line(dx, dy, i);
				}
			}
			
			// 기울기와 index 별로 정렬
			Arrays.sort(lines, 0, idx, new Comparator<Line>() {
				@Override
				public int compare(Line o1, Line o2) {
					if(o1.dx==o2.dx) {
						if(o1.dy==o2.dy) {
							return o1.from - o2.from;
						} else {
							return o1.dy - o2.dy;
						}
					} else {
						return o1.dx- o2.dx;
					}
				}
			});
			
			for(int i=1; i<=N-1; i++) Answer[i] = 0;
			
			int match = 1;		// 동일 직선에 의해 가려지는 점의 개수
			for(int i=0; i<idx-1; i++){
				if(lines[i].dx==lines[i+1].dx && lines[i].dy==lines[i+1].dy){		// 기울기가 같은 경우
					if(lines[i].from==lines[i+1].from) continue;	// 동일 직선인 경우
					match++;
				}else{
					Answer[N - match] += 2;
					match = 1;
				}
			}
			Answer[N - match] += 2;
			
			System.out.print("#" + test_case);
			for(int i=1; i<=N-1; i++){
				System.out.print(" " + Answer[i]);
			}
			System.out.println();
		}
		
		System.out.println("\nElapsed Time : " + ((double)(System.currentTimeMillis() - startTime)/1000));
	}
	
	// 각 점간의 기울기를 판단하기 위한 클래스 선언
	public static class Line {
		public int dx, dy; 	// X, Y좌표 차이
		public int from;   	// 동일한 선상에 있는 점들을 판단하기 위한 index
		
		Line(int dx, int dy, int from){
			this.dx = dx;
			this.dy = dy;
			this.from = from;
		}
	}
}