package com.example.tamires.localizacao;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.tamires.localizacao.Data.webservice.mensagens.PopularMensagem;
import com.example.tamires.localizacao.Data.webservice.webservices.WebServerControle;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.Item;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.Localizacao;
import com.example.tamires.localizacao.Data.webservice.webservices.contents.StringValue;

import org.json.JSONException;

public class CadLocActivity extends AppCompatActivity {

    //campos do layout
    private TextInputLayout xxNome;
    private TextInputLayout xxEndereco;
    private TextInputLayout xxTelefone;
    private TextInputLayout xxPosicao;
    private TextInputLayout xxTipoLocal;
    private TextInputLayout xxDescricao;

    private TextInputEditText edNome;
    private TextInputEditText EdEndereco;
    private TextInputEditText EdTelefone;
    private TextInputEditText EdPosicao;
    private TextInputEditText EdTipoLocal;
    private TextInputEditText EdDescricao;

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_localizacao);

        iniciacomponentes();
    }

            public void iniciacomponentes() {
                xxNome = findViewById(R.id.xxNome);
                edNome = findViewById(R.id.edNome);

                xxEndereco = findViewById(R.id.xxEndereco);
                EdEndereco = findViewById(R.id.EdEndereco);

                xxTelefone = findViewById(R.id.xxTelefone);
                EdTelefone = findViewById(R.id.EdTelefone);

                xxPosicao = findViewById(R.id.xxPosicao);
                EdPosicao = findViewById(R.id.EdPosicao);

                xxTipoLocal = findViewById(R.id.xxTipoLocal);
                EdTipoLocal = findViewById(R.id.EdTipoLocal);

                xxDescricao = findViewById(R.id.xxDescricao);
                EdDescricao = findViewById(R.id.EdDescricao);

                FloatingActionButton fabConfirmar = findViewById(R.id.fabConfirmar);
                FloatingActionButton fabDeletar = findViewById(R.id.fabDeletar);

                edNome.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                EdEndereco.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                EdTelefone.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                EdPosicao.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                EdTipoLocal.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                EdDescricao.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                fabConfirmar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        confirmaTela();
                    }
                });

                fabDeletar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deletaRegistro();
                    }
                });
            }

    private boolean validaTela()
            {
                boolean retorno = true;
                //
                if (edNome.getText().toString().trim().length() == 0)
                {
                    xxNome.setError("Informe o nome do local:");
                    retorno = false;
                }
                //
                if (EdEndereco.getText().toString().trim().length() == 0)
                {
                    xxEndereco.setError("Informe o endereço do local:");
                    retorno = false;
                }

                if (EdTelefone.getText().toString().trim().length() == 0)
                {
                    xxTelefone.setError("Informe o telefone do local:");
                    retorno = false;
                }

                if (EdPosicao.getText().toString().trim().length() == 0)
                {
                    xxPosicao.setError("Informe a posição do local:");
                    retorno = false;
                }

                if (EdTipoLocal.getText().toString().trim().length() == 0)
                {
                    xxTipoLocal.setError("Informe o tipo do local:");
                    retorno = false;
                }

                if (EdDescricao.getText().toString().trim().length() == 0)
                {
                    xxDescricao.setError("Informe o tipo do local:");
                    retorno = false;
                }
                //
                return retorno;
            }

            private void confirmaTela()
                {
                    if(!validaTela())
                        return;

                    salvaRegistro();
                }

                private void salvaRegistro() {
                    Localizacao localizacao = new Localizacao();
                    localizacao.setNomLocal(new StringValue(edNome.getText().toString()));
                    localizacao.setEnderecoLocal(new StringValue(EdEndereco.getText().toString()));
                    localizacao.setTelLocal(new StringValue(EdTipoLocal.getText().toString()));
                    //localizacao.setPosicao(new StringValue(EdPosicao.getText().toString());
                    localizacao.setTipoLocal(new StringValue(EdTipoLocal.getText().toString()));
                    localizacao.setDescLocal(new StringValue(EdDescricao.getText().toString()));

                    try
                    {
                        if(item == null)
                        {
                            new WebServerControle().criarLocalizacao(this, localizacao, new WebServerControle.UpdateLocalizacaoListener()
                            {
                                @Override
                                public void onResultOk() {
                                    CadLocActivity.this.finish();
                                }

                                @Override
                                public void onErro() {
                                    PopularMensagem.VisualizarMensagem(CadLocActivity.this, "Erro ao salvar mensagem");
                                }
                            });
                        }else
                            {
                                new WebServerControle().atualizaLocalizacao(this, localizacao, item.getId(), new WebServerControle.UpdateLocalizacaoListener() {
                                    @Override
                                    public void onResultOk() {
                                        CadLocActivity.this.finish();
                                    }

                                    @Override
                                    public void onErro() {
                                        PopularMensagem.VisualizarMensagem(CadLocActivity.this, "Erro ao salvar mensagem");
                                    }
                                });

                        }

                }catch (JSONException e)
                    {
                        PopularMensagem.VisualizarMensagem(CadLocActivity.this,"Erro ao salvar registro");
                    }
            }
            private void carregaValores(){
                if(item!=null)
                {
                    edNome.setText(item.getLocalizacao().getNomLocal().getIv());
                    EdEndereco.setText(item.getLocalizacao().getEnderecoLocal().getIv());
                    EdTelefone.setText(item.getLocalizacao().getTelLocal().getIv());
                    //EdPosicao.setText(item.getLocalizacao().getPosicao().getLatitude());
                    EdTipoLocal.setText(item.getLocalizacao().getTipoLocal().getIv());
                    EdDescricao.setText(item.getLocalizacao().getDescLocal().getIv());

                }
    }


    private void deletaRegistro()
    {
        if(item !=null)
        {
            new WebServerControle().deleteLocalizacao(this, item.getId(), new WebServerControle.UpdateLocalizacaoListener()
            {
                @Override
                public void onResultOk()
                {
                    CadLocActivity.this.finish();
                }

                @Override
                public void onErro()
                {
                    PopularMensagem.VisualizarMensagem(CadLocActivity.this,"Erro ao salvar a informação");
                }
            });
        }
    }
}



