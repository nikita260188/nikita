package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.getProperty;

public class FileHelper {

    private final static Logger log = LogManager.getLogger("Помошник для работы с файлами");

    /**
     * Хелпер для вычитки пути к файла
     * @param filePath
     * @return null
     */

    public static List<String> linesFromFile(String filePath){
        try {
            log.info("Вычитываем файл");
            return Files.readAllLines(Paths.get(filePath));//, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            log.error(e);
            return null;
        }

    }

    /**
     * Хелпер для вычитки файла и создания Map<String, String>
     * @return Map<String, String>
     */

    public static Map<String, String> loadDataForProvider(){
        log.info("Вычитываем файл и создаем Map<String, String>");
        String path = getProperty("user.dir") + "/src/test/resources/data/negativeAuthData.txt";
        Map<String, String> result = new TreeMap<>();
        linesFromFile(path).forEach(line -> {
            String[] tempLineArray = line.split(":");
            result.put(tempLineArray[0], tempLineArray[1]);
        });
        log.info("Файл вычитан и создан Map<String, String>");
        return result;
    }

    /**
     * Хелпер для вычитки файла и создания Map<String, String>
     * @param path
     * @return Map<String, String>
     */

    public static Map<String, String> loadDataForProvider(String path){
        Map<String, String> result = new TreeMap<>();
        log.info("Вычитываем файл и создаем Map<String, String>");
        linesFromFile(path).forEach(line -> {
            String[] tempLineArray = line.split(":");
            result.put(tempLineArray[0], tempLineArray[1]);
        });
        log.info("Файл вычитан и создан Map<String, String>");
        return result;
    }

    /**
     * Хелпер для записи  файла
     * @param filePath, text
     */

    public static void writeToFile(String filePath, String text){
        List<String> textLines = Arrays.asList(text.split("\n"));
        try {
            File file = new File(filePath);
            if (!file.exists()){
                File dir = file.getParentFile();
                if(!dir.exists()){
                    dir.mkdirs();
                }
                file.createNewFile();
            }
            Files.write(Paths.get(filePath), textLines);
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Хелпер для вычитки файла и создания List<Object[]>
     * @param filePath
     * @return List<Object[]>
     */

    public static List<Object[]> linesFromFileDZ16(String filePath){
        try {
            log.info("Вычитываем файл и создаем List<Object[]>");
            List<String> params = Files.readAllLines(Paths.get(filePath));
            List<Object[]> result = new ArrayList<>();
                   params.forEach(value->{
                       String[] values = value.split(":");
                       String[] label = values[2].split(",");
                       Object[] temp = new Object[]{
                               values[0], values[1], Arrays.asList(label)
                           };
                       log.info("Файл вычитан и создан List<Object[]>");
                       result.add(temp);

                });
        return result;
        } catch (IOException e) {
            log.error(e);
            return null;
        }

    }

}
