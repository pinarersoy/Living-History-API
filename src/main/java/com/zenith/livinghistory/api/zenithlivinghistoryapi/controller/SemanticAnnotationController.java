package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.github.jsonldjava.utils.Obj;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import org.apache.jena.query.*;
import org.apache.jena.sparql.resultset.ResultsFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/semanticannotations/")
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


    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<Object> get(){


        String queryString = "PREFIX bd: <http://www.bigdata.com/rdf#>\n" +
                "PREFIX wikibase: <http://wikiba.se/ontology#>\n" +
                "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" +
                "PREFIX wd: <http://www.wikidata.org/entity/>\n" +
                "SELECT DISTINCT ?country ?countryLabel\n" +
                "WHERE\n" +
                "{\n" +
                "\t?country wdt:P31 wd:Q3624078 .\n" +
                "    ?country wdt:P1622 wd:Q13196750.\n" +
                "    ?country wdt:P30 wd:Q15\n" +
                "\tFILTER NOT EXISTS {?country wdt:P31 wd:Q3024240}\n" +
                "\tSERVICE wikibase:label { bd:serviceParam wikibase:language \"en\" }\n" +
                "}\n" +
                "ORDER BY ?countryLabel";

        Query query = QueryFactory.create(queryString);
        Object response = new Obj();
        try (QueryExecution qexec = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", queryString)){
            ResultSet results = qexec.execSelect();
            results = ResultSetFactory.copyResults(results) ;
            ResultSetFormatter.outputAsJSON(results);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
