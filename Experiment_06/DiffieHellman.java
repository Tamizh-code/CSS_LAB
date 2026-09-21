
public class DiffieHellman{ public static void main(String[] a){ int p=23,g=5,x=4,y=3; double A=Math.pow(g,x)%p,B=Math.pow(g,y)%p; double ac=Math.pow(B,x)%p,bc=Math.pow(A,y)%p; System.out.println("Shared:"+ac+" "+bc); }}
