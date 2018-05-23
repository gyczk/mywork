package com.czk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.BaseDictMapper;
import com.czk.domain.BaseDict;
import com.czk.domain.BaseDictExample;
import com.czk.domain.BaseDictExample.Criteria;
import com.czk.service.DictService;
@Service
public class DictServiceImpl  implements DictService{
	@Autowired
	private BaseDictMapper dictMapper;
	
	@Override
	public List<BaseDict> findDictByTypeCode(String code) {
		BaseDictExample example = new BaseDictExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictTypeCodeEqualTo(code);
		List<BaseDict> list = dictMapper.selectByExample(example);
		return list;
	}

}
