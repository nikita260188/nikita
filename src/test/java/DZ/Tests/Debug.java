package DZ.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.*;

import static helpers.FileHelper.linesFromFile;
import static java.lang.System.getProperty;

public class Debug {

    private final static Logger log = LogManager.getLogger("Тест по работе с файлами");

    @Test
    public void sdf(){
        List<List<String>> result = new ArrayList<>();
        linesFromFile(getProperty ("user.dir") + "/src/test/resources/data/input/NewIssue3Values.txt")
                .forEach(line->{
                        List<String> tempLine = new ArrayList<>(Arrays.asList(line.split (":")));

        result.add(tempLine);

                });
System.out.println(result);

}

}

