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
			File csv = new File("09 Į�θ�.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null) {
				// -1 �ɼ��� ������ "," ���� �� ���鵵 �б� ���� �ɼ�
				String[] token = line.split(",", -1);
				String str = "";
				str += "Į�θ�:" + token[1] + "kcal ź��ȭ��:" + token[2] + "g �ܹ���:" + token[3] + "g";
				map.put(token[0], str);

				// CSV���� �о� �迭�� �ű� �ڷ� Ȯ���ϱ� ���� ���
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
