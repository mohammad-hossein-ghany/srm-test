package com.vasl.srm_test.api.facade.mapper;


import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.service.model.TestUserInputModel;

import com.vasl.srm_test.service.model.TestUserRemoteModel;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

public interface BaseMapper<inputDto, outputDto, inputModel, outputModel, entity>{

//    InModel convertFromInToOut(InDto inputDto);
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
    @Mapping(target = "id", ignore = true)
    void updateEntityFromRemoteApiCallResult(@MappingTarget TestUser entity, TestUserRemoteModel model);


    void updateEntity(@MappingTarget TestUser targetTestUser, TestUser testUser);

}
