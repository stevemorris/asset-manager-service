package com.assetmanager.assets.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.assetmanager.assets.model.Asset;

public interface AssetService extends JpaRepository<Asset, Integer> {
  Page<Asset> findAll(Pageable pageable);

  Page<Asset> findByNameContaining(String name, Pageable pageable);
}
