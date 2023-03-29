package com.realestate.service.Impl;

import com.realestate.entity.ClientReg;
import com.realestate.entity.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repository.ClientRegRepository;
import com.realestate.repository.SaleRepository;
import com.realestate.service.SaleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private ClientRegRepository clientRegRepository;
    public SaleServiceImpl(SaleRepository saleRepository, ClientRegRepository clientRegRepository) {
        this.saleRepository = saleRepository;
        this.clientRegRepository= clientRegRepository;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        ClientReg clientReg = clientRegRepository.findById(saleDto.getClientId()).orElseThrow(
                () -> new EntityNotFoundException("Client not found with id" + saleDto.getClientId())
        );
        Sale sale = new Sale();
        sale.setClientId(saleDto.getClientId());
        sale.setAgentId(saleDto.getAgentId());
        sale.setPropertyId(saleDto.getPropertyId());
        sale.setSaleDate(saleDto.getSaleDate()!= null ? saleDto.getSaleDate() : new Date());

        Sale save = saleRepository.save(sale);

        SaleDto Dto = new SaleDto();
        saleDto.setClientId(save.getClientId());
        saleDto.setAgentId(save.getAgentId());
        saleDto.setPropertyId(save.getPropertyId());
        saleDto.setSaleDate(save.getSaleDate());
        saleDto.setClientReg(clientReg);
        return saleDto;
    }
    //Encapsualation is used and getter and setter are defined below
}
