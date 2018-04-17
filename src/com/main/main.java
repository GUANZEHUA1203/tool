package com.main;

import java.io.IOException;

import com.baidu.speech.TtsMain;
import com.common.DemoException;
import com.tulingreboot.rebootTest;

public class main {
	public static void main(String[] args) throws IOException, DemoException {
		String result = rebootTest.getResult("你好");
		TtsMain ts = new TtsMain();
		ts.run(result);
	}

}
