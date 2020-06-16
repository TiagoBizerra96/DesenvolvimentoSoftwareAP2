package frb.edu.br.tiago.infra.repositorios;

import frb.edu.br.tiago.contratos.IFilme;
import frb.edu.br.tiago.entidades.FilmeDto;
import frb.edu.br.tiago.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmeRepositorio extends DaoUtil implements IFilme{

    public FilmeRepositorio() {
        super();
    }    
    
    @Override
    public boolean incluir(FilmeDto filme) {
        String sql = "INSERT INTO produto (titulo, descricao, ano_de_lancamento, idioma_id, "
                + "idioma_original_id, duracao_da_locacao, preco_da_locacao, duracao_do_filme, "
                + "custo_de_substituicao, classificacao, recursos_especiais, ultima_atualizacao)" +
                     " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getDescricao());
            ps.setDate(3, new java.sql.Date(filme.getLancamento().getTime()));
            ps.setInt(4, filme.getIdidioma());
            ps.setString(5, filme.getIdoriginal());
            ps.setInt(6, filme.getLocacao());
            ps.setFloat(7, filme.getPreco());
            ps.setInt(8, filme.getDuracao());
            ps.setFloat(9, filme.getCusto());
            ps.setString(10, filme.getClassificacao());
            ps.setString(11, filme.getRecursos());
            ps.setInt(12, filme.getAtualizacao());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0; 
    }

    @Override
    public boolean alterar(FilmeDto filme) {
        String sql = "UPDATE filme SET titulo=?, descricao=?, ano_de_lancamento=?, idioma_id=?, "
                + "idioma_original_id=?, duracao_da_locacao=?, preco_da_locacao=?, duracao_do_filme=?, "
                + "custo_de_substituicao=?, classificacao=?, recursos_especiais=?, ultima_atualizacao=?" +
                     " WHERE filme_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getDescricao());
            ps.setDate(3, new java.sql.Date(filme.getLancamento().getTime()));
            ps.setInt(4, filme.getIdidioma());
            ps.setString(5, filme.getIdoriginal());
            ps.setInt(6, filme.getLocacao());
            ps.setFloat(7, filme.getPreco());
            ps.setInt(8, filme.getDuracao());
            ps.setFloat(9, filme.getCusto());
            ps.setString(10, filme.getClassificacao());
            ps.setString(11, filme.getRecursos());
            ps.setInt(12, filme.getAtualizacao());
            ret = ps.executeUpdate();
            ps.close();

                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM produto WHERE filme_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public FilmeDto getRegistroPorId(int id) {
        FilmeDto film = new FilmeDto();
        String sql = "SELECT filme_id, titulo, descricao, ano_de_lancamento, idioma_id,  "; 
        sql += "idioma_original_id, duracao_da_locacao, preco_da_locacao, duracao_do_filme, ";
        sql += "custo_de_substituicao, classificacao, recursos_especiais, ultima_atualizacao, FROM produto";
        sql += " WHERE idProduto = ?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                film = new FilmeDto(rs.getInt("filme_id"),
                                      rs.getString("titulo"),
                                      rs.getString("descricao"),
                                      rs.getDate("ano_de_lancamento"),
                                      rs.getInt("idioma_id"),
                                      rs.getString("idioma_original_id"),
                                      rs.getInt("duracao_da_locacao"),
                                      rs.getFloat("preco_da_locacao"), 
                                      rs.getInt("duracao_do_filme"),
                                      rs.getFloat("custo_da_substituicao"),
                                      rs.getString("classificacao"),
                                      rs.getString("recursos_especiais"),
                                      rs.getInt("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return film;
    }

    @Override
    public List<FilmeDto> getListaTodos() {
        List<FilmeDto> prods = new LinkedList<FilmeDto>();
        String sql = "SELECT filme_id, titulo, descricao, ano_de_lancamento, idioma_id,  "; 
        sql += "idioma_original_id, duracao_da_locacao, preco_da_locacao, duracao_do_filme, ";
        sql += "custo_de_substituicao, classificacao, recursos_especiais, ultima_atualizacao, FROM produto";
        sql += " WHERE idProduto = ?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                prods.add( new FilmeDto(rs.getInt("filme_id"),
                                      rs.getString("titulo"), 
                                      rs.getString("descricao"),
                                      rs.getDate("ano_de_lancamento"),
                                      rs.getInt("idioma_id"),
                                      rs.getString("idioma_original_id"),
                                      rs.getInt("duracao_da_locacao"),
                                      rs.getFloat("preco"), 
                                      rs.getInt("duracao_do_filme"),
                                      rs.getFloat("custo_da_substituicao"),
                                      rs.getString("classificacao"),
                                      rs.getString("recursos_especiais"),
                                      rs.getInt("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return prods;
    }
    
}
