
public class CaesarCipher {
    public static String encode(String enc, int offset){
        offset = offset % 26 + 26;
        StringBuilder out = new StringBuilder();
        for(char c: enc.toCharArray()){
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c))
                    out.append((char)('A'+(c-'A'+offset)%26));
                else
                    out.append((char)('a'+(c-'a'+offset)%26));
            } else out.append(c);
        }
        return out.toString();
    }
    public static String decode(String enc,int offset){ return encode(enc,26-offset);}
    public static void main(String[] args){
        String msg="Anna University";
        System.out.println("Input: "+msg);
        String e=encode(msg,3);
        System.out.println("Encrypted: "+e);
        System.out.println("Decrypted: "+decode(e,3));
    }
}
