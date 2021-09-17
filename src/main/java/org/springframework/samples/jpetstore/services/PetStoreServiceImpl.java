package org.springframework.samples.jpetstore.services;

public class PetStoreServiceImpl implements PetStoreService {

  String storeName;

  @Override
  public String providedService() {
    return "Special Service";
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }
}
