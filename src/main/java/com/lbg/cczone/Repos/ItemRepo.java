package com.lbg.cczone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cczone.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
