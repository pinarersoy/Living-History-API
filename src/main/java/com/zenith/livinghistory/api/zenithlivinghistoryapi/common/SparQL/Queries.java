package com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL;

public final class Queries {

    /**
     * @param - Full name of person.
     */
    public static String person =
              "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "SELECT DISTINCT ?person ?name\n"
            + "WHERE {\n"
            + "?person a foaf:Person; \n"
            + "a dbo:Person; \n"
            + "foaf:name ?name. \n"
            + "FILTER langMatches(lang(?name),\"en\") \n"
            + "FILTER(CONTAINS(?name, \"%1$s\")) \n"
            + "}";

    /**
     * @param - Name of the city.
     */
    public static  String place =
              "PREFIX  dbo: <http://dbpedia.org/ontology/>"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT DISTINCT ?place ?name"
            + "WHERE {"
            + "?place a dbo:Place;"
            + "a dbo:City;"
            + "rdfs:label ?name."
            + "FILTER langMatches(lang(?name),\"en\")"
            + "FILTER(CONTAINS(?name, \"%1$s\"))"
            + "}";

    /**
     * @param - The text that will be searched as city and person.
     */
    public  static String semanticBody =
              "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX  dbo: <http://dbpedia.org/ontology/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "SELECT ?entity ?name ?type\n"
            + "WHERE {\n"
            + "{\n"
            + "SELECT ?entity ?name WHERE\n"
            + "{\n"
            + "?entity a dbo:Place;\n"
            + "a dbo:City;\n"
            + "rdfs:label ?name.\n"
            + "FILTER langMatches(lang(?name),\"en\")\n"
            + "FILTER(CONTAINS(?name, \"%1$s\"))\n"
            + "}\n"
            + "}\n"
            + "UNION\n"
            + "{\n"
            + "SELECT ?entity ?name WHERE\n"
            + "{\n"
            + "?entity a foaf:Person;\n"
            + "a dbo:Person;\n"
            + "foaf:name ?name.\n"
            + "FILTER langMatches(lang(?name),\"en\")\n"
            + "FILTER(CONTAINS(?name, \"%1$s\"))\n"
            + "}\n"
            + "}\n"
            + "}";
}
