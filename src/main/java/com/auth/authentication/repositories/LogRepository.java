package com.auth.authentication.repositories;

import com.auth.authentication.config.logger.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogModel, String> {
}
