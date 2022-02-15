import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetEntityMockObject;
import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetModelMockObject;
import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getIteratorSubnetEntityMockObject;

import static test.com.diegobassay.ip.address.management.mock.SubnetMock.SUBNET_NAME_MOCK;
import static org.mockito.Mockito.lenient;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import com.diegobassay.ip.address.management.service.SubnetService;
import com.diegobassay.ip.address.management.repository.SubnetRepository;
import com.diegobassay.ip.address.management.domain.assembler.SubnetModelAssembler;
import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import org.springframework.hateoas.CollectionModel;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SubnetServiceTest {

    @Mock
    SubnetRepository subnetRepository;
    
    @Mock
    SubnetModelAssembler subnetModelAssembler;

    @InjectMocks
	SubnetService subnetService;
    

    @BeforeEach
    void init() {
    	lenient().when(subnetRepository.findById(1L)).thenReturn(getSubnetEntityMockObject());
        lenient().when(subnetModelAssembler.toModel(Mockito.any(SubnetEntity.class))).thenReturn(getSubnetModelMockObject().get());
        lenient().when(subnetRepository.findById(0L)).thenThrow(new RuntimeException("Subnet not found"));
        lenient().when(subnetRepository.save(Mockito.any(SubnetEntity.class))).thenReturn(getSubnetEntityMockObject().get());
        lenient().when(subnetRepository.findAll()).thenReturn(getIteratorSubnetEntityMockObject());
        lenient().when(subnetModelAssembler.toCollectionModel(Mockito.any(Iterable.class))).thenReturn(CollectionModel.of(new ArrayList<SubnetModel>()));
    }

    @Test
    void testUpdateModel(){
        SubnetModel model = subnetService.update(1L, getSubnetModelMockObject().get());
        assertEquals(SUBNET_NAME_MOCK, model.getName());
    } 

    @Test
    void testFindModelById(){
        SubnetModel model = subnetService.findModelById(1L);
        assertEquals(SUBNET_NAME_MOCK, model.getName());
    }

    @Test
    void testExceptionFindModelById() {
        Exception thrown = assertThrows(
            RuntimeException.class,
            () -> subnetService.findModelById(0L)
        );
        assertTrue(thrown.getMessage().contains("Subnet not found"));
    }

    @Test
    void testCreateModel(){
        SubnetModel model = subnetService.create(getSubnetModelMockObject().get());
        assertEquals(SUBNET_NAME_MOCK, model.getName());
    }

    @Test
    void testFindAllModels(){
        CollectionModel<SubnetModel> collection = subnetService.findAll();
        assertNotNull(collection);
    }


    @Test
    void testDeleteModel(){
        SubnetModel model = subnetService.delete(1L);
        assertNotNull(model);
    } 
   
}