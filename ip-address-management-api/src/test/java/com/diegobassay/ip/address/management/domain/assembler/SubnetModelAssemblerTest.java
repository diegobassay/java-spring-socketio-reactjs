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

import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import com.diegobassay.ip.address.management.domain.assembler.SubnetModelAssembler;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SubnetModelAssemblerTest {

    @InjectMocks
    SubnetModelAssembler assembler;

    @Test
    void testToModel(){
        SubnetEntity entity = new SubnetEntity();
        entity.setId(1L);
        SubnetModel model = assembler.toModel(entity);
        assertEquals(model.getId(), entity.getId());
    }
}