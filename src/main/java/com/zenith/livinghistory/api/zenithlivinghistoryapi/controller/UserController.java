package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.ContentRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.UserRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Annotation;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Content;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.User;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.request.ContentsByCreator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private ContentRepository contentRepository;
    private UserRepository userRepository;
    private AnnotationRepository annotationRepository;

    public UserController(ContentRepository contentRepository, UserRepository userRepository, AnnotationRepository annotationRepository) {
        this.contentRepository = contentRepository;
        this.userRepository = userRepository;
        this.annotationRepository = annotationRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public User get(@PathVariable String username) {
        return userRepository.findFirstByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}/contents")
    public List<Content> getContents(@PathVariable String username) {
        return contentRepository.findContentsByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contents")
    public List<Content> getContents(@RequestBody ContentsByCreator request) {
        return contentRepository.findContentsByCreator(request.getCreator());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}/annotations")
    public List<Annotation> getAnnotations(@PathVariable String username) {
        return annotationRepository.findAnnotationsByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/annotations")
    public List<Annotation> getAnnotations(@RequestBody ContentsByCreator request) {
        return annotationRepository.findByCreator(request.getCreator());
    }
}
