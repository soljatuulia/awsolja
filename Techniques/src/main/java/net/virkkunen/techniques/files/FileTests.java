
package net.virkkunen.techniques.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Solja
 */
public class FileTests {
    
    public static void createFile() {
        try (PrintWriter writer = new PrintWriter("C:\\javatraining\\awsolja\\file3.txt")) {
            writer.println("Tokaan tiedostoon lisätty tekstiä.");
            writer.println("Tokassa tiedostossa vielä lisää tekstiä!");
            writer.flush(); // Muista lisätä!
            writer.close();
        } catch (IOException ex) {
            System.out.println("Virhe " + ex.getMessage());
        }
        
        try (FileWriter fwriter = new FileWriter("C:\\javatraining\\awsolja\\file4.txt")) {
            fwriter.write("Nelostiedostoon lisätty tekstiä.");
            fwriter.write("Nelostiedostoon lisäääää.");
            fwriter.write("Nelostiedostoon lisää lisää lisää.");
            fwriter.flush();
            System.out.println("Nelostiedosto luotu.");
        } catch (IOException ex) {
            System.out.println("Virhe");
        }

        try {File firstFile = new File("file1.txt");
        if (firstFile.createNewFile()) {
            System.out.println("Tiedosto luotu: " + firstFile.getName());
        } else {
            System.out.println("Tiedosto on jo olemassa.");
        }
        } catch (IOException ex) {
            System.out.println("Virhe.");
        }
    }
    
    public static void writeToFile() {
        try { FileWriter myWriter = new FileWriter("file1.txt");
        myWriter.write("Tämä teksti on ekassa tiedostossa.");
        myWriter.close();
        System.out.println("Ekaan tiedostoon lisätty tekstiä.");
        } catch (IOException e) {
        System.out.println("Virhe lisäämisessä");
        }
    }
    
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\javatraining\\awsolja\\file3.txt"))) {
            while (true) {
                String s = reader.readLine();
                if (s == null) break;
                System.out.println("Rivi: " + s);
            }
        } catch (IOException e) {
            System.out.println("Virhe lukemisessa");
        }
        
        // nio-paketti suositeltava tiedostokäsittelyyn
        Path path = Paths.get("C:\\javatraining\\awsolja\\file4.txt");
        try { Files.lines(path).forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
