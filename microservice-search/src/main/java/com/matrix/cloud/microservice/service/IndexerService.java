package com.matrix.cloud.microservice.service;

import java.util.Map;

import com.matrix.cloud.microservice.entity.DocBody;
import com.matrix.cloud.microservice.entity.QueryParam;

/**
 * @Description: 检索接口
 * 
 * @author matrix
 * @date 2018-02-27 14:52:10
 *
 * @Copyright: 2018 www.matrix.com Inc. All rights reserved.
 */
public interface IndexerService
{
    public boolean addDoc( String docId, Map<String, String> docFields );

    public boolean deleteDoc( String docId );

    public boolean updateDoc( String docId, Map<String, String> docFields );

    public DocBody searchDoc( QueryParam queryParam );
}
