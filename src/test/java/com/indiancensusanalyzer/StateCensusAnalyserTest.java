package com.indiancensusanalyzer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest 
{
	public static final String CENSUS_CSV_FILE = "C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaCSVCensusData.csv";
	public static final String INCORRECT_FILE = "useless.csv";
	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int numberOfEntries = stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
			Assert.assertEquals(5,numberOfEntries);
			} 
		catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void givenCensusDataCsv_IfNotExist_ShouldthrowCensusAnalyserException()
	{
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.loadStateCensusData(INCORRECT_FILE);
		}
		catch (CensusAnalyserException e) 
		{
			e.printStackTrace();
			 Assert.assertEquals(CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
}
