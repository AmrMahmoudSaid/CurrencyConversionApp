package com.example.currencyconversionapp.dtos.response;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "currencies rate list should not be empty")
    private List<CurrencyRateDto> conversion_rates ;
    @NotEmpty(message = "Time last update should not be empty")
    private Date time_last_update_utc;

}
