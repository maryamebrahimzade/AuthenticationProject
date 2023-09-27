package com.auth.authentication.config.logger;

import com.auth.authentication.repositories.LogRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class LoggerAspect {
//    private final static Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    private LogRepository logRepository;
//
//    @Autowired
//    public LoggerAspect(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @PostConstruct
//    public void init() {
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//
//    @Around("within(com.auth.authentication.controllers.BaseController+)")
//    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Signature signature = proceedingJoinPoint.getSignature();
//        LogModel logModel = new LogModel();
//        logModel.setMethodName(signature.getName());
//        logModel.setRequest(proceedingJoinPoint.getArgs());
//
//        Object value;
//        try {
//            value = proceedingJoinPoint.proceed();
//            if (value != null) {
//                logModel.setResponse(value);
//            }
//            logRepository.save(logModel);
//            LOGGER.info("Success req/res is " + objectMapper.writeValueAsString(logModel));
//        } catch (Throwable e) {
//            StringWriter writer = new StringWriter();
//            PrintWriter printWriter = new PrintWriter(writer);
//            e.printStackTrace(printWriter);
//            writer.close();
//            printWriter.close();
//            logModel.setErrorTrace(writer.toString());
//            logRepository.save(logModel);
//            LOGGER.error("Failure req/res is " + objectMapper.writeValueAsString(logModel));
//            throw e;
//        }
//        return value;
//    }
}
