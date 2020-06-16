package frb.edu.br.tiago.entidades;

public class IdiomaDto {
    private FilmeDto idioma;
    private String nome;
    private FilmeDto atualizacao;
    
    public IdiomaDto() {    
    }

    public IdiomaDto(FilmeDto idioma, String nome, FilmeDto atualizacao) {
        this.idioma = idioma;
        this.nome = nome;
        this.atualizacao = atualizacao;
    }

    public FilmeDto getIdioma() {
        return idioma;
    }

    public void setIdioma(FilmeDto idioma) {
        this.idioma = idioma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FilmeDto getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(FilmeDto atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    
}
