package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController {
/*
    private ContentRepository contentRepository;

    public StoryController(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Annotation> get(@PathVariable("id") String id) {

        return new ResponseEntity<>(contentRepository.findStoryById(id), HttpStatus.OK);
    }
*/
}
