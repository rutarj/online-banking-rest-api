package com.rutarj.onlinebankingrestapi.app.cus.mapper;

import com.rutarj.onlinebankingrestapi.app.cus.dto.CusCustomerDto;
import com.rutarj.onlinebankingrestapi.app.cus.dto.CusCustomerSaveDto;
import com.rutarj.onlinebankingrestapi.app.cus.dto.CusCustomerUpdateDto;
import com.rutarj.onlinebankingrestapi.app.cus.entity.CusCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CusCustomerMapper {

    CusCustomerMapper INSTANCE = Mappers.getMapper(CusCustomerMapper.class);

    List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList);

    CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer);

    CusCustomer convertToCusCustomer(CusCustomerSaveDto cusCustomerSaveDto);

    CusCustomer convertToCusCustomer(CusCustomerUpdateDto cusCustomerUpdateDto);
}
