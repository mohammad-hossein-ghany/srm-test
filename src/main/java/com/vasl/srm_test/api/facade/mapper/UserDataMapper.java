package com.vasl.srm_test.api.facade.mapper;


import com.vasl.srm_test.api.dto.UserDataInputDto;
import com.vasl.srm_test.api.dto.UserDataOutputDto;
import com.vasl.srm_test.dal.entity.UserData;
import com.vasl.srm_test.service.model.UserDataInputModel;
import com.vasl.srm_test.service.model.UserDataOutputModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDataMapper extends BaseMapper <UserDataInputDto, UserDataOutputDto, UserDataInputModel, UserDataOutputModel, UserData>{
    /*
    //Input (UserDataInputDto -> UserDataInputModel -> UserData)
    UserDataInputModel dtoToModel(UserDataInputDto dto);
    UserData modelToEntity(UserDataInputModel inputModel);
    List<UserDataInputModel> dtoToModel_list(List<UserDataInputDto> dto);
    List<UserData> modelToEntity_list(List<UserDataInputModel> inputModel);


    //Output (UserData -> UserDataOutputModel -> UserDataOutputDto)
    UserDataOutputModel entityToModel(UserData entity);
    UserDataOutputDto modelToDto(UserDataOutputModel model);
    List<UserDataOutputModel> entityToModel_list(List<UserData> entities);
    List<UserDataOutputDto> modelToDto_list(List<UserDataOutputModel> model);


    //entity <-> dto
    UserDataOutputDto entityToDto(UserData entity);
    UserData dtoToEntity(UserDataInputDto dto);
    List<UserDataOutputDto> entityToDto_list(List<UserData> entities);
    List<UserData> dtoToEntity_list(List<UserDataInputDto> dtos);


    //update
    void updateEntity(UserDataInputModel model, @MappingTarget UserData entity);
*/
}
