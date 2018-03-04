package com.matrix.cloud.microservice.service;

import java.util.Map;

import com.matrix.cloud.microservice.entity.QueryParamDto;
import com.matrix.cloud.microservice.entity.ResultDoc;

public interface SearchService
{
    public ResultDoc search( QueryParamDto qpDto );
    
    public boolean addDoc( String docId, Map<String, String> docFields );

    public boolean deleteDoc( String docId );

    public boolean updateDoc( String docId, Map<String, String> docFields );
}
