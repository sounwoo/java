package com.example.practice.naver;

import com.example.practice.naver.dto.SearchImageReq;
import com.example.practice.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClinet naverClinet;

    @Test
    public void searchLocalTest(){

        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClinet.searchLocal(search);
        System.out.println(result);
        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());
    }

    @Test
    public void searchImageTest(){
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClinet.searchImage(search);
        System.out.println(result);
    }

}
