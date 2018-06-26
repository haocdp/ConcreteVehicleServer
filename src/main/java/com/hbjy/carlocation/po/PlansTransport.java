package com.hbjy.carlocation.po;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by haoc_dp on 16/8/4.
 */
@Entity
@Table(name = "plansTransport")
public class PlansTransport {

    public enum Status{
        INPROGRESS, COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column(name = "vehicleNo",nullable = false)
    private String vehicleNo;

    @OneToOne(targetEntity = Goods.class)
//    @Column(name = "goods",nullable = false)
    private Goods goods;

    @Column(name = "startPosition",nullable = false)
    private String startPosition;

    @Column(name = "endPosition",nullable = false)
    private String endPosition;

    @Column(name = "createTime",nullable = false)
    private Date createTime;

    @Column(name = "distance",nullable = false)
    private double distance;

    @Column(name = "currentLatitude",nullable = false)
    private double currentLatitude;

    @Column(name = "currentLongitude",nullable = false)
    private double currentLongitude;

    @Column(name = "status",nullable = false)
    private Status status;

    @Column(name = "progress",nullable = false)
    private double progress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
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
        if (!(o instanceof PlansTransport)) return false;

        PlansTransport that = (PlansTransport) o;

        if (id != that.id) return false;
        if (Double.compare(that.distance, distance) != 0) return false;
        if (Double.compare(that.currentLatitude, currentLatitude) != 0) return false;
        if (Double.compare(that.currentLongitude, currentLongitude) != 0) return false;
        if (Double.compare(that.progress, progress) != 0) return false;
        if (!user.equals(that.user)) return false;
        if (!vehicleNo.equals(that.vehicleNo)) return false;
        if (!goods.equals(that.goods)) return false;
        if (!startPosition.equals(that.startPosition)) return false;
        if (!endPosition.equals(that.endPosition)) return false;
        if (!createTime.equals(that.createTime)) return false;
        return status == that.status;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + vehicleNo.hashCode();
        result = 31 * result + goods.hashCode();
        result = 31 * result + startPosition.hashCode();
        result = 31 * result + endPosition.hashCode();
        result = 31 * result + createTime.hashCode();
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentLatitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentLongitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + status.hashCode();
        temp = Double.doubleToLongBits(progress);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
