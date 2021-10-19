package com.example.springboot.Service;

import com.example.springboot.DealsRunOutExeption;
import com.example.springboot.model.Deal;
import com.example.springboot.repository.DealsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DealService implements IDealsService {

    @Autowired
    DealsRepository dealsRepository;


    @Override
    public void createADeal(Double price, int maxCount) {
        log.info("Received request for price {} and maxCount {}", price, maxCount);
        Deal deal = new Deal(maxCount, price);
        dealsRepository.save(deal);
    }


    public synchronized void claimDeal(Long dealId) throws RuntimeException {
        try {
            Optional<Deal> deal = dealsRepository.findById(dealId);
            int currSubscriber = deal.get().getCurrentSubscriber();
            if (currSubscriber < deal.get().getMaxCount()) {
                deal.get().setCurrentSubscriber(currSubscriber + 1);
                dealsRepository.save(deal.get());
            } else {
                throw new DealsRunOutExeption("The deal has reached its max subscribers");
            }
        }
        catch(DealsRunOutExeption ex) {
            //
        }
        catch (Exception ex) {
            throw new RuntimeException("There is some internal problem. Please come back later");
        }

    }
}
