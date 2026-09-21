
import java.util.*; import java.security.*; import javax.crypto.*; import javax.crypto.spec.SecretKeySpec;
public class AES{ static SecretKeySpec sk; static void setKey(String k)throws Exception{ byte[] b=k.getBytes("UTF-8"); MessageDigest sha=MessageDigest.getInstance("SHA-1"); b=Arrays.copyOf(sha.digest(b),16); sk=new SecretKeySpec(b,"AES");}
 static String encrypt(String s,String sec)throws Exception{ setKey(sec); Cipher c=Cipher.getInstance("AES/ECB/PKCS5Padding"); c.init(Cipher.ENCRYPT_MODE,sk); return Base64.getEncoder().encodeToString(c.doFinal(s.getBytes("UTF-8"))); }
 static String decrypt(String s,String sec)throws Exception{ setKey(sec); Cipher c=Cipher.getInstance("AES/ECB/PKCS5Padding"); c.init(Cipher.DECRYPT_MODE,sk); return new String(c.doFinal(Base64.getDecoder().decode(s))); }
 public static void main(String[] a)throws Exception{ String sec="annaUniversity",url="www.annauniv.edu"; String e=encrypt(url,sec); System.out.println(e); System.out.println(decrypt(e,sec)); }}
