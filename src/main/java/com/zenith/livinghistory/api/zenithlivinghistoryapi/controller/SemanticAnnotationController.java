package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.github.jsonldjava.utils.Obj;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL.Queries;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL.SparQLExecutor;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import org.apache.jena.query.*;
import org.apache.jena.sparql.resultset.ResultsFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/semantic/")
public class SemanticAnnotationController {

    //region Private Members

    private AnnotationRepository annotationRepository;

    //endregion

    //region Constructors

    /**
     * Ctor.
     * @param annotationRepository - Annotation Repository.
     */
    public SemanticAnnotationController(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
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

    //endregion

}
