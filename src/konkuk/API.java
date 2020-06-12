package konkuk;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class API {
	private String kcal;
	private String carb;
	private String prot;
	private String name;
	
	public API(String user,Map map) {
		this.name = user;
		this.kcal = "��������";
		this.carb = "��������";
		this.prot = "��������";
		
		getData((String) map.get(name));
		
	}
	public String getName() {
		return name;
	}
	
	/*
	 ���� API�� �̿��� ������ �������µ� ��� �ڵ�
	 
	public void getAPI(String user) {
		String clientId = "WxpA0MWUUaPxxD2RXSoL"; // ���ø����̼� Ŭ���̾�Ʈ ���̵�"
		String clientSecret = "ixLUAOTsYC"; // ���ø����̼� Ŭ���̾�Ʈ ��ũ����"

		String text = null;
		try {
			text = URLEncoder.encode(user + "���缺��", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("�˻��� ���ڵ� ����", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/encyc.json?query=" + text; // json ���
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml ���
		// title, link, description, thumbnail
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);
			JSONArray infoArray = (JSONArray) jsonObject.get("items");

			JSONObject itemObject = (JSONObject) infoArray.get(0);
			
			getData((String) itemObject.get("description"));

		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(responseBody);
	}

	
	private String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ȣ��
				return readBody(con.getInputStream());
			} else { // ���� �߻�
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API ��û�� ���� ����", e);
		} finally {
			con.disconnect();
		}
	}

	private HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
		}
	}

	private String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
		}
	}
	
	*/
	public String getKcal() {
		return kcal;
	}
	public String getCarb() {
		return carb;
	}
	public String getProt() {
		return prot;
	}
	public void getData(String data) {
		System.out.println(data);
		StringTokenizer str = new StringTokenizer(data," :");
		ArrayList<String> temp = new ArrayList<String>();
		while(str.hasMoreTokens()) {
			temp.add(str.nextToken());
		}
		for(int i =0;i<temp.size();i++) {
			switch(temp.get(i)) {
			case "Į�θ�":
				kcal = temp.get(i+1);
				break;
			case "�ܹ���":
				prot = temp.get(i+1);
				break;
			case "ź��ȭ��":
				carb = temp.get(i+1);
				break;
			}
		}
	}
}
