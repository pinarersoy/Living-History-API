package com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL;

public final class Queries {

    /**
     * @param - The text that will be searched as city and person.
     */
    public  static String semanticBody =
            "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"
                    + "PREFIX  dbo: <http://dbpedia.org/ontology/>"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "SELECT ?thing ?name ?type "
                    + "WHERE  {"
                    + "{"
                    + "SELECT ?thing ?name (\"City\" AS ?type) WHERE"
                    + "{"
                    + "?thing a dbo:Place;"
                    + "a dbo:City;"
                    + "rdfs:label ?name."
                    + "FILTER langMatches(lang(?name),\"en\")"
                    + "FILTER(CONTAINS(?name, \"%1$s\"))"
                    + "}"
                    + "}"
                    + "UNION"
                    + "{"
                    + "SELECT ?thing ?name (\"Person\" AS ?type) WHERE"
                    + "{"
                    + "?thing a foaf:Person;"
                    + "a dbo:Person;"
                    + "foaf:name ?name."
                    + "FILTER langMatches(lang(?name),\"en\")"
                    + "FILTER(CONTAINS(?name, \"%1$s\"))"
                    + "}"
                    + "}"
                    + "}";


    public static String isCity =
            "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "SELECT"
            + "(\"true\" AS ?result)"
            + "WHERE"
            + "{"
	        + "<%1$s> rdf:type ?type."
	        + "<%1$s> rdfs:label ?label."
            + "FILTER langMatches( lang(?label), \"EN\" )"
            + "FILTER (?type IN (dbo:City))"
            + "}"
            + "GROUP BY"
            + "?label";

    public static String getCityProperties =
            "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "SELECT"
            + "(?label 	 		        AS ?name)"
	        + "(SAMPLE(?counrtyLabel)   AS ?counrtyName)"
            + "(SAMPLE(?peopleCount)    AS ?population)"
            + "(SAMPLE(?thumbnail)      AS ?image)"
            + "(SAMPLE(?webSite) 	    AS ?webPage)"
            + "WHERE"
            + "{"
            + "<%1$s> rdfs:label               ?label."
            + "<%1$s> dbo:country              ?ruler."
            + "<%1$s> dbo:populationTotal      ?peopleCount."
            + "<%1$s> dbo:thumbnail            ?thumbnail."
            + "<%1$s> dbo:wikiPageExternalLink ?webSite."
            + "?ruler rdfs:label ?counrtyLabel."
            + "FILTER langMatches( lang(?label), \"EN\" )"
            + "}"
            + "GROUP BY "
            + "?label "
            + "LIMIT 1";

    public static String getIndividualProperties =
            "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "SELECT "
            + "?name "
            + "?jobTitle "
            + "(SAMPLE(?geburtstag)     AS ?birthDate) "
            + "(SAMPLE(?homeTownLabel)  AS ?birthPlace) "
            + "(SAMPLE(?thumbnail)      AS ?image) "
            + "(SAMPLE(?webSite)        AS ?webPage) "
            + "WHERE"
            + "{"
            + "<%1$s> foaf:name                   ?name."
            + "<%1$s> dbo:birthDate               ?geburtstag."
            + "<%1$s> dbo:birthPlace              ?homeTown."
            + "<%1$s> dbo:occupation              ?occupation."
            + "<%1$s> dbo:thumbnail               ?thumbnail."
            + "<%1$s> dbo:wikiPageExternalLink    ?webSite."
            + "?homeTown rdfs:label ?homeTownLabel."
            + "?occupation dbo:title ?jobTitle."
            + "FILTER langMatches( lang(?name), \"EN\" )"
            + "}"
            + "GROUP BY "
            + "?name ?jobTitle";

    static String getTagsOfIndividual =
            "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "SELECT\n"
            + "?name\n" +
            "MIN(?job)\n" +
            "WHERE\n" +
            "{\n" +
            "    OPTIONAL { <http://dbpedia.org/resource/Donald_Trump>  foaf:name  ?name }\n" +
            "    OPTIONAL { <http://dbpedia.org/resource/Donald_Trump>  dbo:occupation  ?occupation }\n" +
            "    OPTIONAL { ?occupation dbo:title ?job}\n" +
            "}\n" +
            "GROUP BY\n" +
            "                ?name\n" +
            " ";
}