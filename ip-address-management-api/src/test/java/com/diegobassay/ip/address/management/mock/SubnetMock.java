package test.com.diegobassay.ip.address.management.mock;

import java.util.Optional;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import com.diegobassay.ip.address.management.domain.model.SubnetModel;

public class SubnetMock{

    public static final String SUBNET_NAME_MOCK = "SUBNET1";

    public static Optional<SubnetEntity> getSubnetEntityMockObject(){
        SubnetEntity entity = new SubnetEntity();
        entity.setId(1L);
        entity.setName(SubnetMock.SUBNET_NAME_MOCK);
        return Optional.of(entity);
    }

    public static Optional<SubnetModel> getSubnetModelMockObject(){
        SubnetModel model = new SubnetModel();
        model.setId(2L);
        model.setName(SubnetMock.SUBNET_NAME_MOCK);
        return Optional.of(model);
    }


}