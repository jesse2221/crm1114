package com.lsx.crm.settings.dao;

import com.lsx.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
