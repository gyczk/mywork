package com.czk.service.impl;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.SysFileMapper;
import com.czk.domain.SysFile;
import com.czk.service.SysFileService;
@Service
public class SysFileServiceImpl implements SysFileService {
	
	@Autowired
	private SysFileMapper sysFileMapper;
	
	@Autowired
	private MyWorkConfig myWorkConfig;
	
	@Override
	public SysFile get(Long picId) {
		SysFile sysFile = sysFileMapper.selectByPrimaryKey(picId);
		return sysFile;
	}

	@Override
	public boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = myWorkConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}
	

}
