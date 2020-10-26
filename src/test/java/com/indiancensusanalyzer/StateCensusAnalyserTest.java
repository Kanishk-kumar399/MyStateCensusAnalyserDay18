package com.indiancensusanalyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest 
{
	public static final String CENSUS_CSV_FILE = "/src/main/resources/IndiaCSVCensusData.csv";
	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int numberOfEntries = stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
			Assert.assertEquals(10,numberOfEntries);
			} 
		catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}
}
