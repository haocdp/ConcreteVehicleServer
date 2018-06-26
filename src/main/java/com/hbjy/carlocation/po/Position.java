package com.hbjy.carlocation.po;

import javax.persistence.*;

/**
 * Created by haoc_dp on 16/8/4.
 */
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "latitude",nullable = false)
    private double latitude = 0;

    @Column(name = "longitude",nullable = false)
    private double longitude = 0;

    @ManyToOne(targetEntity = Goods.class)
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (Double.compare(position.latitude, latitude) != 0) return false;
        if (Double.compare(position.longitude, longitude) != 0) return false;
        return goods.equals(position.goods);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + goods.hashCode();
        return result;
    }
}
