import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diegobassay.ip.address.management.controller.SubnetController;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.diegobassay.ip.address.management.service.SubnetService;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SubnetControllerTest {

    @Mock
    SubnetService subnetService;

    @InjectMocks
	SubnetController subnetController;

    @Test
    void testGetSubnetById(){
        
        MockHttpServletRequest request = new MockHttpServletRequest();

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

    	ResponseEntity<List<String>> arraySubnets = subnetController.getSubnetById(1L);

    	final Integer EXPECTED_STATUS = 200;

    	assertEquals(new Integer(arraySubnets.getStatusCodeValue()), EXPECTED_STATUS);
    }
}