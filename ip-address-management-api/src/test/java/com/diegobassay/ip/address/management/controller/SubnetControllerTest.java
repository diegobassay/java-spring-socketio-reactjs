import static test.com.diegobassay.ip.address.management.mock.SubnetMock.getSubnetModelMockObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diegobassay.ip.address.management.controller.SubnetController;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.diegobassay.ip.address.management.service.SubnetService;
import com.diegobassay.ip.address.management.domain.model.SubnetModel;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SubnetControllerTest {

    @Mock
    SubnetService subnetService;

    @InjectMocks
	SubnetController subnetController;

    final Integer EXPECTED_STATUS_OK = 200;
    final Integer EXPECTED_STATUS_CREATED_OR_DELETED = 201;

    @BeforeEach
    void init() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void testGetSubnetById(){
    	ResponseEntity<SubnetModel> arraySubnets = subnetController.getSubnetById(1L);
    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }

    @Test
    void testUpdateSubnet(){
    	ResponseEntity<SubnetModel> arraySubnets = subnetController.update(1L, getSubnetModelMockObject().get());
    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }

    @Test
    void testCreatedSubnet(){
    	ResponseEntity<SubnetModel> arraySubnets = subnetController.create(getSubnetModelMockObject().get());
    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS_CREATED_OR_DELETED);
    } 

    @Test
    void testAllSubnets(){
    	ResponseEntity<?> arraySubnets = subnetController.delete(1L);
    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }  

    @Test
    void testDeleteSubnet(){
    	ResponseEntity<?> arraySubnets = subnetController.findAll();
    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }  
}