package com.danielpm1982.springboot2meetingmng.util;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    private static Period calculatePeriodUntilNow(LocalDate startDate){
        LocalDate endDate = LocalDate.now();
        return startDate.until(endDate);
    }
    public static Integer calculateAgeInYears(LocalDate birthDate){
        return calculatePeriodUntilNow(birthDate).getYears();
    }
    public static String calculateAgeInYearsMonthsDays(LocalDate birthDate){
        int years = calculatePeriodUntilNow(birthDate).getYears();
        int months = calculatePeriodUntilNow(birthDate).getMonths();
        int days = calculatePeriodUntilNow(birthDate).getDays();
        return years+" years "+months+" months "+days+" days";
    }
}
