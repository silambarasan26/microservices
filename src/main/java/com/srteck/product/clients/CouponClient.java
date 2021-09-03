package com.srteck.product.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.srteck.product.model.Coupon;

@FeignClient(value = "COUPON-SERVICE")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupon/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
