package com.example.practice.controller;

import com.example.practice.wishlist.entity.WishListDto;
import com.example.practice.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/res")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping()
    public WishListDto add(@RequestBody WishListDto wishListDto){
        log.info("{}", wishListDto);

        return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(int index){
        wishListService.delete(index);
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
         wishListService.addVisit(index);
    }
}
