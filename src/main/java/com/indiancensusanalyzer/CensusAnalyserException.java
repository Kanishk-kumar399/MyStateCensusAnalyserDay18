package com.indiancensusanalyzer;

public class CensusAnalyserException extends Exception
{
	enum CensusExceptionType
	{
        CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, SOME_OTHER_INPUTOOTPUT_EXCEPTION, DELIMITER_ISSUE,  NO_SUCH_CLASS
    }
    CensusExceptionType exceptionType;
    public CensusAnalyserException(CensusExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
