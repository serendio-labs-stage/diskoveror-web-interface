package api;

import com.diskoverorta.tamanager.TextManager;
import com.diskoverorta.vo.TAConfig;
import com.serendio.diskoverer.lifesciences.LSManager;
import model.RestInput;

/**
 * Created by praveen on 11/11/14.
 */
public class ApiManager
{
    public String retrieveTextAnalyticsOutput(RestInput res)
    {
        String inputText = res.inputtext;
        TAConfig taConfig = new TAConfig();
        taConfig = updateConfig(res,taConfig);
        TextManager manager = new TextManager();

        String data ="";
        if(res.apiMode == false)
            data = manager.tagTextAnalyticsComponentsINJSON(inputText,taConfig);
        else
            data = manager.tagUniqueTextAnalyticsComponentsINJSON(inputText,taConfig);

        return data;
    }

    public TAConfig updateConfig(RestInput res,TAConfig conf)
    {
        if((res.analysis != null) && (res.analysis.isEmpty() == false) )
        {
            for(String temp : res.analysisSet)
            {
                if(temp.equals("All") == true)
                {
                    conf.analysisConfig.put("Entity", "TRUE");
                    conf.analysisConfig.put("LSEntity", "TRUE");
                    conf.analysisConfig.put("Category", "TRUE");
                    conf.analysisConfig.put("Sentiment", "TRUE");

                }
                if(temp.equals("Entity") == true)
                    conf.analysisConfig.put("Entity","TRUE");
                if(temp.equals("LSEntity") == true)
                    conf.analysisConfig.put("LSEntity","TRUE");
                if(temp.equals("Category") == true)
                    conf.analysisConfig.put("Category","TRUE");
                if(temp.equals("Sentiment") == true)
                    conf.analysisConfig.put("Sentiment","TRUE");

            }
        }

        if(conf.analysisConfig.get("Entity") == "TRUE")
        {
            if((res.entities == null) || (res.entities.isEmpty() == true))
            {
                conf.entityConfig.put("Person","TRUE");
                conf.entityConfig.put("Organization","TRUE");
                conf.entityConfig.put("Location","TRUE");
                conf.entityConfig.put("Date","TRUE");
                conf.entityConfig.put("Time","TRUE");
                conf.entityConfig.put("Currency","TRUE");
                conf.entityConfig.put("Percent","TRUE");
            }
            else if((res.entities != null) && (res.entities.isEmpty() == false))
            {
                for(String temp : res.entitiesSet)
                {
                    if(temp.equals("Person") == true)
                        conf.entityConfig.put("Person","TRUE");
                    if(temp.equals("Organization") == true)
                        conf.entityConfig.put("Organization","TRUE");
                    if(temp.equals("Location") == true)
                        conf.entityConfig.put("Location","TRUE");
                    if(temp.equals("Date") == true)
                        conf.entityConfig.put("Date","TRUE");
                    if(temp.equals("Time") == true)
                        conf.entityConfig.put("Time","TRUE");
                    if(temp.equals("Currency") == true)
                        conf.entityConfig.put("Currency","TRUE");
                    if(temp.equals("Percent") == true)
                        conf.entityConfig.put("Percent","TRUE");
                }
            }
        }
        return conf;
    }
}
