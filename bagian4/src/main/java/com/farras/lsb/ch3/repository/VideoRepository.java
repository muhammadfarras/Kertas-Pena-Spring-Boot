package com.farras.lsb.ch3.repository;

import com.farras.lsb.ch3.entitiy.VideoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

    List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String partialName, String partialDescription, Sort sort);

    Page<VideoEntity> findByNameContainsIgnoreCase(String partialName, Pageable pageable);

    List<VideoEntity> findByDescriptionContainsIgnoreCase(String partialDescription);

}
