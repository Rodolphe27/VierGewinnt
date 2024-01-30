import java.util.Scanner;

public class VierGewinnt {

	public static void main(String[] args) {
		int f=0;
		Spielfeld sp = new Spielfeld(6,7);
		Scanner sc = new Scanner(System.in);
		
		Spieler a = new Spieler("Donald",1);
		Spieler b = new Spieler("Mickey",2);
		
		System.out.println("VIER-GEWINNT ");
		System.out.println("------------");
		do { 
			//System.out.print("continue play: 1-yes 2-no:");
			//int n=sc.nextInt();
			//if(n==1) {
				System.out.println();
				sp.output();
				System.out.println();
				System.out.println("Spieler 1:"+a.getName());
				System.out.print("spalte:");
				f=sc.nextInt();
				if(sp.setzeStein(1,f)) {
					if(sp.testeSieg(1)) {
						System.out.println();
						sp.output();
						System.out.println();
						System.out.println(a.getName()+" Won:");
						break;
					}
				}
				System.out.println();
				sp.output();
				System.out.println();
				System.out.println("Spieler 2:"+b.getName());
				System.out.print("spalte:");
				f=sc.nextInt();
				if(sp.setzeStein(2,f)) {
					if(sp.testeSieg(2)) {
						System.out.println();
						sp.output();
						System.out.println();
						System.out.println(b.getName()+" Won: ");
						break;
					}
				}
				

				
				
			//}
			//else {
			//	break;
			//}
		}while(true);
		

	}

}
