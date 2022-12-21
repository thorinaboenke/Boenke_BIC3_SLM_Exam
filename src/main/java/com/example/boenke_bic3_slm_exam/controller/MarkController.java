package com.example.boenke_bic3_slm_exam.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MarkController {
    @GetMapping("/api/mark")
    public String returnMark(@RequestParam String percentage) {
        Integer percent ;
        try
        {
            percent = Integer.parseInt(percentage);
        }
        catch (NumberFormatException e)
        {
            return "invalid input";
        }
        if (percent > 100) {
            return "invalid parameter";
        }
        else if (percent < 50 ) {
            return "5";

        } else if (percent < 63 ) {
            return "4";

        }else if (percent < 75) {
            return "3";

        }else if (percent < 88) {
            return "2";
        }
        else {
            return "1";
        }
    }
}


