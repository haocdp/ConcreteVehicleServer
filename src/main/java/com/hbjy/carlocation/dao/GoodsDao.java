package com.hbjy.carlocation.dao;

import com.hbjy.carlocation.po.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao on 2016/8/5.
 */
@Repository
public interface GoodsDao extends JpaRepository<Goods, Integer>{
//    Page<Goods> findAll(Pageable pageable);
}
