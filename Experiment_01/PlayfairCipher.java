
import java.awt.Point;
public class PlayfairCipher{
 static char[][] table; static Point[] pos;
 static String prep(String s, boolean j){ s=s.toUpperCase().replaceAll("[^A-Z]",""); return j? s.replace("J","I"):s.replace("Q","");}
 static void create(String key, boolean j){
   table=new char[5][5]; pos=new Point[26];
   String s=prep(key+"ABCDEFGHIJKLMNOPQRSTUVWXYZ",j); int k=0;
   for(int i=0;i<s.length();i++){ char c=s.charAt(i); if(pos[c-'A']==null){ table[k/5][k%5]=c; pos[c-'A']=new Point(k%5,k/5); k++;}}
 }
 static String codec(StringBuilder t,int d){ for(int i=0;i<t.length();i+=2){ char a=t.charAt(i),b=t.charAt(i+1); int r1=pos[a-'A'].y,r2=pos[b-'A'].y,c1=pos[a-'A'].x,c2=pos[b-'A'].x; if(r1==r2){ c1=(c1+d)%5; c2=(c2+d)%5;} else if(c1==c2){ r1=(r1+d)%5; r2=(r2+d)%5;} else {int tmp=c1;c1=c2;c2=tmp;} t.setCharAt(i,table[r1][c1]); t.setCharAt(i+1,table[r2][c2]); } return t.toString();}
 static String encode(String s){ StringBuilder sb=new StringBuilder(s); for(int i=0;i<sb.length();i+=2){ if(i==sb.length()-1) sb.append('X'); else if(sb.charAt(i)==sb.charAt(i+1)) sb.insert(i+1,'X');} return codec(sb,1);}
 static String decode(String s){ return codec(new StringBuilder(s),4);}
 public static void main(String[] args){ create("CSE",true); String txt="Security Lab"; String enc=encode(prep(txt,true)); System.out.println(enc); System.out.println(decode(enc));}
}
