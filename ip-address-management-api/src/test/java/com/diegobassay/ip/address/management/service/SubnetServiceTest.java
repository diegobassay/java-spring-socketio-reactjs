import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetEntityMockObject;
import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetModelMockObject;

import static test.com.diegobassay.ip.address.management.mock.SubnetMock.SUBNET_NAME_MOCK;
import static org.mockito.Mockito.lenient;

import java.util.List;
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
        lenient().when(subnetModelAssembler.toModel(getSubnetEntityMockObject().get())).thenReturn(getSubnetModelMockObject().get());
        lenient().when(subnetRepository.findById(0L)).thenThrow(new RuntimeException("Subnet not found"));

        
    }

    @Test
    void testFindModelById(){
        SubnetModel model = subnetService.findModelById(1L);

        assertEquals(SUBNET_NAME_MOCK, model.getName());
    }


    @Test
    void exceptionTesting() {
        Exception thrown = assertThrows(
            RuntimeException.class,
            () -> subnetService.findModelById(0L)
        );
        assertTrue(thrown.getMessage().contains("Subnet not found"));
    }      
}