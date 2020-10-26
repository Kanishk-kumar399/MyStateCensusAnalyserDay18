package com.indiancensusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser 
{
	public int loadStateCensusData(String csvfilePath) throws CensusAnalyserException {
		try {	
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			Iterator<CSVStateCensus> csvStateCensusIterator = new OpenCSVBuilder().getIteratorCSV(reader,CSVStateCensus.class);
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
			Iterator<CSVStates> csvStateIterator = new OpenCSVBuilder().getIteratorCSV(reader,CSVStates.class);
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
}
