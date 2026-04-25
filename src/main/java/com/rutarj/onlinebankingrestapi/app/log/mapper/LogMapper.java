package com.rutarj.onlinebankingrestapi.app.log.mapper;

import com.rutarj.onlinebankingrestapi.app.kafka.dto.LogMessage;
import com.rutarj.onlinebankingrestapi.app.log.entity.LogDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  LogMapper {

    LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

    @Mapping(target = "details", source = "description")
    LogDetail convertToLogDetail(LogMessage logMessage);
}
