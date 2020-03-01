package com.nyubin.controller;

import com.nyubin.service.GeneralStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralStatisticController {

    @Autowired
    private GeneralStatisticService generalStatisticService;

    @GetMapping("/generalStatistic")
    public String getGeneralStatisric(@PathVariable Long id){
        return generalStatisticService.getGeneralStatistic(id);
    }


}
