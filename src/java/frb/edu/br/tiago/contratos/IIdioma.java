package frb.edu.br.tiago.contratos;

import frb.edu.br.tiago.entidades.IdiomaDto;
import java.util.List;

public interface IIdioma {
    boolean incluir (IdiomaDto idioma);
    boolean deletar (int id);
    boolean alterar (IdiomaDto idioma);
    IdiomaDto getRegistroPorId (int id);
    List <IdiomaDto> getListaTodos();
    
}
