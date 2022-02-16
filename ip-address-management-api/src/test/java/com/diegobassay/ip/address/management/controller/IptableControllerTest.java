import static test.com.diegobassay.ip.address.management.mock.IptableMock.getIptableModelMockObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diegobassay.ip.address.management.controller.IptableController;
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

import com.diegobassay.ip.address.management.service.IptableService;
import com.diegobassay.ip.address.management.domain.model.IptableModel;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class IptableControllerTest {

    @Mock
    IptableService iptableService;

    @InjectMocks
	IptableController iptableController;

    final Integer EXPECTED_STATUS_OK = 200;
    final Integer EXPECTED_STATUS_CREATED_OR_DELETED = 201;

    @BeforeEach
    void init() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void testAllIptables(){
    	ResponseEntity<?> arrayIptables = iptableController.delete(1L);
    	assertEquals(new Integer(arrayIptables.getStatusCodeValue()), EXPECTED_STATUS_OK);
    } 
    
    @Test
    void testCreatedIptable(){
    	ResponseEntity<IptableModel> arrayIptables = iptableController.create(getIptableModelMockObject().get());
    	assertEquals(new Integer(arrayIptables.getStatusCodeValue()), EXPECTED_STATUS_CREATED_OR_DELETED);
    }  

    @Test
    void testDeleteIptable(){
    	ResponseEntity<?> arrayIptables = iptableController.findAll();
    	assertEquals(new Integer(arrayIptables.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }  

    @Test
    void testUpdateIptable(){
    	ResponseEntity<IptableModel> arrayIptables = iptableController.update(1L, getIptableModelMockObject().get());
    	assertEquals(new Integer(arrayIptables.getStatusCodeValue()), EXPECTED_STATUS_OK);
    }
}