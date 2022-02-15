package test.com.diegobassay.ip.address.management.mock;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Iterator;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.model.IptableModel;

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
        model.setIp(new IptableModel());
        return Optional.of(model);
    }

    public static Iterable<SubnetEntity> getIteratorSubnetEntityMockObject(){
        List<SubnetEntity> list = new ArrayList();
        list.add(new SubnetEntity());
        list.add(new SubnetEntity());
        return toIterable(list.iterator());
    }

    private static <T> Iterable<T> toIterable(Iterator<T> iterator){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator()
            {
                return iterator;
            }
        };
    }


}