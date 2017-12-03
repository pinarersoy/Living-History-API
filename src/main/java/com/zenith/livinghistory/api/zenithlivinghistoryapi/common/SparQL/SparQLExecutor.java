package com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SparQLExecutor {


    public JsonArray execute(String query) throws IOException {

        try (
            QueryExecution queryExecutor = QueryExecutionFactory.sparqlService(MagicalStrings.DbpediaURL, query);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        )
        {
            ((QueryEngineHTTP)queryExecutor).addParam("timeout", MagicalStrings.QueryTimeout) ;
            ResultSet results = queryExecutor.execSelect();

            ResultSetFormatter.outputAsJSON(outputStream, results);
            String jsonString = new String(outputStream.toByteArray());
            JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
            JsonArray payload = jsonObject.getAsJsonObject("results").getAsJsonArray("bindings");

            return payload;

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }

    }

}
