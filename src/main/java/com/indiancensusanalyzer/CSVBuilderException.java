package com.indiancensusanalyzer;

public class CSVBuilderException extends Throwable 
{
    enum CSVExceptionType 
    {
    	 CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, DELIMITER_ISSUE,  INCORRECT_HEADER
    }

    CSVExceptionType exceptionType; 

    public CSVBuilderException(CSVExceptionType exceptionType,String message) {
        super(message);
        this.exceptionType=exceptionType;
    }
}