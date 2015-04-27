package us.core_network.crust.io;

import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.RecordMapperProvider;
import org.jooq.RecordType;
import us.core_network.crust.claim.Claim;

public class CustomRecordMapperProvider implements RecordMapperProvider {
    @Override
    public <R extends Record, E> RecordMapper<R, E> provide(RecordType<R> recordType, Class<? extends E> aClass) {

        return null;
    }
}
