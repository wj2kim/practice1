package constant;

public class ConstantDemo {
	
	public static int[]concat(int[]a,int[]b){
		ㅑ
	}
	
	public static void main(String[] args) {
		
//		if (Fruit.APPLE == Company.APPLE) {
//			System.out.println("과일 애플과 회사 애플이 같다.");
//		}
		
//		Fruit type=Fruit.APPLE;
//		switch(type) {
//			case APPLE:
//				System.out.println(57+" Kcal, "+Fruit.APPLE.getColor());
//				break;
//			case PEACH:
//				System.out.println(34+" Kcal, "+Fruit.PEACH.getColor());
//				break;
//			case BANANA:
//				System.out.println(93+" Kcal, "+Fruit.BANANA.getColor());
//				break;
		
		
		for(Fruit f:Fruit.values()) {
			System.out.println(f+", "+f.getColor());
		}
	}

}
