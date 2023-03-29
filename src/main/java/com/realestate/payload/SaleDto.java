package com.realestate.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.realestate.entity.ClientReg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {

    private Long ClientId;

    private Long agentId;

    private Long propertyId;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date saleDate;
    
    private ClientReg clientReg;

}

