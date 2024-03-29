package com.example.practice.wishlist.repository;

import com.example.practice.db.MemoryDbRepositoryAbstract;
import com.example.practice.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
