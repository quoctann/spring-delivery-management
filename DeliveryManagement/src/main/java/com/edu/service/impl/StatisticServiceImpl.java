package com.edu.service.impl;

import com.edu.repository.StatisticRepository;
import com.edu.service.StatisticService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {
    
    @Autowired
    private StatisticRepository statisticRepository;
    
    @Override
    public List<Object[]> incomeStatistic(Date fromDate, Date toDate, String type) {
        return this.statisticRepository.incomeStatistic(fromDate, toDate, type);
    }
    
}
