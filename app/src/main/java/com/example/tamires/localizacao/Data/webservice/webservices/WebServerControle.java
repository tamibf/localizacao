package com.example.tamires.localizacao.Data.webservice.webservices;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.Localizacao;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.tamires.localizacao.Data.webservice.webservices.contents.Item;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.LocalizacoesSquidexInfo;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.Token;

public class WebServerControle {

    //é a classe que faz as chamadas no squidex
    private static RequestQueue requestQueue;
    private static Token token;

    public static RequestQueue getRequestQueueInstance(Context context) {
        if (requestQueue == null)
            requestQueue= Volley.newRequestQueue(context);
        return requestQueue;
    }

    //carrega a listagem de localizações no mapa
    public void carregarLocalizacao(final Context context,
                                    final CarregaLocalizacaoListener carregaLocalizacaoListener){
        if (token==null){
            geraToken(context, new GeraTokenListener(){
                @Override
                public void onTokenOK(){
                    carregarLocalizacao(context, carregaLocalizacaoListener);
                }

                @Override
                public void onErro() {
                    if (carregaLocalizacaoListener != null)
                        carregaLocalizacaoListener.onErro();
                }
            });
            }else{
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        "https://cloud.squidex.io/api/content/localizacao/local",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (carregaLocalizacaoListener != null)
                                    carregaLocalizacaoListener.onResultOk(new Gson().fromJson(response.toString(), LocalizacoesSquidexInfo.class));
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                if(carregaLocalizacaoListener!=null)
                                    carregaLocalizacaoListener.onErro();
                            }
                        })
                {
                 @Override
                 public Map<String, String> getHeaders() throws AuthFailureError{
                     Map<String, String> headers = new HashMap<>();
                     headers.put("Authorization", token.getToken_type()+""+token.getAccess_token());
                     return headers;
                 }
            };
                getRequestQueueInstance(context).add(jsonObjectRequest);
        }
    }

    //cria uma localização no mapa
    public void criarLocalizacao(final Context context, final Localizacao localizacao, final UpdateLocalizacaoListener criaLocalizacaoListener) throws JSONException{
        if (token ==null)
        {
            geraToken(context, new GeraTokenListener()
            {
                @Override
                public void onTokenOK()
                    {
                        try
                        {
                            criarLocalizacao(context, localizacao, criaLocalizacaoListener);
                        }
                        catch (JSONException e)
                        {
                            if(criaLocalizacaoListener !=null)
                                criaLocalizacaoListener.onErro();
                        }
                    }

                @Override
                public void onErro()
              {
                  if(criaLocalizacaoListener!=null)
                      criaLocalizacaoListener.onErro();
              }
            });

        }
        else
        {
            JsonObjectRequest jsonObjectRequest
                    =new JsonObjectRequest(Request.Method.POST,
                    "https://cloud.squidex.io/api/content/localizacao/local",
                    new JSONObject(new Gson().toJson(localizacao)),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            if (criaLocalizacaoListener != null)
                                criaLocalizacaoListener.onResultOk();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            if (criaLocalizacaoListener !=null)
                                criaLocalizacaoListener.onErro();
                        }
                    })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> headers=new HashMap<>();
                    headers.put("Authorization", token.getToken_type()+""+token.getAccess_token());
                    return headers;
                }
            };
            getRequestQueueInstance(context).add(jsonObjectRequest);
        }
    }

    //Atualiza Localização no mapa
    public void atualizaLocalizacao(final Context context, final Localizacao localizacao, final String id, final UpdateLocalizacaoListener atualizaLocalizacaoListener) throws JSONException{
        if (token==null)
        {
            geraToken(context, new GeraTokenListener()
            {
               @Override
               public void onTokenOK()
               {
                   try
                   {
                       atualizaLocalizacao(context, localizacao, id, atualizaLocalizacaoListener);
                   }catch (JSONException e)
                   {
                       if (atualizaLocalizacaoListener !=null)
                           atualizaLocalizacaoListener.onErro();
                   }
               }
               @Override
                public void onErro()
               {
                   if (atualizaLocalizacaoListener !=null)
                       atualizaLocalizacaoListener.onErro();
               }
            });
        }
        else
        {
            JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.PUT,
                    "https://cloud.squidex.io/api/content/localizacao/local/" + id,
                    new JSONObject(new Gson().toJson(localizacao)),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (atualizaLocalizacaoListener != null)
                                atualizaLocalizacaoListener.onResultOk();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (atualizaLocalizacaoListener!=null)
                                atualizaLocalizacaoListener.onErro();
                        }
                    })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", token.getToken_type()+""+token.getAccess_token());
                    return headers;
                }
            };
            getRequestQueueInstance(context).add(jsonObjectRequest);
        }
    }

    //método que apaga a localização no mapa
    public void deleteLocalizacao(final Context context, final String id, final  UpdateLocalizacaoListener deleteLocalizacaoListener)
    {
        if (token == null)
        {
            geraToken(context, new GeraTokenListener()
            {
            @Override
            public void onTokenOK()
            {
                deleteLocalizacao(context, id, deleteLocalizacaoListener);
            }

            @Override
            public void onErro()
            {
                if(deleteLocalizacaoListener != null)
                   deleteLocalizacaoListener.onErro();
            }
            });
        }
        else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.DELETE,
                    "https://cloud.squidex.io/api/content/localizacao/local" + id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (deleteLocalizacaoListener != null)
                                deleteLocalizacaoListener.onResultOk();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (deleteLocalizacaoListener !=null)
                                deleteLocalizacaoListener.onErro();
                        }
                    })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", token.getToken_type()+""+token.getAccess_token());
                    return headers;
                }
            };
            getRequestQueueInstance(context).add(stringRequest);
        }
    }

    private void geraToken(Context context, final GeraTokenListener geraTokenListener)
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                "https://cloud.squidex.io/api/content/localizacao/local",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        token = new Gson().fromJson(response, Token.class);
                        if (geraTokenListener != null)
                            geraTokenListener.onTokenOK();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (geraTokenListener !=null)
                            geraTokenListener.onErro();
                    }
                }

        ){
            @Override
            public String getBodyContentType()
            {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("grant_type", "client_credentials");
                params.put("client_id", "localizacao:tamires");
                params.put("client_secret", "1bHJXexVPb7kQgstsAcwJuRIzeGWNDtbHUgGtP4mCYs=");
                params.put("scope", "squidex-api");
                return params;
            }
        };
        getRequestQueueInstance(context).add(stringRequest);
    }
    public interface GeraTokenListener
    {
        public abstract void onTokenOK();

        public abstract void onErro();
    }

    public interface CarregaLocalizacaoListener
    {
        public abstract void onResultOk(LocalizacoesSquidexInfo localizacoes);

        public abstract void onErro();
    }

    public interface UpdateLocalizacaoListener
    {
        public abstract void onResultOk();
        public abstract void onErro();
    }
}
