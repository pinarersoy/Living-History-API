package com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SparQLExecutor {


    public String execute(String query) throws IOException {

        try (
            QueryExecution queryExecutor = QueryExecutionFactory.sparqlService(MagicalStrings.DbpediaURL, query);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        )
        {
            ((QueryEngineHTTP)queryExecutor).addParam("timeout", MagicalStrings.QueryTimeout) ;
            ResultSet results = queryExecutor.execSelect();

            ResultSetFormatter.outputAsJSON(outputStream, results);
            String json = new String(outputStream.toByteArray());

            return json;

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }

    }

}
