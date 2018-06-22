package week3.graphs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithFiles {
    public static String readFile(String path){
        String text = null;
        String absolutePath = System.getProperty("user.dir")+"\\";
        try{
            text = new String(Files.readAllBytes(
                    Paths.get(absolutePath+path)), StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }
}
