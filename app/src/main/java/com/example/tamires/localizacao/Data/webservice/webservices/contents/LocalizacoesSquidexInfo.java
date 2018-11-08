package com.example.tamires.localizacao.Data.webservice.webservices.contents;

import java.io.Serializable;

public class LocalizacoesSquidexInfo implements Serializable {

    private Long total;
    private Item[] items;

    public Long getTotal()
    {
        return total;
    }

    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Item[] getItems()
    {
        return items;
    }

    public void setItems(Item[] items)
    {
        this.items = items;
    }
}

