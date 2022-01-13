package com.example.coreservicesmongo.services;

import com.example.coreservicesmongo.entity.DBSeq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class DBsequenceService {

    private static MongoOperations mongoOperations;

    @Autowired
    public DBsequenceService(MongoOperations mongoOperations1){
        mongoOperations = mongoOperations1;
    }

    public DBsequenceService(){

    }

    public static long Gensequence(String seq){
        DBSeq count = mongoOperations.findAndModify(query(where("_id").is(seq)),new Update().inc("seq",1), options().returnNew(true).upsert(true),DBSeq.class);
        return !Objects.isNull(count)?count.getSequence():1;
    }
}
