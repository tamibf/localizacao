package com.example.tamires.localizacao.Data.webservice.webservices.contents;

public class Localizacao {

    private StringValue idLocal;
    private StringValue nomLocal;
    private StringValue enderecoLocal;
    private StringValue telLocal;
    private LocationIV posicao;
    private StringValue tipoLocal;
    private StringValue descLocal;

    public StringValue getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(StringValue idLocal) {
        this.idLocal = idLocal;
    }

    public StringValue getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(StringValue nomLocal) {
        this.nomLocal = nomLocal;
    }

    public StringValue getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(StringValue enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public StringValue getTelLocal() {
        return telLocal;
    }

    public void setTelLocal(StringValue telLocal) {
        this.telLocal = telLocal;
    }

    public LocationIV getPosicao() {
        return posicao;
    }

    public void setPosicao(LocationIV posicao) {
        this.posicao = posicao;
    }

    public StringValue getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(StringValue tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public StringValue getDescLocal() {
        return descLocal;
    }

    public void setDescLocal(StringValue descLocal) {
        this.descLocal = descLocal;
    }
}
