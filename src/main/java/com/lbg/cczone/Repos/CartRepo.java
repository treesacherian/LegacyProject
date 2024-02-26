package com.lbg.cczone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cczone.domain.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
