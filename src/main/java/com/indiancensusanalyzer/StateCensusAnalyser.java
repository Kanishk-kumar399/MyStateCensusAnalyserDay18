package com.indiancensusanalyzer;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import com.google.gson.Gson;
import com.newcsvhandler.CSVBuilderException;
import com.newcsvhandler.CSVBuilderFactory;
import com.newcsvhandler.ICSVBuilder;

public class StateCensusAnalyser 
{
	List<CSVStateCensus> csvStateCensusList=null;
	public int loadStateCensusData(String csvfilePath) throws CSVBuilderException{
		try {	
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			ICSVBuilder csvBuilder=CSVBuilderFactory.createCSVBuilder();
			csvStateCensusList=csvBuilder.getCSVFileList(reader,CSVStateCensus.class);
			return csvStateCensusList.size();
			} 
		catch (IOException e) {
			throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.CENSUS_FILE_PROBLEM,"Incorrect File");
		}
	}
	public int loadIndianStateData(String csvfilePath) throws CSVBuilderException 
	{
		try {	
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			ICSVBuilder csvBuilder=CSVBuilderFactory.createCSVBuilder();
			List<CSVStates> csvStateList=csvBuilder.getCSVFileList(reader,CSVStates.class);
			return csvStateList.size();
		} 
		catch (IOException e) {
			throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.CENSUS_FILE_PROBLEM,"Incorrect File");
		}
	}
	public <T> int getCountFromCSVIterator(Iterator<T> csvIterator) {
		Iterable<T> csvIterable = () -> csvIterator;
		int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numberOfEntries;
	}
	public String getStateWiseSortedCensusData() throws CSVBuilderException
	{
		if (csvStateCensusList == null || csvStateCensusList.size() == 0) {
            throw new CSVBuilderException(CSVBuilderException.CSVExceptionType.NO_CENSUS_DATA,"Wrong and null file");
        }
        Comparator<CSVStateCensus> censusComparator = Comparator.comparing(census -> census.stateName);
        this.sort(censusComparator);
        String sortedJson = new Gson().toJson(csvStateCensusList);
        return sortedJson;
    }

    private void sort(Comparator<CSVStateCensus> censusComparator) {
        for (int i = 0; i < csvStateCensusList.size(); i++) {
            for (int j = 0; j < csvStateCensusList.size() - i - 1; j++) {
                CSVStateCensus census1 = csvStateCensusList.get(j);
                CSVStateCensus census2 = csvStateCensusList.get(j + 1);
                if (censusComparator.compare(census1, census2) > 0) {
                	csvStateCensusList.set(j, census2);
                	csvStateCensusList.set(j + 1, census1);
                }

            }

        }
    }
}
