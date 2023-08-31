package com.farras.lsb.ch3.services;

import com.farras.lsb.ch3.UniversalSearch;
import com.farras.lsb.ch3.VideoSearch;
import com.farras.lsb.ch3.entitiy.VideoEntity;
import com.farras.lsb.ch3.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class VideoService extends VideoEntity{
    VideoRepository repository;

    // Depedency injection
    public VideoService(VideoRepository repository){
        this.repository = repository;
    }

    public List<VideoEntity> search(VideoSearch videoSearch){

        if (StringUtils.hasText(videoSearch.name()) && StringUtils.hasText(videoSearch.description())){
            Sort sorting = Sort.by("name").ascending();
            return repository.findByNameContainsOrDescriptionContainsAllIgnoreCase(videoSearch.name(), videoSearch.description(),sorting);
        }

        if (StringUtils.hasText(videoSearch.description())){
            return repository.findByDescriptionContainsIgnoreCase(videoSearch.description());
        }
//        return repository.findAll();
        return Collections.emptyList();
    }
    public Page<VideoEntity> searchUsePage (VideoSearch videoSearch){
        if (StringUtils.hasText(videoSearch.name()) && StringUtils.hasText(videoSearch.page())){
            // Create instance of sort method
            Sort sorting = Sort.by("name").ascending();

            // Set paging and put sorting on ot
            Pageable pageable = PageRequest.of(Integer.parseInt(videoSearch.page()), 4,sorting);
            // pass it to repository method
            return repository.findByNameContainsIgnoreCase(videoSearch.name(), pageable);
        }
        return Page.empty();
    }
    public List<VideoEntity> addVideo (VideoSearch videoSearch){
        repository.save(new VideoEntity(videoSearch.name(),videoSearch.description()));
        return repository.findAll();
    }

    // Universal search
    public List<VideoEntity> unversalSearch (UniversalSearch universalSearch){
        // Creating probe
        VideoEntity probe = new VideoEntity();

        if (StringUtils.hasText(universalSearch.value())){

            // Search partial name
            probe.setName(universalSearch.value());

            // Search partial desc
            probe.setDescription(universalSearch.value());
        }

        // Create ExampleMatcher
        /**
         * Ignore Case
         * Contains
         */
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        // Doing query by Example and setup ExampleMatcher
        Example<VideoEntity> videoEntityExample = Example.of(probe,exampleMatcher);

        return repository.findAll(videoEntityExample);
    }
}
