package konkuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
	Map<Integer, ArrayList> data = new HashMap<Integer, ArrayList>();
	Map<String,String> map = new HashMap<String, String>();
	public Data(Map map) {
		super();
		this.map = map;
	}

	public void addData(int index, String name) {
		ArrayList temp = new ArrayList();
		if (data.get(index - 1) != null) {
			temp = data.get(index - 1);
			temp.add(new API(name,map));
			data.replace(index - 1, temp);
		} else {
			temp.add(new API(name,map));
			data.put(index - 1, temp);
		}
	}

	public ArrayList getData(int key) {
		return data.get(key);
	}

	public ArrayList getkcal() {
		ArrayList temp = new ArrayList<>();
		double kcal = 0;
		for (int i = 0; i < 7; i++) {
			kcal = 0;
			if (data.get(i) != null) {
				for (int j = 0; j < data.get(i).size(); j++) {
					if (!((API) data.get(i).get(j)).getKcal().equals("정보없음")) {
						String str = ((API) data.get(i).get(j)).getKcal();
						String tempstr = str.substring(0, str.length() - 4);
						kcal += Double.parseDouble(tempstr);
					}
				}
			}
			temp.add(kcal);
		}
		return temp;
	}

	public ArrayList getprot() {
		ArrayList temp = new ArrayList<>();
		double prot = 0;
		for (int i = 0; i < 7; i++) {
			prot = 0;
			if (data.get(i) != null) {
				for (int j = 0; j < data.get(i).size(); j++) {
					if (!((API) data.get(i).get(j)).getProt().equals("정보없음")) {
						String str = ((API) data.get(i).get(j)).getProt();
						String tempstr = str.substring(0, str.length() - 1);
						prot += Double.parseDouble(tempstr);
					}
				}
			}
			temp.add(prot);
		}
		return temp;
	}

	public ArrayList getcarb() {
		ArrayList temp = new ArrayList<>();
		double carb = 0;
		for (int i = 0; i < 7; i++) {
			carb = 0;
			if (data.get(i) != null) {
				for (int j = 0; j < data.get(i).size(); j++) {
					if (!((API) data.get(i).get(j)).getCarb().equals("정보없음")) {
						String str = ((API) data.get(i).get(j)).getCarb();
						String tempstr = str.substring(0, str.length() - 1);
						carb += Double.parseDouble(tempstr);
					}
				}
			}
			temp.add(carb);
		}
		return temp;
	}
}
