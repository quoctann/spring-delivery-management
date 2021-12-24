package com.edu.repository;

import java.util.Date;
import java.util.List;

public interface StatisticRepository {
    // Thống kê doanh thu
    List<Object[]> incomeStatistic(Date fromDate, Date toDate, String type);    
}
