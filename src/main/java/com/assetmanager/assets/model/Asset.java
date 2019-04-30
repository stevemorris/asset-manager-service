package com.assetmanager.assets.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.assetmanager.assets.model.AssetType;

@Entity
@Table(name = "assets")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class Asset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String brand;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private String serial_number;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @Type(type = "pgsql_enum")
  private AssetType type;

  private Date acquisition;
  private Date warranty_expiration;
  private Integer owner_id;

  @Column(nullable = false)
  private Integer user_id;

  private Integer asset_id;

  @Column(nullable = false)
  private Boolean retired;

  @Column(nullable = false)
  private Integer cost;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public AssetType getType() {
    return type;
  }

  public void setType(AssetType type) {
    this.type = type;
  }

  public Date getAcquisition() {
    return acquisition;
  }

  public void setAcquisition(Date acquisition) {
    this.acquisition = acquisition;
  }

  public Date getWarranty_expiration() {
    return warranty_expiration;
  }

  public void setWarranty_expiration(Date warranty_expiration) {
    this.warranty_expiration = warranty_expiration;
  }

  public Integer getOwner_id() {
    return owner_id;
  }

  public void setOwner_id(Integer owner_id) {
    this.owner_id = owner_id;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public Integer getAsset_id() {
    return asset_id;
  }

  public void setAsset_id(Integer asset_id) {
    this.asset_id = asset_id;
  }

  public Boolean getRetired() {
    return retired;
  }

  public void setRetired(Boolean retired) {
    this.retired = retired;
  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }
}
