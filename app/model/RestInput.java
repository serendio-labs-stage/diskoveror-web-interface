package model;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by praveen on 6/11/14.
 */
public class RestInput
{
    public Set<String> analysisSet;
    public Set<String> entitiesSet;
    public String analysis;
    public String entities;
    public String domain;
    public String source_type;
    public String source_path;
    public String custom_ontologies;
    public String inputtext;
    public String destination_type;
    public String destination_path;
    public boolean apiMode;

    public RestInput()
    {
        analysisSet = new TreeSet<String>();
        entitiesSet = new TreeSet<String>();
        apiMode = false;
    }
    public void loadData()
    {
        String[] analysisOptions = null;
        String[] entityOptions = null;

        if(analysis != null)
            analysisOptions = analysis.split(",");

        if(entities != null)
            entityOptions = entities.split(",");

        analysisSet = new TreeSet<String>();
        entitiesSet = new TreeSet<String>();

        for(int i=0; analysisOptions != null && i < analysisOptions.length; i++)
            analysisSet.add(analysisOptions[i]);

        for(int i=0; entityOptions != null && i < entityOptions.length; i++)
            entitiesSet.add(entityOptions[i]);
    }
}