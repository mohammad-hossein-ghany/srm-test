package com.vasl.srm_test.api.facade.mapper;

import com.vasl.srm_test.api.dto.TestUserLogInputDto;
import com.vasl.srm_test.api.dto.TestUserLogOutputDto;
import com.vasl.srm_test.dal.entity.TestUserLog;
import com.vasl.srm_test.service.model.TestUserLogInputModel;
import com.vasl.srm_test.service.model.TestUserLogOutputModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestUserLogMapper extends BaseMapper <TestUserLogInputDto, TestUserLogOutputDto, TestUserLogInputModel, TestUserLogOutputModel, TestUserLog>{
}


