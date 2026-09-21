
public class HillCipher{
 static int[][] k={{1,2,1},{2,3,2},{2,2,1}};
 static int[][] ik={{-1,0,1},{2,-1,0},{-2,2,-1}};
 static String A="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 static String enc(char a,char b,char c){ int pa=a-65,pb=b-65,pc=c-65; int x=pa*k[0][0]+pb*k[1][0]+pc*k[2][0]; int y=pa*k[0][1]+pb*k[1][1]+pc*k[2][1]; int z=pa*k[0][2]+pb*k[1][2]+pc*k[2][2]; return ""+A.charAt(x%26)+A.charAt(y%26)+A.charAt(z%26);}
 static String dec(char a,char b,char c){ int pa=a-65,pb=b-65,pc=c-65; int x=pa*ik[0][0]+pb*ik[1][0]+pc*ik[2][0]; int y=pa*ik[0][1]+pb*ik[1][1]+pc*ik[2][1]; int z=pa*ik[0][2]+pb*ik[1][2]+pc*ik[2][2]; return ""+A.charAt((x%26+26)%26)+A.charAt((y%26+26)%26)+A.charAt((z%26+26)%26);}
 public static void main(String[] args){ String m="SECURITYLABORATORY"; while(m.length()%3!=0)m+="X"; String e="",d=""; for(int i=0;i<m.length();i+=3)e+=enc(m.charAt(i),m.charAt(i+1),m.charAt(i+2)); for(int i=0;i<e.length();i+=3)d+=dec(e.charAt(i),e.charAt(i+1),e.charAt(i+2)); System.out.println(e); System.out.println(d);}
}
