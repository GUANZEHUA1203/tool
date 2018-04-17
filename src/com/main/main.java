package com.main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.baidu.speech.TtsMain;
import com.common.DemoException;
import com.tulingreboot.rebootTest;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class main {
	public static void main(String[] args) throws IOException, DemoException, JavaLayerException {
		while(true) {
		String result = rebootTest.getResult("讲个段子");
		TtsMain ts = new TtsMain();
		ts.run(result);
		String path = System.getProperty("user.home");
		
	    new Player(new BufferedInputStream(new FileInputStream(new File("C:\\Users\\11232\\git\\tool\\result.mp3")))).play();
		}
	}

}
