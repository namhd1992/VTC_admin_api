package com.vtc.gamerid.gateway.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vtc.gamerid.gateway.common.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblLuckySpinItem")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TblLuckySpinItem {
    @Id
    @GeneratedValue
    private Long     id;

    private String   name;

    private String   keyName;

    private float    value;

    private String   type;

    private int      quantity        = 0;

    @ManyToOne
    @JoinColumn(name = "createBy")
    private UserGameRID createBy;

    private String   status          = Constants.STATUS_ACTIVE;

    private int      isDefault       = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     createOn;

    private int      weight          = 0;

    private String   urlImage;

    private int      defaultPosition = 1;

    private String   winningTitle;

    private String   wheelTitle;

    private String   description;

    private boolean  bigItem;

    private boolean  highLights;

    public TblLuckySpinItem(String name, String keyName, float value, String type, int quantity, UserGameRID createBy, String status, int isDefault, Date createOn, int weight) {
        this.name = name;
        this.keyName = keyName;
        this.value = value;
        this.type = type;
        this.quantity = quantity;
        this.createBy = createBy;
        this.status = status;
        this.isDefault = isDefault;
        this.createOn = createOn;
        this.weight = weight;
        this.bigItem = false;
    }

}
