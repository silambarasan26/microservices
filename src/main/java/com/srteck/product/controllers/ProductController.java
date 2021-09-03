package com.srteck.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srteck.product.clients.CouponClient;
import com.srteck.product.model.Coupon;
import com.srteck.product.model.Product;
import com.srteck.product.repos.ProductRepo;

@RestController
@RequestMapping(value = "/productapi")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CouponClient couponClient;
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice() - coupon.getDiscount());
		return productRepo.save(product);
		
	}

}
