package com.hbjy.carlocation.dao;

import com.hbjy.carlocation.po.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hao on 2016/8/5.
 */
@Repository
public interface PositionDao extends JpaRepository<Position, Integer>{
    List<Position> findByGoodsId(int goodsId);
}
