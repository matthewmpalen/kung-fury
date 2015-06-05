import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class KungFury {
    private static String readFile(String path, Charset encoding) 
        throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public static void main(String[] args) {
        String energyConverterText = null;
        try {
            energyConverterText = 
                readFile("script.txt", StandardCharsets.UTF_8);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.exit(-1);
        }
        
        
        for (int i = 0; i < 2; i++) {
            for (char c : energyConverterText.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        int count = 0;
        SecureRandom random = new SecureRandom();
        
        while (true) {
            String s = new BigInteger(130, random).toString(32);
            for (char c : s.toCharArray()) {
                System.out.print(c);
                if (count % 80 == 0) {
                    System.out.println();
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
            }
        }
    }
}
