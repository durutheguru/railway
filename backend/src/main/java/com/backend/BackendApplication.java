package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println("MyAtoi: " + Solution.myAtoi("   -042"));
		// SpringApplication.run(BackendApplication.class, args);
	}

}


class Solution {
    public static int myAtoi(String s) {
        int number = 0;
        int polarity = 1;

        char c, x;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                if (number > 0) {
                    break;
                }
                continue;
            }
            if (c == '+') {
                if (number > 0) {
                    break;
                }
                continue;
            }
            if (c == '-') {
                if (number > 0) {
                    break;
                }
                polarity = -1;
                continue;
            }

            if (c >= '0' && c <= '9') {
                number *= 10;
				number = number + (polarity * Character.getNumericValue(c));
            }
            else {
                break;
            }

            if (i < s.length() - 1) {
                x = s.charAt(i + 1);
                if (x >= '0' && x <= '9') {
                    if (number <= Integer.MIN_VALUE / 10 && x >= Integer.MIN_VALUE % 10) {
                        return Integer.MIN_VALUE;
                    }
                    if (number >= Integer.MAX_VALUE / 10 && x >= Integer.MAX_VALUE % 10) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }

        return number;
    }
}

