package com.vtc.gamerid.gateway.luckyspin.service._interface;

import com.vtc.gamerid.gateway.common.dao.entity.UserGameRID;
import com.vtc.gamerid.gateway.common.dto.response.ServiceResponse;
import com.vtc.gamerid.gateway.luckyspin.bean.SpinItemBeanRequest;

/**
 * Created by phucnguyen on 03/07/2017.
 */
public interface AdminItemSpinService {
    public ServiceResponse createItemSpin(SpinItemBeanRequest spinItemBeanRequest,
                                          UserGameRID createBy);

    public ServiceResponse updateItemSpin(SpinItemBeanRequest spinItemBeanRequest,
                                          UserGameRID createBy);

    public ServiceResponse deleteItemSpin(Long spintItemId,
                                          UserGameRID createBy);
}
