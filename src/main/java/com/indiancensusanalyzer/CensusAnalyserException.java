package com.indiancensusanalyzer;

public class CensusAnalyserException extends Exception
{
	enum CensusExceptionType
	{
        CENSUS_FILE_PROBLEM, INCORRECT_DATA_ISSUE, SOME_OTHER_INPUTOOTPUT_EXCEPTION, DELIMITER_ISSUE,  NO_SUCH_CLASS
    }
    CensusExceptionType type;
    public CensusAnalyserException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
