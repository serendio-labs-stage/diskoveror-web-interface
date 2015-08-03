package controllers;

/**
 * Created by praveen on 14/10/14.
 */

import api.ApiManager;
import com.diskoverorta.entities.*;

import com.diskoverorta.legal.LegalManager;
import edu.stanford.nlp.ling.CoreLabel;
import model.DataContent;
import model.LegalInput;
import model.RestInput;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;
import play.mvc.Result;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class InputData extends Controller
{
    private static final Form<DataContent>productForm = Form.form(DataContent.class);
    private static final Form<LegalInput>legalInput = Form.form(LegalInput.class);
    private static final Form<RestInput>restInput = Form.form(RestInput.class);
    static LegalManager legal = new LegalManager();

    public static Result getInput()
    {
        return ok(views.html.input.render(Form.form(DataContent.class)));
    }

    public static Result getAPIInput()
    {
        Form<RestInput>restData = restInput.bindFromRequest();

        RestInput data = restData.get();
        data.inputtext = data.inputtext.replace("\n","");
        data.inputtext = data.inputtext.replace("\r","");
        data.apiMode = true;

        data.loadData();

        ApiManager api = new ApiManager();
        return ok(api.retrieveTextAnalyticsOutput(data));
    }

    public static Result getJSON()
    {
        Form<DataContent>boundForm = productForm.bindFromRequest();
        DataContent product = boundForm.get();


        RestInput restIp = new RestInput();
        ApiManager api = new ApiManager();

        product.rawInput = product.rawInput.replace("\n","");
        product.rawInput = product.rawInput.replace("\r","");
        restIp.inputtext = product.rawInput;
        restIp.analysisSet.add("All");
        restIp.analysis = "All";
        restIp.apiMode = true;
        restIp.loadData();

        return ok(json.render(api.retrieveTextAnalyticsOutput(restIp)));
    }

    public static Result myAction() {
        String[] postAction = request().body().asFormUrlEncoded().get("action");
        if (postAction == null || postAction.length == 0)
        {
            return ok(json.render("{\"Error\":\"Try with valid input.\"}"));
        }
        else
        {
            String action = postAction[0];
            if ("json".equals(action))
            {
                Form<DataContent>boundForm = productForm.bindFromRequest();
                DataContent product = boundForm.get();


                RestInput restIp = new RestInput();
                ApiManager api = new ApiManager();

                product.rawInput = product.rawInput.replace("\n","");
                product.rawInput = product.rawInput.replace("\r","");
                restIp.inputtext = product.rawInput;
                restIp.analysisSet.add("All");
                restIp.analysis = "All";
                restIp.apiMode = true;
                restIp.loadData();

                return ok(json.render(api.retrieveTextAnalyticsOutput(restIp)));
            }
            else if ("analyze".equals(action))
            {
                Form<DataContent>boundForm = productForm.bindFromRequest();
                DataContent product = boundForm.get();
                RestInput restIp = new RestInput();
                ApiManager api = new ApiManager();

                product.rawInput = product.rawInput.replace("\n","");
                product.rawInput = product.rawInput.replace("\r","");
                restIp.inputtext = product.rawInput;
                restIp.analysisSet.add("All");
                restIp.analysis = "All";
                restIp.apiMode = true;
                restIp.loadData();



                return ok(hello.render(api.retrieveTextAnalyticsOutput(restIp),restIp.inputtext));
            }
        }
        return ok(json.render("{\"Error\":\"Try with valid input.\"}"));
    }

    public static Result getLegalTAOutput()
    {
        Form<LegalInput>boundForm = legalInput.bindFromRequest();
        Map<String,String> legConfig = new TreeMap<String,String>();
        LegalInput product = boundForm.get();

        product.inputtext = product.inputtext.replace("\n","");
        product.inputtext = product.inputtext.replace("\r","");

        if(product.chunksize != null)
            legConfig.put("chunksize",product.chunksize);
        else
            legConfig.put("chunksize","3");

        String jsonOut = legal.tagLegalTextAnalyticsComponents(product.inputtext,legConfig);
        return ok(jsonOut);
    }

    public static Result getTaggedOutput()
    {
        Form<DataContent>boundForm = productForm.bindFromRequest();
        DataContent product = boundForm.get();
        RestInput restIp = new RestInput();
        ApiManager api = new ApiManager();

        product.rawInput = product.rawInput.replace("\n","");
        product.rawInput = product.rawInput.replace("\r","");
        restIp.analysisSet.add("All");
        restIp.analysis = "All";

        restIp.inputtext = product.rawInput;


        return ok(hello.render(api.retrieveTextAnalyticsOutput(restIp),restIp.inputtext));

        //return ok(hello.render("sdsadsa",product.rawInput));

        //return ok(api.retrieveTextAnalyticsOutput(restIp));
    }
}