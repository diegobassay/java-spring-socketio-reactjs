import static org.junit.jupiter.api.Assertions.assertNotNull;
import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetEntityMockObject;
import static org.mockito.Mockito.lenient;
import com.diegobassay.ip.address.management.controller.SubnetController;

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

import com.diegobassay.ip.address.management.repository.SubnetRepository;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SubnetRepositoryTest {
    
    @Mock
	SubnetRepository subnetRepository;

    @BeforeEach
    void init() {
    	lenient().when(subnetRepository.findById(1L)).thenReturn(getSubnetEntityMockObject());
    }

    @Test
    void testFindById(){

        Optional<SubnetEntity> optional = subnetRepository.findById(1L);
        optional.ifPresent(subnet -> {
            assertNotNull(subnet);  
        });

    }
}