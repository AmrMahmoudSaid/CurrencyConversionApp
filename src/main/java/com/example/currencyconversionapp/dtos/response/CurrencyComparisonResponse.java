package com.example.currencyconversionapp.dtos.response;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyComparisonResponse {
    private List<CurrencyRateDto> conversion_rates ;
    @NotBlank
    private Date time_last_update_utc;

}
