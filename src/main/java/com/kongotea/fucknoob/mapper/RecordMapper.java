package com.kongotea.fucknoob.mapper;

import com.kongotea.fucknoob.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {

    int save(Record record);
    int deleteById(String id);
    int update(Record record);
    Record findById(String id);
    List<Record> findAllByUserName(String name);
}
