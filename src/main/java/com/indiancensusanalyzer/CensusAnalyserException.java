package com.indiancensusanalyzer;

public class CensusAnalyserException extends Exception
{
	enum CensusExceptionType
	{
        CENSUS_FILE_PROBLEM
    }
    CensusExceptionType type;
    public CensusAnalyserException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
