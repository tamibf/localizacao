package com.example.tamires.localizacao.Data.webservice.webservices.contents;

import java.io.Serializable;

public class Item implements Serializable
{
    private String id;
    private Localizacao localizacao;
    private Long version;
    private String created;
    private String createdBy;
    private String lastModified;
    private String lastModifiedBy;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Localizacao getLocalizacao()
    {
        return localizacao;
    }

    public void setData(Localizacao localizacao)
    {
        this.localizacao = localizacao;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getLastModified()
    {
        return lastModified;
    }

    public void setLastModified(String lastModified)
    {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
    }
}
