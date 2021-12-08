package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.PromotionCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PromotionCouponRepository extends JpaRepository<PromotionCoupon, Long>,
  JpaSpecificationExecutor<PromotionCoupon> {

}
