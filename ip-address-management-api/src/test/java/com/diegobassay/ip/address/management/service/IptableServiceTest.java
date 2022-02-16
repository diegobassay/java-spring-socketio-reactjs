import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static test.com.diegobassay.ip.address.management.mock.IptableMock.getIptableEntityMockObject;
import static test.com.diegobassay.ip.address.management.mock.IptableMock.getIptableModelMockObject;
import static test.com.diegobassay.ip.address.management.mock.IptableMock.getIteratorIptableEntityMockObject;

import static test.com.diegobassay.ip.address.management.mock.IptableMock.IPTABLE_IP_MOCK;
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

import com.diegobassay.ip.address.management.service.IptableService;
import com.diegobassay.ip.address.management.repository.IptableRepository;
import com.diegobassay.ip.address.management.domain.assembler.IptableModelAssembler;
import com.diegobassay.ip.address.management.domain.model.IptableModel;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;
import org.springframework.hateoas.CollectionModel;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class IptableServiceTest {

    @Mock
    IptableRepository iptableRepository;
    
    @Mock
    IptableModelAssembler iptableModelAssembler;

    @InjectMocks
	IptableService iptableService;
    

    @BeforeEach
    void init() {
    	lenient().when(iptableRepository.findById(1L)).thenReturn(getIptableEntityMockObject());
        lenient().when(iptableModelAssembler.toModel(Mockito.any(IptableEntity.class))).thenReturn(getIptableModelMockObject().get());
        lenient().when(iptableRepository.findById(0L)).thenThrow(new RuntimeException("Iptable not found"));
        lenient().when(iptableRepository.save(Mockito.any(IptableEntity.class))).thenReturn(getIptableEntityMockObject().get());
        lenient().when(iptableRepository.findAll()).thenReturn(getIteratorIptableEntityMockObject());
        lenient().when(iptableModelAssembler.toCollectionModel(Mockito.any(Iterable.class))).thenReturn(CollectionModel.of(new ArrayList<IptableModel>()));
    }

    @Test
    void testUpdateModel(){
        IptableModel model = iptableService.update(1L, getIptableModelMockObject().get());
        assertEquals(IPTABLE_IP_MOCK, model.getIp());
    } 

    @Test
    void testFindModelById(){
        IptableModel model = iptableService.findModelById(1L);
        assertEquals(IPTABLE_IP_MOCK, model.getIp());
    }

    @Test
    void testExceptionFindModelById() {
        Exception thrown = assertThrows(
            RuntimeException.class,
            () -> iptableService.findModelById(0L)
        );
        assertTrue(thrown.getMessage().contains("Iptable not found"));
    }

    @Test
    void testCreateModel(){
        IptableModel model = iptableService.create(getIptableModelMockObject().get());
        assertEquals(IPTABLE_IP_MOCK, model.getIp());
    }

    @Test
    void testFindAllModels(){
        CollectionModel<IptableModel> collection = iptableService.findAll();
        assertNotNull(collection);
    }


    @Test
    void testDeleteModel(){
        IptableModel model = iptableService.delete(1L);
        assertNotNull(model);
    } 
   
}