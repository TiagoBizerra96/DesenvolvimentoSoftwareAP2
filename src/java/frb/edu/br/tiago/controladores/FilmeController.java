package frb.edu.br.tiago.controladores;

import frb.edu.br.tiago.contratos.IFilme;
import frb.edu.br.tiago.entidades.FilmeDto;
import frb.edu.br.tiago.infra.repositorios.FilmeRepositorio;
import java.util.List;


public class FilmeController {
    
    private FilmeDto filme;
    private List<FilmeDto> filmes = null;
    
    private IFilme filmeRepositorio = new FilmeRepositorio();


    public FilmeController() {
    }

    public FilmeDto getFilme() {
        return filme;
    }

    public void setFilme(FilmeDto filme) {
        this.filme = filme;
    }

    public List<FilmeDto> getFilmes() {
        if(filmes == null){
            filmes = filmeRepositorio.getListaTodos();
        }
        return filmes;
    }
    
    public String prepararInclusao(){
        filme = new FilmeDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        
        filmeRepositorio.incluir(filme);
        filmes = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        filmeRepositorio.alterar(filme);
        filmes = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        filmeRepositorio.deletar( filme.getIdfilme() );
        filmes = null;
        return "refresh";
    }
    
}
