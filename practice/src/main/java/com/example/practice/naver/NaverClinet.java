package com.example.practice.naver;

import com.example.practice.naver.dto.SearchImageReq;
import com.example.practice.naver.dto.SearchImageRes;
import com.example.practice.naver.dto.SearchLocalReq;
import com.example.practice.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClinet {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var respnseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var respnseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                respnseType
        );

        return respnseEntity.getBody();

    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var respnseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var respnseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                respnseType
        );

        return respnseEntity.getBody();

    }
}
