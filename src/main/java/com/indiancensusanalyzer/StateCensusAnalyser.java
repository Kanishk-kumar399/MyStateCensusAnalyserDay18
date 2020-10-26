package com.indiancensusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.indiancensusanalyzer.CensusAnalyserException.CensusExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class StateCensusAnalyser 
{
	public int loadStateCensusData(String csvfilePath) throws CensusAnalyserException {
		try {	
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			Iterator<CSVStateCensus> csvStateCensusIterator = getIteratorCSV(reader,CSVStateCensus.class);
			return getCountFromCSVIterator(csvStateCensusIterator);
			} 
		catch (IOException e) {
			throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM,"Incorrect File");
		}
	}
	public int loadIndianStateData(String csvfilePath) throws CensusAnalyserException 
	{
		try {	
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			Iterator<CSVStates> csvStateIterator = getIteratorCSV(reader,CSVStates.class);
			return getCountFromCSVIterator(csvStateIterator);
		} 
		catch (IOException e) {
			throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM,"Incorrect File");
		}
	}
	public <T> int getCountFromCSVIterator(Iterator<T> csvIterator) {
		Iterable<T> csvIterable = () -> csvIterator;
		int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numberOfEntries;
	}
	public<T> Iterator<T> getIteratorCSV(Reader reader, Class<T> CSVclass) throws CensusAnalyserException 
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
				throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.INCORRECT_TYPE_ISSUE,"Incorrect Type");
			} 
			else if (ExceptionUtils.indexOfType(e, CsvRequiredFieldEmptyException.class) != -1) 
			{
				if(e.getMessage().equalsIgnoreCase("Error capturing CSV header!")) {
					throw new CensusAnalyserException(CensusExceptionType.INCORRECT_HEADER,"Incorrect header");
				}
				else 
				{
					throw new CensusAnalyserException(CensusExceptionType.DELIMITER_ISSUE,"Incorrect Delimiter Issue");
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
