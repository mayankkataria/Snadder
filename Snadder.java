import java.util.*;
class Players{
	String name = new String();
	int pos,m,n;
	int dice,temp;
	Random r1 = new Random();
	void input(){
			dice=r1.nextInt(6);
			dice+=1;
			System.out.println("Dice rolls : "+dice);
	}
	void calculate(){
		temp=pos;
		pos+=dice;
		if(pos>100){
			pos=temp;
			System.out.println(name + " still at : "+pos);
		}
		else{
			System.out.println(name + " moved to : "+pos);
		}
		m=pos;
		if(m == 40 || m == 50 || m == 81 || m == 95 || m == 4 || m == 10 || m == 14 || m == 74){
			if(m == 40)
				n=20;
			else if(m == 50)
				n=16;
			else if(m == 81)
				n=78;
			else if(m == 95)
				n=56;
			else if(m == 4)
				n=22;
			else if(m == 10)
				n=29;
			else if(m == 14)
				n=77;
			else if(m == 74)
				n=90;
			if(m>n){
				System.out.println("OOPS! Snake bites at " + m + " , " + name + " fell  to " +n);
				pos=n;
			}
			else{
				System.out.println("BINGO! Ladder found at " + m + " , " + name + " jumped to " +n);
				pos=n;
			}
		}
	}
}
class Snadder{
	void display(){
		System.out.println("\n\n      Snake\t\t      Ladder");
		System.out.println("Bites At    Fall To\tFound At  Jump To");
		System.out.println("   40         20   \t   4         22");
		System.out.println("   50         16   \t   10        29");
		System.out.println("   81         78   \t   14        77");
		System.out.println("   95         36   \t   74        90\n\n");
	}
	public static void main(String args[]){
		int i=0,nop;
		char key;
		Scanner s1 = new Scanner(System.in);
		System.out.print("Enter no. of players:");
		nop=s1.nextInt();
		Players p[] = new Players[nop];
		for(i=0;i<nop;i++){
			p[i]=new Players();   //Memory should be allocated just once or else data members of class Students will be reinitialised to 0
			System.out.print("Enter name of Player " + (i+1) + " : ");
			p[i].name=s1.next();
		}
		do{
			if(i==nop)
				i=0;
			Snadder s = new Snadder();
			s.display();
			System.out.println("Positions:");
			for(int j=0;j<nop;j++){
				System.out.println(p[j].name+" : "+ p[j].pos);
			}			
			System.out.println("\n\n" + p[i].name + "'s chance:");
			System.out.println("Roll the dice!\n\n\n\n\n\n\n\n\n");
			key=s1.next().charAt(0); //To accept char value
			if(key=='\n')
				continue;
			System.out.println("\n");
			p[i].input();
			p[i].calculate();
			i++;
		}
		while(p[i-1].pos!=100);
		System.out.println("\n\n" + p[i-1].name + " won the game!!!");
	}
}