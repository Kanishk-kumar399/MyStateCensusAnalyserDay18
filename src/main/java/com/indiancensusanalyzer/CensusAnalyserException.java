package com.indiancensusanalyzer;
import com.newcsvhandler.*;
public class CensusAnalyserException extends Exception
{
	enum CensusExceptionType
	{
        CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, DELIMITER_ISSUE,  INCORRECT_HEADER
    }
    CensusExceptionType exceptionType;
    public CensusAnalyserException(CensusExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
