package day0501.ch26.ex1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToStreamTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //파일로부터 스트림 얻기
        Path path = Paths.get(FileToStreamTest.class.getResource("student.txt").toURI());
        Stream<String> fileStream = Files.lines(path, Charset.defaultCharset());
        fileStream.forEach(System.out::println);

    }
}
