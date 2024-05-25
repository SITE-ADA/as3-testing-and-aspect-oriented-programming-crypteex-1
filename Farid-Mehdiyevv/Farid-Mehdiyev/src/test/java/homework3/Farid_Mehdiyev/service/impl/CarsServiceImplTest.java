package homework3.Farid_Mehdiyev.service.impl;


import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;
import homework3.Farid_Mehdiyev.repository.CarsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarsServiceImplTest {


    @Mock
    private CarsRepository carsRepository;

    @InjectMocks
    private CarsServiceImpl carsService;

    private Cars car;

    @BeforeEach
    void setUp(){

        carsService = new CarsServiceImpl(carsRepository);
        car = new Cars("Mercedes-Benz", "2014", "Non-AMG");

    }

    @Test
    void is_ListAllCars_method_can_List_all_cars() {

        List<CarsDTO> cars = carsService.list();

        assertNotNull(cars);
        verify(carsRepository).findAll();

    }

    @Test

    void is_SaveCars_method_is_able_to_save_Cars() {

        carsService.save(car);

        ArgumentCaptor<Cars> carsArgumentCaptor = ArgumentCaptor.forClass(Cars.class);
        verify(carsRepository).save(carsArgumentCaptor.capture());

        Cars capturedCar = carsArgumentCaptor.getValue();
        assertThat(capturedCar).isEqualTo(car);

    }


    @Test
    void is_FindById_Able_To_Get_Expected_Result() {

        when(carsRepository.findById(car.getId())).thenReturn(Optional.of(car));


        Optional<Cars> actualCar = carsService.getById(car.getId());

        assertNotNull(actualCar);
        verify(carsRepository, times(1)).findById(car.getId());

    }

    @Test
    @DirtiesContext
    void is_delete_ById_method_actually_deleted() {



        doNothing().when(carsRepository).deleteById(car.getId());

       carsService.deleteById(car.getId());
       verify(carsRepository, times(1)).deleteById(car.getId());
       verifyNoMoreInteractions(carsRepository);
    }


    @Test
    void update () {

        when(carsRepository.findById(car.getId())).thenReturn(Optional.of(car));


        Optional <Cars> updatedCar = carsRepository.findById(car.getId());


    }

    @Test
    void partialUpdate(){

    }

}
