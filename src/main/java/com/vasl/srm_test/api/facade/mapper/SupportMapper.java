package com.vasl.srm_test.api.facade.mapper;


import com.vasl.srm_test.api.dto.SupportInputDto;
import com.vasl.srm_test.api.dto.SupportOutputDto;
import com.vasl.srm_test.dal.entity.Support;
import com.vasl.srm_test.service.model.SupportInputModel;
import com.vasl.srm_test.service.model.SupportOutputModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupportMapper extends BaseMapper <SupportInputDto, SupportOutputDto, SupportInputModel, SupportOutputModel, Support>{
}
