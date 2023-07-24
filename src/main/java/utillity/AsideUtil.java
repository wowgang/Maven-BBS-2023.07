package utillity;

import java.io.BufferedReader;
import java.io.FileReader;

public class AsideUtil {
	public String getTodayQuote(String filename) {
		String result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename), 1024); // BufferedReader로 readline함
			int index = (int) Math.floor(Math.random() * 100); // 한줄 단위로 100을곱해서 0-99까지 해당한 인덱스 읽기
			for (int i=0; i<=index; i++) // 처음부터 인덱스까지 읽고
				result = br.readLine();	// result에 overwrite하기 랜덤넘버로 지정한 값이 읽혀지는것임
			br.close();
		} catch (Exception e) {	// throw하면 미룬거라 userController에서 exception이 또 떠서 여기서 try catch한것임
			e.printStackTrace();
		}
		return result;
	}
}
