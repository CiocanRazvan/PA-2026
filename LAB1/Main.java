public class Main{

    public static void main(){
        String language[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = n*3;
        String input0="10101";
        int n0 = Integer.parseInt(input0,2);
        n = n + n0;
        String input2="FF";
        int n1 = Integer.parseInt(input2,16);
        n = n+n1;
        n = n*6;
        int sum=0;
        int c=0;
        while(n>0){
            c=n%10;
            sum=sum+c;
            n=n/10;
            if(n<=0 && sum>9){
                n=sum;
                sum=0;
            }
        }
        System.out.println( "Willy-nilly, this semester I will learn " + language[sum]);
    }
}