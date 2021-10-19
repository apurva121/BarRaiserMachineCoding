package com.example.springboot.Service;

import com.example.springboot.repository.DealsRepository;

public interface IDealsService {

    public void createADeal(Double price, int maxCount);
}
