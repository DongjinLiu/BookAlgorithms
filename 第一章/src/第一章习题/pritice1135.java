package 第一章习题;

import java.util.Random;

public class pritice1135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int SIDES=6;
		double[] dist=new double[SIDES*2+1];
		double[] test=new double[SIDES*2+1];
		for(int i=1;i<=SIDES;i++) {
			for(int j=1;j<=SIDES;j++) {
				dist[i+j]+=1.0;
			}
		}
		
		for(int k=2;k<=SIDES*2;k++) {
			dist[k]/=36;
		}
		
		Random r=new Random();
		int a,b;
		int numberOfTest=1000000;
		for(int i=0;i<numberOfTest;i++) {
			a=r.nextInt(6)+1;
			b=r.nextInt(6)+1;
			test[a+b]+=1;
		}
		System.out.println("理论值\t\t\t实验值");
		for(int i=2;i<test.length;i++) {
			test[i]/=numberOfTest;
			System.out.println(dist[i]+"\t"+test[i]);
		}
	}

}
