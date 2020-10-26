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
	public static final String WRONGDELIMITER_CENSUS_CSV = "C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\SampleCSVFile_2kb.csv";
	public static final String INCORRECT_HEADER_CSV="C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\AddressBookCSVTest.csv";
	public static final String STATE_CSV_FILE="C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\Statecode.csv";
	public static final String INCORRECTSTATE_FILE = "/users.txt";
	public static final String INCORRECTSTATE_CSV_FILE="C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\AddressBookCSVTest.csv";
	public static final String WRONGDELIMITERSTATE_CENSUS_CSV = "C:\\Users\\Asus\\eclipse-workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\SampleCSVFile_2kb.csv";
	public static final String INCORRECTSTATE_HEADER_CSV="";
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
	@Test
	public void givenCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGDELIMITER_CENSUS_CSV);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_HEADER_CSV);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
	@Test
	public void givenIndiaStateCodeDataCsv_ShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int numberOfEntries = stateCensusAnalyser.loadIndianStateData(STATE_CSV_FILE);
			Assert.assertEquals(4,numberOfEntries);
			} 
		catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}

	@Test
    public void GivenTheStateCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_FILE);
		}
		catch(CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
    }
	@Test
	public void givenStateWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_CSV_FILE);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenStateCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(WRONGDELIMITER_CENSUS_CSV);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenStateCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_HEADER_CSV);
		}catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
}
