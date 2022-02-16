package test.com.diegobassay.ip.address.management.mock;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Iterator;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;
import com.diegobassay.ip.address.management.domain.model.IptableModel;

public class IptableMock{

    public static final String IPTABLE_IP_MOCK = "127.0.0.1";
    public static final String IPTABLE_DEVICE_MOCK = "PC-01";

    public static Optional<IptableEntity> getIptableEntityMockObject(){
        IptableEntity entity = new IptableEntity();
        entity.setId(1L);
        entity.setIp(IptableMock.IPTABLE_IP_MOCK);
        entity.setDevice(IptableMock.IPTABLE_DEVICE_MOCK);
        return Optional.of(entity);
    }

    public static Optional<IptableModel> getIptableModelMockObject(){
        IptableModel model = new IptableModel();
        model.setId(2L);
        model.setIp(IptableMock.IPTABLE_IP_MOCK);
        model.setDevice(IptableMock.IPTABLE_DEVICE_MOCK);
        return Optional.of(model);
    }

    public static Iterable<IptableEntity> getIteratorIptableEntityMockObject(){
        List<IptableEntity> list = new ArrayList();
        list.add(new IptableEntity());
        list.add(new IptableEntity());
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