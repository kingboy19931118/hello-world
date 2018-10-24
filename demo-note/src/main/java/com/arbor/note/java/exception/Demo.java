package com.arbor.note.java.exception;

import java.io.IOException;

public class Demo {
	public static void main(String[] args) {
		try {
			testNPE();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.print("finally");
		}
	}
	
	public static void testNPE() throws IOException {
		String s = null;
		s.toString();
	}
}