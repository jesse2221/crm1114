package com.lsx.crm.workbench.dao;

import com.lsx.crm.workbench.domain.TranHistory;

import java.util.List;

public interface TranHistoryDao {

    int save(TranHistory th);

    List<TranHistory> getHistoryListTranId(String tranId);
}
