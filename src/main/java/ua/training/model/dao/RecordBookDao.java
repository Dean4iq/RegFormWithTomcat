package ua.training.model.dao;

import ua.training.model.Record;

import java.util.List;

public interface RecordBookDao extends AutoCloseable {
        void create(Record noteBook);
        Record findById(int id);
        List<Record> findAll();
        void update(Record entity);
        void delete(int id);
}
