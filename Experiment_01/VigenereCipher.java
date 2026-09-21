
public class VigenereCipher{
 static String encode(String t,String k){ String r=""; t=t.toUpperCase(); for(int i=0,j=0;i<t.length();i++){ char c=t.charAt(i); if(c<'A'||c>'Z')continue; r+=(char)((c+k.charAt(j)-2*'A')%26+'A'); j=++j%k.length();} return r;}
 static String decode(String t,String k){ String r=""; t=t.toUpperCase(); for(int i=0,j=0;i<t.length();i++){ char c=t.charAt(i); if(c<'A'||c>'Z')continue; r+=(char)((c-k.charAt(j)+26)%26+'A'); j=++j%k.length();} return r;}
 public static void main(String[] a){ String k="VIGENERECIPHER",m="SecurityLaboratory"; String e=encode(m,k); System.out.println(e); System.out.println(decode(e,k));}
}
