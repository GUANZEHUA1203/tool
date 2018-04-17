package com.tulingreboot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 */

/**
 * @author zehua
 *
 */
//图灵机器人测试
public class rebootTest {
	public static String getResult(String msg) throws IOException{
		try {
			
			String keys[]={"64f6c01591294327960fbedfc2a83f17","4dfd2816872b4607af2f3834f1ad0f21","da4ebfd925cf4b98b21630eec91a5eff","716e2562950a4da19b8079889a97b530"};
			int i=new Random().nextInt(4);
			String key=Arrays.asList(keys).get(i);
			String APIKEY=URLEncoder.encode(key, "UTF-8");
			URL url = new URL("http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + msg);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 	
			 connection.connect();
			InputStream  inputStream = connection.getInputStream();
			InputStreamReader isr=new InputStreamReader(inputStream, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			StringBuffer sb=new StringBuffer();
			String line="";
			while ((line=br.readLine())!=null) {
				sb.append(line);
			}
			JSONObject parseObject = JSONObject.parseObject(sb.toString());
			System.out.println(parseObject);
			return parseObject.getString("text");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		List<String> question=new ArrayList<String>();
		while (true) {
			String result = getResult("你好,你叫什么名字？");
			System.out.println(result);
		}
		
	}

}
