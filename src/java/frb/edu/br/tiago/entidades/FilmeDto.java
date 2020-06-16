package frb.edu.br.tiago.entidades;

import java.util.Date;

public class FilmeDto {
    private int idfilme;
    private String titulo;
    private String descricao;
    private Date lancamento;
    private int ididioma;
    private String idoriginal;
    private int locacao;
    private float preco;
    private int duracao;
    private float custo;
    private String classificacao;
    private String recursos;
    private int atualizacao;
    
    public FilmeDto(){
    }

    public FilmeDto(int idfilme, String titulo, String descricao, Date lancamento, int idioma, String idoriginal, int locacao, float preco, int duracao, float custo, String classificacao, String recursos, int atualizacao) {
        this.idfilme = idfilme;
        this.titulo = titulo;
        this.descricao = descricao;
        this.lancamento = lancamento;
        this.ididioma = idioma;
        this.idoriginal = idoriginal;
        this.locacao = locacao;
        this.preco = preco;
        this.duracao = duracao;
        this.custo = custo;
        this.classificacao = classificacao;
        this.recursos = recursos;
        this.atualizacao = atualizacao;
    }

    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public int getIdidioma() {
        return ididioma;
    }

    public void setIdidioma(int ididioma) {
        this.ididioma = ididioma;
    }

    public String getIdoriginal() {
        return idoriginal;
    }

    public void setIdoriginal(String idoriginal) {
        this.idoriginal = idoriginal;
    }

    public int getLocacao() {
        return locacao;
    }

    public void setLocacao(int locacao) {
        this.locacao = locacao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public int getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(int atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    

    
    
    
}
