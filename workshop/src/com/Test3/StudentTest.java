package com.Test3;

public class StudentTest {
	
	public static void main(String[] args) {
		
		Student studentArray [] = new Student[3];
		
		studentArray[0]= new Student("홍길동", 15, 170, 80);
		studentArray[1]= new Student("한사람", 13, 180, 70);
		studentArray[2]= new Student("임걱정", 16, 175, 65);
		
		 int ageSum=0;
		 int heightSum=0;
		 int weightSum=0;
		 
		 int maxAge=0;
		 int minAge=1000;
		 
		 String maxAgeName="", maxHeightName="", maxWeightName="";
		 String minAgeName="", minHeightName="", minWeightName="";
		 
		 int maxHeight=0;
		 int minHeight=1000;
		 
		 int maxWeight=0;
		 int minWeight=1000;
		
		// 배열에 있는 객체 정보를 모두 출력. 
		System.out.println("이름    나이   신장   몸무게");
		for (Student s: studentArray) {
			System.out.println(s.getName()+"   "+s.getAge()+"    "+s.getHeight()+"    "+s.getWeight());
			ageSum+=s.getAge(); // 배열안에 있는 모든 나이 더하기.
			heightSum+=s.getHeight(); // 배열안에 있는 모든 키 더하기.
			weightSum+=s.getWeight(); // 배열안에 있는 모든 몸무게 더하기.
			
			if (maxAge<s.getAge()) { // 가장 많은 나이 구하기
				maxAge=s.getAge();
				maxAgeName=s.getName(); // 나이가 가장 많은 학생 이름 구하기
			}
			if (minAge>s.getAge()) { // 가장 적은 나이 구하기
				minAge=s.getAge();
				minAgeName=s.getName(); // 나이가 가장 적은 학생 이름 구하기
			}
			if (maxHeight<s.getHeight()) { // 가장 큰 신장 구하기
				maxHeight=s.getHeight();
				maxHeightName=s.getName();// 신장이 가장 큰 학생 이름 구하기
			}
			if (minHeight>s.getHeight()) { // 가장 적은 신장 구하기
				minHeight=s.getHeight();
				minHeightName=s.getName(); // 신장이 가장 적은 학생 이름 구하기
			}
			if (maxWeight<s.getWeight()) { // 가장 많이나가는 몸무게 구하기
				maxWeight=s.getWeight();
				maxWeightName=s.getName(); // 몸무게가 가장 많이 나가는 학생 이름 구하기
			}
			if (minWeight>s.getWeight()) { // 가장 적게 나가는 몸무게 구하기
				minWeight=s.getWeight();
				minWeightName=s.getName(); // 몸무게가 가장 적게 나가는 학생 이름 구하기
			}
		}
		
		System.out.println();
		
		int lgn=studentArray.length; // 배열 길이 선언 줄이기
		
		// Student 객체들의 평균 나이 출력		
		double avgAge=(double)ageSum/lgn;
		System.out.printf("평균나이: %.3f\n",avgAge);
		
		// Student 객체들의 평균 신장 출력 
		double avgHeight=(double)heightSum/lgn;
		System.out.printf("평균나이: %.3f\n",avgHeight);
		
		// Student 객체들의 평균 몸무게 출력 
		double avgWeight=(double)weightSum/lgn;
		System.out.printf("평균나이: %.3f\n",avgWeight); 

		System.out.println();
		
		System.out.println("나이가 가장 많은 학생: "+maxAgeName);
		System.out.println("나이가 가장 적은 학생: "+minAgeName);
		System.out.println("신장이 가장 큰 학생: "+maxHeightName);
		System.out.println("신장이 가장 작은 학생: "+minHeightName);
		System.out.println("몸무게가 가장 많이 나가는 학생: "+maxWeightName);
		System.out.println("몸무게가 가장 적게 나가는 학생: "+minWeightName);
	}
}
