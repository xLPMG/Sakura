package me.lpmg.sakura.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataHandler {

	private Map<String, String> dataMap = new HashMap<>();
	private String dataFolder = System.getenv("LOCALAPPDATA");
	
	public void save() {
		File dir = new File(dataFolder+"/Sakura");
		if (!dir.exists()){
			dir.mkdirs();
		}
		
		File dataFile = new File(dir+"/data.dat");
		if(!dataFile.exists()) {try {
			dataFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}}
		
		try {
			FileWriter writer = new FileWriter(dataFile.getAbsolutePath());
			writer.write("");
			dataMap.remove("placeholder");
			for (Entry<String, String> entry : dataMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				writer.write(key + ":" + value + "|");
			}
			writer.write("placeholderkey:placeholderValue");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done saving data.");
		load();
	}
	
	public void load() {
		dataMap.clear();
		File dir = new File(dataFolder+"/Sakura");
		if (!dir.exists()){
			dir.mkdirs();
		}
		
		File dataFile = new File(dir+"/data.dat");
		if(dataFile.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(dataFile.getAbsolutePath()));
				String line;
				while ((line = br.readLine()) != null) {
					if (!line.isEmpty()) {
						String data[] = line.split("[|]");
						for (String singleData : data) {
							String singleInfo[] = singleData.split(":");
							dataMap.put(singleInfo[0], singleInfo[1]);
						}
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Map<String, String> getData() {
		return dataMap;
	}

	public void setData(Map<String, String> data) {
		this.dataMap = data;
	}
}
