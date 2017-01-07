import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by david on 1/6/2017.
 */
public class SimpleFileReadAndWrite {

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        try (BufferedReader buffer = Files.newBufferedReader(path)) {
            String read;
            while ((read = buffer.readLine()) != null) {
                System.out.println(read); //readLine() cannot be called twice in a loop
                                          //or it will skip every other line
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
