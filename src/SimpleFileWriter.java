import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by david on 1/6/2017.
 */
public class SimpleFileWriter {

    public static void main(String[] args) throws IOException {
        FileWriter newFile = null;
        try {
            newFile = new FileWriter("out.txt");
            newFile.append("c");
        } catch (IOException e) {
            System.out.println("caught IOException " + e.getMessage());
        } finally {
            if (newFile != null) {
                newFile.close();
            } else {
                System.out.println("file never opened");
            }

        }


    }
}
