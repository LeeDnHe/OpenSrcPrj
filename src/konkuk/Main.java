package konkuk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();

		try {
			File csv = new File("09 칼로리.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null) {
				// -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
				String[] token = line.split(",", -1);
				String str = "";
				str += "칼로리:" + token[1] + "kcal 탄수화물:" + token[2] + "g 단백질:" + token[3] + "g";
				map.put(token[0], str);

				// CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Myframe frame = new Myframe(map);
	}

}
