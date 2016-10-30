package br.umc.io.factory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderFactory {
	
	public BufferedReader getBufferedReader() {
		final InputStream is = System.in;
		final InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
}
