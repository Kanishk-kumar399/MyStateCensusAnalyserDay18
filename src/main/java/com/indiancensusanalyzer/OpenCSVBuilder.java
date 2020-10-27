package com.indiancensusanalyzer;

import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVBuilder implements ICSVBuilder
{
	public<T> Iterator<T> getIteratorCSV(Reader reader, Class<T> CSVclass) throws CSVBuilderException
	{
		try {
			CsvToBeanBuilder<T> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVclass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<T> csvToBean = csvToBeanBuilder.build();
			Iterator<T> censusCSVIterator=csvToBean.iterator();
			return censusCSVIterator;
		}
		catch (RuntimeException e) 
		{
			if (ExceptionUtils.indexOfType(e, CsvDataTypeMismatchException.class) != -1)
			{
				throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.INCORRECT_TYPE_ISSUE,"Incorrect Type");
			} 
			else if (ExceptionUtils.indexOfType(e, CsvRequiredFieldEmptyException.class) != -1) 
			{
				if(e.getMessage().equalsIgnoreCase("Error capturing CSV header!")) {
					throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.INCORRECT_HEADER,"Incorrect header");
				}
				else 
				{
					throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.DELIMITER_ISSUE,"Incorrect Delimiter Issue");
				}
			} 
			else {
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}
	}
}
