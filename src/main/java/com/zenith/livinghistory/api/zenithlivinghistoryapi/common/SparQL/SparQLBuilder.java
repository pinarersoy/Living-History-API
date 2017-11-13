package com.zenith.livinghistory.api.zenithlivinghistoryapi.common.SparQL;

import java.util.HashMap;
import java.util.Map;

public class SparQLBuilder {

    //region Private Members

    private Map<String, String> curies;

    //endregion

    //region Constructors

    /**
     * Ctor.
     */
    public SparQLBuilder(){

         this.curies = new HashMap<>();
    }
    //endregion

    //region Public Methods

    /**
     * Adds new curry that will be used while query generation.
     * @param abbreviation - Abbreviation.
     * @param URI - URI
     */
    public SparQLBuilder addCurry(String abbreviation, String URI){

        if(!this.curies.containsKey(abbreviation))
            this.curies.put(abbreviation, URI);

        return this;
    }

    /**
     *
     * @return
     */
    public String build(){

        StringBuilder query = new StringBuilder();

        // Add curries
        for (String abbreviation : this.curies.keySet()){

            //query.append(MagicalStrings.curryPrefix).append();

        }


        return query.toString();
    }

    //endregion

}
