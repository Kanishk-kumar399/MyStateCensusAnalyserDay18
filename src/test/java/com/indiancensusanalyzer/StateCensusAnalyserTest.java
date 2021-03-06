package com.indiancensusanalyzer;

import java.io.IOException;

import com.google.gson.Gson;
import com.newcsvhandler.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	public static final String INCORRECTSTATE_HEADER_CSV="C:\\\\Users\\\\Asus\\\\eclipse-workspace\\\\IndianStateCensusAnalyser\\\\src\\\\main\\\\resources\\\\SampleCSVFile_2kb.csv";
	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int numberOfEntries = stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
			Assert.assertEquals(5,numberOfEntries);
			} 
		catch (CSVBuilderException e) {
			e.printStackTrace();
		}

	}
	@Test
    public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_FILE);
		}
		catch(CSVBuilderException e) 
		{
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
    }
	@Test
	public void givenWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_CSV_FILE);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE()  throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGDELIMITER_CENSUS_CSV);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() throws CSVBuilderException  {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_HEADER_CSV);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
	@Test
	public void givenIndiaStateCodeDataCsv_ShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int numberOfEntries = stateCensusAnalyser.loadIndianStateData(STATE_CSV_FILE);
			Assert.assertEquals(4,numberOfEntries);
			} 
		catch (CSVBuilderException e) {
			e.printStackTrace();
		}

	}

	@Test
    public void GivenTheStateCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException()  throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_FILE);
		}
		catch(CSVBuilderException e) 
		{
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
    }
	@Test
	public void givenStateWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() throws CSVBuilderException  {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_CSV_FILE);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenStateCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE()  throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadIndianStateData(WRONGDELIMITER_CENSUS_CSV);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenStateCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() throws CSVBuilderException {
		try {
			StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
			ExpectedException exceptionRule= ExpectedException.none();
			exceptionRule.expect(CSVBuilderException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECT_HEADER_CSV);
		}catch(CSVBuilderException e) {
			Assert.assertEquals(CSVBuilderException.CSVExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
		@Test
	    public void givenIndianCensusData_WhenSortedOnState_ShouldReturnSortedResult()
	 	{
	        try {
	            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
	            stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
	            String sortedCensusData=stateCensusAnalyser.getStateWiseSortedCensusData();
	            CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
	            Assert.assertEquals("Bihar",censusCSV[0].stateName);
	        } catch (CSVBuilderException e) {
	          e.printStackTrace();
	        }
	    }
		@Test
	    public void givenIndianStateData_WhenSortedOnStateCode_ShouldReturnSortedResult()
	 	{
	        try {
	            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
	            stateCensusAnalyser.loadIndianStateData(STATE_CSV_FILE);
	            String sortedCensusData=stateCensusAnalyser.getStateCodeWiseSortedCensusData();
	            CSVStates[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStates[].class);
	            Assert.assertEquals("Haryana",censusCSV[0].stateName);
	        } catch (CSVBuilderException e) {
	          e.printStackTrace();
	        }
	    }
		@Test
	    public void givenIndianCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult()
	 	{
	        try {
	            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
	            stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
	            String sortedCensusData=stateCensusAnalyser.getPopulationWiseSortedCensusData();
	            CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
	            Assert.assertEquals("Bihar",censusCSV[0].stateName);
	        } catch (CSVBuilderException e) {
	          e.printStackTrace();
	        }
	    }
		@Test
	    public void givenIndianCensusData_WhenSortedAsAreaInSqKm_ShouldReturnSortedResult()
	 	{
	        try {
	            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
	            stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
	            String sortedCensusData=stateCensusAnalyser.getAreaInSqKmWiseSortedCensusData();
	            CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
	            Assert.assertEquals("Uttar Pradesh",censusCSV[0].stateName);
	        } catch (CSVBuilderException e) {
	          e.printStackTrace();
	        }
	    }
		@Test
	    public void givenIndianCensusData_WhenSortedAsDensityPerSqKm_ShouldReturnSortedResult()
	 	{
	        try {
	            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
	            stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
	            String sortedCensusData=stateCensusAnalyser.getPopulationDensityWiseSortedCensusData();
	            CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
	            Assert.assertEquals("West Bengal",censusCSV[0].stateName);
	        } catch (CSVBuilderException e) {
	          e.printStackTrace();
	        }
	    }
}
