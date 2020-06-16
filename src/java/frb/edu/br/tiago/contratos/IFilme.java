package frb.edu.br.tiago.contratos;

import frb.edu.br.tiago.entidades.FilmeDto;
import java.util.List;

public interface IFilme {
    boolean incluir (FilmeDto filme);
    boolean deletar (int id);
    boolean alterar (FilmeDto filme);
    FilmeDto getRegistroPorId (int id);
    List<FilmeDto> getListaTodos();
}
