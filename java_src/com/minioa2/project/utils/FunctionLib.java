package com.minioa2.project.utils;

import java.util.regex.Pattern;

public class FunctionLib {
	public static boolean isNum(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str).matches();
	}
}
