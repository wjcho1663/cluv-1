package com.gsitm.intern.repository;

import com.gsitm.intern.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>{

}