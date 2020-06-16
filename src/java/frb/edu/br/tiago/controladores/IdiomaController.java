package frb.edu.br.tiago.controladores;

import frb.edu.br.tiago.contratos.IIdioma;
import frb.edu.br.tiago.entidades.IdiomaDto;
import frb.edu.br.tiago.infra.repositorios.IdiomaRepositorio;
import java.util.List;

public class IdiomaController {
    private IIdioma idiomasDao = new IdiomaRepositorio();
    
    private IdiomaDto idioma;
    private List<IdiomaDto> idiomas = null;
    
    
    public IdiomaController() {
    }

    public IdiomaDto getIdioma() {
        return idioma;
    }

    public void setIdioma(IdiomaDto idioma) {
        this.idioma = idioma;
    }

    public List<IdiomaDto> getIdiomas() {
        if(idiomas == null){
            idiomas = idiomasDao.getListaTodos();
        }
        return idiomas;
    }
    public String preparaInclusao(){
        idioma = new IdiomaDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        idiomasDao.incluir(idioma);
        return "voltaParaListagem";
    }
}
