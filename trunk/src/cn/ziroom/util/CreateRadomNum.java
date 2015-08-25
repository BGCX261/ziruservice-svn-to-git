package cn.ziroom.util;

import java.util.Random;

public class CreateRadomNum {
	
	public static Integer createNum() {
		return Math.abs(new Random().nextInt()) % 1000;
	}
}
