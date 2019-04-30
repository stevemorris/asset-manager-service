package com.assetmanager.assets.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.assetmanager.assets.model.Asset;
import com.assetmanager.assets.service.AssetService;

@RestController
public class AssetController {

  @Autowired
  private AssetService assetService;

  @PostMapping("/assets")
  Asset create(@RequestBody Asset asset) {
    return assetService.save(asset);
  }

  @PutMapping("/assets/{id}")
  ResponseEntity<String> update(@RequestBody Asset asset, @PathVariable Integer id) {
    if (assetService.findById(id).isPresent()) {
      asset.setId(id);
      assetService.save(asset);
    }

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/assets/{id}")
  void delete(@PathVariable Integer id) {
    if (assetService.findById(id).isPresent()) {
      assetService.deleteById(id);
    }
  }

  @GetMapping("/assets")
  Page<Asset> read(@PageableDefault(page = 0, size = Integer.MAX_VALUE) Pageable pageable) {
    return assetService.findAll(pageable);
  }

  @GetMapping("/assets/{id}")
  Optional<Asset> findById(@PathVariable Integer id) {
    Optional<Asset> asset = assetService.findById(id);

    if (!asset.isPresent()) {
      throw new NotFoundException();
    }

    return asset;
  }

  @GetMapping("/assets/search")
  Page<Asset> findByName(@RequestParam("name") String name,
      @PageableDefault(page = 0, size = Integer.MAX_VALUE) Pageable pageable) {
    return assetService.findByNameContaining(name, pageable);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
      super();
    }
  }
}
