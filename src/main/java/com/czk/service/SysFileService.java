package com.czk.service;

import com.czk.domain.SysFile;

public interface SysFileService {

	SysFile get(Long picId);

	boolean isExist(String url);

	

}
