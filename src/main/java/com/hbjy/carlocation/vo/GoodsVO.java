package com.hbjy.carlocation.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 2016/8/6.
 */
public class GoodsVO {

    private int id;
    private String name;
    private String description;
    private int userId;
    private List<PositionVO> positionVOList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PositionVO> getPositionVOList(){
        return this.positionVOList;
    }
}
