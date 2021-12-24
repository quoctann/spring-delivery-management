package com.edu.service;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    List<Object[]> incomeStatistic(Date fromDate, Date toDate, String type); 
}
