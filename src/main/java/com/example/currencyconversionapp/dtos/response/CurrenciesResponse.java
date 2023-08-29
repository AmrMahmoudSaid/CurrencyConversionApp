package com.example.currencyconversionapp.dtos.response;

import com.example.currencyconversionapp.dtos.CurrencyDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrenciesResponse {
    @NotEmpty(message = "currencies list should not be empty")
    List<CurrencyDto> currencies ;
}
