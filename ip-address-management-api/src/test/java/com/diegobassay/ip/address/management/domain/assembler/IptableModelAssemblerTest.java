import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import com.diegobassay.ip.address.management.domain.model.IptableModel;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;
import com.diegobassay.ip.address.management.domain.assembler.IptableModelAssembler;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class IptableModelAssemblerTest {

    @InjectMocks
    IptableModelAssembler iptableModelAssembler;

    @Test
    void testToModel(){
        IptableEntity entity = new IptableEntity();
        entity.setId(1L);
        IptableModel model = iptableModelAssembler.toModel(entity);
        assertEquals(model.getId(), entity.getId());
    }
}