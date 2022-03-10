package com.lsx.crm.workbench.service;

import com.lsx.crm.workbench.domain.Tran;
import com.lsx.crm.workbench.domain.TranHistory;

import java.util.List;
import java.util.Map;

public interface TranService {
    boolean save(Tran t, String customerName);

    Tran detail(String id);

    List<TranHistory> getHistoryListTranId(String tranId);

    boolean changeStage(Tran t);

    Map<String, Object> getCharts();
}
