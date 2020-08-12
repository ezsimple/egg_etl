/*
 * Copyright 2020 the original EzFarm and author or authors.
*/

package newegg.common.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mkeasy.utils.QueryMap;
import io.mkeasy.webapp.processor.EsFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public abstract class AbstractEtlService implements EtlService {
	
	@Autowired
	EsFactory esFactory;

	public String makeBulkParams(List<QueryMap> list , String index_meta, String field_name) {
		StringBuffer bulkStr = new StringBuffer();
		for(QueryMap item : list) {
			String index = String.valueOf(item.get(index_meta));
			String field = String.valueOf(item.get(field_name));
			if(StringUtils.isEmpty(index)) continue;
			bulkStr.append(index+"\n");
			bulkStr.append(field+"\n");
		}
		return bulkStr.toString();
	}

}
