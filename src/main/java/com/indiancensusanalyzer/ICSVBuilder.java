package com.indiancensusanalyzer;

import java.io.Reader;
import java.util.Iterator;

public interface ICSVBuilder 
{
	 public  <T> Iterator<T> getIteratorCSV(Reader reader, Class<T> csvClass) throws CSVBuilderException;
}
