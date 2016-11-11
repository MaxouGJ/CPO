import java.nio.charset.Charset;

public class Convertisseur {
 
    public static String reencode(String s, Charset in, Charset out){
        return new String(s.getBytes(in), out);
    }       
}
