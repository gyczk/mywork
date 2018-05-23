package com.czk.service;

import java.util.List;

import com.czk.domain.BaseDict;

public interface DictService {

	List<BaseDict> findDictByTypeCode(String code);

}
