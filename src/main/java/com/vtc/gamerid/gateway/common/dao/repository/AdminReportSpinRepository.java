package com.vtc.gamerid.gateway.common.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtc.gamerid.gateway.common.dao.entity.LuckySpin;
import com.vtc.gamerid.gateway.common.dto.response.ResultReportSpinGetResponseData;

/**
 * Created by phucnguyen on 14/07/2017.
 */
@Repository
public interface AdminReportSpinRepository extends JpaRepository<LuckySpin, Long>{
    
    @Query(value = "select"
            + " s.luckySpin as luckySpinId,"
            + " COUNT(s.item) as total,"
            + " i.type as typeItem,"
            + " i.value as value"
            + " from tblLuckySpinHistory s" 
            + " RIGHT JOIN tblLuckySpinItem i ON s.item = i.id"
            + " WHERE s.luckySpin = ?1"
            + " AND s.createOn BETWEEN ?2 AND ?3"
            + " GROUP BY i.id ORDER BY i.value DESC" , nativeQuery = true)
    public List<ResultReportSpinGetResponseData> getResultReportSpin(long luckySpinId , Date startDate, Date endDate);

//    public Map<String, Long> countTotalSpinReport(SpinReportBean spinReportBean);
    
    @Query(value = "select count(id) from TblLuckySpinUser where luckySpin.id=?1 and createOn between ?2 and ?3")
    public int countAllUserJoinEventBetweenDate(long luckySpinId, Date startDate, Date endDate);
}
