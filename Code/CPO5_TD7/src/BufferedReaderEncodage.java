
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;

public class BufferedReaderEncodage extends BufferedReader{
    
    File current;
    Charset in, out;
    
    public BufferedReaderEncodage(File f, Charset in, Charset out){
        current = f;
        this.in = in;
        this.out = out;
    }
    
    public String readLine() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(current));
            return new String((in.readLine()).getBytes(this.in), this.out);
    }
    
    public byte[] readLineTwo() throws IOException{
        String str = readLine();
        str = Convertisseur.reencode(str, Charset.defaultCharset(), in);
        return (str.getBytes(out));        
    }
    
    /*Exercice 5*/
    public void reencodeUTF8(File f){
        File ancienRep = f.getParentFile();
        File nouveauRep = new File(ancienRep, "utf8");
        nouveauRep.mkdir();
        File nouveauFic = new File(nouveauRep, f.getName()+"_utf8");
        nouveauFic.createNewFile();
        
        BufferedReader reader = new BufferedReader(new Reader(f));
        
        OutputStreamWriter writer = new FileOutputStream(nouveauFic, Charset.forName("UTF8"));
        
        while (reader.isReady()){
            String str = reader.readLine();
            writer.write(nouveauFic);
            writer.write('\n');
        }
    }
}
