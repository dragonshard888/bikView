package com.centrabank.bik.server.service;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для распарсивания данных из .DBF  в удобный формат
 */
@Service
public class ParserForDBF {

	public static Map<Integer, Map<String, Object>> parseDBF( String resourceLocation) {

		Map<Integer, Map<String, Object>> tempMap = new HashMap<Integer, Map<String, Object>>();
		try {
			//"src/main/resources/dbf/BNKSEEK.DBF"
			InputStream inputStream  = new FileInputStream( ResourceUtils.getFile(resourceLocation));
			DBFReader reader = new DBFReader( inputStream);
			//установка кодировки бд
			reader.setCharactersetName("CP866");

			int numberOfFields = reader.getFieldCount();

			String[] keys = new String[numberOfFields];
			for( int i=0; i<numberOfFields; i++) {
				keys[i] = reader.getField(i).getName();
			}

			Object[] rowObjects;
			//счетчик для строк
			int j = 0;
			while((rowObjects = reader.nextRecord()) !=null ){
				for(int i = 0; i < rowObjects.length; i++){
					Map<String, Object> temp = new HashMap<String, Object>();

					for(int k = 0; k < keys.length; k++){
						temp.put(keys[k], rowObjects[i++]);
					}
					tempMap.put(j++, temp);
					i+= keys.length;

				}
			}

			inputStream.close();
		}
		catch( DBFException e) {

			System.out.println( e.getMessage());
		}
		catch( IOException e) {

			System.out.println( e.getMessage());
		}
		return tempMap;
	}
}

