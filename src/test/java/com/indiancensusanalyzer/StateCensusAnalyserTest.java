package com.indiancensusanalyzer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.indiancensusanalyzer.CensusAnalyserException.CensusExceptionType;

public class StateCensusAnalyserTest 
{
	public static final String CENSUS_CSV_FILE = "C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaCSVCensusData.csv";
	public static final String INCORRECT_FILE = "/users.txt";
	public static final String INCORRECT_CSV_FILE="C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\AddressBookCSVTest.csv";
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
    public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_FILE);
		}
		catch(CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
    }
	@Test
	public void givenWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_CSV_FILE);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}
}
