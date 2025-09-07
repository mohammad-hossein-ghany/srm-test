package com.vasl.srm_test.api.facade.mapper;


import com.vasl.srm_test.api.dto.TestUserInputDto;
import com.vasl.srm_test.api.dto.TestUserOutputDto;
import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.service.model.TestUserInputModel;
import com.vasl.srm_test.service.model.TestUserOutputModel;
import com.vasl.srm_test.service.model.TestUserRemoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring" , uses =  {SupportMapper.class , UserDataMapper.class})
public interface TestUserMapper extends BaseMapper<TestUserInputDto, TestUserOutputDto, TestUserInputModel, TestUserOutputModel, TestUser>{

    TestUser fromRemoteModelToEntity(@MappingTarget TestUser testUser, TestUserRemoteModel remoteModel);
//    <OutModel, OutDto> OutDto convertFronOutModelToOutDto(OutModel outModel);
    /*
    //Input (TestUserInputDto -> TestUserInputModel -> TestUser)
    TestUserInputModel dtoToModel(TestUserInputDto dto);
    TestUser modelToEntity(TestUserInputModel inputModel);
    List<TestUserInputModel> dtoToModel_list(List<TestUserInputDto> dto);
    List<TestUser> modelToEntity_list(List<TestUserInputModel> inputModel);


    //Output (TestUser -> TestUserOutputModel -> TestUserOutputDto)
    TestUserOutputModel entityToModel(TestUser entity);
    TestUserOutputDto modelToDto(TestUserOutputModel model);
    List<TestUserOutputModel> entityToModel_list(List<TestUser> entities);
    List<TestUserOutputDto> modelToDto_list(List<TestUserOutputModel> model);


    //entity <-> dto
    TestUserOutputDto entityToDto(TestUser entity);
    TestUser dtoToEntity(TestUserInputDto dto);
    List<TestUserOutputDto> entityToDto_list(List<TestUser> entities);
    List<TestUser> dtoToEntity_list(List<TestUserInputModel> dtos);


    //update
    void updateEntity(TestUserInputModel model, @MappingTarget TestUser entity);
*/
}









