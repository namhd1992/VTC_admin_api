package com.vtc.gamerid.gateway.common.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblLuckySpin")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LuckySpin {
    @Id
    @GeneratedValue
    private Long               id;

    private String             name;

    private String             type;

    private String             keyName;

    private String             image;

    @Temporal(TemporalType.TIMESTAMP)
    private Date               createOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date               startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date               endDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date               lastUpdate;

    private String             description;
    
    private String             linkLiveStream;

    private int                freeSpinPerDay;

    private int                freeSpinOnStart;

    private String             buyTurnType;

    private int                maxSpinPerUser;

    private int                pricePerTurn;
    
    private String             status;

    private int                spinTimes   = 0;

    @ManyToOne
    @JoinColumn(name = "createBy")
    private UserGameRID        createBy;

    private boolean            checkDeviceId;

    @OneToMany(mappedBy = "luckySpin",  fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TblLuckySpinItemOfLuckySpin> spinItems = new ArrayList<>();

    public LuckySpin(String name, String keyName, String image, Date createOn, Date startDate, Date endDate, Date lastUpdate, String description, int freeSpinPerDay, int freeSpinOnStart, int maxSpinPerUser, int pricePerTurn, String status, UserGameRID createBy) {
        this.name = name;
        this.keyName = keyName;
        this.image = image;
        this.createOn = createOn;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdate = lastUpdate;
        this.description = description;
        this.freeSpinPerDay = freeSpinPerDay;
        this.freeSpinOnStart = freeSpinOnStart;
        this.maxSpinPerUser = maxSpinPerUser;
        this.pricePerTurn = pricePerTurn;
        this.status = status;
        this.createBy = createBy;
        this.spinTimes = 0;
    }

}
