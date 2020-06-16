package frb.edu.br.tiago.infra.repositorios;

import frb.edu.br.tiago.contratos.IIdioma;
import frb.edu.br.tiago.entidades.FilmeDto;
import frb.edu.br.tiago.entidades.IdiomaDto;
import frb.edu.br.tiago.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdiomaRepositorio extends DaoUtil implements IIdioma {
    
    public IdiomaRepositorio(){
        super();
    }

    @Override
    public boolean incluir(IdiomaDto idioma) {
        String sql = "INSERT INTO idioma (idioma_id, nome, ultima_atualizacao) " +
                     " VALUES (?, ?, ?) ";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, idioma.getIdioma().getIdidioma());
            ps.setString(2, idioma.getNome());
            ps.setInt(3, idioma.getAtualizacao().getAtualizacao());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex){
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public boolean alterar(IdiomaDto idioma) {
        String sql = "UPDATE idioma SET idioma_id=?, nome=?, ultima_atualizacao=?, " +
                     " WHERE idioma_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, idioma.getIdioma().getIdidioma());
            ps.setString(2, idioma.getNome());
            ps.setInt(3, idioma.getAtualizacao().getAtualizacao());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex){
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM idioma " +
                     " WHERE idioma=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex){
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public IdiomaDto getRegistroPorId(int id) {
        IdiomaDto idioma = new IdiomaDto();
        
        String sql = "SELECT idioma_id, nome, ultima_atualizacao, " +
                     " FROM idioma WHERE idioma_id=?";
        
        FilmeRepositorio film = new FilmeRepositorio();

        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {                
                idioma = new IdiomaDto(rs.getInt("id_idioma"), 
                        film.getRegistroPorId(rs.getInt("nome")), 
                        film.getRegistroPorId(rs.getInt("atualizacao")),
                )
                
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return idioma;
    }

    @Override
    public List<IdiomaDto> getListaTodos() {
        List<IdiomaDto> idioma = new LinkedList<IdiomaDto>();
        
        String sql = "SELECT idioma_id, nome, ultima_atualizacao, FROM idioma";
        
        FilmeRepositorio film = new FilmeRepositorio();

        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {
                FilmeDto filme = film.getRegistroPorId(rs.getInt("idioma_id"));
                FilmeDto atualizacao = film.getRegistroPorId(rs.getInt("ultima_atualizacao"));
                        idioma.add( new IdiomaDto(
                        rs.getInt("nome"),
                        filme,
                        atualizacao,
                        )     
                );
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return idioma;
    }
    
}
