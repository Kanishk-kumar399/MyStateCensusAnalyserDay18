package com.indiancensusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {

    @CsvBindByName(column = "State")
    public String stateName;

    @CsvBindByName(column = "Population",required = true)
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public String densityPerSqKm;

    @Override
    public String toString() {
        return  "StateName='" + stateName + 
                ", Population='" + population + 
                ", Area In Square Km='" + areaInSqKm + 
                ", DensityPerSqKm='" + densityPerSqKm  +"\n";
    }
}