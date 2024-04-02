package com.example.practice.wishlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishServiceTest {

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        // naver seach moking 처리해서 테스트 코드 작성해야됨
        var result = wishListService.search("갈비집");

        System.out.println("reuslt : " + result);
        Assertions.assertNotNull(result);
    }
}
