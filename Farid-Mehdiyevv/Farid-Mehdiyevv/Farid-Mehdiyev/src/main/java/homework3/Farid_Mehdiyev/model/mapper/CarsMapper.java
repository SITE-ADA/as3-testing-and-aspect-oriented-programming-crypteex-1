package homework3.Farid_Mehdiyev.model.mapper;


import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;
import org.mapstruct.factory.Mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;



@Mapper
public interface CarsMapper {

    CarsMapper INSTANCE = Mappers.getMapper(CarsMapper.class);


    @Mapping(source = "carsDescription", target = "description")
    CarsDTO carsToCarsDTO(Cars cars);

    List<CarsDTO> carsListToCarsDTOList(List<Cars> cars);

    Cars carsDTOToCars(CarsDTO carsDTO);


}
