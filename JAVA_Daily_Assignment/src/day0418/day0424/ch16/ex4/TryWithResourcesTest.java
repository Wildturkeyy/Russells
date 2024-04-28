package day0424.ch16.ex4;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResourcesTest {

	public static void main(String[] args) {
		
		String path = Paths.get("").toAbsolutePath().toString();
		System.out.println(path);
		
		
		//try-catch 문으로 예외 처리
		FileInputStream fis1 = null;
		
		try {
			fis1 = new FileInputStream("./src/day0424/ch16/ex4/test.txt");
			int ch = fis1.read();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				fis1.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println();
		
		//try-with-resource 사용
		try(FileInputStream fis2 = new FileInputStream("./test.txt")){
			int ch = fis2.read();
		}catch (IOException e) {
			System.out.println("IOException이 발생했습니다.");
		}
	}

}
