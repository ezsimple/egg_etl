package newegg.common.service;

import io.mkeasy.resolver.CommandMap;

// --------------------------
// RDB to Elastic
// --------------------------
public interface EtlService {
	public String post(CommandMap commandMap) throws Exception;
}
