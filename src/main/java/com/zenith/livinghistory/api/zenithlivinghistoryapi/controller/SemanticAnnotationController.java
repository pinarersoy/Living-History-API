package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.github.jsonldjava.utils.Obj;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL.Queries;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL.SparQLExecutor;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.ContentRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Annotation;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Content;
import org.apache.jena.query.*;
import org.apache.jena.sparql.resultset.ResultsFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/semantic/")
public class SemanticAnnotationController {

    //region Private Members

    private AnnotationRepository annotationRepository;

    private ContentRepository contentRepository;

    //endregion

    //region Constructors

    /**
     * Ctor.
     * @param annotationRepository - Annotation Repository.
     */
    public SemanticAnnotationController(AnnotationRepository annotationRepository, ContentRepository contentRepository) {
        this.annotationRepository = annotationRepository;
        this.contentRepository = contentRepository;
    }

    //endregion

    //region Public Methods

    @RequestMapping(method = RequestMethod.GET, value = "/entities/{keyword}")
    public ResponseEntity<Object> get(@PathVariable("keyword") String keyword){

        String queryString = String.format(Queries.semanticBody, keyword);
        SparQLExecutor executor = new SparQLExecutor();
        String response = "";

        try {
            response = executor.execute(queryString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> post(@RequestBody @Valid Annotation annotation) {

        String[] parts = annotation.getTarget().getId().split("/");
        String targetId = parts[parts.length - 1].split("#")[0];

        Content content = contentRepository.findContentByStoryItemId(targetId);
        List<Annotation> annotations = content.getAnnotations();
        annotations.add(annotation);
        content.setAnnotations(annotations);
        contentRepository.save(content);


        return new ResponseEntity<>(annotation, HttpStatus.OK);

    }

    //endregion

}
