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
		this.kcal = "정보없음";
		this.carb = "정보없음";
		this.prot = "정보없음";
		
		getData((String) map.get(name));
		
	}
	public String getName() {
		return name;
	}
	
	/*
	 원래 API를 이용해 정보를 가져오는데 썼던 코드
	 
	public void getAPI(String user) {
		String clientId = "WxpA0MWUUaPxxD2RXSoL"; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = "ixLUAOTsYC"; // 애플리케이션 클라이언트 시크릿값"

		String text = null;
		try {
			text = URLEncoder.encode(user + "영양성분", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/encyc.json?query=" + text; // json 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml 결과
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
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
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
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
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
			case "칼로리":
				kcal = temp.get(i+1);
				break;
			case "단백질":
				prot = temp.get(i+1);
				break;
			case "탄수화물":
				carb = temp.get(i+1);
				break;
			}
		}
	}
}
