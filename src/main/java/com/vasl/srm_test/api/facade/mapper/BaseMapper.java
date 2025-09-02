package com.vasl.srm_test.api.facade.mapper;


import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.service.model.TestUserInputModel;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper <inputDto, outputDto,inputModel,outputModel,entity>{
    //Input (TestUserInputDto -> inputModel -> entity)
    inputModel dtoToModel(inputDto dto);
    entity modelToEntity(inputModel inputModel);
    List<inputModel> dtoToModel_list(List<inputDto> dto);
    List<entity> modelToEntity_list(List<inputModel> inputModel);


    //Output (entity -> TestUserOutputModel -> TestUserOutputDto)
    outputModel entityToModel(entity entity);
    outputDto modelToDto(outputModel model);
    List<outputModel> entityToModel_list(List<entity> entities);
    List<outputDto> modelToDto_list(List<outputModel> model);


    //entity <-> dto
    outputDto entityToDto(entity entity);
    entity dtoToEntity(inputDto dto);
    List<outputDto> entityToDto_list(List<entity> entities);
    List<entity> dtoToEntity_list(List<inputDto> dtos);


    //update
    void updateEntity(TestUserInputModel model, @MappingTarget TestUser entity);

}
